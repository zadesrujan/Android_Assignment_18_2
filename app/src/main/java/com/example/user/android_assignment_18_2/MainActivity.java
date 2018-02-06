package com.example.user.android_assignment_18_2;
//Package objects contain version information about the implementation and specification of a Java package.
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //public is a method and fields can be accessed by the members of any class.
    //class is a collections of objects.
    //created MainActivity and extends with AppCompatActivity which is Parent class.

    @Override
    //we use override to tells the compiler that the following method overrides a method of its superclass.
    protected void onCreate(Bundle savedInstanceState) {
        //protected can be accessed by within the package and class and subclasses
        //The Void class is an uninstantiable placeholder class to hold a reference to the Class object
        //representing the Java keyword void.
        //The savedInstanceState is a reference to a Bundle object that is passed into the onCreate method of every Android Activity
        // Activities have the ability, under special circumstances, to restore themselves to a previous state using the data stored in this bundle.
        super.onCreate(savedInstanceState);
        //Android class works in same.You are extending the Activity class which have onCreate(Bundle bundle) method in which meaningful code is written
        //So to execute that code in our defined activity. You have to use super.onCreate(bundle)
        setContentView(R.layout.activity_main);
        //R means Resource
        //layout means design
        //main is the xml you have created under res->layout->main.xml
        //Whenever you want to change your current Look of an Activity or when you move from one Activity to another .
        //he other Activity must have a design to show . So we call this method in onCreate and this is the second statement to set
        //the design

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{Manifest.permission.RECEIVE_SMS,Manifest.permission.READ_SMS},1);
        }
        Intent intent = new Intent(MainActivity.this,MyReceiver.class);
        //creating an intent object of context mainactivity.this which results the secondactivty.class
        sendBroadcast(intent);
        //broadcastIntent to send it to any interested BroadcastReceiver components, and startService(Intent)
        //or bindService(Intent, ServiceConnection, int) to communicate with a background Service.
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        //This interface is the contract for receiving the results for permission requests.
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //It is possible that the permissions request interaction with the user is interrupted.
        // In this case you will receive empty permissions and results arrays which should be treated as a cancellation.
        if(requestCode==1&grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
            //if request code is 1 and length is gretaer than 0 then it will give the permission
            Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show();
            //showing as message that permission is granted
        }
    }
}

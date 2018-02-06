package com.example.user.android_assignment_18_2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.widget.Toast;

/**
 * Created by User on 30-01-2018.
 */

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Cursor cursor = context.getContentResolver().query(Uri.parse("content://sms/inbox"),null,null,null,null);
        //Cursor is an interface which is used as a collection to represent data it gets the data  the uri has given.
        if (cursor != null){
            //if cusor not equals to null it Cursor is like ResultSet in java, it has rows returned by some queries with its pointer.
            // moveToFirst(), moveToNext() and moveToPosition(position) sets the pointer to desired postion.
            cursor.moveToFirst();
            //When you invokes moveToFirst() method on the Cursor, it takes the cursor pointer to the first location.
            // Now you can access the data present in the first record it  get the data of the column index

           String num=cursor.getString(cursor.getColumnIndex("address"));
           //craeted a string object as num and getting the details from column that is address.
            Toast.makeText(context, " "+num, Toast.LENGTH_LONG).show();
            //showing the text what is the number.
            String body =cursor.getString(cursor.getColumnIndex("body"));
            //created a string object as body and the details of the message as string.
            Toast.makeText(context, " "+body, Toast.LENGTH_LONG).show();
            //showing the body of the message as toast.
        }

    }
}


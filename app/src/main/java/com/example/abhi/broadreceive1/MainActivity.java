package com.example.abhi.broadreceive1;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void notify (View v){
        String events[]=new String[6];
        events[0] = "Helloo..!";
        events[1] = "How are you?";
        events[2] = "HIII !!";
        events[3] = "i am fine...";
        events[4] = "what about you? all is well?";
        events[5] = "Yes, every thing is all right..";
        Bitmap icon1= BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this).setAutoCancel(true)
                .setContentTitle("Inbox Style Notification")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(icon1)
                .setContentText("Hello World!");
        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
        inboxStyle.setBigContentTitle("Event details");
        for (int i=0;i<events.length;i++){
            inboxStyle.addLine(events[i]);
        }
        builder.setStyle(inboxStyle);
        Intent result = new Intent(this,NextClass.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(NextClass.class);
        stackBuilder.addNextIntent(result);
        PendingIntent resultPending = stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(resultPending);
        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(100,builder.build());
    }

}

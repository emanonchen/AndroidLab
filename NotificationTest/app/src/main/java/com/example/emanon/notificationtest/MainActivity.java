package com.example.emanon.notificationtest;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button sendNotice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendNotice = (Button) findViewById(R.id.send_notice);
        sendNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                Intent intent = new Intent(MainActivity.this, NotificationActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);

                Notification.Builder builder = new Notification.Builder(MainActivity.this);
                builder.setAutoCancel(false); //设置可以清除
                builder.setTicker("this is ticker text");
                builder.setContentTitle("This is content title");
                builder.setContentText("This is content text");
                builder.setSmallIcon(R.drawable.ic_launcher);
                //builder.setOngoing(true);
                builder.setContentIntent(pendingIntent);

                Notification notification = builder.build();
                manager.notify(1, notification);

            }
        });
    }
}

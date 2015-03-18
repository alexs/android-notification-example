package com.github.alexs.notificationsexample;
import android.os.Bundle;
import android.app.NotificationManager;

/**
 * Created by alex on 17/03/15.
 */
public class NotificationView extends MainActivity{
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification);

        //call notification
        NotificationManager nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        nm.cancel(getIntent().getExtras().getInt("notificationID"));

    }
}

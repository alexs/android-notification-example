package com.github.alexs.notificationsexample;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {
    int notificationID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLaunch = (Button) findViewById(R.id.btnNotification);

        btnLaunch.setOnClickListener(new OnClickListener(){
            //@Override
            public void onClick(View v){
                show();
            }

        });
    }

    protected void show(){
        Intent i = new Intent(this, NotificationView.class);
        i.putExtra("notificationID", notificationID);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, i, 0);
        NotificationManager nm = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);

        Notification notif = new Notification(
                R.drawable.ic_launcher,
                "Meeting at: Meeting start at 18:00 hrs",
                System.currentTimeMillis());

        CharSequence from="System Alarm";
        CharSequence message="Meeting start at 18:00 hrs at north room";

        notif.setLatestEventInfo(this,from,message,pendingIntent);
        // 100 ms delay, 250 ms vibrate, 500 ms pause, 500 ms vibrate
        notif.vibrate = new long[]{100,250,500,500};
        nm.notify(notificationID,notif);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

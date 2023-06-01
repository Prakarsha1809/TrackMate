package com.rtls.trackmate.service;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import com.rtls.trackmate.R;

public class ForegroundService extends Service {

    public static final String FOREGROUND_CHANNEL_ID = "foreground_01";

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        PendingIntent pendingIntent =
                PendingIntent.getActivity(this, 0, intent, 0);

        Notification notification = new NotificationCompat.Builder(this, FOREGROUND_CHANNEL_ID)
                .setContentTitle("TrackMate Service")
                .setContentText("Application is running")
                .setSmallIcon(R.drawable.jadylogo1)
                .setContentIntent(pendingIntent)
                .build();

        startForeground(10, notification);

        //do heavy work on a background thread
        //stopSelf();

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        stopSelf();
        stopForeground(true);

        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }



}

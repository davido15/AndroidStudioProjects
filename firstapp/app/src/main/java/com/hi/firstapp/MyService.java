package com.hi.firstapp;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
public class MyService extends Service {
    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Let it continue running until it is stopped.
        Toast.makeText(this, "Service yopi", Toast.LENGTH_LONG).show();
        return START_STICKY;
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Service cool",
                Toast.LENGTH_LONG).show();
    }
}
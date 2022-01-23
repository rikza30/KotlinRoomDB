package com.example.kotlinroomdb_31_rikzaharisinsyira.room;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.kotlinroomdb_31_rikzaharisinsyira.MainActivity;
import com.example.kotlinroomdb_31_rikzaharisinsyira.R;

public class Splash extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Thread thread = new Thread() {
            public void run () {
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    startActivity(new Intent(Splash.this, MainActivity.class));
                    finish();
                }
            }
        };
        thread.start();
    }
}

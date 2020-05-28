package com.example.teamthreadsactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startOdds(View view){
        //create a new instance
        Odds oddClass = new Odds(new WeakReference<MainActivity> (this));
        Thread myThread = new Thread(oddClass);
        myThread.start();
    }

    public void startEvens(View view){
        Evens evenClass = new Evens(new WeakReference<MainActivity> (this));
        Thread myThread = new Thread(evenClass);
        myThread.start();

    }
}

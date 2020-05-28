package com.example.teamthreadsactivity;

import android.content.Context;
import android.widget.Toast;

import java.lang.ref.WeakReference;

public class Odds implements Runnable {
    private WeakReference<MainActivity> ui;

    Odds(WeakReference<MainActivity> ui){
        this.ui = ui;
    }

    @Override
    public void run(){
        for(int i = 1; i<=100; i+=2){
            System.out.println(i);
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //make a toast
        if(ui.get() != null) {
            ui.get().runOnUiThread(new Runnable() {
                public void run() {
                    Context context = ui.get().getApplicationContext();
                    CharSequence text = "Finished counting odds!";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                }
            });
        }
    }
}
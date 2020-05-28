package com.example.teamthreadsactivity;

import android.content.Context;
import android.widget.Toast;

import java.lang.ref.WeakReference;

public class Evens implements Runnable {
    private WeakReference<MainActivity> ui;
    Evens(WeakReference<MainActivity> ui){
        this.ui = ui;
    }

    @Override
    public void run(){
        for(int i = 0; i<=100; i+=2){
            System.out.println(i);
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(ui.get() != null) {
            ui.get().runOnUiThread(new Runnable() {
                public void run() {
                    Context context = ui.get().getApplicationContext();
                    CharSequence text = "Finished counting evens!";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                }
            });
        }
    }
}

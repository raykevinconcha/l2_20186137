package com.example.l2_20186137;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;

public class Cuenta {
    private int tiempodeEspera=10000; // 10seg
    private final int tiempomin=1000; //1seg

    ContadorEvent c_change_listen;
    public static Thread o_thread;
    public Cuenta() {
        o_thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 104; i < 227; i = i + 1) {
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException d) {
                        d.printStackTrace();
                    }
                    Message msg = Message.obtain();
                    msg.obj = i;
                    mHandler.sendMessage(msg);
                    //if(tiempodeEspera>tiempomin){
                        //tiempodeEspera-=1000;
                    //}
                }
            }
        });

    }
        @SuppressLint("HandlerLeak")
        Handler mHandler =new Handler()
        {
            @Override
            public void handleMessage(Message msg){
                int ic=(Integer)msg.obj;
                c_change_listen.cambio(ic);
            }
        };

        public void setCount(ContadorEvent cuenta_listen){

            c_change_listen=cuenta_listen;
        }
        public void start(){

            o_thread.start();
        }
    }



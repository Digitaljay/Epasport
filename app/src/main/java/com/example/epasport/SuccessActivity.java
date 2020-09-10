package com.example.epasport;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.concurrent.TimeUnit;


public class SuccessActivity extends AppCompatActivity implements View.OnClickListener{

    class myThread extends Thread{
        String data;
        myThread(String str){
            data=str;
        }
        public void run(){
            Log.d("threads","started");
            try {
                Thread.sleep(1500);
                giveIntent(data);
            }
            catch(Exception e){
                Log.d("threads",e.getMessage());
            }

        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);
        String data =getIntent().getStringExtra("data");
        myThread thread=new myThread(data);
        thread.start();
    }


    @Override
    public void onClick(View v) {
        // по id определеяем кнопку, вызвавшую этот обработчик
        Intent intent = new Intent(this, ResultActivity.class);
        startActivity(intent);
    }
    public void giveIntent(String data){
        Intent intent =new Intent(this, ResultActivity.class);
        intent.putExtra("data",data);
        startActivity(intent);
    }
}

package com.example.epasport;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ErrorActivity extends AppCompatActivity implements View.OnClickListener {
    Button goBack;
    Button reTry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error);
        goBack = (Button) findViewById(R.id.goBack);
        goBack.setOnClickListener(ErrorActivity.this);
        reTry=(Button) findViewById(R.id.reTry);
        reTry.setOnClickListener(ErrorActivity.this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.goBack:
                Intent intent1 = new Intent(this, MainActivity.class);
                startActivity(intent1);
                break;
            case R.id.reTry:
                Intent intent2 = new Intent(this, ActivityTwo.class);
                startActivity(intent2);
                break;
        }
    }
}

package com.example.epasport;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView totalResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        totalResult=(TextView)findViewById(R.id.totalResult);
        StringBuffer result=new StringBuffer();
        String data =getIntent().getStringExtra("data");
        for (String word:data.split(";")){
            result.append(word+"\n");
        }
        totalResult.setText(result.toString());



    }


}

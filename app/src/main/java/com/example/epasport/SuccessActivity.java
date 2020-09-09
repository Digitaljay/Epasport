package com.example.epasport;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SuccessActivity extends AppCompatActivity implements View.OnClickListener{

    Button button1;
    TextView ressa;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);
        String intent =getIntent().getStringExtra("data");
        // найдем View-элементы
        button1 = (Button) findViewById(R.id.button1);

        // присваиваем обработчик кнопкам
        button1.setOnClickListener(SuccessActivity.this);
        ressa=(TextView) findViewById(R.id.ressa);
        ressa.setText(intent);
    }

    @Override
    public void onClick(View v) {
        // по id определеяем кнопку, вызвавшую этот обработчик
        Intent intent = new Intent(this, ResultActivity.class);
        startActivity(intent);
    }
}

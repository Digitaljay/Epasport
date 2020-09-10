package com.example.epasport;

import android.app.Activity;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;
import java.util.Stack;


public class MainActivity extends Activity implements View.OnClickListener {
    Button button1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // найдем View-элементы
        button1 = (Button) findViewById(R.id.button1);

        // присваиваем обработчик кнопкам
        button1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // по id определеяем кнопку, вызвавшую этот обработчик
                Intent intent = new Intent(this, ActivityTwo.class);
                startActivity(intent);

    }

}


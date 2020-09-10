package com.example.epasport;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


import java.util.Calendar;
import java.util.Date;

import static java.nio.charset.StandardCharsets.UTF_8;

public class ActivityTwo extends AppCompatActivity implements View.OnClickListener, NfcAdapter.ReaderCallback{
    Button goBack;
    private NfcAdapter nfcAdapter;
    Calendar c= Calendar.getInstance();
    Date d2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        goBack = (Button) findViewById(R.id.goBack);
        goBack.setOnClickListener(ActivityTwo.this);
        nfcAdapter = NfcAdapter.getDefaultAdapter(ActivityTwo.this);
        d2=c.getTime();

    }
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private String HEX_CHARS = "0123456789ABCDEF";
    byte[] hexStringToByteArray(String  data){
        char[] ddata=data.toCharArray();
        byte[] result = new byte[data.length() / 2];
        for (int i=0;i<data.length();i+= 2) {
            int firstIndex = HEX_CHARS.indexOf(ddata[i]);
            int secondIndex = HEX_CHARS.indexOf(ddata[i + 1]);
            int octet = firstIndex<<(4)|secondIndex;
            result[i>>1]= (byte)octet;
        }

        return result;
    }

    @Override
    public void onTagDiscovered(Tag tag) {
        try {
            IsoDep isoDep = IsoDep.get(tag);
            isoDep.connect();
            byte[] response = isoDep.transceive(hexStringToByteArray(
                    "00A4040007A0000002471001"));
            Log.d("NFC", "Recieved sth");
            giveIntent(new String(response,UTF_8));
            isoDep.close();
        }
        catch (Exception e){
            Log.d("NFC", e.getMessage());

        }
    }

    @Override
    public void onResume() {
        super.onResume();
        nfcAdapter.enableReaderMode(this, this,
                NfcAdapter.FLAG_READER_NFC_A |
                NfcAdapter.FLAG_READER_SKIP_NDEF_CHECK,
                null);
        if (c.getTime().getTime()-d2.getTime()>30000){
            Intent intent =new Intent(this, ErrorActivity.class);
            startActivity(intent);
        }
    }

    void giveIntent(String data){
        Intent intent =new Intent(this, SuccessActivity.class);
        intent.putExtra("data",data);
        startActivity(intent);
    }

    private char[] HEX_CHARS_ARRAY = "0123456789ABCDEF".toCharArray();
    String toHex( byte[] byteArray){
        StringBuffer result = new StringBuffer();
        for (byte it: byteArray) {
            int octet = (int)it;
            int firstIndex = (octet & 0xF0)>>(4);
            int secondIndex = octet&0x0F;
            result.append(HEX_CHARS_ARRAY[firstIndex]);
            result.append(HEX_CHARS_ARRAY[secondIndex]);
        }

        return result.toString();
    }
}

package com.example.michael.michaelvanderzwet_pset2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FourthActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        Intent intent = getIntent();
        //String receivedText = intent.getStringExtra("inputtext");
        String receivedText2 = intent.getStringExtra("thestory");

//        TextView textView = (TextView) findViewById(R.id.textView5);
//        textView.setText(receivedText);

        TextView textView2 = (TextView) findViewById(R.id.textView5);
        textView2.setText(receivedText2);


    }

    public void goBack(View view) {
        Intent intent = new Intent(this, MatLib.class);
        startActivity(intent);
    }
}

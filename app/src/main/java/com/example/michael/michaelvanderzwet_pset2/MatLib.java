package com.example.michael.michaelvanderzwet_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

public class MatLib extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mat_lib);
    }


    public void goToSecond(View view) {

        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);

    }
}

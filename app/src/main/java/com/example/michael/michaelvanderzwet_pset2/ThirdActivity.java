package com.example.michael.michaelvanderzwet_pset2;

import android.content.Intent;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import java.io.Serializable;

public class ThirdActivity extends AppCompatActivity {

    private Story myStory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        if(savedInstanceState == null || myStory == null) {

            Log.d("mystory", "string");

            String[] texts = {"madlib0_simple.txt", "madlib1_tarzan.txt", "madlib2_university.txt", "madlib3_clothes.txt", "madlib4_dance.txt"};
            int index = new Random().nextInt(texts.length);
            String random = (texts[index]);

            try {
                myStory = new Story(getAssets().open(random));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        TextView remaining2 = (TextView) findViewById(R.id.textView3);
        remaining2.setText(myStory.getPlaceholderCount() + " Word(s) left");

        EditText input4 = (EditText) findViewById(R.id.editText2);
        input4.setHint(myStory.getNextPlaceholder());

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("story", myStory);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);


        Log.d("saveInstanceSTate", "triggered");
        myStory = (Story) savedInstanceState.getSerializable("story");
    }

    public void goToStory(View view) {

        Log.d("test", "button");
        EditText input2 = (EditText) findViewById(R.id.editText2);
        String input = (String) input2.getText().toString();
        myStory.fillInPlaceholder(input);

        TextView remaining = (TextView) findViewById(R.id.textView3);
        remaining.setText(myStory.getPlaceholderRemainingCount() + " Word(s) left");

        EditText input3 = (EditText) findViewById(R.id.editText2);
        input3.setHint(myStory.getNextPlaceholder());
        input3.setText("");

        if (myStory.isFilledIn()) {
            myStory.fillInPlaceholder(input);
            goToNext();
        }
    }

    public void goToNext(){
        Intent intent = new Intent(this, FourthActivity.class);
        intent.putExtra("thestory", String.valueOf(myStory));
        startActivity(intent);
    }
}

package com.hi.calculator;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText enterText;
    private SeekBar myseekBar;
    private Button myButton;
    private TextView myResult;
    private TextView mySeek;
    private int perCent;
    private float enterBilled;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enterText = (EditText) findViewById(R.id.billAmount);
        myseekBar = (SeekBar) findViewById(R.id.seekBar);
        myButton = (Button) findViewById(R.id.calculate);
        myResult = (TextView) findViewById(R.id.textView4);
        mySeek = (TextView) findViewById(R.id.seekbarview);
         myButton.setOnClickListener(this);
        Toast.makeText(MainActivity.this, "hello",Toast.LENGTH_LONG).show();

        myseekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar myseekbar, int progress, boolean fromUser) {
                mySeek.setText(String.valueOf(myseekbar.getProgress()));

            }

            ;

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            ;

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                perCent = myseekBar.getProgress();
            }

            ;
        });
    };

    @Override
    public void onClick(View v) {
        calculate();
    };

    public void calculate() {
        float result = 0.0f;
        if (!enterText.getText().toString().equals("")) {

            enterBilled = (float) Double.parseDouble(enterText.getText().toString());
            result = enterBilled * perCent / 100;
            myResult.setText(String.valueOf(result) + " bill ");

        }

    }

}
package com.hi.firstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button mButton;
    private TextView mtext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = (Button) findViewById(R.id.mButton);
        mtext = (TextView) findViewById(R.id.mtext);
        //mEditText = (EditText) findViewById(R.id.editText);


        //change the title of the button
        mButton.setText(R.string.button_name);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // String enteredText;

                // enteredText = mEditText.getText().toString();

                mtext.setVisibility(View.VISIBLE);
                mtext.setText("hi");

            }
        });

    }


    }


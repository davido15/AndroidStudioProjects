package com.hi.myfirstactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class secondActivity extends AppCompatActivity {
    private TextView fromFirst;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle notes = getIntent().getExtras();
        fromFirst= (TextView) findViewById(R.id.showMessage);
        backButton=(Button) findViewById(R.id.bkbutton);
        if(notes!= null){
            String mymessage = notes.getString("greeting");

            int mynun =notes.getInt("value");
            fromFirst.setText(String.valueOf(mynun));
        }
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnintent = getIntent();
                returnintent.putExtra("returnData", "secondActivity");
                setResult(RESULT_OK,returnintent);
                finish();

            }
        });

    }
}

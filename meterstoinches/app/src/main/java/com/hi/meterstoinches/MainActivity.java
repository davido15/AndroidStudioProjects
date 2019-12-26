package com.hi.meterstoinches;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private EditText editTextid;
private Button convertid;
    private TextView textid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextid = (EditText) findViewById(R.id.editTextid);
        convertid=(Button) findViewById(R.id.convertid);
        textid=(TextView) findViewById(R.id.textid);
        convertid.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double myPi = 3.1455;
                double result =0.0;

                if (editTextid.getText().equals("")){
                    textid.setText(R.string.error_meassage);
                    textid.setTextColor(R.color.colorPrimary);

                }
                else {
                    double metervalue = Double.parseDouble(editTextid.getText().toString());
                    result = myPi * metervalue;
                    textid.setText(Double.toString(result));
                    textid.setText(String.format("%.2f", result));
                }


            }
        });

    }
}

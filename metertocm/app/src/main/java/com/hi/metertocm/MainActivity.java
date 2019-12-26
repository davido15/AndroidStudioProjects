package com.hi.metertocm;

import android.graphics.Color;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button convertid;
    private TextView resultid;
    private RadioButton radiobutton;
    private RadioGroup  radiogroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         //radiobutton= (RadioButton)  findViewById(R.id.yesid);

        convertid = (Button) findViewById(R.id.convertid);
        editText= (EditText) findViewById(R.id.textid);
        resultid= (TextView) findViewById(R.id.resultid);
        convertid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //convertion
//double x =4.4;
                if (editText.getText().toString().equals("")) {

                    resultid.setText(R.string.app_error);
                    resultid.setTextColor(Color.BLUE);
                }
                else {
                    double multi= 3.14;
                    double myresult;
                    myresult = 0.0;

                    double meterto = Double.parseDouble(editText.getText().toString());
                    myresult = multi * meterto;
                    resultid.setText(String.format("%.2f", myresult) + " inc");
                }
            }
        });

        //adio
        radiogroup=(RadioGroup) findViewById(R.id.options);
        radiogroup.setOnCheckedChangeListener(new radiogroup.OnChe()){
            @Override
            public void onCheckedChange(RadioGroup group,@IdRes  int checkedID) {
                radiobutton =(RadioButton) findViewById(checkedID);
                switch (radiobutton.getId()){
                    case R.id.yesid:{
                        Log.d("YES");
                    }
                    case R.id.noid:{
                        Log.d("nO");
                    }
                    case R.id.maybe:{
                        Log.d("May be");
                    }
                }
            }




        }


    }
}

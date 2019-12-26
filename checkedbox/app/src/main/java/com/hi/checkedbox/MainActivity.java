package com.hi.checkedbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mydisplay;
    private CheckBox myfemale;
    private CheckBox  mymale;
    private CheckBox  mynone;
    private Button youclick;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myfemale = (CheckBox) findViewById(R.id.female);
        mymale = (CheckBox) findViewById(R.id.male);
        mynone = (CheckBox) findViewById(R.id.none);
        mydisplay =(TextView) findViewById(R.id.resultId);;
        youclick =(Button) findViewById(R.id.button);

        youclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder mystrings  =new StringBuilder();
                 mystrings.append(mymale.getText().toString() + "status is :" + mymale.isChecked()+"\n");
                 mystrings.append(myfemale.getText().toString() + "status is :" + myfemale.isChecked()+"\n");
                 mystrings.append(mynone.getText().toString() + "status is :" + mynone.isChecked()+"\n");
                mydisplay.setText(mystrings);
            }
        });
    }
}

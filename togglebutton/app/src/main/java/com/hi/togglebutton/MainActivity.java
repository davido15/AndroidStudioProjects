package com.hi.togglebutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private TextView mytextview;
    private ToggleButton mytoogleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mytextview= (TextView) findViewById(R.id.peekaboo);
        mytoogleButton=(ToggleButton) findViewById(R.id.toggleId);
        mytoogleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
mytextview.setVisibility(View.VISIBLE);
                }
                else{
                    mytextview.setVisibility(View.INVISIBLE);
                }
            }
        });
    }
}

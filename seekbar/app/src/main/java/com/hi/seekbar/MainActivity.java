package com.hi.seekbar;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView resultext;
    private SeekBar seekmybar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultext = (TextView) findViewById(R.id.resultID);
        seekmybar= (SeekBar) findViewById(R.id.seekBar);
        seekmybar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                resultext.setTextColor(Color.GRAY);
                resultext.setText("Pain Level"+ seekBar.getProgress() +"/" + seekBar.getMax());
                Log.d("SB","PROGRESSING");
            };

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.d("SB","START");
            };

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (seekBar.getProgress()>=8){
                   // resultext.setText("Pain Level"+ seekBar.getProgress() +"/" + seekBar.getMax());
                    resultext.setTextColor(Color.RED);
                }
                Log.d("SB","STOP");
            };
        });
    };
}

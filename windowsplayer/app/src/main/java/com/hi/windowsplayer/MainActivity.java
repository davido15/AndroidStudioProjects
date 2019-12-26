package com.hi.windowsplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private Button mybutton;
    private SeekBar myseekbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = new MediaPlayer();
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.shane);
        myseekbar = (SeekBar) findViewById(R.id.mseekBar);
        myseekbar.setMax(mediaPlayer.getDuration());
        myseekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser){
                    mediaPlayer.seekTo(progress);

                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                int duration = mp.getDuration();
                String mduration = String.valueOf(duration/1000);
                Toast.makeText(getApplicationContext(),"Duration is "+mduration,Toast.LENGTH_LONG).show();
            }
        });
        mybutton = (Button) findViewById(R.id.playbutton);
        mybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()){
                    //// STOPSHIP: 8/7/2018
                    pauseMusic();
                }else{

                    startMusic();
                }

            }
        });
    }
    public void pauseMusic()
    {
        if (mediaPlayer != null){
            mediaPlayer.pause();
            mybutton.setText("Play");
        }

    }
    public void startMusic()
    {
        if (mediaPlayer != null){
            mediaPlayer.start();
            mybutton.setText("Pause");
        }
    }
    @Override
    protected void onDestroy() {

        if (mediaPlayer != null && mediaPlayer.isPlaying() ){
            mediaPlayer.stop();
        mediaPlayer.release();
        mediaPlayer = null;}
        super.onDestroy();

    }




}

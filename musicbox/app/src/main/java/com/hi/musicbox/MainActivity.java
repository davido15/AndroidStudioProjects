package com.hi.musicbox;

import android.graphics.drawable.Drawable;
import android.icu.text.SimpleDateFormat;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Date;

import static android.R.attr.duration;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private MediaPlayer mediaPlayer;
    private TextView lefttext;
    private TextView righttext;
    private ImageView artiImag;
    private SeekBar mseekbar;
    private Button prevbut;
    private Button nexbut;
    private Button playbut;
    private Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpUI();
        mseekbar.setMax(mediaPlayer.getDuration());
        mseekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser){
                    mediaPlayer.seekTo(progress);

                }
                SimpleDateFormat dateFormat = new SimpleDateFormat("mm:ss");
                int currentPos= mediaPlayer.getCurrentPosition();
                int duration = mediaPlayer.getDuration();
                lefttext.setText(dateFormat.format(new Date(currentPos)));
                righttext.setText(dateFormat.format(new Date(duration - currentPos)));


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }



    public void setUpUI(){
        mediaPlayer = new MediaPlayer();
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.shane);
        lefttext = (TextView) findViewById(R.id.leftview);
        righttext = (TextView) findViewById(R.id.rightview);
        artiImag = (ImageView) findViewById(R.id.imageView);
        mseekbar= (SeekBar) findViewById(R.id.seekBar);
        prevbut = (Button) findViewById(R.id.button);
        playbut = (Button) findViewById(R.id.button2);
        nexbut = (Button) findViewById(R.id.button3);
        prevbut.setOnClickListener(this);
        playbut.setOnClickListener(this);
        nexbut.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.button:
                musicprev();
                break;
            case R.id.button2:
                if(mediaPlayer.isPlaying()){
                    Pausemusic();
                }else{
                    Startmusic();
                }
                break;
            case R.id.button3:
                musicnext();
                break;
        }
    }
    public void Startmusic(){
        if(mediaPlayer != null)
        {
            mediaPlayer.start();
            updatethread();
            playbut.setBackgroundResource(android.R.drawable.ic_media_pause);
        }

    }
    public void Pausemusic(){
        if(mediaPlayer != null)
        {
            mediaPlayer.pause();
            playbut.setBackgroundResource(android.R.drawable.ic_media_play);
        }

    }
    public void musicprev(){
        if(mediaPlayer.isPlaying())
        {
          mediaPlayer.seekTo(0);
        }

    }
    public void musicnext(){
        if(mediaPlayer != null)
            if(mediaPlayer.isPlaying())
            {
                mediaPlayer.seekTo(mediaPlayer.getDuration());
            }

    }
    public void updatethread(){
        thread = new Thread(){
            @Override
            public void run() {
                super.run();

                try{
                    while(mediaPlayer !=null && mediaPlayer.isPlaying()){
                    Thread.sleep(50);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            int newPosition = mediaPlayer.getCurrentPosition();
                            int newMax = mediaPlayer.getDuration();
                            mseekbar.setMax(newMax);
                            mseekbar.setProgress(newPosition);
                            lefttext.setText(String.valueOf(new java.text.SimpleDateFormat("mm:ss").format(new Date(newPosition))));
                            righttext.setText(String.valueOf(new java.text.SimpleDateFormat("mm:ss").format(new Date(duration - newPosition))));

                        }
                    });
                }
            }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
        };

thread.start();
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

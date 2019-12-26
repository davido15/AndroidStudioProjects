package com.hi.tryme;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private View windowmyview;
    private Button trymeButton;
    private int[] mycolors;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mycolors= new int[]{Color.CYAN, Color.BLUE,Color.RED,Color.GREEN};
        windowmyview=(View) findViewById(R.id.windowview);
        trymeButton=(Button) findViewById(R.id.trymeSee);

        trymeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               int mytotal= mycolors.length;
                Random random = new Random();
                int Randomnum= random.nextInt(mytotal);
                windowmyview.setBackgroundColor(mycolors[Randomnum]);
            }
        });
    }
}

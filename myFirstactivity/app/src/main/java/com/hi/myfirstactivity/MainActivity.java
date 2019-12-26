package com.hi.myfirstactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button gotoSecondact;
    private final int REQUEST_CODE=2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gotoSecondact = (Button)findViewById(R.id.showButton);
        gotoSecondact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intention = new Intent(MainActivity.this, secondActivity.class);

                //startActivity(new Intent(MainActivity.this, secondActivity.class));
                intention.putExtra("greeting","Hi from first");
                intention.putExtra("firstNum","123");
                intention.putExtra("value",123345);
                startActivityForResult(intention, REQUEST_CODE);

            }


        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==REQUEST_CODE){
            if (resultCode== RESULT_OK);
            String result=data.getStringExtra("returnData");
            Toast.makeText(MainActivity.this,result, Toast.LENGTH_SHORT).show();

        }
    }
}

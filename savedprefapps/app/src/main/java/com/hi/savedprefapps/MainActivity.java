package com.hi.savedprefapps;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private Button entertext;
    private TextView mresult;
    private EditText mtext;
    private SharedPreferences myprefs;
    private static final String PREFS_NAME = "myprefsfile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        entertext = (Button) findViewById(R.id.enterbut);
        mresult = (TextView) findViewById(R.id.result);
        mtext = (EditText) findViewById(R.id.entname);
        entertext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myprefs = getSharedPreferences(PREFS_NAME, 0);
                SharedPreferences.Editor editor = myprefs.edit();
                editor.putString("message", mtext.getText().toString());
                editor.commit();

            }
        });

        SharedPreferences myprefs = getSharedPreferences(PREFS_NAME, 0);
        if (myprefs.contains("message")) {
            String message = myprefs.getString("message", "not found");
            mresult.setText("message " + message);
        }

    }
}

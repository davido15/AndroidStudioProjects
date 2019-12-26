package com.hi.apphoney;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    private Button mbutton;
    private EditText editext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mbutton = (Button) findViewById(R.id.button);
        editext = (EditText) findViewById(R.id.editText);
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //logic is here
                if (!editext.getText().toString().equals("")) {
                    String mymessage = editext.getText().toString();
                    writetofile(mymessage);
                }else{
                    //do nothing

                }

            }
        });
        try {
            if (readfromfile()!= null){
                //add the message read

                editext.setText(readfromfile());

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void writetofile(String message){
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput("todolist.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(message);
            outputStreamWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private String readfromfile() throws IOException {
        String result ="";
        InputStream inputStream = openFileInput("todolist.txt");
        if(inputStream !=null){

            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String tempString = "";
            StringBuilder stringBuilder = new StringBuilder();
            while ((tempString = bufferedReader.readLine()) != null){
                stringBuilder.append(tempString);


            }
            inputStream.close();
            result= stringBuilder.toString();

        }
        return result;



    }

}

package com.hi.alertdialog;

import android.content.DialogInterface;
import android.preference.DialogPreference;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private AlertDialog.Builder alerDiag;
    private Button showDiag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showDiag = (Button) findViewById(R.id.showDialog);
        showDiag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alerDiag= new AlertDialog.Builder(MainActivity.this);
                alerDiag.setTitle(getResources().getString(R.string.title));
                alerDiag.setMessage(getResources().getString(R.string.message));
                alerDiag.setCancelable(false);
                alerDiag.setPositiveButton(getResources().getString(R.string.yes),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                MainActivity.this.finish();
                            }
                        });
                alerDiag.setNegativeButton(getResources().getString(R.string.no),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                       AlertDialog alerdie = alerDiag.create();
                alerdie.show();

                        }
        });
    }
}

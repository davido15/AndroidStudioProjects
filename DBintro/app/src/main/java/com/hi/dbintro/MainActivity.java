package com.hi.dbintro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import data.DataBaseHandler;
import model.Contact;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DataBaseHandler db = new DataBaseHandler(this);
        Log.d("Insert","Inserting..");
        db.addcontact(new Contact("Paul","02333"));
        db.addcontact(new Contact("Paul000","0233344"));
        Log.d("Read","Reading..");
        List<Contact> contactList = db.getAllcontacts();
        for (Contact c : contactList){
            String log = "id ,"+ c.getId()+ " name ,"+ c.getUsername()+ " phone, "+c.getPhonenumber();
            Log.d("Name", log);

        }
    }
}

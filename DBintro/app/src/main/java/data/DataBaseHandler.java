package data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import Utils.utils;
import model.Contact;

/**
 * Created by Davido17 on 8/8/2018.
 */

public class DataBaseHandler extends SQLiteOpenHelper {

    public DataBaseHandler(Context context) {
        super(context, utils.DATABASE_NAME,null,utils.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACT = "CREATE TABLE" + utils.DATABASE_TABLE + "("+utils.KEY_ID +" INTEGER PRIMARY KEY ,"+
                utils.KEY_NAME+" TEXT " + utils.KEY_NUMBER + "TEXT"+")";
 db.execSQL(CREATE_CONTACT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
db.execSQL("DROP TABLE IF EXISTS"+ utils.DATABASE_TABLE);
        //create again
        onCreate(db);
    }

    /*kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk
    *CRUD OPERATIONS(CREATE READ,DELETE,UPDATE
    * KKKKKKKKKKKKKKKKKKKKKKKKKKKKKK
    */
    public void addcontact(Contact contact){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(utils.KEY_NAME, contact.getUsername());
        values.put(utils.KEY_NUMBER, contact.getPhonenumber());
        db.insert(utils.DATABASE_TABLE,null,values);
        db.close();

    }
//get contact
    public Contact getContact(int id ){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor  = db.query(utils.DATABASE_TABLE,new String[]{
                utils.KEY_ID,utils.KEY_NAME,utils.KEY_NUMBER}, utils.KEY_ID +"=?",new String[]{String.valueOf(id)},null,null,null,null);
        if (cursor !=null){
            cursor.moveToFirst();
            Contact contact = new Contact(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2));
            return  contact;
        }


    }
    //list all contact
    public List<Contact> getAllcontacts(){
        SQLiteDatabase db = this.getWritableDatabase();
        List<Contact> contactList = new ArrayList<>();
        String selectall= "SELECT * FROM "+utils.DATABASE_TABLE;
        Cursor cursor = db.rawQuery(selectall,null);
        if(cursor.moveToFirst()){
            do {
                Contact contact = new Contact();
                contact.setId(Integer.parseInt(cursor.getString(0)));
                contact.setUsername(cursor.getString(1));
                contact.setPhonenumber(cursor.getString(2));
            // add contact obj to our list
                contactList.add(contact);

            }while  (cursor.moveToNext());
        }
return contactList;

    }





}

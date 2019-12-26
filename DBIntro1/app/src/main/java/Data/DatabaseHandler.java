package Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import Model.Contact;
import Util.Util;

/**
 * Created by Davido17 on 9/9/2018.
 */

public class DatabaseHandler extends SQLiteOpenHelper {
    public DatabaseHandler(Context context) {
        super(context, Util.DATABASE_NAME, null, Util.DATABASE_VERSION);
    }

    public DatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    //crete table
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACT_TABLE = "CREATE TABLE" + Util.TABLE_NAME + "(" + Util.KEY_ID + "INTEGER PRIMARY KEY" + Util.KEY_NAME + "TEXT" + Util.KEY_PHONE_NUMBER + "TEXT" + ")";
        db.execSQL(CREATE_CONTACT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //drop table
        db.execSQL("DROP TABLE IF EXISTS" + Util.TABLE_NAME);
        //create empty table
        onCreate(db);

    }

    /**
     * CRUD- CREATE READ UPDATE DELETE
     */
    public void addContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(Util.KEY_NAME, contact.getName());
        value.put(Util.KEY_PHONE_NUMBER, contact.getPhoneNumber());
        //insert to row
        db.insert(Util.TABLE_NAME, null, value);
        db.close();
    }

    //get contact bby is
    public Contact getContact(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(Util.TABLE_NAME, new String[]{String.valueOf(id)}, new String[]{Util.KEY_ID, Util.KEY_NAME, Util.KEY_PHONE_NUMBER}
                + Util.KEY_ID + "=?", null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
            Contact contact = new Contact(
                    Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1),
                    cursor.getString(2)
            );
            return contact;
    }

    //get all contacts

    public List<Contact> getAllContacts(){
        SQLiteDatabase db = this.getWritableDatabase();
        List<Contact> contactList =new ArrayList<>();
        ///select all query
        String selectAll = "SELECT * FROM "+Util.TABLE_NAME;
        Cursor cursor = db.rawQuery(selectAll,null);
        if(cursor.moveToFirst()){
            do{
                Contact contact = new Contact();
                contact.setId(Integer.parseInt(cursor.getString(0)));
                contact.setName(cursor.getString(1));
                contact.setPhoneNumber(cursor.getString(2));

            }while (cursor.moveToNext());
        }
        return contactList;

    }
}




















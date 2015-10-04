package com.example.g0294.a6_2_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class ContactDao {
    private SQLiteDatabase db;
    private DatabaseHandler dbHelper;

    public ContactDao(Context context) {
        dbHelper = new DatabaseHandler(context);
    }

    // 關閉資料庫
    public void close() {
        db.close();
    }

    // 新增聯絡人
    public void addContact(Contact contact) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DatabaseHandler.KEY_NAME, contact.get_name());
        values.put(DatabaseHandler.KEY_PH_NO, contact.get_phone_number());

        db.insert(DatabaseHandler.TABLE_CONTACTS, null, values);
        db.close(); // 關閉連線
    }

    // 取得單一聯絡人資訊
    public Contact getContact(int id) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor cursor =
                db.query(DatabaseHandler.TABLE_CONTACTS, new String[]{DatabaseHandler.KEY_ID,
                                DatabaseHandler.KEY_NAME, DatabaseHandler.KEY_PH_NO}, DatabaseHandler.KEY_ID + "=?",
                        new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
            // return contact
            return new Contact(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2));
        }
        // return contact
        return null;
    }

    // 取得所有聯絡人資料
    public List<Contact> getAllContacts() {
        List<Contact> contactList = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + DatabaseHandler.TABLE_CONTACTS;

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            while (cursor.moveToNext()) {
                Contact contact = new Contact();
                contact.set_id(Integer.parseInt(cursor.getString(0)));
                contact.set_name(cursor.getString(1));
                contact.set_phone_number(cursor.getString(2));
                // Adding contact to list
                contactList.add(contact);
            }
        }
        return contactList;
    }

    // 聯絡人數量
    public int getContactsCount() {
        String countQuery = "SELECT  * FROM " + DatabaseHandler.TABLE_CONTACTS;
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        return cursor.getCount();
    }

    // 更新聯絡人
    public int updateContact(Contact contact) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DatabaseHandler.KEY_NAME, contact.get_name());
        values.put(DatabaseHandler.KEY_PH_NO, contact.get_phone_number());

        return db.update(DatabaseHandler.TABLE_CONTACTS, values, DatabaseHandler.KEY_ID + " = ?",
                new String[]{String.valueOf(contact.get_id())});
    }

    // 刪除聯絡人
    public void deleteContact(Contact contact) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(DatabaseHandler.TABLE_CONTACTS, DatabaseHandler.KEY_ID + " = ?",
                new String[]{String.valueOf(contact.get_id())});
        db.close();
    }
}

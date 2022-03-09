package com.group7.fitnessapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBaseReviewTest {

    public static final String K_RATING = "rating";
    public static final String K_FEEDBACK = "feedback";
    private static final String DB_NAME = "DBRevRec";
    private static final String DB_TABLE = "tblReview";
    private static final int DB_VERSION = 1;

    private DBHelper dbHelper;
    private final Context context;
    private SQLiteDatabase dBase;

    private static class DBHelper extends SQLiteOpenHelper{
        public DBHelper(Context context){
            super(context, DB_NAME,null, DB_VERSION);
            // TODO Auto-generated method stub
        }

        @Override
        public void onCreate(SQLiteDatabase db){
            // TODO Auto-generated method stub
            db.execSQL(
                    " CREATE TABLE " + DB_TABLE + " (" +
                            K_RATING + " TEXT NOT NULL," +
                            K_FEEDBACK + " TEXT NOT NULL);"
            );
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
            // TODO Auto-generated method stub
            db.execSQL(" DROP TABLE IF EXISTS " + DB_TABLE);
            onCreate(db);
        }
    }

    public DBaseReviewTest(Context c) { context = c; }

    public DBaseReviewTest open() throws SQLException{
        dbHelper = new DBHelper(context);
        dBase = dbHelper.getWritableDatabase();
        return this;
    }
    public void close() { dbHelper.close(); }

    public long add(float _rating, String _feedback) {
        // TODO Auto-generated method stub
        ContentValues cv = new ContentValues();
        cv.put(K_RATING, _rating);
        cv.put(K_FEEDBACK, _feedback);
        return dBase.insert(DB_TABLE, null, cv);
    }

    public String getAllRecord(){
        // TODO Auto-generated method stub
        String[] cols = new String[]{K_RATING, K_FEEDBACK};
        Cursor c = dBase.query(DB_TABLE, cols,null,null,null,null,null);
        String result = "";

        float indexRating = c.getColumnIndex(K_RATING);
        int indexFeedback = c.getColumnIndex(K_FEEDBACK);

        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
            result = result + c.getString((int) indexRating) + " "
                    + c.getString(indexFeedback)
                    + "\n";
        }
        return result;
    }
}


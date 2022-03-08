package com.group7.fitnessapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MealPlanDBase {
    public static final String K_RID = "_id";
    public static final String K_DAY = "day";
    public static final String K_BREAKFAST = "breakfast";
    public static final String K_LUNCH = "lunch";
    public static final String K_DINNER = "dinner";
    public static final String K_COMPLETED = "done";
    private static final String DB_NAME = "DBMealPlan";
    private static final String DB_TABLE = "tblMealPlan";
    private static final int DB_VERSION = 1;

    private DBHelper dbHelper;
    private final Context context;
    private SQLiteDatabase dBase;

    private static class DBHelper extends SQLiteOpenHelper{
        public DBHelper(Context context){
            super(context, DB_NAME, null, DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL(
                    "CREATE TABLE " + DB_TABLE + " (" +
                            K_RID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                            K_DAY + " TEXT NOT NULL, " +
                            K_BREAKFAST + " TEXT NOT NULL, " +
                            K_LUNCH + " TEXT NOT NULL, " +
                            K_DINNER + " TEXT NOT NULL, " +
                            K_COMPLETED + " TEXT NOT NULL);"
            );
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DB_TABLE);
            onCreate(sqLiteDatabase);
        }
    }

    public MealPlanDBase(Context c)
    {
        context = c;

    }

    public MealPlanDBase open() throws SQLException{
        dbHelper = new DBHelper(context);
        dBase = dbHelper.getWritableDatabase();
        return this;
    }
    public void close(){
        dbHelper.close();
    }

    public void addAllMealPlan(){
        ContentValues day1 = new ContentValues();
        day1.put(K_DAY, "1");
        day1.put(K_BREAKFAST, R.string.d1_bf_content);
        day1.put(K_LUNCH, R.string.d1_lunch_content);
        day1.put(K_DINNER, R.string.d1_dinner_content);
        day1.put(K_COMPLETED, "false");

        ContentValues day2 = new ContentValues();
        day2.put(K_DAY, "2");
        day2.put(K_BREAKFAST, R.string.d2_bf_content);
        day2.put(K_LUNCH, R.string.d2_lunch_content);
        day2.put(K_DINNER, R.string.d2_dinner_content);
        day2.put(K_COMPLETED, "false");

        ContentValues day3 = new ContentValues();
        day3.put(K_DAY, "3");
        day3.put(K_BREAKFAST, R.string.d3_bf_content);
        day3.put(K_LUNCH, R.string.d3_lunch_content);
        day3.put(K_DINNER, R.string.d3_dinner_content);
        day3.put(K_COMPLETED, "false");

        ContentValues day4 = new ContentValues();
        day4.put(K_DAY, "4");
        day4.put(K_BREAKFAST, R.string.d4_bf_content);
        day4.put(K_LUNCH, R.string.d4_lunch_content);
        day4.put(K_DINNER, R.string.d4_dinner_content);
        day4.put(K_COMPLETED, "false");

        ContentValues day5 = new ContentValues();
        day5.put(K_DAY, "5");
        day5.put(K_BREAKFAST, R.string.d5_bf_content);
        day5.put(K_LUNCH, R.string.d5_lunch_content);
        day5.put(K_DINNER, R.string.d5_dinner_content);
        day5.put(K_COMPLETED, "false");

        ContentValues day6 = new ContentValues();
        day6.put(K_DAY, "6");
        day6.put(K_BREAKFAST, R.string.d6_bf_content);
        day6.put(K_LUNCH, R.string.d6_lunch_content);
        day6.put(K_DINNER, R.string.d6_dinner_content);
        day6.put(K_COMPLETED, "false");

        ContentValues day7 = new ContentValues();
        day7.put(K_DAY, "7");
        day7.put(K_BREAKFAST, R.string.d7_bf_content);
        day7.put(K_LUNCH, R.string.d7_lunch_content);
        day7.put(K_DINNER, R.string.d7_dinner_content);
        day7.put(K_COMPLETED, "false");

        dBase.insert(DB_TABLE, null, day1);
        dBase.insert(DB_TABLE, null, day2);
        dBase.insert(DB_TABLE, null, day3);
        dBase.insert(DB_TABLE, null, day4);
        dBase.insert(DB_TABLE, null, day5);
        dBase.insert(DB_TABLE, null, day6);
        dBase.insert(DB_TABLE, null, day7);
    }

    public String[] getMealPlan(String day) throws SQLException{
        String selectQuery = "SELECT * FROM " +DB_TABLE+" WHERE "+K_DAY+"="+day;
        Cursor c = null;
        c = dBase.rawQuery(selectQuery, null);
        String[] data = new String[5];
        if(c.moveToFirst()){
            data[0] = c.getString((int)c.getColumnIndex(K_DAY));
            data[1] = c.getString((int)c.getColumnIndex(K_BREAKFAST));
            data[2] = c.getString((int)c.getColumnIndex(K_LUNCH));
            data[3] = c.getString((int)c.getColumnIndex(K_DINNER));
            data[4] = c.getString((int)c.getColumnIndex(K_COMPLETED));
        }

        return data;
    }

    public void reset_completed() throws SQLException{
        ContentValues cv = new ContentValues();
        cv.put(K_COMPLETED, "false");
        dBase.update(DB_TABLE, cv, null, null);
    }

    public void mark_complete(String day) throws SQLException{
        ContentValues cv= new ContentValues();
        cv.put(K_COMPLETED, "true");
        dBase.update(DB_TABLE, cv, K_DAY +"=" + day , null);
    }
}

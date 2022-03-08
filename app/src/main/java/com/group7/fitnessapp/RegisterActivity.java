package com.group7.fitnessapp;


import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.EditText;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    EditText Name, Email, Number, User, Password, Height, Weight, Age;
    Button SignUp;
    CheckBox terms;
    RadioButton Male, Female;
    String NameHolder, EmailHolder, NumberHolder, UserHolder, PasswordHolder, HeightHolder, WeightHolder, AgeHolder;
    Boolean EditTextEmptyHolder, checked;
    SQLiteDatabase sqLiteDatabaseObj;
    String SQLiteDataBaseQueryHolder;
    DatabaseHelper sqLiteHelper;
    Cursor cursor;
    String F_Result = "Not_Found";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        SignUp = (Button)findViewById(R.id.buttonRegister);

        Name = (EditText)findViewById(R.id.editName);
        Email = (EditText)findViewById(R.id.editEmail);
        Number = (EditText)findViewById(R.id.editNumber);
        User = (EditText)findViewById(R.id.editUser);
        Password = (EditText)findViewById(R.id.editPassword);
        Height = (EditText)findViewById(R.id.editHeight);
        Weight = (EditText)findViewById(R.id.editWeight);
        Age = (EditText)findViewById(R.id.editAge);
        Male = (RadioButton)findViewById(R.id.radioMale);
        Female = (RadioButton)findViewById(R.id.radioFemale);
        terms = (CheckBox)findViewById(R.id.checkBox);

        sqLiteHelper = new DatabaseHelper(this);

        // Adding click listener to register button.
        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Creating SQLite database if dose n't exists
                SQLiteDataBaseBuild();

                // Creating SQLite table if dose n't exists.
                SQLiteTableBuild();

                // Checking EditText is empty or Not.
                CheckEditTextStatus();

                // Method to check Email is already exists or not.
                CheckingEmailAlreadyExistsOrNot();

                // Empty EditText After done inserting process.
                EmptyEditTextAfterDataInsert();


            }
        });

    }

    // SQLite database build method.
    public void SQLiteDataBaseBuild(){

        sqLiteDatabaseObj = openOrCreateDatabase(DatabaseHelper.DATABASE_NAME, Context.MODE_PRIVATE, null);

    }

    // SQLite table build method.
    public void SQLiteTableBuild() {

        sqLiteDatabaseObj.execSQL("CREATE TABLE IF NOT EXISTS " + DatabaseHelper.TABLE_NAME + "(" + DatabaseHelper.Table_Column_ID + " PRIMARY KEY AUTOINCREMENT NOT NULL, " + DatabaseHelper.Table_Column_1_Name + " VARCHAR, " + DatabaseHelper.Table_Column_2_Email + " VARCHAR, " + DatabaseHelper.Table_Column_3_Password + " VARCHAR);");

    }

    // Insert data into SQLite database method.
    public void InsertDataIntoSQLiteDatabase(){

        // If editText is not empty then this block will executed.
        if(EditTextEmptyHolder == true)
        {

            // SQLite query to insert data into table.
            SQLiteDataBaseQueryHolder = "INSERT INTO "+ DatabaseHelper.TABLE_NAME+" (name,email,number,username,password,height,weight,age) VALUES('"+NameHolder+"', '"+EmailHolder+"', '"+NumberHolder+"', '"+UserHolder+"', '"+PasswordHolder+"', '"+HeightHolder+"', '"+WeightHolder+"', '"+AgeHolder+"');";

            // Executing query.
            sqLiteDatabaseObj.execSQL(SQLiteDataBaseQueryHolder);

            // Closing SQLite database object.
            sqLiteDatabaseObj.close();

            // Printing toast message after done inserting.
            Toast.makeText(RegisterActivity.this,"User Registered Successfully", Toast.LENGTH_LONG).show();

        }
        // This block will execute if any of the registration EditText is empty.
        else {

            // Printing toast message if any of EditText is empty.
            Toast.makeText(RegisterActivity.this,"Please Fill All The Required Fields.", Toast.LENGTH_LONG).show();

        }

    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        String str="";

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioMale:
                if (checked)
                    str = "Male";
                // Male
                break;
            case R.id.radioFemale:
                if (checked)
                    str = "Female";
                // Female
                break;
        }
        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
    }


    public void onCheckboxClicked(View view) {
        String terms = "";
        boolean checked = ((CheckBox) view).isChecked();

        if(checked)
            terms = "Terms Accepted";
        else terms = "Terms Not Accepted";
    }

    // Empty edittext after done inserting process method.
    public void EmptyEditTextAfterDataInsert(){

        Name.getText().clear();

        Email.getText().clear();

        Password.getText().clear();

        Number.getText().clear();

        User.getText().clear();

        Height.getText().clear();

        Weight.getText().clear();

        Age.getText().clear();

    }

    // Method to check EditText is empty or Not.
    public void CheckEditTextStatus(){

        // Getting value from All EditText and storing into String Variables.
        NameHolder = Name.getText().toString() ;
        EmailHolder = Email.getText().toString();
        PasswordHolder = Password.getText().toString();
        NumberHolder = Number.getText().toString();
        UserHolder = User.getText().toString();
        HeightHolder = Height.getText().toString();
        WeightHolder = Weight.getText().toString();
        AgeHolder = Age.getText().toString();

        if(TextUtils.isEmpty(NameHolder) || TextUtils.isEmpty(EmailHolder) || TextUtils.isEmpty(PasswordHolder) || TextUtils.isEmpty(NumberHolder) || TextUtils.isEmpty(UserHolder) || TextUtils.isEmpty(HeightHolder) || TextUtils.isEmpty(WeightHolder) || TextUtils.isEmpty(AgeHolder)){

            EditTextEmptyHolder = false ;

        }
        else {

            EditTextEmptyHolder = true ;
        }
    }

    // Checking Email is already exists or not.
    public void CheckingEmailAlreadyExistsOrNot(){

        // Opening SQLite database write permission.
        sqLiteDatabaseObj = sqLiteHelper.getWritableDatabase();

        // Adding search email query to cursor.
        cursor = sqLiteDatabaseObj.query(DatabaseHelper.TABLE_NAME, null, " " + DatabaseHelper.Table_Column_2_Email + "=?", new String[]{EmailHolder}, null, null, null);

        while (cursor.moveToNext()) {

            if (cursor.isFirst()) {

                cursor.moveToFirst();

                // If Email is already exists then Result variable value set as Email Found.
                F_Result = "Email Found";

                // Closing cursor.
                cursor.close();
            }
        }

        // Calling method to check final result and insert data into SQLite database.
        CheckFinalResult();

    }


    // Checking result
    public void CheckFinalResult(){

        // Checking whether email is already exists or not.
        if(F_Result.equalsIgnoreCase("Email Found"))
        {

            // If email is exists then toast msg will display.
            Toast.makeText(RegisterActivity.this,"Email Already Exists",Toast.LENGTH_LONG).show();

        }
        else {

            // If email already doesn't exist then user registration details will be entered to SQLite database.
            InsertDataIntoSQLiteDatabase();

        }

        F_Result = "Not_Found" ;

    }
}
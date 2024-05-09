package com.example.library_manager;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DB_Handler extends SQLiteOpenHelper {

    // creating a constant variables for our database.
    // below variable is for our database name.
    private static final String DB_NAME = "library_db";

    // below int is our database version
    private static final int DB_VERSION = 1;

    //book table
    private static final String BOOK_TABLE = "book_table";
    private static final String BOOK_ID ="book_id";
    private static final String TITLE = "title";
    private static final String PUBLISHER_NAME = "publisher_name";


    //publisher table
    private static final String PUBLISHER_TABLE = "publisher_table";
    private static final String NAME = "name";
    private static final String ADDRESS = "address";
    private static final String PHONE = "phone";

    //branch table
    private static final String BRANCH_TABLE = "branch_table";
    private static final String BRANCH_ID = "branch_id";
    private static final String BRANCH_NAME = "branch_name";
    private static final String BRANCH_ADDRESS= "branch_address";
    //ADDRESS


    //member table
    private static final String MEMBER_TABLE = "member_table";
    private static final String CARD_NO = "card_no";
    private static final String MEMBER_NAME = "member_name";
    private static final String MEMBER_ADDRESS = "member_address";
    private static final String MEMBER_PHONE = "member_phone";
    private static final String UNPAID_DUES = "unpaid_dues";


    //book_author table
    private static final String AUTHOR_TABLE = "author_table";
    private static final String AUTHOR_BOOK_ID = "book_id";
    private static final String AUTHOR_NAME = "author_name";


    //book_copy table
    private static final String COPY_TABLE = "copy_table";
    private static final String COPY_BOOK_ID = "book_id";
    private static final String COPY_BRANCH_ID = "branch_id";
    private static final String ACCESS_NO = "access_no";


    //loan table
    private static final String LOAN_TABLE = "loan_table";
    private static final String LOAN_ACCESS_NO = "access_no";
    private static final String LOAN_BRANCH_ID = "branch_id";
    private static final String LOAN_CARD_NO = "card_no";
    private static final String DATE_OUT = "date_out";
    private static final String DATE_DUE = "date_due";
    private static final String DATE_RETURNED = "date_returned";


    //queries
    private static final String CREATE_TABLE_BOOK = "CREATE TABLE " + BOOK_TABLE + " ("
            + BOOK_ID + " TEXT PRIMARY KEY, "
            + TITLE + " TEXT,"
            + PUBLISHER_NAME + " TEXT" + ")";

    private static final String CREATE_TABLE_PUBLISHER = "CREATE TABLE " + PUBLISHER_TABLE + " ("
            + NAME + " TEXT PRIMARY KEY ,"
            + ADDRESS + " TEXT, "
            + PHONE + " INTEGER " + ")";
    private static final String CREATE_TABLE_BRANCH = "CREATE TABLE " + BRANCH_TABLE + " ("
            + BRANCH_ID + " TEXT PRIMARY KEY ,"
            + BRANCH_NAME + " TEXT,"
            + BRANCH_ADDRESS + " TEXT ) ";

    private static final String CREATE_TABLE_MEMBER = "CREATE TABLE " + MEMBER_TABLE + " ("
            + CARD_NO + " TEXT PRIMARY KEY ,"
            + MEMBER_NAME + " TEXT, "
            + MEMBER_ADDRESS + " TEXT, "
            + MEMBER_PHONE + " TEXT, "
            + UNPAID_DUES + " REAL" + ")";

    private static final String CREATE_TABLE_AUTHOR = "CREATE TABLE " + AUTHOR_TABLE + " ("
            + AUTHOR_BOOK_ID + " TEXT PRIMARY KEY ,"
            + AUTHOR_NAME + " TEXT ,"
            + " FOREIGN KEY("+ AUTHOR_BOOK_ID+") REFERENCES " + BOOK_TABLE +"("+BOOK_ID+"))";

    private static final String CREATE_TABLE_COPY = "CREATE TABLE " + COPY_TABLE + " ("
            + COPY_BOOK_ID + " TEXT PRIMARY KEY ,"
            + COPY_BRANCH_ID + " TEXT ,"
            + ACCESS_NO + " TEXT,"
            + " FOREIGN KEY("+ COPY_BOOK_ID +") REFERENCES " + BOOK_TABLE +"("+BOOK_ID+"),"
            + " FOREIGN KEY("+ COPY_BRANCH_ID+") REFERENCES " + BRANCH_TABLE +"("+BRANCH_ID+"))";

    private static final String CREATE_TABLE_LOAN = "CREATE TABLE " + LOAN_TABLE + " ("
            + LOAN_ACCESS_NO + " TEXT PRIMARY KEY ,"
            + LOAN_BRANCH_ID + " TEXT ,"
            + LOAN_CARD_NO + " TEXT ,"
            + DATE_OUT + " TEXT  ,"
            + DATE_DUE + " TEXT  ,"
            + DATE_RETURNED + " TEXT,"
            + " FOREIGN KEY("+ LOAN_ACCESS_NO+") REFERENCES " + COPY_TABLE +"("+ACCESS_NO+"),"
            + " FOREIGN KEY("+ LOAN_BRANCH_ID+") REFERENCES " + COPY_TABLE +"("+COPY_BRANCH_ID+"),"
            + " FOREIGN KEY("+ LOAN_CARD_NO+") REFERENCES " + MEMBER_TABLE +"("+CARD_NO+"),"
            + "FOREIGN KEY("+ LOAN_BRANCH_ID+") REFERENCES " + BRANCH_TABLE +"("+BRANCH_ID+"))";



    // creating a constructor for our database handler.
    public DB_Handler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // below method is for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_BOOK );
        db.execSQL(CREATE_TABLE_PUBLISHER);
        db.execSQL(CREATE_TABLE_BRANCH);
        db.execSQL(CREATE_TABLE_MEMBER);
        db.execSQL(CREATE_TABLE_AUTHOR);
        db.execSQL(CREATE_TABLE_COPY);
        db.execSQL(CREATE_TABLE_LOAN);

    }

    // this method is use to add new books to our sqlite database.
    public void addNewBook(String book_id, String title, String publisher_name) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(BOOK_ID, book_id);
        values.put(TITLE, title);
        values.put(PUBLISHER_NAME, publisher_name);

        db.insert(BOOK_TABLE, null, values);

        db.close();
    }

    //add new publishers
    public void addNewPub(String name, String address, String phone) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(NAME, name);
        values.put(ADDRESS, address);
        values.put(PHONE, phone);

        db.insert(PUBLISHER_TABLE, null, values);

        db.close();
    }

    //add new branch
    public void addNewBranch(String branch_id, String branch_name, String address) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(BRANCH_ID, branch_id);
        values.put(BRANCH_NAME, branch_name);
        values.put(BRANCH_ADDRESS, address);

        db.insert(BRANCH_TABLE, null, values);

        db.close();
    }

    //add new member
    public void addNewMember(String card_no, String name, String address, String phone, String unpaid_dues) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(CARD_NO, card_no);
        values.put(MEMBER_NAME, name);
        values.put(MEMBER_ADDRESS, address);
        values.put(MEMBER_PHONE, phone);
        values.put(UNPAID_DUES, unpaid_dues);

        db.insert(MEMBER_TABLE, null, values);

        db.close();
    }

    //add new author
    public void addNewAuthor(String book_id, String author_name) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(AUTHOR_BOOK_ID, book_id);
        values.put(AUTHOR_NAME, author_name);

        db.insert(AUTHOR_TABLE, null, values);

        db.close();
    }

    //add new book_copy
    public void addNewBookCopy(String book_id, String branch_id, String access_no) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(COPY_BOOK_ID, book_id);
        values.put(COPY_BRANCH_ID, branch_id);
        values.put(ACCESS_NO, access_no);

        db.insert(COPY_TABLE, null, values);

        db.close();
    }

    //add new lending
    public void addNewLoan(String access_no, String branch_id, String card_no, String date_out, String date_due, String date_returned) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(LOAN_ACCESS_NO, access_no);
        values.put(LOAN_BRANCH_ID, branch_id);
        values.put(LOAN_CARD_NO, card_no);
        values.put(DATE_OUT, date_out);
        values.put(DATE_DUE, date_due);
        values.put(DATE_RETURNED, date_returned);

        db.insert(LOAN_TABLE, null, values);

        db.close();
    }

    //delete a book
    public void deleteEntry(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        // Delete the row with the given id
        db.delete(BOOK_TABLE, BOOK_ID + " = ?", new String[]{String.valueOf(id)});
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + BOOK_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + PUBLISHER_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + BRANCH_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + MEMBER_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + AUTHOR_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + COPY_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + LOAN_TABLE);
        onCreate(db);
    }
}


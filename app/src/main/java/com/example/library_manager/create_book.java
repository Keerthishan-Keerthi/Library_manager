package com.example.library_manager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class create_book extends AppCompatActivity {

    private EditText bookid, booktitle, bookpub;
    private Button addbook;

    private DB_Handler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_book);

        // initializing all our variables.
        bookid = findViewById(R.id.book_bookid);
        booktitle = findViewById(R.id.book_booktitle);
        bookpub = findViewById(R.id.book_bookpub);
        addbook = findViewById(R.id.btn_book_add);


        // creating a new dbhandler class
        // and passing our context to it.
        dbHandler = new DB_Handler(create_book.this);

        addbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // below line is to get data from all edit text fields.
                String book_id = bookid.getText().toString();
                String book_title = booktitle.getText().toString();
                String book_pub = bookpub.getText().toString();


                // validating if the text fields are empty or not.
                if (book_id.isEmpty() && book_title.isEmpty() && book_pub.isEmpty() ) {
                    Toast.makeText(create_book.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                // on below line we are calling a method to add new
                // course to sqlite data and pass all our values to it.
                dbHandler.addNewBook(book_id, book_title, book_pub);

                // after adding the data we are displaying a toast message.
                Toast.makeText(create_book.this, "Book has been added.", Toast.LENGTH_SHORT).show();
                bookid.setText("");
                booktitle.setText("");
                bookpub.setText("");
            }
        });
        findViewById(R.id.imageView2).setOnClickListener(
                a-> finish()
        );



    }


}
package com.example.library_manager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class delete_book extends AppCompatActivity {
    private EditText deleteId;
    private Button deleteBook;

    private DB_Handler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_book);

        // initializing all our variables.
        deleteId = findViewById(R.id.delete_bookid);
        deleteBook = findViewById(R.id.btn_book_delete);

        dbHandler = new DB_Handler(delete_book.this);

        deleteBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // below line is to get data from all edit text fields.
                String book_id = deleteId.getText().toString();



                // validating if the text fields are empty or not.
                if (book_id.isEmpty() ) {
                    Toast.makeText(delete_book.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                // on below line we are calling a method to add new
                // course to sqlite data and pass all our values to it.
                dbHandler.deleteEntry(book_id);

                // after adding the data we are displaying a toast message.
                Toast.makeText(delete_book.this, "Book has been deleted.", Toast.LENGTH_SHORT).show();
                deleteId.setText("");

            }
        });
        findViewById(R.id.imageView2).setOnClickListener(
                a-> finish()
        );

    }
}
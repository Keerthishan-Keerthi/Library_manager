package com.example.library_manager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class create_author extends AppCompatActivity {

    private EditText bookid, authname;
    private Button addauthor;
    private DB_Handler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_author);

        findViewById(R.id.imageView2).setOnClickListener(
                a-> finish()
        );

        // initializing all our variables.
        bookid = findViewById(R.id.author_bookid);
        authname = findViewById(R.id.author_name);
        addauthor = findViewById(R.id.btn_author_add);



        // creating a new dbhandler class
        // and passing our context to it.
        dbHandler = new DB_Handler(create_author.this);

        // below line is to add on click listener for our add course button.
        addauthor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // below line is to get data from all edit text fields.
                String book_id = bookid.getText().toString();
                String author_name= authname.getText().toString();


                // validating if the text fields are empty or not.
                if (book_id.isEmpty() && author_name.isEmpty() ) {
                    Toast.makeText(create_author.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                // on below line we are calling a method to add new
                // course to sqlite data and pass all our values to it.
                dbHandler.addNewAuthor(book_id, author_name);

                // after adding the data we are displaying a toast message.
                Toast.makeText(create_author.this, "Author has been added.", Toast.LENGTH_SHORT).show();
                bookid.setText("");
                authname.setText("");

            }
        });
    }
}
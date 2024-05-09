package com.example.library_manager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class create_copy extends AppCompatActivity {

    private EditText bookid, branchid, accessno;
    private Button addcopy;
    private DB_Handler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_copy);

        findViewById(R.id.imageView2).setOnClickListener(
                a-> finish()
        );

        // initializing all our variables.
        bookid = findViewById(R.id.copy_bookid);
        branchid = findViewById(R.id.copy_branchid);
        accessno = findViewById(R.id.copy_accessno);
        addcopy = findViewById(R.id.btn_copy_add);


        // creating a new dbhandler class
        // and passing our context to it.
        dbHandler = new DB_Handler(create_copy.this);

        // below line is to add on click listener for our add course button.
        addcopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // below line is to get data from all edit text fields.
                String book_id = bookid.getText().toString();
                String branch_id = branchid.getText().toString();
                String access_no = accessno.getText().toString();


                // validating if the text fields are empty or not.
                if (book_id.isEmpty() && branch_id.isEmpty() && access_no.isEmpty() ) {
                    Toast.makeText(create_copy.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                // on below line we are calling a method to add new
                // course to sqlite data and pass all our values to it.
                dbHandler.addNewBookCopy(book_id, branch_id, access_no);

                // after adding the data we are displaying a toast message.
                Toast.makeText(create_copy.this, "Copy has been added.", Toast.LENGTH_SHORT).show();
                bookid.setText("");
                branchid.setText("");
                accessno.setText("");
            }
        });
    }
}
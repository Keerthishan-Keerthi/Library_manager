package com.example.library_manager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class create_pub extends AppCompatActivity {

    private EditText pubname, pubaddr, pubcontact;
    private Button addpub;
    private DB_Handler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_pub);

        findViewById(R.id.imageView2).setOnClickListener(
                a-> finish()
        );

        // initializing all our variables.
        pubname = findViewById(R.id.pub_name);
        pubaddr = findViewById(R.id.pub_addr);
        pubcontact = findViewById(R.id.pub_phone);
        addpub = findViewById(R.id.btn_pub_add);


        // creating a new dbhandler class
        // and passing our context to it.
        dbHandler = new DB_Handler(create_pub.this);

        // below line is to add on click listener for our add course button.
        addpub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // below line is to get data from all edit text fields.
                String pub_name = pubname.getText().toString();
                String pub_addr = pubaddr.getText().toString();
                String pub_contact = pubcontact.getText().toString();


                // validating if the text fields are empty or not.
                if (pub_name.isEmpty() && pub_addr.isEmpty() && pub_contact.isEmpty() ) {
                    Toast.makeText(create_pub.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                // on below line we are calling a method to add new
                // course to sqlite data and pass all our values to it.
                dbHandler.addNewPub(pub_name, pub_addr, pub_contact);

                // after adding the data we are displaying a toast message.
                Toast.makeText(create_pub.this, "Publisher has been added.", Toast.LENGTH_SHORT).show();
                pubname.setText("");
                pubaddr.setText("");
                pubcontact.setText("");
            }
        });
    }
}
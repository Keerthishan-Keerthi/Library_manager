package com.example.library_manager;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class create_member extends AppCompatActivity {

    private EditText cadrno, name, addr, phone, dues;
    private Button addUser;
    private DB_Handler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_member);

        findViewById(R.id.image_back).setOnClickListener(
                a-> finish()
        );

        // initializing all our variables.
        cadrno = findViewById(R.id.member_cardno);
        name = findViewById(R.id.member_name);
        addr = findViewById(R.id.member_addr);
        phone = findViewById(R.id.member_phone);
        dues = findViewById(R.id.member_dues);
        addUser = findViewById(R.id.btn_member_add);


        // creating a new dbhandler class
        // and passing our context to it.
        dbHandler = new DB_Handler(create_member.this);

        // below line is to add on click listener for our add course button.
        addUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // below line is to get data from all edit text fields.
                String card_no = cadrno.getText().toString();
                String m_name = name.getText().toString();
                String m_addr = addr.getText().toString();
                String m_phone = phone.getText().toString();
                String m_dues = dues.getText().toString();


                // validating if the text fields are empty or not.
                if (card_no.isEmpty() && m_name.isEmpty() && m_addr.isEmpty() && m_phone.isEmpty() && m_dues.isEmpty() ) {
                    Toast.makeText(create_member.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                // on below line we are calling a method to add new
                // course to sqlite data and pass all our values to it.
                dbHandler.addNewMember(card_no, m_name, m_addr, m_phone, m_dues);

                // after adding the data we are displaying a toast message.
                Toast.makeText(create_member.this, "Member has been added.", Toast.LENGTH_SHORT).show();
                cadrno.setText("");
                name.setText("");
                addr.setText("");
                phone.setText("");
                dues.setText("");
            }
        });
    }
}
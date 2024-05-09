package com.example.library_manager;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class create_loan extends AppCompatActivity {

    private EditText accessno, branchid, cardno, outdate, duedate, returndate;
    private Button addloan;
    private DB_Handler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_loan);

        findViewById(R.id.image_back).setOnClickListener(
                a-> finish()
        );

        // initializing all our variables.
        accessno = findViewById(R.id.loan_accessno);
        branchid = findViewById(R.id.loan_branchid);
        cardno = findViewById(R.id.loan_cardno);
        outdate = findViewById(R.id.loan_outdate);
        duedate = findViewById(R.id.loan_duedate);
        returndate = findViewById(R.id.loan_returndate);
        addloan = findViewById(R.id.btn_loan_add);


        // creating a new dbhandler class
        // and passing our context to it.
        dbHandler = new DB_Handler(create_loan.this);

        // below line is to add on click listener for our add course button.
        addloan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // below line is to get data from all edit text fields.
                String access_no = accessno.getText().toString();
                String branch_id = branchid.getText().toString();
                String card_no = cardno.getText().toString();
                String out_date = outdate.getText().toString();
                String due_date = duedate.getText().toString();
                String return_date = returndate.getText().toString();


                // validating if the text fields are empty or not.
                if (access_no.isEmpty() && branch_id.isEmpty() && card_no.isEmpty() && out_date.isEmpty() && due_date.isEmpty() && return_date.isEmpty() && card_no.isEmpty()) {
                    Toast.makeText(create_loan.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                // on below line we are calling a method to add new
                // course to sqlite data and pass all our values to it.
                dbHandler.addNewLoan(access_no, branch_id, card_no, out_date, due_date, return_date);

                // after adding the data we are displaying a toast message.
                Toast.makeText(create_loan.this, "Lending has been added.", Toast.LENGTH_SHORT).show();
                accessno.setText("");
                branchid.setText("");
                cardno.setText("");
                outdate.setText("");
                duedate.setText("");
                returndate.setText("");
            }
        });
    }
}
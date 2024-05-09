package com.example.library_manager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class create_branch extends AppCompatActivity {
    private EditText branchid, branchname, branchaddr;
    private Button addbranch;
    private DB_Handler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_branch);

        findViewById(R.id.imageView2).setOnClickListener(
                a-> finish()
        );
        // initializing all our variables.
        branchid = findViewById(R.id.branch_branchid);
        branchname = findViewById(R.id.branch_name);
        branchaddr = findViewById(R.id.branch_address);
        addbranch = findViewById(R.id.btn_branch_add);


        // creating a new dbhandler class
        // and passing our context to it.
        dbHandler = new DB_Handler(create_branch.this);

        // below line is to add on click listener for our add course button.
        addbranch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // below line is to get data from all edit text fields.
                String branch_id = branchid.getText().toString();
                String branch_name = branchname.getText().toString();
                String branch_addr = branchaddr.getText().toString();


                // validating if the text fields are empty or not.
                if (branch_id.isEmpty() && branch_name.isEmpty() && branch_addr.isEmpty() ) {
                    Toast.makeText(create_branch.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                // on below line we are calling a method to add new
                // course to sqlite data and pass all our values to it.
                dbHandler.addNewBranch(branch_id, branch_name, branch_addr);

                // after adding the data we are displaying a toast message.
                Toast.makeText(create_branch.this, "Branch has been added.", Toast.LENGTH_SHORT).show();
                branchid.setText("");
                branchname.setText("");
                branchaddr.setText("");
            }
        });
    }
}
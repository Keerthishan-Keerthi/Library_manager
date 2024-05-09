package com.example.library_manager;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class activity_book extends AppCompatActivity {



    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        findViewById(R.id.image_back).setOnClickListener(
                a-> finish()
        );

    }

    public void book_btn(View view){
        switch (view.getId()){
            case R.id.ibtn_viewBooks:
                startActivity(new Intent(activity_book.this, view_book.class));
                break;
            case R.id.ibtn_addBooks:
                startActivity(new Intent(activity_book.this, create_book.class));
                break;
        }
    }

}
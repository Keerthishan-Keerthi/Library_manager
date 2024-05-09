package com.example.library_manager;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @SuppressLint("NonConstantResourceId")
    public void main_btn(View view){
        switch (view.getId()){
            case R.id.btn_books:
                startActivity(new Intent(MainActivity.this , activity_book.class));
                break;
            case R.id.btn_pubs:
                startActivity(new Intent(MainActivity.this , activity_pub.class));
                break;
            case R.id.btn_branches:
                startActivity(new Intent(MainActivity.this , activity_branch.class));
                break;
            case R.id.btn_members:
                startActivity(new Intent(MainActivity.this , activity_member.class));
                break;
            case R.id.btn_authors:
                startActivity(new Intent(MainActivity.this , activity_author.class));
                break;
            case R.id.btn_copies:
                startActivity(new Intent(MainActivity.this , activity_copy.class));
                break;
            case R.id.btn_lendings:
                startActivity(new Intent(MainActivity.this , activity_loan.class));
                break;
            case R.id.btn_delete:
                startActivity(new Intent(MainActivity.this , delete_book.class));
                break;
            case R.id.btn_exit:
                this.finishAffinity();
                break;
        }
    }

}


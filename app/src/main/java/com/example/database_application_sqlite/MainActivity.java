package com.example.database_application_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView insert,read,update,delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        insert = findViewById(R.id.insert);
        read = findViewById(R.id.read);
        update = findViewById(R.id.update);
        delete = findViewById(R.id.delete);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Insert_Activity.class);
                Toast.makeText(MainActivity.this, "Welcome to Insert page", Toast.LENGTH_SHORT).show();
                startActivity(intent);
                finish();
            }
        });

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Read_Activity.class);
                Toast.makeText(MainActivity.this, "Welcome to Read Data page", Toast.LENGTH_SHORT).show();
                startActivity(intent);
                finish();
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Update_Activity.class);
                Toast.makeText(MainActivity.this, "Welcome to Update Data page", Toast.LENGTH_SHORT).show();
                startActivity(intent);
                finish();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Delete_Activity.class);
                Toast.makeText(MainActivity.this, "Welcome to Delete Data page", Toast.LENGTH_SHORT).show();
                startActivity(intent);
                finish();
            }
        });
    }
}
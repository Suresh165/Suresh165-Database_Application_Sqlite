package com.example.database_application_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Insert_Activity extends AppCompatActivity {

    private EditText name,email;
    private Button btn_insert;

    DatabaseHelper mydb = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_);

        name  = findViewById(R.id.name);
        email = findViewById(R.id.email);

        btn_insert = findViewById(R.id.btn_insert);

        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Insert_Activity.this,MainActivity.class);
              //  Toast.makeText(Insert_Activity.this, "", Toast.LENGTH_SHORT).show();
                startActivity(intent);
                finish();
                Insert_Info();
            }
        });
    }

    private void Insert_Info() {
        String strname = name.getText().toString();
        String stremail = email.getText().toString();

        boolean result_1 = mydb.Insert_Data(strname,stremail);
        if (TextUtils.isEmpty(strname)){
            Toast.makeText(this, "Enter the Name", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(stremail)){
            Toast.makeText(this, "Enter the Email", Toast.LENGTH_SHORT).show();
        }else if (result_1){
            Toast.makeText(this, "Insert Data", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Data is not insert", Toast.LENGTH_SHORT).show();
        }

//        if (result_1){
//            Toast.makeText(this, "Insert Data", Toast.LENGTH_SHORT).show();
//        }else {
//            Toast.makeText(this, "Data is not Insert", Toast.LENGTH_SHORT).show();
//        }
    }
}
package com.example.database_application_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Update_Activity extends AppCompatActivity {

    private EditText user_ID,up_name,up_email;
    private Button btn_update;

    DatabaseHelper mydb = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_);

        user_ID = findViewById(R.id.userid);
        up_name = findViewById(R.id.up_name);
        up_email = findViewById(R.id.up_email);

        btn_update = findViewById(R.id.btn_update);

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Update_Activity.this,MainActivity.class);
                startActivity(intent);
                finish();
                Updateinfo();
            }
        });
    }

    private void Updateinfo() {
        String str_id = user_ID.getText().toString();
        String str_name = up_name.getText().toString();
        String str_email = up_email.getText().toString();

        boolean result_update = mydb.Update_Data(str_id,str_name,str_email);

        if (TextUtils.isEmpty(str_id)){
            Toast.makeText(this, "Enter the ID", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(str_name)){
            Toast.makeText(this, "Enter the Name", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(str_email)){
            Toast.makeText(this, "Enter the Email", Toast.LENGTH_SHORT).show();
        }else if (result_update){
            Toast.makeText(this, "Data is insert", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Data is not insert", Toast.LENGTH_SHORT).show();
        }

//        if (result_update)
//            Toast.makeText(this, "Data update", Toast.LENGTH_SHORT).show();
//        else
//            Toast.makeText(this, "Data is not Update", Toast.LENGTH_SHORT).show();
    }
}
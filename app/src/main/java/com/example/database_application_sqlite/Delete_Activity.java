package com.example.database_application_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Delete_Activity extends AppCompatActivity {

    private EditText del_id;
    private Button btn_delete;

    DatabaseHelper mydb = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_);

        del_id = findViewById(R.id.del_id);
        btn_delete = findViewById(R.id.btn_Delete);

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str_id = del_id.getText().toString();
                int result_delete = mydb.Delete_Data(str_id);
                if(TextUtils.isEmpty(str_id)){
                    Toast.makeText(Delete_Activity.this, "Enter the ID", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(Delete_Activity.this,MainActivity.class);
                    Toast.makeText(Delete_Activity.this, result_delete + "Data is deleted", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}
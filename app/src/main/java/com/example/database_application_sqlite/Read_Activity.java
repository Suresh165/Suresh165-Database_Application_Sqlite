package com.example.database_application_sqlite;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Read_Activity extends AppCompatActivity {

    private Button btn_readData;
    private TextView show_data;

    DatabaseHelper mydb = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_);

        btn_readData = findViewById(R.id.btn_read_data);
        show_data = findViewById(R.id.show_data_txtview);

        btn_readData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Readinfo();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.logout:
                Intent intent = new Intent(Read_Activity.this,MainActivity.class);
                Toast.makeText(this, "Log out successfully", Toast.LENGTH_SHORT).show();
                startActivity(intent);
                fileList();
                return true;
            case R.id.delete:
                Intent intent_Delete = new Intent(Read_Activity.this,Delete_Activity.class);
                Toast.makeText(this, "Welcome to delete Activity", Toast.LENGTH_SHORT).show();
                startActivity(intent_Delete);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void Readinfo() {
        Cursor cursor = mydb.Read_Data();
        StringBuilder stringBuilder = new StringBuilder();

        if (cursor!=null && cursor.getCount()>0){
            while (cursor.moveToNext()){
                stringBuilder.append("ID: ").append(cursor.getString(0)).append("\n");
                stringBuilder.append("Name: ").append(cursor.getString(1)).append("\n");
                stringBuilder.append("Email: ").append(cursor.getString(2)).append("\n");
            }
            show_data.setText(stringBuilder.toString());
        }else {
            Toast.makeText(this, "Data retrive failed", Toast.LENGTH_SHORT).show();
        }
    }
}
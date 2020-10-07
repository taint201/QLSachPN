package com.example.qlsach.Function;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.qlsach.List.ListUser;
import com.example.qlsach.R;
import com.example.qlsach.SQlite.SQLNguoiDung;

public class Xoa extends AppCompatActivity {

    EditText id;
    Button xoa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xoa);
        xoa = findViewById(R.id.btnXoa);
        id = findViewById(R.id.edtID);
        xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLNguoiDung sqlNguoiDung = new SQLNguoiDung(Xoa.this);
                sqlNguoiDung.xoaNguoiDung(id.getText().toString());
                Intent intent = new  Intent(Xoa.this, ListUser.class);
                startActivity(intent);
            }
        });
    }
}
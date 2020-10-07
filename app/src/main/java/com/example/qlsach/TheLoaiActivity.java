package com.example.qlsach;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.qlsach.List.ListCategory;
import com.example.qlsach.SQlite.SQLTheLoai;
import com.example.qlsach.MODEL.TheLoai;

public class TheLoaiActivity extends AppCompatActivity {
    Button btnAdd, btnShow, btnCancel;
    EditText edtid, edtname, edtvitri, edtmota;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_loai);
        setTitle("Thể Loại Sách");
        edtid = findViewById(R.id.edtIDUser);
        edtname = findViewById(R.id.edtNameBook);
        edtvitri = findViewById(R.id.edtLocation);
        edtmota = findViewById(R.id.edtMoTa);
        btnAdd = findViewById(R.id.btnAdd);
        btnShow = findViewById(R.id.btnShow);
        btnCancel = findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TheLoaiActivity.this, TrangChuActivity.class);
                startActivity(i);
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtid.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Không được để trống ID Thể Loại", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (edtname.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Không được để trống tên sách", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (edtvitri.length() == 0) {
                    Toast.makeText(getApplicationContext(), "không được để trống vị trí", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (edtmota.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Không được để trống mô tả", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    SQLTheLoai sqlTheLoai = new SQLTheLoai(TheLoaiActivity.this);
                    TheLoai theLoai = new TheLoai(edtid.getText().toString(), edtname.getText().toString(), edtvitri.getText().toString(),
                            edtmota.getText().toString());
                    sqlTheLoai.addTheLoai(theLoai);
                    Intent i = new Intent(TheLoaiActivity.this, ListCategory.class);
                    startActivity(i);
                    Toast.makeText(getApplicationContext(), "Thêm thành công", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TheLoaiActivity.this, ListCategory.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(), "Hiển thị thành công", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
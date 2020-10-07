package com.example.qlsach;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.qlsach.List.ListInvoice;
import com.example.qlsach.SQlite.SQLHoaDon;
import com.example.qlsach.MODEL.HoaDon;

public class HoaDonActivity extends AppCompatActivity {
Button btnAdd, btnShow, btnCancel;
EditText edtId, edtDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoa_don);
        edtId = findViewById(R.id.edtIDInvoice);
        edtDate = findViewById(R.id.edtDate);
        btnAdd = findViewById(R.id.btnAdd);
        btnShow = findViewById(R.id.btnShow);
        btnCancel = findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HoaDonActivity.this, TrangChuActivity.class);
                startActivity(i);
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtId.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Không được để trống ID thể loại", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (edtDate.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Không được để trống ngày xuất hóa đơn", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    SQLHoaDon sqlHoaDon = new SQLHoaDon(HoaDonActivity.this);
                    HoaDon hoaDon = new HoaDon(edtId.getText().toString(), edtDate.getText().toString());
                    sqlHoaDon.addHoaDon(hoaDon);
                    Intent i = new Intent(HoaDonActivity.this, ListInvoice.class);
                    startActivity(i);
                    Toast.makeText(getApplicationContext(), "Thêm thành công", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HoaDonActivity.this, ListInvoice.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(), "Hiển thị thành công", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
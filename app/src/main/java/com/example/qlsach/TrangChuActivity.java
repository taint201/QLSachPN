package com.example.qlsach;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TrangChuActivity extends AppCompatActivity {
   Button btnNguoiDung , btnSach, btnHoaDon , btnSachBanChay , btnTheLoai ,btnThongKe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu);
        setTitle("Phương Nam ");

        btnNguoiDung = findViewById(R.id.btnNguoiDung);
        btnSach = findViewById(R.id.btnSach);
        btnHoaDon = findViewById(R.id.btnHoaDon);
        btnTheLoai = findViewById(R.id.btnTheLoai);
        btnSachBanChay = findViewById(R.id.btnSachBanChay);
        btnThongKe = findViewById(R.id.btnThongKe);

        btnNguoiDung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TrangChuActivity.this,NguoiDungActivity.class);
                startActivity(i);
            }
        });
        btnTheLoai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TrangChuActivity.this,TheLoaiActivity.class);
                startActivity(i);
            }
        });
        btnSach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TrangChuActivity.this,SachActivity.class);
                startActivity(i);
            }
        });
        btnHoaDon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TrangChuActivity.this,HoaDonActivity.class);
                startActivity(i);
            }
        });
        btnSachBanChay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TrangChuActivity.this,SachBanChayActivity.class);
                startActivity(i);
            }
        });
        btnThongKe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TrangChuActivity.this,ThongKeActivity.class);
                startActivity(i);
            }
        });


}}
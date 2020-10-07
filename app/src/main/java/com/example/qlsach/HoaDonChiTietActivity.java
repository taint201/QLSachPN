package com.example.qlsach;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.qlsach.List.ListInvoiceDetail;
import com.example.qlsach.SQlite.SQLHoaDonChiTiet;
import com.example.qlsach.MODEL.HoaDonChiTiet;

public class HoaDonChiTietActivity extends AppCompatActivity {

    Button btnAdd, btnShow, btnCancel;
    EditText idhdct, idhd, idsach, soluong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoa_don_chi_tiet);
        btnAdd = findViewById(R.id.btnAdd);
        btnShow = findViewById(R.id.btnShow);
        idhdct = findViewById(R.id.edtIDInvoiceDetail);
        idhd = findViewById(R.id.edtIDInvoice);
        idsach = findViewById(R.id.edtIDBook);
        soluong = findViewById(R.id.edtAmount);
        btnCancel = findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HoaDonChiTietActivity.this, TrangChuActivity.class);
                startActivity(i);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (idhdct.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Không được để trống ID hóa đơn chi tiết", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (idhd.length() == 0) {
                    Toast.makeText(getApplicationContext(), "không được để trống ID hóa đơn", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (idsach.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Không được để trống id sách", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (soluong.length()<0){
                    Toast.makeText(getApplicationContext(), "Số Lượng không được được là số âm", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    SQLHoaDonChiTiet sqlHoaDonChiTiet = new SQLHoaDonChiTiet(HoaDonChiTietActivity.this);
                    HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet(idhdct.getText().toString(), idhd.getText().toString(), idsach.getText().toString(), soluong.getText().toString());
                    sqlHoaDonChiTiet.addHoaDonChiTiet(hoaDonChiTiet);
                    Intent i = new Intent(HoaDonChiTietActivity.this, ListInvoiceDetail.class);
                    startActivity(i);
                    Toast.makeText(getApplicationContext(), "Thêm thành công", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HoaDonChiTietActivity.this, ListInvoiceDetail.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(), "Hiển thị thành công", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
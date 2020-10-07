package com.example.qlsach;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.qlsach.List.ListBook;
import com.example.qlsach.SQlite.SQLSach;
import com.example.qlsach.MODEL.Sach;

import java.util.ArrayList;

public class SachActivity extends AppCompatActivity {
    Button btnAdd, btnShow, btnCancel;
    Spinner spn;
    EditText edtid, edtname, edttacgia, edtnhaxuatban, edtprice, edtamount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sach);
        setTitle("Sách");
        btnAdd = findViewById(R.id.btnAdd);
        btnShow = findViewById(R.id.btnShow);
        edtid = findViewById(R.id.edtIDBook);
        edtname = findViewById(R.id.edtNameBook);
        edttacgia = findViewById(R.id.edtTacGia);
        edtnhaxuatban = findViewById(R.id.edtNhaXuatBan);
        edtprice = findViewById(R.id.edtPrice);
        edtamount = findViewById(R.id.edtAmount);
        btnCancel = findViewById(R.id.btnCancel);
        spn = findViewById(R.id.spinner);
        final ArrayList<String> thel= new ArrayList<String>();
        thel.add("IT");
        thel.add("Math");
        thel.add("English");
        thel.add("Literature");
       ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,thel);
       spn.setAdapter(adapter);
        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SachActivity.this,spn.getItemAtPosition(position).toString(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SachActivity.this, TrangChuActivity.class);
                startActivity(i);
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtid.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Không được để trống ID Sách ", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (edtname.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Không được để trống tên Sách", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (edttacgia.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Không được để trống tên Tác Gỉa", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (edtnhaxuatban.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Không được để trống nhà xuất bản", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (edtprice.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Không được để trống số tiền", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (edtamount.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Không được để trống số lượng", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    SQLSach sqlSach = new SQLSach(SachActivity.this);
                    Sach sach = new Sach(edtid.getText().toString(),null, edtname.getText().toString(), edttacgia.getText().toString(),
                            edtnhaxuatban.getText().toString(),edtprice.getText().toString(),edtamount.getText().toString());
                    sqlSach.addSach(sach);
                    Toast.makeText(getApplicationContext(), "Thêm thành công", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(SachActivity.this, ListBook.class);
                    startActivity(i);

                }
            }
        });
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SachActivity.this, ListBook.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(), "Hiển thị thành công", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

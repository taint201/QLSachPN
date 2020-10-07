package com.example.qlsach;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class DangNhapActivity extends AppCompatActivity {
Button btnLogin, btnCancel;
EditText edtuser, edtpass;
CheckBox chk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
        setTitle("Đăng Nhập");
        btnLogin = findViewById(R.id.btnLogin);
        btnCancel = findViewById(R.id.btnCancel);
        edtuser = findViewById(R.id.edtUsername);
        edtpass = findViewById(R.id.edtPassword);
        chk = findViewById(R.id.checkbox);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtuser.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Không được để trống tên đăng nhập", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (edtpass.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Không được để trống mật khẩu", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(edtpass.length()<4){
                    Toast.makeText(getApplicationContext(), "Mật khẩu phải ít nhất 4 kí tự", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(chk.isChecked()==false){
                    Toast.makeText(getApplicationContext(), "Vui lòng nhớ mật khẩu", Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(getApplicationContext(), "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(DangNhapActivity.this,TrangChuActivity.class);
                startActivity(i);

            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DangNhapActivity.this,DangkiActivity.class);
                startActivity(i);
            }
        });
    }
}
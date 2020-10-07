package com.example.qlsach;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.qlsach.List.ListUser;
import com.example.qlsach.SQlite.SQLNguoiDung;
import com.example.qlsach.MODEL.NguoiDung;

public class NguoiDungActivity extends AppCompatActivity {
    Button btnAdd, btnList, btnCancel,xoa;
    EditText edtid, edtphone, edtfullname, edtgmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nguoi_dung);
        setTitle("Người Dùng");
        btnAdd = findViewById(R.id.btnAdd);
        btnList = findViewById(R.id.btnList);
        edtid = findViewById(R.id.edtIDUser);
        edtphone = findViewById(R.id.edtPhoneUser);
        edtfullname = findViewById(R.id.edtFullName);
        edtgmail = findViewById(R.id.edtGmail);
        btnCancel = findViewById(R.id.btnCancel);
        xoa = findViewById(R.id.btnXoa);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(NguoiDungActivity.this, TrangChuActivity.class);
                startActivity(i);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            public boolean validateEmail(CharSequence email) {
                return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
            }
            public  boolean validateNumber(CharSequence number){
                return  !TextUtils.isEmpty(number) && Patterns.PHONE.matcher(number).matches();
            }
            @Override
            public void onClick(View view) {
                if (edtid.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Không được để trống ID Người dùng", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (edtfullname.length() == 0) {
                    Toast.makeText(getApplicationContext(), "không được để trống họ tên", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (edtphone.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Không được để trống số điện thoại", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (edtphone.length()!=10){
                    Toast.makeText(getApplicationContext(), "Vui lòng nhập đúng định dạng số điện thoại", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!validateNumber(edtphone.getText().toString())){
                    Toast.makeText(getApplicationContext(), "Vui lòng nhập đúng định dạng số điện thoại", Toast.LENGTH_SHORT).show();
                    return;
                }

                    if (edtgmail.length() == 0) {
                        Toast.makeText(getApplicationContext(), "không được để trống gmail", Toast.LENGTH_SHORT).show();
                        return;
                }
                if (!validateEmail(edtgmail.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Vui lòng nhập đúng định dạng email", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                        SQLNguoiDung sqlNguoiDung = new SQLNguoiDung(NguoiDungActivity.this);
                        NguoiDung nguoiDung = new NguoiDung(edtid.getText().toString(), edtfullname.getText().toString(), edtphone.getText().toString(),
                                edtgmail.getText().toString());
                        sqlNguoiDung.addNguoiDung(nguoiDung);
                        Intent i = new Intent(NguoiDungActivity.this, ListUser.class);
                        startActivity(i);
                    Toast.makeText(getApplicationContext(), "Thêm thành công", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(NguoiDungActivity.this, ListUser.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(), "Hiển thị thành công", Toast.LENGTH_SHORT).show();
            }
        });
//        xoa.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getApplicationContext(),"bạn chọn xóa",Toast.LENGTH_SHORT).show();
//            }
//        });

    }

}



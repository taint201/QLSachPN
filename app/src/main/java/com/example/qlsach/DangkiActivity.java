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

public class DangkiActivity extends AppCompatActivity {
Button btnSignIn, btnSignUp, btnCancel;
EditText edtuser, edtpass, edtrepass, edtphone, edtemail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ki);
        setTitle("Đăng Kí");
        btnSignIn = findViewById(R.id.btnSignIn);
        btnSignUp = findViewById(R.id.btnSignUp);
        btnCancel = findViewById(R.id.btnCancel);
        edtuser = findViewById(R.id.edtUsername);
        edtpass = findViewById(R.id.edtPassword);
        edtrepass = findViewById(R.id.edtPass);
        edtphone = findViewById(R.id.edtPhone);
        edtemail = findViewById(R.id.edtEmail);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            public boolean validateEmail(CharSequence email) {
                return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
            }
            public  boolean validateNumber(CharSequence number){
                return  !TextUtils.isEmpty(number) && Patterns.PHONE.matcher(number).matches();
            }
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
                if (edtrepass.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Vui lòng nhập lại mật khẩu", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(edtrepass.length()<4) {
                    Toast.makeText(getApplicationContext(), "Mật khẩu phải ít nhất 4 kí tự", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!edtpass.getText().toString().equals(edtrepass.getText().toString())){
                    Toast.makeText(getApplicationContext(), "Mật khẩu không trùng khớp vui lòng nhập đúng mật khẩu", Toast.LENGTH_SHORT).show();
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
                if (edtemail.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Không được để trống email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!validateEmail(edtemail.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Vui lòng nhập đúng định dạng email", Toast.LENGTH_SHORT).show();
                    return;
 //               }
//                    if(pass.getText().toString() != repass.getText().toString()){
//                        Toast.makeText(getApplicationContext(), "Vui lòng nhập đúng mật khẩu", Toast.LENGTH_SHORT).show();
//                        return;

                } else {
                    Toast.makeText(getApplicationContext(), "Đăng kí thành công, vui lòng đăng nhập", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(DangkiActivity.this, DangNhapActivity.class);
                    startActivity(i);
                }
            }
        });
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DangkiActivity.this,DangNhapActivity.class);
                startActivity(i);
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DangkiActivity.this,ChaoActivity.class);
                startActivity(i);
            }

        });


    }

}
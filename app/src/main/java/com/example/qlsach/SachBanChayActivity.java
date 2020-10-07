package com.example.qlsach;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SachBanChayActivity extends AppCompatActivity {
Button btnSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sach_ban_chay);
        setTitle("Sách Bán Chạy");
        btnSearch = findViewById(R.id.btnSearch);


}
 }
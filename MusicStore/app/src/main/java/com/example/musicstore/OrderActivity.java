package com.example.musicstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Intent orderIntent = getIntent();
        String userName = orderIntent.getStringExtra("userName");
        TextView orderTextView = findViewById(R.id.order_text_view);
        orderTextView.setText(userName);
    }
}
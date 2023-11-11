package com.example.musicstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import javax.security.auth.Subject;

public class OrderActivity extends AppCompatActivity {
    String[] addresses = {"managerteammate777@gmail.com"};
    String subject = "Your order fom MusicShop";
    StringBuilder bodyText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Intent orderIntent = getIntent();
        String userName = orderIntent.getStringExtra("userName");
        String goodsName = orderIntent.getStringExtra("goodsName");
        int quantity = orderIntent.getIntExtra("quantity", 0);
        float orderPrice = orderIntent.getFloatExtra("orderPrice", 0.0f);
        float pricePerPiece = orderIntent.getFloatExtra("pricePerPiece", 0.0f);
        TextView orderTextView = findViewById(R.id.order_text_view);
        bodyText = new StringBuilder();
        bodyText.append("Name: ").append(userName)
                .append("\nProduct: ").append(goodsName)
                .append("\nQuantity: ").append(quantity)
                     .append("\nPrice per piece: ").append(pricePerPiece)
                .append("\nPrice: ").append(orderPrice);
             orderTextView.setText(bodyText.toString());



    }

    public void submitOrder(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, bodyText.toString());
        startActivity(intent);


    }
}
package com.example.musicstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Map;


/** @noinspection DataFlowIssue*/
public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    int quantity;
    Spinner spinner;
    String [] instruments;
    ArrayAdapter<String> arrayAdapter;
    Map<String, Float> map;
    String goodsName = "guitar";
    String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createSpinner();
        createMap();
    }

    public void increaseQuantity(View view) {
        TextView quantityView = findViewById(R.id.quantity_text_view);
        quantity++;
        quantityView.setText(Integer.toString(quantity));
        setNewPrice();

    }
    public void decreaseQuantity(View view) {
        if (quantity == 0) return;
        TextView quantityView = findViewById(R.id.quantity_text_view);
        quantity--;
        quantityView.setText(Integer.toString(quantity));
        setNewPrice();
    }

    public void addToCart(View view) {
        EditText editText = findViewById(R.id.nameEditText);
        userName = editText.getText().toString();
        if (userName.isBlank() || userName.isEmpty()) return;

        userName = userName.trim();
        Order order = new Order(userName, goodsName, quantity, getNewPrice());
        Log.d("print order", order.toString());
        Intent orderIntent = new Intent(MainActivity.this, OrderActivity.class);
        orderIntent.putExtra("userName", order.getUserName());

        startActivity(orderIntent);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        goodsName = spinner.getSelectedItem().toString();
        setNewPrice();
        setGoodsView();
    }


    float getNewPrice() {
        return map.get(goodsName) * quantity;
    }
    void createMap() {
        map = Map.of("guitar", 500.00f, "drums", 1000.00f, "piano", 1200.00f);
    }

    //************************* SET VIEW ELEMENTS *************************************
    void setNewPrice() {
        TextView priceView = findViewById(R.id.price);
        priceView.setText(Float.toString(getNewPrice()));
    }
    void createSpinner() {
        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        instruments = new String[]{"guitar", "drums", "piano"};
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, instruments);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
    }
    void setGoodsView() {
        ImageView goodsImageView = findViewById(R.id.goodsImageView);
        switch (goodsName) {
            case "guitar" -> {
                goodsImageView.setImageResource(R.drawable.guitar);
            }
            case "drums" -> {
                goodsImageView.setImageResource(R.drawable.drums);
            }
            case "piano" -> {
                goodsImageView.setImageResource(R.drawable.piano);
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        goodsName = instruments[0];

    }
}
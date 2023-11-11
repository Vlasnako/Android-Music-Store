package com.example.musicstore;

import androidx.annotation.NonNull;

public class Order {
    private String userName;
    private String goodsName;
    private int quantity;
    private float pricePerPiece;
    private float orderPrice;

    public float getPricePerPiece() {
        return pricePerPiece;
    }

    public void setPricePerPiece(float pricePerPiece) {
        this.pricePerPiece = pricePerPiece;
    }

    public Order(String userName, String goodsName, int quantity, float orderPrice) {
        this.userName = userName;
        this.goodsName = goodsName;
        this.quantity = quantity;
        this.orderPrice = orderPrice;
    }
    public Order() {}

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(float orderPrice) {
        this.orderPrice = orderPrice;
    }

    @NonNull
    @Override
    public String toString() {
        return "Order{" +
                "userName='" + userName + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", quantity=" + quantity +
                ", orderPrice=" + orderPrice +
                '}';
    }
}

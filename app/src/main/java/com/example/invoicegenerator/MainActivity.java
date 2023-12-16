package com.example.invoicegenerator;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

class Data {
    public int price, quantity, discount;
    public String product_Name;

    Data(int quantity, int discount, int price, String product_Name) {
        this.quantity = quantity;
        this.discount = discount;
        this.product_Name = product_Name;
        this.price = price;
    }
}

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    Intent intent;
    ArrayList<Data> data = new ArrayList<>();

    public void add_product_btn(View view) {
        EditText product_Obj = findViewById(R.id.productName);
        String product_Name = product_Obj.getText().toString();

        EditText price_Obj = findViewById(R.id.price);
        int price = Integer.parseInt(price_Obj.getText().toString());

        EditText quantity_Obj = findViewById(R.id.quantity);
        int quantity = Integer.parseInt(quantity_Obj.getText().toString());

        EditText discount_Obj = findViewById(R.id.discount);
        int discount = Integer.parseInt(discount_Obj.getText().toString());

        data.add(new Data(quantity, discount, price, product_Name));

        Toast.makeText(this, "Product Added!", Toast.LENGTH_SHORT).show();
        product_Obj.setText("");
        price_Obj.setText("");
        quantity_Obj.setText("");
        discount_Obj.setText("");
    }

    public void checkout_btn(View view) {
        intent = new Intent(this, MainActivity2.class);
        Bundle b = new Bundle();
        for (int i = 0; i < data.size(); i++) {
            String key = "Obj" + i;
            Data tmp = data.get(i);
            String value = tmp.product_Name + "|" + tmp.price + "|" + tmp.quantity + "|" + tmp.discount;
            b.putString(key, value);
        }
        intent.putExtras(b);
        startActivity(intent);
    }
}
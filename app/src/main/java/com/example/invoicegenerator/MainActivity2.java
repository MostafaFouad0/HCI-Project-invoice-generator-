package com.example.invoicegenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity2 extends AppCompatActivity {


    public static String getTotal(String discount, String price) {
        String ret;
        int disc = Integer.parseInt(discount);
        int pri = Integer.parseInt(price);
        double total = (pri - (pri * (disc / 100.0)));
        ret = String.valueOf(total);
        return ret;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        TextView text_pane = findViewById(R.id.result);
        double all = 0;
        for (int i = 0; i < b.size(); i++) {
            String to_be_printed;
            String key = "Obj" + i;
            String data = b.getString(key);
            String cur[] = data.split("\\|");
            String tot = getTotal(cur[3], cur[1]);
            all += Double.parseDouble(tot);
            to_be_printed = "Name \t\t\t\t\t\t " + cur[0] + "\n" + "Price \t\t\t\t\t\t\t$ " + cur[1] + "\n" + "quantity \t\t\t\t " + cur[2] + "\n" + "discount \t\t\t\t " + cur[3] + "%" + "\n" + "\t\t\t\t\tTotal \t\t\t\t\t\t\t$ " + tot + "\n\n";
            text_pane.append(to_be_printed);
            text_pane.setTextSize(16);
            text_pane.setTypeface(text_pane.getTypeface(), Typeface.NORMAL);
        }
    }

    public void back_btn(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
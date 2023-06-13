package com.example.laba5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Adapter adapter;
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Deliver deliver = new Deliver("Райан Гослинг", "366346364574", "Доставляет незаконные вещи, водитель от Бога, есть машина");
        ArrayList<Order> orders = new ArrayList<Order>();
        orders.add(new Order(new Firm("Парковая, 3", "Citilink"),
                new PackSmall(true, "200x150"),
                "Парковая, 3", "Бульвар Космонавтов, 5", 2000));
        orders.add(new Order(new Firm("Гражданская, 9", "Samsung"),
                new PackDoc(false, "200x300", "Как можно скорее", "От директора главному менеджеру"),
                "Гражданская, 9", "Почтовая, 7", 1000));
        orders.add(new Order(new Firm("Осенняя, 4", "Mr Doors"),
                new PackBig(false, "2000x3000"),
                "Осенняя, 15", "Ленина, 7", 1500));
        setContentView(R.layout.activity_main);
        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        TextView textView = findViewById(R.id.info);
        textView.setText("Имя: " + deliver.getName() + "\nСчёт " + deliver.getAccount() + "\nВозможности: " + deliver.getCapabilities());

        ListView listView = (ListView) findViewById(R.id.items);

        adapter = new Adapter(this, orders);

        listView.setAdapter(adapter);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                clear(view);
            }
        });

        btn2.setOnClickListener(new Button.OnClickListener() {
            @Override public void onClick(View v) {
                showResult(v);
            }
        });
    }
    public void showResult(View v) {
        int result = 0;
        for (Order p : adapter.getBox()) {
            if (p.getBox())
                result += p.getPrice();
        }
        Toast toast = Toast.makeText(this, Integer.toString(result), Toast.LENGTH_LONG);
        toast.show();
    }

    public void clear(View v) {
        for (Order p : adapter.getBox()) {
                p.setBox(false);
                adapter.notifyDataSetChanged();
        }
    }
}
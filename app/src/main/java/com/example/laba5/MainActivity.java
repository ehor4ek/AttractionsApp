package com.example.laba5;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

//у курьера есть варианты машины
//заказы перелетают в личный кабинет
//добавить графу размера посылки
//выводятся заказы нужного размера
//курьер выбирает машину в личном кабинете

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends Activity {
    private Adapter adapter;
    private Car car = null;
    private ArrayList<Order> orders, goodOrders, takenOrders;
    private  Deliver deliver;
    private ListView listView;
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        deliver = new Deliver("Райан Гослинг", "366346364574", "Доставляет незаконные вещи, водитель от Бога, есть машина");
        orders = new ArrayList<Order>();
        orders.add(new Order(new Firm("Парковая, 3", "Citilink"),
                new PackSmall(true, "2000x150x200"),
                "Парковая, 3", "Бульвар Космонавтов, 5", 2000));
        orders.add(new Order(new Firm("Гражданская, 9", "Samsung"),
                new PackDoc(false, "200x300x350", "Как можно скорее", "От директора главному менеджеру"),
                "Гражданская, 9", "Почтовая, 7", 1000));
        orders.add(new Order(new Firm("Осенняя, 4", "Mr Doors"),
                new PackBig(false, "2000x3000x2500"),
                "Осенняя, 15", "Ленина, 7", 1500));
        goodOrders = orders;
        takenOrders = new ArrayList<>();
        Bundle arguments = getIntent().getExtras();
        if (arguments != null) {
            takenOrders = arguments.getParcelableArrayList(Order.class.getSimpleName());
            goodOrders = arguments.getParcelableArrayList("good");
        }
//        for(int i = 0; i < orders.size(); i++) {
//            if(car == null || orders.get(i).sizable(car.getX(), car.getY(), car.getZ())) {
//                goodOrders.add(orders.get(i));
//            }
//        }
//        for(int i = 0; i < takenOrders.size(); i++) {
//            for (int j = 0; j < goodOrders.size(); j++) {
//                int k = -1;
//                if (takenOrders.get(i).getOrderFrom().equals(goodOrders.get(j).getOrderFrom()) &&
//                        takenOrders.get(i).getOrderTo().equals(goodOrders.get(j).getOrderTo())) {
//                    k = j;
//                    break;
//                }
//                if (k != -1)
//                    goodOrders.remove(k);
//            }
//        }
        setContentView(R.layout.activity_main);
        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button menu_btn = findViewById(R.id.menu_btn);
        TextView textView = findViewById(R.id.info);
        textView.setText("Имя: " + deliver.getName() + "\nСчёт " + deliver.getAccount() + "\nВозможности: " + deliver.getCapabilities());
        //textView.setText(takenOrders.toString());
        listView = (ListView) findViewById(R.id.items);

        adapter = new Adapter(this, goodOrders);

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
        menu_btn.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                intent.putExtra(Order.class.getSimpleName(), takenOrders);
                intent.putExtra("good", goodOrders);
                //intent.putExtra(Deliver.class.getSimpleName(), deliver);
                startActivity(intent);
                finish();
            }
        });
    }
    public void showResult(View v) {
        int result = 0;
        for (Order p : adapter.getBox()) {
            if (p.getBox()) {
                result += p.getPrice();
                takenOrders.add(p);
                goodOrders.remove(p);
            }
        }
        adapter = new Adapter(this, goodOrders);
        listView.setAdapter(adapter);
        Toast toast = Toast.makeText(this, Integer.toString(result), Toast.LENGTH_LONG);
        toast.show();
    }

    public void clear(View v) {
        for (Order p : adapter.getBox()) {
                p.setBox(false);
                adapter.notifyDataSetChanged();
        }
    }
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
//        if (intent == null) {
//            return;
//        }
//        Bundle arguments = intent.getExtras();
//        //car = (Car)arguments.getSerializable(Car.class.getSimpleName());
//        takenOrders = arguments.getParcelableArrayList(Order.class.getSimpleName());
//    }
}
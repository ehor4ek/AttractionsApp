package com.example.laba5;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ProfileActivity extends Activity {
    private ArrayList<Order> orders, goodOrders;
    private Deliver deliver;
    private Adapter adapter;
    private ArrayList<Car> cars;
    private RadioButton newRadioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getIntent().getExtras();
        orders = arguments.getParcelableArrayList(Order.class.getSimpleName());
        goodOrders = arguments.getParcelableArrayList("good");
        //Deliver deliver = (Deliver)arguments.getSerializable(Deliver.class.getSimpleName());
        setContentView(R.layout.profile);
        ListView listView = (ListView) findViewById(R.id.items);
        adapter = new Adapter(this, orders);
        if (orders != null)
            listView.setAdapter(adapter);
        cars = new ArrayList<Car>();
        cars.add(new Car("Reanult", 1000, 1000, 1000));
        cars.add(new Car("Matiz", 2000, 3000, 1000));
        cars.add(new Car("Subaru", 1500, 2000, 500));
        RadioGroup radioGroup = findViewById(R.id.car_radio);
        Context t = this;
        for (int i = 0; i < cars.size(); i++) {
            newRadioButton = new RadioButton(this);
            Car exactCar = cars.get(i);
            newRadioButton.setText(exactCar.getName() + " Вместимость: " + exactCar.getX() + "x" + exactCar.getY() + "x" + exactCar.getZ());
            radioGroup.addView(newRadioButton);
        }
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
                RadioButton myRadioButton = findViewById(checkedRadioButtonId);
                int checkedIndex = radioGroup.indexOfChild(myRadioButton);
                Car car = cars.get(checkedIndex);
                goodOrders = new ArrayList<Order>();
                for(int i = 0; i < orders.size(); i++) {
                    if (car == null || orders.get(i).sizable(car.getX(), car.getY(), car.getZ())) {
                        goodOrders.add(orders.get(i));
                    }
                }
                adapter = new Adapter(t, goodOrders);
                listView.setAdapter(adapter);
            }
        });
    }

    @Override
    public void onBackPressed () {
        Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
        intent.putExtra(Order.class.getSimpleName(), orders);
        intent.putExtra("good", goodOrders);
        startActivity(intent);
        setResult(RESULT_OK, intent);
        finish();
    }
}
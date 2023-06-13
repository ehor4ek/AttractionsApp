package com.example.laba5;

import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;

public class Adapter extends BaseAdapter {
    Context ctx;
    LayoutInflater lInflater;
    ArrayList<Order> objects;

    Adapter(Context context, ArrayList<Order> orders) {
        ctx = context;
        objects = orders;
        lInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public Object getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.item0, parent, false);
        }

        Order p = getOrder(position);

        ((TextView) view.findViewById(R.id.firm)).setText(p.getOrderFirm().getName());
        ((TextView) view.findViewById(R.id.type)).setText(p.getType());
        ((TextView) view.findViewById(R.id.ad_from)).setText(p.getOrderFrom());
        ((TextView) view.findViewById(R.id.ad_to)).setText(p.getOrderTo());
        ((TextView) view.findViewById(R.id.price)).setText(Integer.toString(p.getPrice()));

        CheckBox cbBuy = (CheckBox) view.findViewById(R.id.chBox);
        cbBuy.setOnCheckedChangeListener(myCheckChangeList);
        cbBuy.setTag(position);
        cbBuy.setChecked(p.getBox());
        return view;
    }

    Order getOrder(int position) {
        return ((Order) getItem(position));
    }

    ArrayList<Order> getBox() {
        ArrayList<Order> box = new ArrayList<Order>();
        for (Order p : objects) {
            if (p.getBox())
                box.add(p);
        }
        return box;
    }

    OnCheckedChangeListener myCheckChangeList = new OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            getOrder((Integer) buttonView.getTag()).setBox(isChecked);
        }
    };
}
package com.example.cb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class Adapter extends ArrayAdapter<Product> {
    private ArrayList<Product> products;
    private Context context;

    public Adapter(@NonNull Context context, ArrayList<Product> products) {
        super(context, 0, products);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        Product product = getItem(position);
        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_listview, parent, false);
        TextView name = convertView.findViewById(R.id.displayName);
        TextView gtin = convertView.findViewById(R.id.displayGTIN);

        name.setText(product.getName());
        gtin.setText(product.getGtin());

        return convertView;
    }

}

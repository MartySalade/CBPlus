package com.example.cb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
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
        TextView date = convertView.findViewById(R.id.displayDate);
        TextView type = convertView.findViewById(R.id.displayType);
        ImageView foodImage = convertView.findViewById(R.id.foodImage);

        name.setText(product.getName());
        gtin.setText("GTIN: " + product.getGtin());
        date.setText(product.getDate());
        type.setText("Type: " + product.getType());
        if (product.getType().equals("Viande"))
            foodImage.setImageResource(R.drawable.meat);
        else if (product.getType().equals("Légume"))
            foodImage.setImageResource(R.drawable.harvest);
        else if (product.getType().equals("Liquide"))
            foodImage.setImageResource(R.drawable.water);
        else if (product.getType().equals("Défault"))
            foodImage.setImageResource(R.drawable.diet);
        else if (product.getType().equals("Produit ménager"))
            foodImage.setImageResource(R.drawable.menage);
        else if (product.getType().equals("Produit laitier"))
            foodImage.setImageResource(R.drawable.milk);
        else if (product.getType().equals("Fruit"))
            foodImage.setImageResource(R.drawable.fruits);
        else if (product.getType().equals("Féculent"))
            foodImage.setImageResource(R.drawable.ravioli);


        return convertView;
    }

}

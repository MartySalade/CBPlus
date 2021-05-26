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

    // This class define the adapter which is the process of converting the Java object into a View

    // Constructor
    public Adapter(@NonNull Context context, ArrayList<Product> products) {
        super(context, 0, products);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        // We get the product that we're working on using the position
        Product product = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_listview, parent, false);

        // Getting data views
        TextView name = convertView.findViewById(R.id.displayName);
        TextView gtin = convertView.findViewById(R.id.displayGTIN);
        TextView date = convertView.findViewById(R.id.displayDate);
        TextView type = convertView.findViewById(R.id.displayType);
        ImageView foodImage = convertView.findViewById(R.id.foodImage);

        // Setting up the template with data from the product
        name.setText(product.getName());
        gtin.setText("GTIN: " + product.getGtin());
        date.setText(product.getDate());
        type.setText("Type: " + product.getType());


        // Setting the image of the product depending on his type (8 different types)
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

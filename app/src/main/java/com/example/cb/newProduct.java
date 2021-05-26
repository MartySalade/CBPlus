package com.example.cb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class newProduct extends AppCompatActivity {

    // newProduct is the class associated to the layout where the user can add a new product to the list

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_product);

        // We get today's date and we put it in the EditText to help user to go faster when he adds a new product
        EditText date = findViewById(R.id.productDate);
        Date actual = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String strDate = dateFormat.format(actual);
        date.setText(strDate);

        // We set up the spinner with all different kinds of product and use the adapter to make the list visible on the view
        TextView text = findViewById(R.id.text_view);
        Spinner dropdown = findViewById(R.id.type);
        String[] items = new String[]{"Défault", "Viande", "Légume", "Fruit", "Liquide", "Produit laitier", "Féculent", "Produit ménager"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

        // Each time that an item is selected we put this item into a textview.
        // If the user validate the product at the end we'll get the kind selected by checking what's inside this textview.
        // This textview is invisible for the user. It is just use for technical purpose
        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selected = (String) adapterView.getItemAtPosition(i);
                text.setText(selected);
            }

            // If nothing is selected we make the user know that the product will take default type
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(getApplicationContext(),"Le produit prend le type par défault",Toast.LENGTH_LONG).show();
            }
        });

        // Animated background
        ConstraintLayout layout = findViewById(R.id.background2);
        AnimationDrawable animationDrawable = (AnimationDrawable) layout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        // If the doesn't want to add the product he can click on the cross located in the top left corner
        // It will lead him to the main page without adding any product
        ImageButton cancel = findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(newProduct.this, MainActivity.class));
            }
        });

        // When the user click the validate button
        Button validateButton = findViewById(R.id.buttonValidate);
        validateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // We get the last views
                EditText name = findViewById(R.id.productName);
                EditText gtin = findViewById(R.id.productGTIN);

                // We get the values that the user entered
                String name_ = name.getText().toString();
                String gtin_ = gtin.getText().toString();
                String date_ = date.getText().toString();
                String type_ = text.getText().toString();

                // If a data is missing we let the user know and he must fill every fields (expect 'type' which take default type)
                if (name_.isEmpty() || gtin_.isEmpty() || date_.isEmpty())
                {
                    Toast.makeText(newProduct.this, "Vous devez renseigner tous les champs avant d'ajouter un produit !", Toast.LENGTH_SHORT).show();
                    return;
                }
                // We go back to the MainActivity and we add the four data that we need to create a new Product object
                Intent intent = new Intent(newProduct.this, MainActivity.class);
                intent.putExtra("product", new String[] {name_, gtin_, date_, type_});
                startActivity(intent);
            }
        });
    }
}
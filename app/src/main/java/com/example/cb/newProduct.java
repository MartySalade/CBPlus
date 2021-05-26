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
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class newProduct extends AppCompatActivity {

    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_product);

        EditText date = findViewById(R.id.productDate);
        Date actual = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String strDate = dateFormat.format(actual);
        date.setText(strDate);

        TextView text = findViewById(R.id.text_view);
        Spinner dropdown = findViewById(R.id.type);
        String[] items = new String[]{"Défault", "Viande", "Fruit / Légume", "Liquide", "Autre"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selected = (String) adapterView.getItemAtPosition(i);
                text.setText(selected);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(getApplicationContext(),"Le produit prend le type par défault",Toast.LENGTH_LONG).show();
            }
        });

        ConstraintLayout layout = findViewById(R.id.background2);
        AnimationDrawable animationDrawable = (AnimationDrawable) layout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        Button validateButton = findViewById(R.id.buttonValidate);
        validateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name = findViewById(R.id.productName);
                EditText gtin = findViewById(R.id.productGTIN);

                String name_ = name.getText().toString();
                String gtin_ = gtin.getText().toString();
                String date_ = date.getText().toString();
                String type_ = text.getText().toString();

                if (name_.isEmpty() || gtin_.isEmpty() || date_.isEmpty())
                {
                    Toast.makeText(newProduct.this, "Vous devez renseigner tous les champs avant d'ajouter un produit !", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(newProduct.this, MainActivity.class);
                intent.putExtra("product", new String[] {name_, gtin_, date_, type_});
                startActivity(intent);
            }
        });
    }
}
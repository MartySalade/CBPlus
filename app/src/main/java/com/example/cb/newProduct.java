package com.example.cb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class newProduct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_product);

        Button validateButton = findViewById(R.id.buttonValidate);
        validateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name = findViewById(R.id.productName);
                EditText gtin = findViewById(R.id.productGTIN);

                String name_ = name.getText().toString();
                String gtin_ = gtin.getText().toString();

                //while (name_.isEmpty() || gtin_.isEmpty())
                Intent intent = new Intent(newProduct.this, MainActivity.class);
                intent.putExtra("product", new String[] {name_, gtin_});
                startActivity(intent);
            }
        });
    }
}
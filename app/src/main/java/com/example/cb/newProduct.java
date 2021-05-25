package com.example.cb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class newProduct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_product);

        EditText date = findViewById(R.id.productDate);
        Date actual = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String strDate = dateFormat.format(actual);
        date.setText(strDate);


        Button validateButton = findViewById(R.id.buttonValidate);
        validateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name = findViewById(R.id.productName);
                EditText gtin = findViewById(R.id.productGTIN);

                String name_ = name.getText().toString();
                String gtin_ = gtin.getText().toString();
                String date_ = date.getText().toString();

                //while (name_.isEmpty() || gtin_.isEmpty())
                Intent intent = new Intent(newProduct.this, MainActivity.class);
                intent.putExtra("product", new String[] {name_, gtin_, date_});
                startActivity(intent);
            }
        });
    }
}
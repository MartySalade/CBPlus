package com.example.cb;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Pair;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Product> products = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Animated background
        ConstraintLayout layout = findViewById(R.id.background);
        AnimationDrawable animationDrawable = (AnimationDrawable) layout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        // If there already are products we don't need to show the logo and the welcome sentence
        // So we remove them by clearing values inside the two ImageViews and the TextView
        if (products.size() > 0)
        {
            TextView empty = findViewById(R.id.empty);
            ImageView emptyImage = findViewById(R.id.emptyImage);
            ImageView roundCorners = findViewById(R.id.roundCorners);
            empty.setText("");
            emptyImage.setImageResource(0);
            roundCorners.setImageResource(0);
        }

        // We find our listView and create a new Adapter using 'products' the list of all our products
        ListView list = findViewById(R.id.listView);
        Adapter adapter = new Adapter(this, products);
        list.setAdapter(adapter);

        // Big 'PLUS' button in the MainActivity. When button is pressed, it lead the user to the Add Product page
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, newProduct.class));
            }
        });
    }

    @Override
    public void onResume(){
        super.onResume();
        // We get the info from Add Product activity
        String[] tmp = getIntent().getStringArrayExtra("product");
        if (tmp != null)
        {
            // If there are info passed, we get the views
            TextView empty = findViewById(R.id.empty);
            ImageView emptyImage = findViewById(R.id.emptyImage);
            ImageView roundCorners = findViewById(R.id.roundCorners);

            // We disable the welcome sentence and logo because we're going to print data in the list view
            empty.setText("");
            emptyImage.setImageResource(0);
            roundCorners.setImageResource(0);

            // We loop through the list of product and if we find that a product already exist (by checking the GTIN), we just change the expiration date for the product
            // Otherwise we add the product to the ArrayList
            for (int i = 0; i < products.size(); i++)
            {
                if (products.get(i).getGtin().equals(tmp[1]))
                {
                    products.get(i).setDate(tmp[2]);
                    return;
                }
            }
            products.add(new Product(tmp[0], tmp[1], tmp[2], tmp[3]));
        }
    }

    @Override
    public void onBackPressed() {

        //If back button is pressed we go back to this activity without changing anything
        Intent intent = new Intent(MainActivity.this, MainActivity.class);
        this.finish();
        finish();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        // If 'Découvrir CB+' is pressed we lead the user through the official website
        if (id == R.id.action_settings) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://cb-plus.eu/")));
            return true;
        }

        // If the user want to sort the product we compare 'sum' filed of every product in the list and put the lowest one first
        if (id == R.id.action_sort) {
            Collections.sort(products, new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    return o1.getSum() - o2.getSum();
                }
            });

            // Then we update the list to make it appear instantly
            Intent intent = getIntent();
            finish();
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
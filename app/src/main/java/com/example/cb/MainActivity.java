package com.example.cb;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
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
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Product> products = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView empty = findViewById(R.id.empty);

        /*if (products.size() == 0)
            empty.setText("Vous pouvez ajouter un premier produit en appuyant sur le bouton plus");
        else
            empty.setText("");*/


        ListView list = findViewById(R.id.listView);
        Adapter adapter = new Adapter(this, products);
        list.setAdapter(adapter);

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
        String[] tmp = getIntent().getStringArrayExtra("product");
        if (tmp != null)
        {
            TextView empty = findViewById(R.id.empty);
            ImageView emptyImage = findViewById(R.id.emptyImage);
            empty.setText("");
            emptyImage.setImageResource(0);
            for (int i = 0; i < products.size(); i++)
            {
                if (products.get(i).getGtin().equals(tmp[1]))
                {
                    products.get(i).setDate(tmp[2]);
                    return;
                }
            }
            products.add(new Product(tmp[0], tmp[1], tmp[2]));
        }
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
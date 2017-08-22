package com.example.milly.builderpattern_myself;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import com.example.milly.builderpattern_myself.strategy.AverageContext;
import com.example.milly.builderpattern_myself.strategy.PreHospitalAverageStrategy;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mStrategy;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initViews();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {

               Products product = checkProductBuilder();

            }
        });
    }

    private void initViews() {
        mStrategy = (Button)findViewById(R.id.strategy);
    }

    private Products checkProductBuilder() {
        return new Products.ProductBuilder(100 , "drink")
            .setType("1")
            .setDescription("red tea")
            .setSource("711")
            .build();
    }

    @Override public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override public boolean onOptionsItemSelected(MenuItem item) {
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

    @Override public void onClick(View v) {
        if(v.getId() == R.id.strategy){

            //pass the strategy you want to use , and then will show the result of the choose strategy
            AverageContext averageContext = new AverageContext(new PreHospitalAverageStrategy());
            averageContext.calculateResult();
        }
    }
}

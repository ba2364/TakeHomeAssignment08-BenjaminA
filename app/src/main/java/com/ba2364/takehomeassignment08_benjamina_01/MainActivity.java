package com.ba2364.takehomeassignment08_benjamina_01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity
{
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference titleRef = database.getReference("title");
    private DatabaseReference cityRef = database.getReference("city");
    private TextView title;
    private TextView city;
    private TextView state;
    private TextView population;
    private CheckBox big;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        title = (TextView) findViewById(R.id.titleview);
        city = (TextView) findViewById(R.id.cityName);
        state = (TextView) findViewById(R.id.state);
        population = (TextView) findViewById(R.id.population);
        big = (CheckBox) findViewById(R.id.big);
    }

    public void setTitle(View view)
    {
        titleRef.setValue(title.getText().toString());
    }

    public void addCity(View view)
    {
        String cityName = city.getText().toString();
        String st = state.getText().toString();
        int pop = Integer.parseInt(population.getText().toString());
        boolean biggy =((CheckBox) findViewById(R.id.big)).isChecked();
        cityRef.push().setValue(new City(cityName,st,pop,biggy));
    }
}
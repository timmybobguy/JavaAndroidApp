package com.example.javaassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class LevelSelect extends AppCompatActivity {

    RecyclerView recyclerView;
    Adapter adapter;
    ArrayList<String> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_select);

        items = new ArrayList<>();
        items.add("Number 1");
        items.add("Number 2");
        items.add("Number 3");

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter(this, items);
        recyclerView.setAdapter(adapter);
    }
}
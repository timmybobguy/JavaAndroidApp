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
    ArrayList<String[]> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_select);

        items = new ArrayList<>();
        items.add(new String[]{"Level #1", "This is a very simple level", "5", "6", "#######+x+.##..w.##....#######"});
        items.add(new String[]{"Level #2", "This is a slightly harder level", "test"});
        items.add(new String[]{"Level #3", "This is a hard level", "test"});
        items.add(new String[]{"Level #4", "This is a level that can't be finished", "test"});

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter(this, items);
        recyclerView.setAdapter(adapter);
    }
}
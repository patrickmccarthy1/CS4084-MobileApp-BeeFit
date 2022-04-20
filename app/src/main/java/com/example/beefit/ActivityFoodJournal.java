package com.example.beefit;


import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class ActivityFoodJournal extends AppCompatActivity {

    RecyclerView recyclerFood;
    ArrayList<com.example.beefit.Journal> journalList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        //find recyclerFood View
        recyclerFood = findViewById(R.id.recycler_food);
        //specify an orientation for recyclerView
        LinearLayoutManager layoutManager;
        layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerFood.setLayoutManager(layoutManager);

        journalList = (ArrayList<com.example.beefit.Journal>) getIntent().getExtras().getSerializable("list");
        //set adapter
        recyclerFood.setAdapter(new com.example.beefit.JournalAdapter(journalList));

    }

}

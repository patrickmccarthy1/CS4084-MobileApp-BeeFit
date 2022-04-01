package ie.ul.BeeFit_Journal;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ActivityFoodJournal extends AppCompatActivity {

    RecyclerView recyclerFood;
    ArrayList<Journal> journalList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        recyclerFood = findViewById(R.id.recycler_food);

        LinearLayoutManager layoutManager;
        layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerFood.setLayoutManager(layoutManager);

        journalList = (ArrayList<Journal>) getIntent().getExtras().getSerializable("list");

        recyclerFood.setAdapter(new JournalAdapter(journalList));


    }

}

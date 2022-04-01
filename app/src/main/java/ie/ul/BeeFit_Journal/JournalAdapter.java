package ie.ul.BeeFit_Journal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class JournalAdapter extends RecyclerView.Adapter<JournalAdapter.JournalView> {

    ArrayList<Journal> journalList = new ArrayList<>();

    public JournalAdapter(ArrayList<Journal> journalList) {

    this.journalList =journalList;
}
    @NonNull
    @Override
    public JournalView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_food_journal,parent,false);

        return new JournalView(view);
    }

    @Override
    public int getItemCount() {
        return journalList.size();
    }

    public class JournalView extends RecyclerView.ViewHolder{

        TextView textFoodName,textFoodCal,textFoodPro,textFoodFat,textFoodCarbs,textFoodFibre,textFoodSugar;
        public JournalView(@NonNull View itemView){
            super(itemView);

            textFoodName = (TextView)itemView.findViewById(R.id.text_food_name);
            textFoodCal = (TextView)itemView.findViewById(R.id.text_food_cal);
            textFoodPro = (TextView)itemView.findViewById(R.id.text_protein);
            textFoodFat = (TextView)itemView.findViewById(R.id.text_fat);
            textFoodCarbs = (TextView)itemView.findViewById(R.id.text_Carb);
            textFoodFibre = (TextView)itemView.findViewById(R.id.text_Fib);
            textFoodSugar = (TextView)itemView.findViewById(R.id.text_Sugar);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull JournalView holder, int position) {

        Journal journal = journalList.get(position);
        holder.textFoodName.setText(journal.getFoodName());
        holder.textFoodCal.setText(journal.getFoodCal());
        holder.textFoodPro.setText(journal.getFoodPro());
        holder.textFoodFat.setText(journal.getFoodFat());
        holder.textFoodCarbs.setText(journal.getFoodCarbs());
        holder.textFoodFibre.setText(journal.getFoodFibre());
        holder.textFoodSugar.setText(journal.getFoodSugar());
    }


}

package com.example.javaassignment;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import sokoban.Direction;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private LayoutInflater layoutInflater;
    private List<String[]> data;

    Adapter(Context context, List<String[]> data) {
        this.layoutInflater = LayoutInflater.from(context);
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = layoutInflater.inflate(R.layout.custom_view, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        String title = data.get(i)[0];
        String desc = data.get(i)[1];
        viewHolder.textTitle.setText(title);
        viewHolder.textDescription.setText(desc);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder {

        TextView textTitle,textDescription;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {

                    Intent myIntent = new Intent(v.getContext(), GameActivity.class);
                    myIntent.putExtra("title", data.get(getAdapterPosition())[0]);
                    myIntent.putExtra("x", data.get(getAdapterPosition())[2]);
                    myIntent.putExtra("y", data.get(getAdapterPosition())[3]);
                    myIntent.putExtra("levelString", data.get(getAdapterPosition())[4]);
                    v.getContext().startActivity(myIntent);

                }
            });

            textTitle = itemView.findViewById(R.id.textTitle);
            textDescription = itemView.findViewById(R.id.textDescription);

        }
    }
}

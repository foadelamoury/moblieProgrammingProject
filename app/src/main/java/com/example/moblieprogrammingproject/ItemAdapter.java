package com.example.moblieprogrammingproject;

import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder> {

    List<Item> itemList;

    public ItemAdapter(List<Item> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.nameTextView.setText(itemList.get(position).getName());
        holder.surnameTextView.setText(itemList.get(position).getSurname());
        holder.marksTextView.setText(itemList.get(position).getMarks());
        holder.timestamp.setText(formatDate(itemList.get(position).getTimestamp()));
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        TextView surnameTextView;
        TextView marksTextView;
        TextView timestamp;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.name);
            surnameTextView=itemView.findViewById(R.id.surname);
            marksTextView=itemView.findViewById(R.id.marks);
            timestamp = itemView.findViewById(R.id.timestamp);

        }
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    private String formatDate(String dateStr) {
        try {
            SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = fmt.parse(dateStr);
            SimpleDateFormat fmtOut = new SimpleDateFormat("MMM d HH:mm:ss");
            return fmtOut.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return "";
    }
}

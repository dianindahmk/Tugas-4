package com.example.tugas4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private List<String> dataList;

    public DataAdapter(List<String> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String data = dataList.get(position);

        holder.textViewItem.setText(data);

        holder.imageViewIcon.setImageResource(R.drawable.ic_launcher_foreground);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void addItem(String data) {
        dataList.add(data);
        notifyItemInserted(dataList.size() - 1);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewItem;
        ImageView imageViewIcon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewItem = itemView.findViewById(R.id.textViewItem);
            imageViewIcon = itemView.findViewById(R.id.imageViewIcon);
        }
    }
}
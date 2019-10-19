package com.example.todolist.main;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todolist.model.Item;

import java.util.List;

public class MainAdapter
        extends RecyclerView.Adapter<MainAdapter.MainAdapterViewHolder> {

    List<Item> list;
    MainContract.Presenter presenter;
    MainAdapter(List<Item> list, MainContract.Presenter presenter) {
        this.list = list;
        this.presenter = presenter;
    }

    public static class MainAdapterViewHolder
            extends RecyclerView.ViewHolder {
        View view;
        TextView title;

        public MainAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            title = itemView.findViewById(android.R.id.text1);
        }
    }

    // 1번째 단계
    @NonNull
    @Override
    public MainAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(android.R.layout.simple_list_item_1,
                        parent,
                        false);
        return new MainAdapterViewHolder(view);
    }

    // 2번째 단계
    @Override
    public void onBindViewHolder(@NonNull MainAdapterViewHolder holder,
                                 int position) {
        Item item = list.get(position);
        holder.title.setText(item.getTitle());
        holder.view.setOnClickListener(v ->
                presenter.showDetail(item.getNo())
        );
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

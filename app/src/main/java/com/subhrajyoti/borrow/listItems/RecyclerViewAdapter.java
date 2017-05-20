package com.subhrajyoti.borrow.listItems;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.subhrajyoti.borrow.R;
import com.subhrajyoti.borrow.db.ItemAndPerson;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

    private List<ItemAndPerson> itemAndPersonList;

    public RecyclerViewAdapter(List<ItemAndPerson> itemAndPersonList) {
        this.itemAndPersonList = itemAndPersonList;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecyclerViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item, parent, false));
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolder holder, int position) {
        ItemAndPerson itemAndPerson = itemAndPersonList.get(position);
        holder.itemTextView.setText(itemAndPerson.getItemName());
        holder.nameTextView.setText(itemAndPerson.getFirstName().concat(" ").concat(itemAndPerson.getLastName()));
        holder.dateTextView.setText(itemAndPerson.getBorrowDate().toLocaleString().substring(0, 11));
    }

    @Override
    public int getItemCount() {
        return itemAndPersonList.size();
    }

    public void addItems(List<ItemAndPerson> itemAndPersonList) {
        this.itemAndPersonList = itemAndPersonList;
        notifyDataSetChanged();
    }

    static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView itemTextView;
        private TextView nameTextView;
        private TextView dateTextView;

        RecyclerViewHolder(View view) {
            super(view);
            itemTextView = (TextView) view.findViewById(R.id.itemTextView);
            nameTextView = (TextView) view.findViewById(R.id.nameTextView);
            dateTextView = (TextView) view.findViewById(R.id.dateTextView);
        }
    }
}
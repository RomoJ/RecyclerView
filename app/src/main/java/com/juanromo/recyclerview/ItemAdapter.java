package com.juanromo.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    private List<Item> itemList;
    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(Item item);
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        TextView itemName;
        TextView itemDescription;
        ImageView itemIcon;

        public ItemViewHolder(View itemView) {
            super(itemView);
            itemName = (TextView) itemView.findViewById(R.id.item_name);
            itemDescription = (TextView) itemView.findViewById(R.id.item_description);
            itemIcon = (ImageView) itemView.findViewById(R.id.item_icon);
        }
    }

    public ItemAdapter(List<Item> itemList, OnItemClickListener onItemClickListener) {
        this.itemList = itemList;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int position) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder viewHolder, int position) {
        final Item item = itemList.get(position);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(item);
            }
        });

        viewHolder.itemName.setText(item.getName());
        viewHolder.itemDescription.setText(item.getDescription());
        viewHolder.itemIcon.setImageResource(item.getIconResId());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}

package com.example.yonyo.templateproject.model;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.yonyo.templateproject.R;
import com.mikepenz.fastadapter.items.AbstractItem;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Mango extends AbstractItem<Mango, Mango.ViewHolder> {

    private String name, imageUrl, description;

    public Mango() { }

    public Mango(String name, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
    }

    // Your Getter Setters here

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getImageUrl() { return imageUrl; }

    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    // Fast Adapter methods
    @Override
    public int getType() { return R.id.mango_id; }

    @Override
    public int getLayoutRes() { return R.layout.item_mango; }

    @Override
    public ViewHolder getViewHolder(View v) {
        return new ViewHolder(v);
    }

    @Override
    public void bindView(ViewHolder holder) {
        super.bindView(holder);

        holder.tvtTitle.setText(name);
        holder.tvDesc.setText(description);
    }

    // Manually create the ViewHolder class
    protected static class ViewHolder extends RecyclerView.ViewHolder {

        //TODO: Declare your UI widgets here
        @BindView(R.id.tv_text)
        TextView tvtTitle;
        @BindView(R.id.tv_desc)
        TextView tvDesc;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}

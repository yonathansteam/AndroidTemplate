package com.example.yonyo.templateproject.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yonyo.templateproject.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategorySearchAdapter extends RecyclerView.Adapter<CategorySearchAdapter.CategorySearchViewHolder> {

    private Context mContext;
    private List<String> list;

    public CategorySearchAdapter(Context context) {
        mContext = context;
        list = new ArrayList<>();
    }

    @NonNull
    @Override
    public CategorySearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CategorySearchViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_category,  parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CategorySearchViewHolder holder, int position) {
        holder.bindDataToView(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void updateData(List<String> searchList) {
        list = searchList;
        notifyDataSetChanged();
    }

    public class CategorySearchViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_name)
        TextView tvName;

        public CategorySearchViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindDataToView(String name) {
            tvName.setText(name);
        }
    }
}

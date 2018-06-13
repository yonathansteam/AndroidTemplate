package com.example.yonyo.templateproject.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yonyo.templateproject.R;
import com.example.yonyo.templateproject.model.Category;
import com.example.yonyo.templateproject.view.MainContract;
import com.example.yonyo.templateproject.view.MainPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.CategoryListViewHolder> {

    private Context mContext;
    private List<Category> categoryArrayList;
    private List<Category> allData;
    private MainContract.View mView;

    public CategoryListAdapter(Context context, MainContract.View mView) {
        mContext = context;
        this.mView = mView;
        categoryArrayList = new ArrayList<>();
    }

    @NonNull
    @Override
    public CategoryListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CategoryListViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_category, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final CategoryListViewHolder holder, final int position) {
        holder.bindDataToView(categoryArrayList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if (holder.ivRightArrow.getVisibility() == View.VISIBLE){
                   mView.itemOnClick(position);
               }
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryArrayList.size();
    }

    public void updateData(List<Category> categoryList) {
        categoryArrayList = categoryList;
        allData = categoryList;

        List<Category> a  = new ArrayList<>();
        for (int i = 0 ; i < categoryArrayList.size() ; i++){
            a.add(new Category(categoryArrayList.get(i).getName(),
                    categoryArrayList.get(i).getChildren().size()));
        }
        categoryArrayList = a;

        notifyDataSetChanged();
    }

    public void showChildrenData(int secondPageIndex) {
        List<Category> a  = new ArrayList<>();

        for (int i = 0 ; i < allData.get(secondPageIndex).getChildren().size() ; i++){
            a.add(new Category(allData.get(secondPageIndex).getChildren().get(i).getName(),
                    allData.get(secondPageIndex).getChildren().get(i).getCategoryGrandchildren().size()));
        }

        categoryArrayList = a;
        notifyDataSetChanged();
    }

    public void showChildrenData( int secondPageIndex, int thirdPageIndex) {
        List<Category> a  = new ArrayList<>();

        for (int i = 0 ; i < allData.get(secondPageIndex).getChildren().get(thirdPageIndex).getCategoryGrandchildren().size() ; i++){
            a.add(new Category(allData.get(secondPageIndex).getChildren().get(thirdPageIndex).getCategoryGrandchildren().get(i).getName(), 0));
        }

        categoryArrayList = a;
        notifyDataSetChanged();
    }

    public class CategoryListViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.iv_right_arrow)
        ImageView ivRightArrow;

        public CategoryListViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindDataToView(Category category) {
            tvName.setText(category.getName());

            if (category.getChildrenSize() == 0){
                ivRightArrow.setVisibility(View.GONE);
            } else {
                ivRightArrow.setVisibility(View.VISIBLE);
            }
        }
    }
}

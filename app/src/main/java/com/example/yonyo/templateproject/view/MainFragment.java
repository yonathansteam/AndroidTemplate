package com.example.yonyo.templateproject.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yonyo.templateproject.R;
import com.example.yonyo.templateproject.adapter.CategoryListAdapter;
import com.example.yonyo.templateproject.adapter.CategorySearchAdapter;
import com.example.yonyo.templateproject.model.Category;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainFragment extends Fragment implements MainContract.View {

    @BindView(R.id.tv_category)
    TextView tvCategory;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.search_rv)
    RecyclerView rvSearch;
    @BindView(R.id.et_search)
    EditText etSearch;
    @BindView(R.id.iv_clear)
    ImageView ivClear;
    @BindView(R.id.ll_search)
    LinearLayout llSearch;
    @BindView(R.id.ll_back)
    LinearLayout llBack;
    @BindView(R.id.tv_back_title)
    TextView tvBackTitle;
    @BindView(R.id.tv_not_found)
    TextView tvNotFound;

    private Context context;
    private Unbinder unbinder;
    private MainContract.Presenter mPresenter;
    private CategoryListAdapter categoryListAdapter;
    private CategorySearchAdapter categorySearchAdapter;
    private List<Category> categories;
    private boolean secondPage, thirdPage;
    private int secondPageIndex;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        context = null;
    }

    public static MainFragment newInstance() {

        Bundle args = new Bundle();

        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        unbinder = ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mPresenter.searchData(s.toString(), categories);
            }
        });
        setupRecyclerView();
        mPresenter = new MainPresenter(this);
        mPresenter.fetchData();
    }

    private void setupRecyclerView(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(linearLayoutManager);
        rvSearch.setLayoutManager(layoutManager);

        categorySearchAdapter = new CategorySearchAdapter(context);
        rvSearch.setAdapter(categorySearchAdapter);
        categoryListAdapter = new CategoryListAdapter(context, this);
        recyclerView.setAdapter(categoryListAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void showData(List<Category> categoryList) {
        categories = categoryList;
        categoryListAdapter.updateData(categoryList);
    }

    @Override
    public void showInfoNotFound() {
        tvNotFound.setVisibility(View.VISIBLE);
        rvSearch.setVisibility(View.GONE);
    }

    @Override
    public void showCategoryList() {
        tvCategory.setVisibility(View.VISIBLE);

        llSearch.setVisibility(View.VISIBLE);
        llBack.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
        rvSearch.setVisibility(View.GONE);
        tvNotFound.setVisibility(View.GONE);
    }

    @Override
    public void showSearchData(List<String> searchList) {
        tvCategory.setVisibility(View.GONE);
        recyclerView.setVisibility(View.GONE);
        rvSearch.setVisibility(View.VISIBLE);
        tvNotFound.setVisibility(View.GONE);
        categorySearchAdapter.updateData(searchList);
    }

    @Override
    public void itemOnClick(int position) {
        llSearch.setVisibility(View.GONE);
        llBack.setVisibility(View.VISIBLE);

        if (secondPage){
            thirdPage = true;

            tvCategory.setText(categories.get(secondPageIndex).getChildren().get(position).getName());
            tvBackTitle.setText("Kembali ke "+categories.get(secondPageIndex).getName());
            categoryListAdapter.showChildrenData(secondPageIndex, position);
        } else {
            secondPage = true;
            secondPageIndex = position;

            tvCategory.setText(categories.get(secondPageIndex).getName());
            categoryListAdapter.showChildrenData(secondPageIndex);
        }
    }

    @Override
    public void backToCategoryList() {
        secondPage = false;
        tvCategory.setText("SEMUA KATEGORI");

        llSearch.setVisibility(View.VISIBLE);
        llBack.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
        categoryListAdapter.updateData(categories);
        rvSearch.setVisibility(View.GONE);
    }

    @Override
    public void backToChildrenList() {
        tvBackTitle.setText("Kembali ke semua kategori");

        tvCategory.setText(categories.get(secondPageIndex).getName());
        thirdPage = false;
        categoryListAdapter.showChildrenData(secondPageIndex);
    }

    @Override
    public void showSnackbar(String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    @OnClick({R.id.iv_clear, R.id.ll_back})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.iv_clear:
                etSearch.setText("");
                mPresenter.searchData("", null);
                break;
            case R.id.ll_back:
                mPresenter.validateBackButton(secondPage, thirdPage);
                break;
        }
    }
}

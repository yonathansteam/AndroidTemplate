package com.example.yonyo.templateproject.view;

import android.support.annotation.NonNull;

import com.example.yonyo.templateproject.model.Category;
import com.example.yonyo.templateproject.model.CategoryChildren;
import com.example.yonyo.templateproject.model.CategoryGrandChildren;
import com.example.yonyo.templateproject.model.MainResponse;
import com.example.yonyo.templateproject.service.RetrofitService;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View mView;

    public MainPresenter(MainContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void fetchData() {
        Call<MainResponse> call = RetrofitService.retrofitRequest().getCategory();
        call.enqueue(new Callback<MainResponse>() {
            @Override
            public void onResponse(@NonNull Call<MainResponse> call, @NonNull Response<MainResponse>  response)  {
                if (response.isSuccessful()){

                    MainResponse mainResponse = response.body();
                    assert mainResponse != null;
                    mView.showData(mainResponse.getCategoryList());
                } else {
                    mView.showSnackbar("Connection failed");
                }
            }

            @Override
            public void onFailure(@NonNull Call<MainResponse> call,@NonNull Throwable t) {
                mView.showSnackbar("Connection failure");
            }
        });
    }

    @Override
    public void searchData(String s, List<Category> categories) {

        if (s.isEmpty()){
            mView.showCategoryList();
        } else {
            List<String> searchList = new ArrayList<>();

            for (Category category : categories){
                if (category.getName().toLowerCase().contains(s.toLowerCase())){
                    searchList.add(category.getName());
                }
                for (CategoryChildren children : category.getChildren()){
                    if (children.getName().toLowerCase().contains(s.toLowerCase())){
                        searchList.add(children.getName() +" / "+ category.getName());
                    }

                    for (CategoryGrandChildren grandChildren : children.getCategoryGrandchildren()){
                        if (grandChildren.getName().toLowerCase().contains(s.toLowerCase())){
                            searchList.add(grandChildren.getName() +" / "+ children.getName() +" / "+ category.getName());
                        }
                    }
                }
            }

            if (searchList.isEmpty()){
                mView.showInfoNotFound();
            } else {
                mView.showSearchData(searchList);
            }

        }
    }

    @Override
    public void validateBackButton(boolean secondPage, boolean thirdPage) {
        if (thirdPage){
            mView.backToChildrenList();
        } else {
            mView.backToCategoryList();
        }
    }

}

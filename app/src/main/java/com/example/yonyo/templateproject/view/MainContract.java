package com.example.yonyo.templateproject.view;

import com.example.yonyo.templateproject.model.Category;

import java.util.List;

public interface MainContract {

    interface View {
        void showData(List<Category> categoryList);
        void showSearchData(List<String> searchList);
        void showSnackbar(String message);
        void showCategoryList();
        void itemOnClick(int position);

        void backToCategoryList();
        void backToChildrenList();

        void showInfoNotFound();
    }

    interface Presenter {
        void fetchData();
        void searchData(String s, List<Category> categories);
        void validateBackButton(boolean secondPage, boolean thirdPage);
    }

}

package com.example.todolist.main;

import com.example.todolist.base.BasePresenter;
import com.example.todolist.base.BaseView;
import com.example.todolist.model.Item;

import java.util.List;

public class MainContract {
    public interface View
            extends BaseView {
        void fetchItemsDone(List<Item> items);
        void showDetail(int pos);
    }

    public interface Presenter
            extends BasePresenter<View> {
        //TODO fetch Items
        void fetchItems();
        void fetchItemsDone(List<Item> items);
        void showDetail(int no);
    }
}

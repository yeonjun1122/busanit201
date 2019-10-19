package com.example.todolist.logic;

import com.example.todolist.base.BasePresenter;
import com.example.todolist.model.Item;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

public interface Repository<T> {
    void setPresenter(BasePresenter<T> presenter);
    Single<Long> save(Item item);
    void saveDone();

    //Fetch
    Flowable<List<Item>> fetchItems();
    void fetchItemsDone(List<Item> items);

    Single<Item> fetchItem(int no);
}

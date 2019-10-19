package com.example.todolist.logic;

import com.example.todolist.model.Item;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

public interface DataSource {
    void setRepository(Repository repository);
    Single<Long> save(Item item);

    Flowable<List<Item>> fetchItems();

    Single<Item> fetchItem(int no);
}

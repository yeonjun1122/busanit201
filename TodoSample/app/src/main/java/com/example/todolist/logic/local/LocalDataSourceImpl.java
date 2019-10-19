package com.example.todolist.logic.local;

import com.example.todolist.logic.DataSource;
import com.example.todolist.logic.Repository;
import com.example.todolist.model.Item;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

public class LocalDataSourceImpl implements DataSource {
    Repository repository;
    AppDatabase appDatabase;

    public LocalDataSourceImpl() {
        try {
            appDatabase = AppDatabaseProvider.getINSTANCE();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    @Override
    public Single<Long> save(final Item item) {
        //TODO SAVE
        return getItemDao().saveItem(item);
    }

    // Fetch Items
    @Override
    public Flowable<List<Item>> fetchItems() {
        return getItemDao().fetchItems();
    }

    @Override
    public Single<Item> fetchItem(int no) {
        return getItemDao().fetchItem(no);
    }

    private ItemDao getItemDao() {
        return appDatabase.getItemDao();
    }
}

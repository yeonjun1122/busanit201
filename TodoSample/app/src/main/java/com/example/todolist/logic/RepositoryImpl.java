package com.example.todolist.logic;

import com.example.todolist.base.BasePresenter;
import com.example.todolist.logic.local.LocalDataSourceImpl;
import com.example.todolist.logic.remote.RemoteDataSourceImpl;
import com.example.todolist.main.MainContract;
import com.example.todolist.model.Item;
import com.example.todolist.write.WriteContract;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

public class RepositoryImpl<T> implements Repository {
    BasePresenter<T> presenter;
    DataSource localDataSource;
    DataSource remoteDataSource;

    @Override
    public void setPresenter(BasePresenter presenter) {
        this.presenter = presenter;
        localDataSource = new LocalDataSourceImpl();
        remoteDataSource = new RemoteDataSourceImpl();
        localDataSource.setRepository(this);
        remoteDataSource.setRepository(this);
    }

    @Override
    public Single<Long> save(Item item) {
        return localDataSource.save(item);
    }

    @Override
    public void saveDone() {
        ((WriteContract.Presenter)presenter).saveDone();
    }

    @Override
    public Flowable<List<Item>> fetchItems() {
        return localDataSource.fetchItems();
    }

    @Override
    public void fetchItemsDone(List list) {
        ((MainContract.Presenter)presenter).fetchItemsDone(list);
    }

    @Override
    public Single<Item> fetchItem(int no) {
        return localDataSource.fetchItem(no);
    }
}

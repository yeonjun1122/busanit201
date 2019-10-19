package com.example.todolist.main;

import com.example.todolist.base.BasePresenterImpl;
import com.example.todolist.logic.Repository;
import com.example.todolist.logic.RepositoryImpl;
import com.example.todolist.model.Item;

import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter
        extends BasePresenterImpl<MainContract.View>
        implements MainContract.Presenter {
    Repository repository;

    MainPresenter() {
        this.repository = new RepositoryImpl();
        this.repository.setPresenter(this);
    }

    @Override
    public void fetchItems() {
        Disposable da = this.repository.fetchItems()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<Item>>) items -> {
                        view.fetchItemsDone(items);
                });

        bag.add(da);

    }

    @Override
    public void fetchItemsDone(List<Item> items) {
        view.fetchItemsDone(items);
    }

    @Override
    public void showDetail(int no) {
        view.showDetail(no);
    }


}

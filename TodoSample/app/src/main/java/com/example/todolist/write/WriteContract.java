package com.example.todolist.write;

import com.example.todolist.base.BasePresenter;
import com.example.todolist.base.BaseView;
import com.example.todolist.model.Item;

public class WriteContract {
    public interface View extends BaseView {
        // 작성완료 ( <= Presenter)
        void saveDone();
    }

    public interface Presenter
            extends BasePresenter<View> {
        // 저장
        void save(Item item);
        // 작성완료 ( <= Repository)
        void saveDone();
    }
}

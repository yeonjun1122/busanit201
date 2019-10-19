package com.example.todolist.base;

public interface BasePresenter<T> {
    void setView(T view);
    void removeView();
}

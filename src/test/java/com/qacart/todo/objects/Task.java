package com.qacart.todo.objects;

public class Task {
    private boolean IsCompleted;
    private String Item;

    public Task(boolean isCompleted, String item) {
        IsCompleted = isCompleted;
        Item = item;
    }

    public boolean getIsCompleted() {
        return IsCompleted;
    }

    public void setIsCompleted(boolean completed) {
        IsCompleted = completed;
    }

    public String getItem() {
        return Item;
    }

    public void setItem(String item) {
        Item = item;
    }

}

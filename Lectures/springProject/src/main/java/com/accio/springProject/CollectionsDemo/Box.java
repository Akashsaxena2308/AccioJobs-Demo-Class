package com.accio.springProject.CollectionsDemo;

public class Box<T> {

    private final T value;

    public Box(T val){
        this.value = val;
    }

    public T get(){
        return this.value;
    }
}

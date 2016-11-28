package com.aptyr.datastructures;

/**
 * Created by artur on 28/11/2016.
 */
class LinkedNode<E> {

    private E item;
    private LinkedNode<E> next;

    public E getItem() {
        return item;
    }

    public void setItem(E item) {
        this.item = item;
    }

    public LinkedNode<E> getNext() {
        return next;
    }

    public void setNext(LinkedNode<E> next) {
        this.next = next;
    }
}

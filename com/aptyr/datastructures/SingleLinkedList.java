package com.aptyr.datastructures;

/*
 * Copyright (C) 2016 Artur Matusiak (github.com/aptyr)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class SingleLinkedList<E> implements Array<E>, LinkedList<E> {

    private LinkedNode<E> head;
    private LinkedNode<E> tail;

    @Override
    public int size() {
        return 0;
    }

    @Override
    public int capacity() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public E at(int index) {
        return null;
    }

    @Override
    public void push(E item) {

    }

    @Override
    public void insert(int index, E item) {

    }


    @Override
    public E pop() {
        return null;
    }

    @Override
    public void delete(int index) {

    }

    @Override
    public void remove(E item) {

    }

    @Override
    public int find(E item) {
        return 0;
    }

    @Override
    public E front() {
        return null;
    }

    @Override
    public E back() {
        return null;
    }

    @Override
    public void reverse() {

    }

    @Override
    public void pushFront(E item) {

    }

    @Override
    public void pushBack(E item) {

    }
}

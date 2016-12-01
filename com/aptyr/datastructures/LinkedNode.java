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
class LinkedNode<E> {

    private E item;
    private LinkedNode<E> next;
    private LinkedNode<E> previous;

    public LinkedNode(E item){
        this.item = item;
    }

    public LinkedNode(E item, LinkedNode linkedNode){
        this.item = item;
        linkedNode.next = this;
    }

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

    public LinkedNode<E> getPrevious() {
        return previous;
    }

    public void setPrevious(LinkedNode<E> previous) {
        this.previous = previous;
    }
}

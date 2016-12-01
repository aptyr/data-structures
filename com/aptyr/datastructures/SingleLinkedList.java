package com.aptyr.datastructures;

import com.sun.istack.internal.Nullable;

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

    private int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public int capacity() {
        return size();
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public E at(int index) {
        if (index >= 0 && index < size()) {
            LinkedNode<E> node = head;
            int i = 0;
            while (i < index) {
                node = node.getNext();
                ++i;
            }
            return node.getItem();
        } else {
            throw new IndexOutOfBoundsException("Requested for item at index: " + index + " when list size is: " + size);
        }
    }

    /**
     * Result equals to pushBack
     *
     * @param item
     */
    @Override
    public void push(E item) {
        pushBack(item);
    }

    @Override
    public void insert(int index, E item) {
        if (index < size) {
            LinkedNode<E> node = head;
            LinkedNode<E> toInsert = new LinkedNode<E>(item);

            if (index == 0) {
                toInsert.setNext(node);
                head = toInsert;
            } else {
                int i = 1;
                while (i < index) {
                    node = node.getNext();
                    ++i;
                }

                toInsert.setNext(node.getNext());
                node.setNext(toInsert);
            }
            size++;
        } else {
            throw new IndexOutOfBoundsException("Requested for insert item at index: " + index + " when list size is: " + size);
        }
    }


    @Nullable
    @Override
    public E pop() {
        if (head != null) {
            LinkedNode<E> node = head;
            int index = 1;
            while (index < size) {
                node = node.getNext();
                ++index;
            }
            node.setNext(null);
            tail = node;
            decrementSize();
            return node.getItem();
        }
        return null;
    }

    @Override
    public void delete(int index) {
        if (index >= 0 && index < size) {
            int i = 0;
            LinkedNode<E> node = head;
            while(i != index){
                node = node.getNext();
                ++i;
            }
            node = node.getNext();
            decrementSize();
        } else {
            throw new IndexOutOfBoundsException("Requested for delete item at index: " + index + " when list size is: " + size);
        }
    }

    @Override
    public void remove(E item) {
//        LinkedNode<E> node = head;
//        while(node.getNext() != null){
//
//            node = node.getNext();
//
//        }
//        node = node.getNext();
//        decrementSize();
    }

    @Override
    public int find(E item) {
        if (head != null) {
            int result = 0;
            LinkedNode<E> node = head;
            if (item == null) {
                result = size - 1;
            } else {
                if(size > 1) {
                    while (node.getNext() != null) {
                        node = node.getNext();
                        ++result;
                        if (node.getItem().equals(item)) {
                            break;
                        }
                        if (node.getNext() == null) {
                            result = -1;
                        }
                    }
                } else {
                    result = -1;
                    if(node.getItem().equals(item)){
                        result = 0;
                    }
                }
            }
            return result;
        }
        return -1;
    }

    @Nullable
    @Override
    public E front() {
        if (head != null) {
            return head.getItem();
        }
        return null;
    }

    @Nullable
    @Override
    public E back() {
        if (tail != null) {
            return tail.getItem();
        } else if (head != null) {
            return last().getItem();
        }
        return null;
    }

    @Override
    public void reverse() {

    }

    @Override
    public void pushFront(E item) {
        if (head != null) {
            LinkedNode<E> toInsert = new LinkedNode<E>(item);
            toInsert.setNext(head);
            head = toInsert;
        } else {
            head = new LinkedNode<>(item);
            tail = head;
        }
        size++;
    }

    @Override
    public void pushBack(E item) {
        if (tail != null) {
            tail = new LinkedNode<>(item, tail);
        } else if (head != null) {
            tail = last();
            tail = new LinkedNode<>(item, tail);
        } else {
            head = new LinkedNode<>(item);
            tail = head;
        }
        size++;
    }

    private LinkedNode<E> last() {
        LinkedNode<E> node = head;
        while (node.getNext() != null) {
            node = node.getNext();
        }
        return node;
    }

    private void decrementSize() {
        if (--size == 0) {
            head = null;
        }
    }
}

package com.aptyr.datastructures;

/*
 * Copyright (C) 2016 Aptyr (github.com/aptyr)
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
public class ArrayList<E> implements Array<E> {

    private final int defaultCapacity = 16;

    private int capacity = defaultCapacity;
    private int size;

    private Object data[] = new Object[defaultCapacity];

    @Override
    public int size() {
        return size;
    }

    @Override
    public int capacity() {
        return capacity;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E at(int index) {
        if (index < size) {
            return data(index);
        } else {
            throw new IndexOutOfBoundsException("Requested for item with index: " + index + " when array size is: " + size);
        }
    }

    @Override
    public void push(E item) {
        resizeBeforeAddItem();
        data[size++] = item;
    }

    @Override
    public void insert(int index, E item) {
        if (index < size) {
            resizeBeforeAddItem();
            Object[] tmpArr = copy();
            data = new Object[capacity];

            int position = 0;

            for (int i = 0; i < size; i++) {
                if (i == index) {
                    data[position++] = item;
                    size++;
                }
                data[position++] = tmpArr[i];
            }
        } else {
            throw new IndexOutOfBoundsException("Requested for insert item at index: " + index + " when array size is: " + size);
        }
    }

    @Override
    public void prepend(E item) {

    }

    @Override
    public E pop() {
        if (size > 0) {
            E toReturn = data(size - 1);
            data[--size] = null;
            return toReturn;
        } else {
            throw new IndexOutOfBoundsException("Nothing to pop");
        }
    }

    @Override
    public void delete(int index) {
        if (index < size) {
            Object[] tmpArr = copy();
            data = new Object[capacity];

            int position = 0;

            for (int i = 0; i < size; i++) {
                if (i != index) {
                    data[position++] = tmpArr[i];
                } else {
                    tmpArr[i] = null;
                }
            }

            --size;
            resizeAfterDeleteItem();
        } else {
            throw new IndexOutOfBoundsException("Requested for delete item at index: " + index + " when array size is: " + size);
        }
    }


    @Override
    public void remove(E item) {
        if (size > 0) {
            int itemsToDelete[] = new int[size];
            for (int i = 0; i < itemsToDelete.length; i++) {
                itemsToDelete[i] = -1;
            }

            int index = 0;
            int counter = 0;

            if (item == null) {
                for (int i = 0; i < size; i++) {
                    if (data[i] == null) {
                        itemsToDelete[index++] = i;
                        counter++;
                    }
                }
            } else {
                for (int i = 0; i < size; i++) {
                    if (data[i].equals(item)) {
                        itemsToDelete[index++] = i;
                        counter++;
                    }
                }
            }

            Object[] tmpArr = copy();
            data = new Object[capacity];

            int position = 0;
            boolean remove;
            for (int i = 0; i < size; i++) {
                remove = false;

                for (int i1 = 0; i1 < itemsToDelete.length; i1++) {
                    if(itemsToDelete[i1] == i){
                        remove = true;
                        itemsToDelete[i1] = -1;
                        break;
                    }
                }

                if (!remove) {
                    data[position++] = tmpArr[i];
                } else {
                    tmpArr[i] = null;
                }
            }
            size -= counter;
            resizeAfterDeleteItem();


        }
    }

    @Override
    public int find(E item) {
        if (item == null) {
            for (int i = 0; i < size; i++) {
                if (data[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (data[i].equals(item)) {
                    return i;
                }
            }
        }
        return -1;
    }

    private void resize(int capacity) {
        if (capacity < defaultCapacity) {
            capacity = defaultCapacity;
        }

        Object[] tmpArr = copy();
        data = new Object[capacity];
        this.capacity = capacity;

        for (int i = 0; i < size; i++) {
            data[i] = tmpArr[i];
        }

        tmpArr = null;
    }

    private void resizeBeforeAddItem() {
        if (size + 1 >= capacity) {
            resize(capacity * 2);
        }
    }

    private void resizeAfterDeleteItem() {
        if (size < capacity / 4) {
            resize(capacity / 4);
        }
    }

    private Object[] copy() {
        Object[] arr = new Object[data.length];
        for (int i = 0; i < data.length; i++) {
            arr[i] = data[i];
        }
        return arr;
    }

    private E data(int index) {
        return (E) data[index];
    }
}

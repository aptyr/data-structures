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
public interface Array<T> {

    int size();

    int capacity();

    boolean isEmpty();

    T at(int index);

    void push(T item);

    void insert(int index, T item);

    T pop();

    void delete(int index);

    void remove(T item);

    int find(T item);

}

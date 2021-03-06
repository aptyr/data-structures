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
public interface LinkedList<T> {

    /**
     * @return value of front item
     */
    @Nullable
    T front();

    /**
     * @return vale of end item
     */
    @Nullable
    T back();

    /**
     * reverses the list
     */
    void reverse();

    /**
     * Adds an item to the front of the list
     *
     * @param item
     */
    void pushFront(T item);

    /**
     * Adds an item at the end
     *
     * @param item
     */
    void pushBack(T item);

    int size();

    boolean isEmpty();

    @Nullable
    T pop();

}

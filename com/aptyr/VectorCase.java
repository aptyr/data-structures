package com.aptyr;

import com.aptyr.datastructures.Array;
import com.aptyr.datastructures.ArrayList;

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
public class VectorCase implements Case {


    @Override
    public void run() {
        Array<String> arr = new ArrayList<>();

        for (int i = 0; i < 18; i++) {
            arr.push("String " + i);
        }

        arr.insert(2, "SD");
        arr.insert(6, "SD");
        arr.insert(1, "SD");

        System.out.println("pop: " + arr.pop());
        System.out.println("pop: " + arr.pop());

        System.out.println("find: " + arr.find("String 2"));
        System.out.println("find: " + arr.find("String 22"));

        arr.delete(1);
        arr.delete(1);
        arr.delete(1);
        arr.delete(1);
        arr.delete(1);

        arr.remove("SD");
        arr.remove("String 1");
        arr.remove("String 10");
        arr.remove("String 0");
        arr.remove("String 290");
        arr.remove("String 2");
        arr.remove("String 3");
        arr.remove("String 4");
        arr.remove("String 5");
        arr.remove("String 6");
        arr.remove("String 7");
        arr.remove("String 8");
        arr.remove("String 11");
        arr.remove("String 12");

        System.out.println("Arr size: " + arr.size() + " capacity: " + arr.capacity());

        for (int i = 0; i < arr.size(); i++) {
            System.out.println(i + ": " + arr.at(i));
        }

    }
}

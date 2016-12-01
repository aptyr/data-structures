package com.aptyr.cases;

import com.aptyr.datastructures.Array;
import com.aptyr.datastructures.LinkedList;
import com.aptyr.datastructures.SingleLinkedList;

/**
 * Created by artur on 30/11/2016.
 */
public class SingleLinkedListCase implements Case {

    @Override
    public void run() {

        LinkedList<String> linkedList = new SingleLinkedList<>();
        linkedList.pushFront("String0#Case1");
        for(int i = 0; i<2; i++) {
            linkedList.pushBack("String1#Case1 - " + i);
            linkedList.pushBack("String2#Case1 - " + i);
        }
        linkedList.pushFront("String00#Case1");
        System.out.println("case1:back: " + linkedList.back());
        System.out.println("case1:front: " + linkedList.front());

        while (!linkedList.isEmpty()) {
            System.out.println("case1:pop: " + linkedList.pop() + " left: " + linkedList.size());
        }

        System.out.println();

        Array<String> linkedList2 = new SingleLinkedList<>();

        linkedList2.push("String1#Case2");
        System.out.println("case2:find: " + linkedList2.find("NO"));
        linkedList2.push("String2#Case2");
        linkedList2.push("String3#Case2");
        linkedList2.push("String4#Case2");
        linkedList2.insert(3, "String1X#Case2");
        linkedList2.insert(3, "String2X#Case2");
        linkedList2.insert(3, "String3X#Case2");
        linkedList2.insert(1, "String4X#Case2");

        linkedList2.delete(1);
        linkedList2.delete(1);
        linkedList2.delete(0);
        linkedList2.delete(3);

        System.out.println("case2:at: " + linkedList2.at(0));
        System.out.println("case2:at: " + linkedList2.at(2));
        System.out.println("case2:at: " + linkedList2.at(1));
        System.out.println("case2:find: " + linkedList2.find("NO"));
        System.out.println("case2:find: " + linkedList2.find("String1X#Case2"));
        System.out.println("case2:find: " + linkedList2.find(null));


        while (!linkedList2.isEmpty()) {
            System.out.println("case2:pop: " + linkedList2.pop() + " left: " + linkedList2.size());
        }

    }
}

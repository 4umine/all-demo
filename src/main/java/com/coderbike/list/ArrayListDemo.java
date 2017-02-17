package com.coderbike.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: imant
 * date: 2017/2/14 17:32
 */
public class ArrayListDemo {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer i = iterator.next();
            System.out.println(i);
        }
    }
}

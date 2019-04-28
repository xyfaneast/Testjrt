package com.cmc;

import java.util.ArrayList;
import java.util.List;

public class TestSublist {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        List<Integer> subList1 = list.subList(0, 1);
        // List<Integer> subList1 = new ArrayList<>();
        // subList1.add(10);
        list1 list0 = new list1(subList1);
        subList1 = list.subList(1, 2);
        // subList1.set(0, 11);
        list1 list1 = new list1(subList1);
        subList1 = list.subList(2, 3);
        // subList1.set(0, 12);
        list1 list2 = new list1(subList1);
        subList1 = list.subList(3, 4);
        // subList1.set(0, 13);
        list1 list3 = new list1(subList1);
        List<Integer> list00 = list0.getList();
        List<Integer> list11 = list1.getList();
        List<Integer> list22 = list2.getList();
        List<Integer> list33 = list3.getList();
    }
}

class list1 {
    private List<Integer> list = new ArrayList<>();

    public list1(List<Integer> list) {
        this.list = list;
    }

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }

}

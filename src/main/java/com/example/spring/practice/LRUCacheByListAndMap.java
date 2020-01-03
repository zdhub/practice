package com.example.spring.practice;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

/**
 * @ClassName LRUCacheByListAndMap
 * @Descirption
 * @Author yizhendong
 * @Date 3/1/2020
 **/
public class LRUCacheByListAndMap {

    @Setter
    @Getter
    @Data
    class Node {
        private Node prev;
        private Node next;
        private int key;
        private int value;
    }

    private int capacity;
    private Node head;
    private Node tail;
    private HashMap<Integer, Node> nodeMap;

    public LRUCacheByListAndMap(int capacity) {
        this.capacity = capacity;
        nodeMap = new HashMap<>();

    }

}

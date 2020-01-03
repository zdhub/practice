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

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private Node head;
    private Node tail;
    private HashMap<Integer, Node> nodeMap;

    public LRUCacheByListAndMap(int capacity) {
        this.capacity = capacity;
        nodeMap = new HashMap<>();
    }

    public void set(int key, int value) {
        Node nodeTemp = new Node(key, value);
        if (head == null) {
            head = nodeTemp;
            nodeMap.put(key, nodeTemp);
            return;
        }
        if (nodeMap.containsKey(key)) {
            Node node = nodeMap.get(key);
            node.value = value;
            insertToHead(node);
            return;
        }
        addNode(nodeTemp);

        if (nodeMap.size() > capacity) {
            removeLastNode();
        }
    }

    public Integer get(int key) {
        if (nodeMap.get(key) == null) {
            return null;
        }
        insertToHead(nodeMap.get(key));
        return nodeMap.get(key).getValue();

    }

    private void removeLastNode() {
        nodeMap.remove(tail.getKey());
        tail = null;
    }

    private void addNode(Node nodeTemp) {
        nodeTemp.next = head;
        head.prev = nodeTemp;
        nodeMap.put(nodeTemp.getKey(), nodeTemp);
    }

    private void insertToHead(Node node) {
        if (node.prev == null) {
            return;
        }
        if (node.next == null) {
            head = node.next;
            node.prev = null;
        } else {
            head.prev.next = head.next;
            head.next.prev = head.prev;
        }

        head.prev = node;
        node.next = head;
    }

}

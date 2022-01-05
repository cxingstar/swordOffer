package groundtrue.chapters5;

import java.util.HashMap;

public class o31 {
    //LRUCache 最近最长未使用缓存
    class LRUCache {
    class Node{
        int key, val;
        Node pre,next;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
        public Node(){

        }
    }
    Node head;
    Node tail;
    int size;
    HashMap<Integer,Node> map;

    public LRUCache(int capacity){
        size = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
        map = new HashMap<>();
    }
    public int get(int key){
        if(!map.containsKey(key))
            return -1;
        Node node = map.get(key);
        moveToHead(node);
        return node.val;
    }
    public void put(int key,int value){
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            map.put(key,node);
            moveToHead(node);
        }
        else{
            if(map.size() == size){
                Node node = tail.pre;
                deleteNode(node);
                map.remove(node.key);
            }
            Node node = new Node(key,value);
            map.put(key,node);
            addToHead(node);
        }
    }

    public void deleteNode(Node node){
        node.next.pre = node.pre;
        node.pre.next = node.next;
    }
    public void moveToHead(Node node){
        deleteNode(node);
        addToHead(node);
    }
    public void addToHead(Node node){
        Node after = head.next;
        head.next= node;
        node.next = after;
        after.pre = node;
        node.pre = head;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}



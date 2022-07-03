import java.util.*;
public class LRUCache
{
    private class Node {
        int key, value;
        Node next, prev;
        Node() {}
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private Node head, tail;
    private HashMap<Integer, Integer> hashmap;
    private HashMap<Integer, Node> map;
    private int capacity;
    LRUCache(int capacity)
    {
        this.capacity = capacity;
        hashmap = new HashMap<>();
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = head;
    }

    public int get(int key)
    {
        if(!hashmap.containsKey(key)) return -1;
        update(key, -1);
        return hashmap.get(key);
    }

    public void put(int key, int value)
    {        
        if(hashmap.containsKey(key)) {
            update(key, value);
        } else {
            if(capacity == 0) {
                int lru = deleteFirst();
                hashmap.remove(lru);
                map.remove(lru);
                capacity++;
            }
            
            hashmap.put(key, value);
            tail.next = new Node(key, value);
            tail.next.prev = tail;
            tail = tail.next;
            map.put(key, tail);
            capacity--;
        }
    }
    
    private int deleteFirst() {
        int val = head.next.key;
        head.next = head.next.next;
        if(head.next != null) head.next.prev = head;
        if(head.next == null) tail = head;
        return val;
    }
    
    private void update(int key, int value) {
        Node node = map.get(key);
        Node prev = node.prev;
        
        tail.next = node;
        node.prev = tail;
        prev.next = node.next;
        if(node.next != null) node.next.prev = prev;
        tail = tail.next;
        tail.next = null;
        if(value != -1) tail.value = value;
        hashmap.put(key, tail.value);
    }
}

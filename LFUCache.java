import java.util.*;
public class LFUCache {
    HashMap<Integer, Integer> lfu, lru, hashmap;
    PriorityQueue<Integer> pq;
    int capacity, counter;
	LFUCache(int capacity) {
		this.capacity = capacity;
        this.counter = 0;
        lfu = new HashMap<>();
        lru = new HashMap<>();
        hashmap = new HashMap<>();
        pq = new PriorityQueue<>((a, b) -> {
            if(lfu.get(a) == lfu.get(b)) return lru.get(a) - lru.get(b);
            return lfu.get(a) - lfu.get(b);
        });
	}

	int get(int key) {
		if(!hashmap.containsKey(key)) {
            return -1;
        }
        
        lfu.put(key, lfu.get(key) + 1);
        lru.put(key, ++counter);
        pq.remove(key);
        pq.add(key);
        return hashmap.get(key);
	}

	void put(int key, int value) {
		if(hashmap.containsKey(key)) {
            lfu.put(key, lfu.get(key) + 1);
            lru.put(key, ++counter);
            hashmap.put(key, value);
            pq.remove(key);
            pq.add(key);
        } else {
            if(capacity == 0) {
                int rem = pq.poll();
                lfu.remove(rem);
                lru.remove(rem);
                hashmap.remove(rem);
                capacity++;
            }
            
            lfu.put(key, 1);
            lru.put(key, ++counter);
            hashmap.put(key, value);
            pq.add(key);
            capacity--;
        }
	}
}

package cyril.lru.cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {

    int sizeofCache;

    public LRUCache(int size) {
        sizeofCache = size;
    }

    public V get(K key) {
        // GET FROM MAP
        Node node = map.get(key);
        if (null == node) {
            System.out.println("Get :" + key + "  - " + null);
            displayDLL(d);
            return null;
        }
        // MOVE TO LAST IN DLL
        moveToLast(node);
        V value = node.value;

        System.out.println("Get :" + key + "  - " + value);
        displayDLL(d);
        return value;

    }

    public void put(K key, V value) {
        System.out.println("Put :" + key + "  - " + value);
        Node node = map.get(key);
        if (node != null) {
            // If present , just update
            node.key = key;
            node.value = value;
        } else {
            if (map.size() == sizeofCache) {
                LRUCache<K, V>.Node removed = d.removefirst();
                if (removed != null) {
                    K key2 = removed.key;
                    map.remove(key2);
                }
            }
            node = d.add(key, value);
            map.put(key, node);
        }

        displayDLL(d);
    }

    private void displayDLL(LRUCache<K, V>.DoubleLinkedList d2) {
        LRUCache<K, V>.Node start = d2.start;
        String s = "";
        s += ">>>>>DLL DISPLAY  ";

        while (start != null) {
            s += start.value + " ";
            start = start.next;
        }
        System.out.println(s);

    }

    public void remove(K key) {
        Node node = map.remove(key);
        if (null != node) {
            d.remove(node);
        }

    }

    private void moveToLast(LRUCache<K, V>.Node node) {

        if (d.last == node) {
            return;
        }
        if (d.start == node) {
            d.start = d.start.next;
        }
        LRUCache<K, V>.Node prev = node.prev;
        if (prev != null) {
            prev.next = node.next;
        }
        LRUCache<K, V>.Node next = node.next;
        if (next != null) {
            next.prev = node.prev;
        }

        d.last.next = node;
        node.prev = d.last;
        node.next = null;
        d.last = node;

    }

    public class Node {
        K    key;
        V    value;
        Node next;
        Node prev;

        @Override
        public String toString() {
            return "{" + key + ":" + value + "}";
        }
    }

    public class DoubleLinkedList {

        Node start;
        Node last;

        private LRUCache<K, V>.Node add(K key, V val) {
            Node node = new Node();
            node.key = key;
            node.value = val;
            if (start == null) {
                start = node;
                last = node;
            } else {
                last.next = node;
                node.prev = last;
                last = last.next;
            }

            return node;
        }

        public LRUCache<K, V>.Node removefirst() {

            if (d.start != null) {
                Node deleted = d.start;
                d.start = d.start.next;
                d.start.prev = null;
                return deleted;
            }
            return null;
        }

        public void remove(LRUCache<K, V>.Node node) {

            if (start == node) {
                start = node.next;
            }
            if (last == node) {
                last = node.prev;
            }
            LRUCache<K, V>.Node prev = node.prev;
            if (prev != null) {
                prev.next = node.next;
            }
            LRUCache<K, V>.Node next = node.next;
            if (next != null) {
                next.prev = node.prev;
            }

            d.last.next = node;
            node.prev = d.last;
            node.next = null;
            d.last = node;

        }

    }

    Map<K, Node>     map = new HashMap<K, Node>();
    DoubleLinkedList d   = new DoubleLinkedList();

    public static void main(String[] args) {
        LRUCache<String, String> cache = new LRUCache<String, String>(3);
        cache.put("1", "val1");
        cache.put("2", "val2");
        cache.put("3", "val3");
        cache.put("4", "val4");
        cache.get("1");
        cache.get("3");
        cache.get("2");
        cache.get("4");
        cache.put("5", "val5");
        cache.put("4", "val44");
        cache.get("1");
        cache.get("2");
        cache.get("3");
        cache.get("4");
        cache.get("5");

    }
}

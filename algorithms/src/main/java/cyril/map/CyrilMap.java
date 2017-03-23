package cyril.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * 
 * Given arrival and departure times of all trains that reach a railway station,
 * find the minimum number of platforms required for the railway station so that no train waits.
 * We are given two arrays which represent arrival and departure times of trains that stop
 * 
 * Examples:
 * 
 * Input: arr[] = {9:00, 9:40, 9:50, 11:00, 15:00, 18:00}
 * dep[] = {9:10, 12:00, 11:20, 11:30, 19:00, 20:00}
 * Output: 3
 * There are at-most three trains at a time (time between 11:00 to 11:20)
 * 
 */
public class CyrilMap<K, V> implements Map<K, V> {

    int     currentSize;
    Entry[] arr;

    public CyrilMap(int ini) {
        currentSize = ini;
        arr = new Entry[10];
    }

    int hash(Object key) {
        return Math.abs(key.hashCode() % currentSize);
    }

    class Entry<K, V> implements java.util.Map.Entry<K, V> {
        K     key;
        V     val;
        Entry next;

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return val;
        }

        @Override
        public V setValue(V value) {
            V temp = val;
            val = value;
            return temp;
        }
    }

    public static void main(String[] args) {

        CyrilMap<String, String> cyrilMap = new CyrilMap<String, String>(5);
        cyrilMap.put("asdf", "qwerty");
        cyrilMap.put("123", "9876");
        cyrilMap.put("0", "qwe");
        cyrilMap.put("1", "aa");

        String s = cyrilMap.get("sadfasdf");
        System.out.println(s);
        s = cyrilMap.get("asdf");
        System.out.println(s);
        cyrilMap.remove("123");
        s = cyrilMap.get("123");
        System.out.println(s);
        s = cyrilMap.get("0");
        System.out.println(s);
        s = cyrilMap.get("1");
        System.out.println(s);
    }

    @Override
    public void clear() {
        arr = new Entry[currentSize];
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public synchronized Set<java.util.Map.Entry<K, V>> entrySet() {
        Set<java.util.Map.Entry<K, V>> l = new HashSet<java.util.Map.Entry<K, V>>();
        Arrays.asList(arr).forEach(e ->
        {
            if (e != null) {
                while (e != null) {
                    l.add(e);
                    e = e.next;
                }
            }
        });
        return l;
    }

    @Override
    public synchronized V get(Object key) {
        int hash = hash(key);
        CyrilMap<K, V>.Entry<K, V> entry = arr[hash];
        while (entry != null) {
            if (entry.key.equals(key)) {
                return entry.val;
            }
            entry = entry.next;
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return entrySet().size() == 0;
    }

    @Override
    public synchronized Set<K> keySet() {
        Set<java.util.Map.Entry<K, V>> entrySet = entrySet();
        Set<K> keyset = new HashSet<>();
        entrySet.forEach(en ->
        {
            keyset.add(en.getKey());
        });
        return keyset;
    }

    @Override
    public synchronized V put(K key, V value) {
        int hash = hash(key);
        CyrilMap<K, V>.Entry<K, V> entry = arr[hash];
        while (entry != null) {
            if (entry.key.equals(key)) {
                V val = entry.val;
                entry.val = value;
                return val;
            }
            entry = entry.next;
        }
        Entry entry3 = new Entry();
        entry3.key = key;
        entry3.val = value;
        entry3.next = arr[hash];
        arr[hash] = entry3;
        return null;
    }

    @Override
    public synchronized void putAll(Map<? extends K, ? extends V> m) {
        m.entrySet().forEach(en ->
        {
            put(en.getKey(), en.getValue());
        });

    }

    @Override
    public V remove(Object key) {
        int hash = hash(key);
        CyrilMap<K, V>.Entry<K, V> entry = arr[hash];
        if (entry.key.equals(key)) {
            arr[hash] = entry.next;
            return entry.val;
        }

        Entry prev = entry;
        while (entry != null) {
            if (entry.key.equals(key)) {
                prev.next = entry.next;
                return entry.val;
            }
            prev = entry;
            entry = entry.next;
        }
        return null;
    }

    @Override
    public int size() {
        return entrySet().size();
    }

    @Override
    public Collection<V> values() {
        Set<java.util.Map.Entry<K, V>> entrySet = entrySet();
        List<V> valueset = new ArrayList<V>();
        entrySet.forEach(en ->
        {
            valueset.add(en.getValue());
        });
        return valueset;

    }

}
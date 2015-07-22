package evilp0s;

import java.util.*;

/**
 * 封装一些集合相关度工具类
 * <p/>
 * Collection<--List<--Vector
 * Collection<--List<--ArrayList
 * Collection<--List<--LinkedList
 * Collection<--Set<--HashSet
 * Collection<--Set<--HashSet<--LinkedHashSet
 * Collection<--Set<--SortedSet<--TreeSet
 * Map<--SortedMap<--TreeMap
 * Map<--HashMap
 */
public class CollectionUtil {


    /**
     * 求俩个集合的交集
     */
    public static <T> List<T> intersection(List<T> list1, List<T> list2) {
        if (ValidUtil.isValid(list1, list2)) {
            Set<T> set = new HashSet<>(list1);
            set.retainAll(list2);
            return new ArrayList<>(set);
        }
        return new ArrayList<T>();
    }

    public static <T> Set<T> intersection(Set<T> set1, Set<T> set2) {
        if (ValidUtil.isValid(set1, set2)) {
            List<T> list = new ArrayList<T>(set1);
            list.retainAll(set2);
            return new HashSet<>(list);
        }
        return new HashSet<T>();
    }

    public static <T> Queue<T> intersection(Queue<T> queue1, Queue<T> queue2) {
        if (ValidUtil.isValid(queue1, queue2)) {
            Set<T> set = new HashSet<T>(queue1);
            set.retainAll(queue2);
            return new LinkedList<T>(set);
        }
        return new LinkedList<T>();
    }

    /**
     * Map集合的交集只提供键的交集
     *
     * @param map1
     * @param map2
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V> Map<K, V> intersectionKey(Map<K, V> map1, Map<K, V> map2) {
        Map<K, V> map = new HashMap<>();
        if (ValidUtil.isValid(map1, map2)) {
            Set<K> setkey1 = map1.keySet();
            Set<K> setkey2 = map2.keySet();
            setkey1.retainAll(setkey2);
            for (K k : setkey1) {
                map.put(k, map1.get(k));
            }
        }
        return map;
    }

    ///////////////////////////////////////////////////////////////////////////////

    /**
     * 求俩个集合的并集
     */
    public static <T> List<T> unicon(List<T> list1, List<T> list2) {
        List<T> list = new ArrayList();
        list.addAll(list1);
        list.addAll(list2);
        return list;
    }

    public static <T> Set<T> unicon(Set<T> set1, Set<T> set2) {
        Set<T> set = new HashSet<>();
        set = set1;
        set.addAll(set2);
        return set;
    }

    public static <T> Queue<T> unicon(Queue<T> queue1, Queue<T> queue2) {
        Queue queue = new LinkedList();
        queue.addAll(queue1);
        queue.addAll(queue2);
        return queue;
    }

    public static <K, V> Map<K, V> unicon(Map<K, V> map1, Map<K, V> map2) {
        Map<K, V> map = new HashMap<>();
        map.putAll(map1);
        map.putAll(map2);
        return map;
    }

    ///////////////////////////////////////////////////////////////////////////////

    /**
     * 求俩个集合的差集
     */
    public static <T> List<T> subtract(List<T> list1, List<T> list2) {
        List<T> list = new ArrayList<>();
        if (ValidUtil.isValid(list1)) {
            list.addAll(list1);
            list.removeAll(list2);
        }
        return list;
    }

    public static <T> Set<T> subtract(Set<T> set1, Set<T> set2) {
        Set<T> set = new HashSet<>();
        if (ValidUtil.isValid(set1)) {
            set.addAll(set1);
            set.removeAll(set2);
        }
        return set;
    }

    public static <T> Queue<T> subtract(Queue<T> queue1, Queue<T> queue2) {
        Queue<T> queue = new LinkedList<>();
        if (ValidUtil.isValid(queue1)) {
            queue.addAll(queue1);
            queue.removeAll(queue2);
        }
        return queue;
    }

    public static <K, V> Map<K, V> subtract(Map<K, V> map1, Map<K, V> map2) {
        Map<K, V> map = new HashMap<>();
        map.putAll(map1);
        if (ValidUtil.isValid(map2)) {
            for (K k : map.keySet())
                map.remove(k);
        }
        return map;
    }
}
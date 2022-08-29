import java.util.HashMap;
import java.util.Map;
//请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
//        实现 LRUCache 类：
//        LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
//        int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
//        void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
//        函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
//
//         
//
//        示例：
//
//        输入
//        ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//        [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//        输出
//        [null, null, null, 1, null, -1, null, -1, 3, 4]
//
//        解释
//        LRUCache lRUCache = new LRUCache(2);
//        lRUCache.put(1, 1); // 缓存是 {1=1}
//        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//        lRUCache.get(1);    // 返回 1
//        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//        lRUCache.get(2);    // 返回 -1 (未找到)
//        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//        lRUCache.get(1);    // 返回 -1 (未找到)
//        lRUCache.get(3);    // 返回 3
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/lru-cache
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
/**
 * @author LC
 */
public class LRUCache {
    int capacity = 0;
    Map<Integer, DLinkNode> map;
    DLinkNode head;
    DLinkNode tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        head = new DLinkNode(-1, -1);
        tail = new DLinkNode(-1, -1);
        head.setNext(tail);
        tail.setPrev(head);
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            DLinkNode node = map.get(key);
            moveToHead(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        DLinkNode node = map.get(key);
        if (node == null) {
            node = new DLinkNode(key, value);
            add(node);
            map.put(key, node);
        } else {
            node.setValue(value);
            moveToHead(node);
        }
    }

    private void add(DLinkNode node) {
        if (node == null) {
            return;
        }
        if (map.size() == this.capacity) {
            removeTail();
        }
        DLinkNode nextNode = head.next;
        head.setNext(node);
        node.setNext(nextNode);
        node.setPrev(head);
        nextNode.setPrev(node);
    }

    private void moveToHead(DLinkNode node) {
        if (node == null) {
            return;
        }
        DLinkNode nextNode = node.next;
        DLinkNode prevNode = node.prev;

        prevNode.setNext(nextNode);
        nextNode.setPrev(prevNode);

        DLinkNode oriFirst = head.next;
        head.setNext(node);
        node.setNext(oriFirst);
        node.setPrev(head);
        oriFirst.setPrev(node);
    }

    private void removeTail() {
        if (tail.prev == head) {
            return;
        }
        DLinkNode lastNode = tail.prev;
        DLinkNode newLast = lastNode.prev;
        newLast.setNext(tail);
        tail.setPrev(newLast);

        map.remove(lastNode.key);
    }
}




/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

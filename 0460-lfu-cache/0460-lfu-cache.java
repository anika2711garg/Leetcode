import java.util.*;

class LFUCache {

    // Node of Doubly Linked List
    class Node {

        // Cache key
        int key;

        // Cache value
        int value;

        // Number of times this key has been accessed
        int freq;

        // Previous node
        Node prev;

        // Next node
        Node next;

        // Constructor
        Node(int key, int value) {
            this.key = key;
            this.value = value;

            // Initially frequency is 1
            this.freq = 1;
        }
    }

    // Doubly Linked List for nodes having same frequency
    class DoublyLinkedList {

        // Dummy head
        Node head;

        // Dummy tail
        Node tail;

        // Number of nodes in this list
        int size;

        DoublyLinkedList() {

            head = new Node(0, 0);
            tail = new Node(0, 0);

            head.next = tail;
            tail.prev = head;

            size = 0;
        }

        // Insert node after head (Most Recently Used in this frequency)
        void add(Node node) {

            node.next = head.next;
            node.prev = head;

            head.next.prev = node;
            head.next = node;

            size++;
        }

        // Remove any node
        void remove(Node node) {

            node.prev.next = node.next;
            node.next.prev = node.prev;

            size--;
        }

        // Remove Least Recently Used node of this frequency
        Node removeLast() {

            if (size == 0)
                return null;

            Node last = tail.prev;

            remove(last);

            return last;
        }
    }

    // Maximum cache size
    int capacity;

    // Current minimum frequency
    int minFreq;

    // key -> Node
    HashMap<Integer, Node> nodeMap;

    // frequency -> Doubly Linked List
    HashMap<Integer, DoublyLinkedList> freqMap;

    public LFUCache(int capacity) {

        this.capacity = capacity;

        nodeMap = new HashMap<>();
        freqMap = new HashMap<>();

        minFreq = 0;
    }

    // Increase frequency of a node
    private void update(Node node) {

        int oldFreq = node.freq;

        // Get old frequency list
        DoublyLinkedList oldList = freqMap.get(oldFreq);

        // Remove node from old list
        oldList.remove(node);

        // If this was the last node having minimum frequency
        if (oldFreq == minFreq && oldList.size == 0) {
            minFreq++;
        }

        // Increase frequency
        node.freq++;

        // Create new list if not present
        freqMap.putIfAbsent(node.freq, new DoublyLinkedList());

        // Insert node into new frequency list
        freqMap.get(node.freq).add(node);
    }

    public int get(int key) {

        // Key not found
        if (!nodeMap.containsKey(key))
            return -1;

        Node node = nodeMap.get(key);

        // Increase frequency
        update(node);

        return node.value;
    }

    public void put(int key, int value) {

        // Capacity is zero
        if (capacity == 0)
            return;

        // Key already exists
        if (nodeMap.containsKey(key)) {

            Node node = nodeMap.get(key);

            // Update value
            node.value = value;

            // Increase frequency
            update(node);

            return;
        }

        // Cache full
        if (nodeMap.size() == capacity) {

            // Get minimum frequency list
            DoublyLinkedList list = freqMap.get(minFreq);

            // Remove least recently used node
            Node removeNode = list.removeLast();

            // Remove from HashMap
            nodeMap.remove(removeNode.key);
        }

        // Create new node
        Node newNode = new Node(key, value);

        // Minimum frequency becomes 1
        minFreq = 1;

        // Create frequency 1 list if absent
        freqMap.putIfAbsent(1, new DoublyLinkedList());

        // Add node
        freqMap.get(1).add(newNode);

        // Store in HashMap
        nodeMap.put(key, newNode);
    }
}
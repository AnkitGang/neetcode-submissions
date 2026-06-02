class LRUCache {
    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private final Map<Integer, Node> cacheMap;
    private final int capacity;

    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.cacheMap = new HashMap<>();
        this.capacity = capacity;

        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);

        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!cacheMap.containsKey(key))
            return -1;
        
        // create new node and move to last 
        Node node = cacheMap.get(key);
        moveToTail(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(cacheMap.containsKey(key)) {
            Node node = cacheMap.get(key);
            node.val = value;
            moveToTail(node);
        }
        else {
            if(cacheMap.size() == capacity) {
                Node lruNode = head.next;   // oldest node
                removeNode(lruNode);
                cacheMap.remove(lruNode.key);
            }

            Node newNode = new Node(key, value);
            cacheMap.put(key, newNode);
            addToTail(newNode);
        }
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    private void addToTail(Node node) {
        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
    }

    //First remove the prev occurrence of node then add it to tail
    private void moveToTail(Node node) {
        removeNode(node);
        addToTail(node);
    }
}

class LRUCache {
    Map<Integer, Integer> cacheMap;
    int totalCapacity;

    public LRUCache(int capacity) {
        cacheMap = new LinkedHashMap<>();
        totalCapacity = capacity;
    }
    
    public int get(int key) {
        if(!cacheMap.containsKey(key))
            return -1;

        int value = cacheMap.get(key);
        cacheMap.remove(key);
        cacheMap.put(key, value);
        return value;
    }
    
    public void put(int key, int value) {
        if(cacheMap.containsKey(key)) {
            cacheMap.remove(key);
        }
        
        if(cacheMap.size() == totalCapacity) {
            Iterator<Integer> iterator = cacheMap.keySet().iterator();
            iterator.next();
            iterator.remove();
        } 

        cacheMap.put(key, value);
    }
}

class TimeMap {
    class TimeValue {
        int timestamp;
        String value;

        public TimeValue(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    Map<String, ArrayList<TimeValue>> timeMap;

    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        timeMap.putIfAbsent(key, new ArrayList<>());
        timeMap.get(key).add(new TimeValue(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!timeMap.containsKey(key))
            return "";

        ArrayList<TimeValue> list = timeMap.get(key);
        int l = 0;
        int h = list.size()-1;
        int largestTimestamp = 0;
        String ans = "";

        while(l <= h) {
            int m = l + (h-l)/2;
            TimeValue midEntry = list.get(m);

            if(midEntry.timestamp == timestamp)
                return midEntry.value;
            else if(midEntry.timestamp < timestamp) {
                ans = midEntry.value;
                l = m + 1;
            }
            else 
                h = m - 1;
        }

        return ans;
    }
}

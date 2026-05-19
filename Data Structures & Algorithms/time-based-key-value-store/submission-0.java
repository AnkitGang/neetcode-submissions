class TimeMap {
    ArrayList<ArrayList<String>> list;

    public TimeMap() {
        list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList("TimeMap")));
    }
    
    public void set(String key, String value, int timestamp) {
        list.add(new ArrayList<>(Arrays.asList(key, value, String.valueOf(timestamp))));
    }
    
    public String get(String key, int timestamp) {
        int l = 0;
        int h = list.size()-1;
        int largestTimestamp = 0;
        String ans = "";
        while(l <= h) {
            if(list.get(l).size() < 3) {
                l++;
                continue;
            }
            
            String k = list.get(l).get(0);
            int t = Integer.parseInt(list.get(l).get(2));
            if(key.equals(k) &&  t <= timestamp) {
                if(t >= largestTimestamp) 
                    ans = list.get(l).get(1);
            }
            l++;
        }

        return ans;
    }
}

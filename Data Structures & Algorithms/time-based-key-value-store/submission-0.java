class TimeMap {
    class Pair{
        int timestamp;
        String val;

        Pair(int timestamp,String val){
            this.timestamp=timestamp;
            this.val=val;
        }
    }
    HashMap<String,ArrayList<Pair>>data;
    public TimeMap() {
        data=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        Pair val=new Pair(timestamp,value);
        if(data.containsKey(key)){
            data.get(key).add(val);
        }
        else{
            data.put(key,new ArrayList<>());
            data.get(key).add(val);
        }
        
    }
    
    public String get(String key, int timestamp) {
        if(!data.containsKey(key)){
            return "";
        }
        else{
            return search_timestamp(timestamp,data.get(key));

        }   
    }

    public String search_timestamp(int timestamp,ArrayList<Pair>curr){
        int r=curr.size()-1;
        int l=0;
        String ans = "";
        while(l<=r){
            int mid=l+(r-l)/2;
            if(curr.get(mid).timestamp==timestamp){
                return curr.get(mid).val;
            }
            else if(curr.get(mid).timestamp<timestamp){
                ans = curr.get(mid).val;
                l=mid+1;

            }
            else{
                r=mid-1;

            }
        }
        return ans;
    }
}

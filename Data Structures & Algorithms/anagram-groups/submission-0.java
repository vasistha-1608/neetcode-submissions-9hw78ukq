class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
     Map<String,List<String>> map = new HashMap<String, List<String>>();
     List<List<String>> list = new ArrayList<>();
     for(int i=0;i<strs.length;i++){
        char[] temp = strs[i].toCharArray();
        Arrays.sort(temp);
        String key = new String(temp);
        if(map.containsKey(key)){
            map.get(key).add(strs[i]);
        }
        else{
            map.put(key, new ArrayList<>(Arrays.asList(strs[i])));
        }
     }
    map.forEach((key, value) -> {
        list.add(value);
        });
     
 return list;
  }
}

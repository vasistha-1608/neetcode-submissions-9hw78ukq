class Solution {

    public String encode(List<String> strs) {
      StringBuilder s = new StringBuilder();
      for(int i=0;i<strs.size();i++){
         s.append(strs.get(i).length()).append("#").append(strs.get(i));
      }
      return s.toString();  
    }

    public List<String> decode(String str) {
      List<String> res = new ArrayList<>();
      int i = 0;
      while (i < str.length()) {
          int slash = str.indexOf("#", i);
          int size = Integer.parseInt(str.substring(i, slash));
          i = slash + 1 + size;
          res.add(str.substring(slash + 1, i));
      }
      return res;
    }
}

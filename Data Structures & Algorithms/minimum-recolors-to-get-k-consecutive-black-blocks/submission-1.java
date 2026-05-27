class Solution {
    public int minimumRecolors(String blocks, int k) {
    //   String subblock = blocks.substring(0,k);
      int mincounter = 0;
      for(int i=0;i<k;i++){
        if(blocks.charAt(i)=='W') mincounter++;
      }
      int count= mincounter;
      for(int i=k;i<blocks.length();i++){
        int localcounter = mincounter;
        if(blocks.charAt(i)=='W'){
            localcounter++;
        }
        if (blocks.charAt(i - k) == 'W') {
                localcounter--;
        }
        mincounter= localcounter;
        count=Math.min(count,mincounter);
      }
      return count;
    }
}
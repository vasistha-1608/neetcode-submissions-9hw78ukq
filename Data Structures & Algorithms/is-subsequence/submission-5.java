class Solution {
    public boolean isSubsequence(String s, String t) {
        int innercounter =0;
        if(s.isEmpty()){
            return true;
        }

        if(t.isEmpty()){
            return false;
        }
        for(int i=0;i<t.length();i++){
            if(s.charAt(innercounter) == t.charAt(i)){
                innercounter++;
            
            }
            if(innercounter== s.length()){
                return true;
            }
        }

        return false;
    }
}
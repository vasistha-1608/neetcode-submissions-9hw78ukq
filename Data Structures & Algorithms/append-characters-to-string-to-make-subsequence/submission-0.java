class Solution {
    public int appendCharacters(String s, String t) {
        int innercounter =0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==t.charAt(innercounter)){
                innercounter++;
            }
            if(innercounter == t.length()){
                return 0;
            }
        }

        int append = t.length()-innercounter;

        return append;
    }
}
class Solution {
    public boolean isPalindrome(int x) {
        int temp =0;
        int num =x;
        while(num>0){
            temp =10*temp + num%10 ;
            num = num/10;
        }

        return temp==x;
    }
}
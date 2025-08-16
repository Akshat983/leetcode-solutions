class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        int i = 0;
        while(i < bills.length && five >= 0) {
            if(bills[i] == 5) {
                five++;
            }
            if(bills[i] == 10) {
                ten++;
                five--;
                if(five < 0)
                    return false;
            }
            if(bills[i] == 20) {
                if(ten > 0) {
                    ten--;
                    five--;
                    
                }
                else {
                    five-=3;
                }
                if(five < 0)
                    return false;
            }
            i++;
        }
        return true;
    }
}
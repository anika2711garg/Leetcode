class Solution {
    public int convertTime(String current, String correct) {
        int curH = Integer.parseInt(current.substring(0,2));
        int curM = Integer.parseInt(current.substring(3,5));
        int curT = curH * 60 + curM;

        int corH = Integer.parseInt(correct.substring(0,2));
        int corM = Integer.parseInt(correct.substring(3,5));
        int corT = corH * 60 + corM;

        int diff = corT - curT;
        int op = 0;

        op = op + diff/60;
        diff = diff%60;

        op = op + diff/15;
        diff = diff%15;

        op = op + diff/5;
        diff = diff%5;

        op = op + diff;
        
      return op;  
        
        
    }
}
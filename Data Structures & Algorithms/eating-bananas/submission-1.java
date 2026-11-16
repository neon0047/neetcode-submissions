class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        if(h<piles.length) return -1;
        int max = Integer.MIN_VALUE, min = 1;
        for(int n: piles) max = Math.max(max, n);

        while(min<max){
            int currEatRate = (min + max)/2;
            if(isFeasible(piles, h, currEatRate)){
                max = currEatRate;
            }else{
                min = currEatRate + 1;
            }
        }
        return min;

    }
    public boolean isFeasible(int[] piles, int h, int eatRate){
        int time = 0;
        for(int i = 0; i<piles.length; i++){
            if(piles[i]%eatRate == 0){
                time += piles[i]/eatRate;
            }else{
                time += piles[i]/eatRate + 1;
            }
        }
        return time<=h;
        
    }
}

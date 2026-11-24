class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> st = new Stack();
        int[] res = new int[temperatures.length];
        for(int i = 0; i<temperatures.length; i++){
            int currTemp = temperatures[i];
            while(!st.isEmpty() && st.peek()[0]<currTemp){
                int[] day = st.pop();
                res[day[1]] = i - day[1];
            }
            st.push(new int[]{currTemp, i});
        }
        return res;
    }
}

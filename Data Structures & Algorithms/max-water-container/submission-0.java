class Solution {
    public int maxArea(int[] heights) {
        int area = 0;
        int i = 0, j = heights.length-1;
        while(i<j){
            area = Math.max(area, Math.min(heights[i], heights[j])*(j-i));
            if(heights[i]>heights[j]){
                j--;
            }else{
                i++;
            }
        }
        return area;
    }
}

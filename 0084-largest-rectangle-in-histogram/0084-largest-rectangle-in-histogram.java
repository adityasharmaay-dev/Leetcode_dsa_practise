class Solution {
    public int largestRectangleArea(int[] heights) {
        return area(heights);
    }
    public int area(int[] arr){
        Stack<Integer> st = new Stack<>();
        int ans = 0;
        for(int i=0; i<arr.length; i++){
            while(!st.isEmpty() && arr[i]<arr[st.peek()]){
                int h = arr[st.pop()];
                int r = i;
                if(st.isEmpty()){
                    int area = h*r;
                    ans = Math.max(ans, area);
                }
                else{
                    int l = st.peek();
                    int area = h*(r-l-1);
                    ans = Math.max(ans, area);
                }
            }
            st.push(i);
        }
        int r = arr.length;
        while(!st.isEmpty()){
            int h = arr[st.pop()];
            if(st.isEmpty()){
                int area = h*r;
                ans = Math.max(ans, area);
            }
            else{
                int l = st.peek();
                int area = h*(r-l-1);
                ans = Math.max(ans, area);
            }
        }
        return ans;
    }
}
class Solution {
    public boolean validMountainArray(int[] arr) {
        int i = 0;
        int l = arr.length;
        if(arr.length < 3) return false;
        while(i+1 < l && arr[i+1] > arr[i]) i++;
        if(i == 0 || i == l-1) return false;
        while(i+1 < l && arr[i+1] < arr[i]) i++;
        return(i == l-1);
    }
}
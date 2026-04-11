class Solution {
      static int minimum(int arr[],int low,int high,int ans)
      {
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if(arr[low]<=arr[mid])
            {
                if(arr[low]<=ans)
                {
                    ans = arr[low];
                }
                low = mid+1;
            }else
            {
                if(arr[low]<=ans)
                {
                    ans = arr[low];
                }
                high = mid;
            }
    }
    return ans;
    }
    public int findMin(int[] nums)
     {
        return minimum(nums,0,nums.length-1,Integer.MAX_VALUE);
    }
}
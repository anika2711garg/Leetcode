class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n-1;
        int first = -1;
        int last = -1;
        while(left <= right)
        {
            int mid = left + (right - left)/2;
            if(target <= nums[mid])
            {
                if(nums[mid] == target)
                {
                    first = mid;
                }
                 right = mid - 1;
                 
        }
            else
            {
               left = mid+1;
            }
        }
         left = 0;
         right = n-1;
         while(left <= right)
        {
            int mid = left + (right - left)/2;
            if(target >= nums[mid])
            {
                if(nums[mid] == target)
                {
                    last = mid;
                }
                 left = mid + 1;
        }
            else
            {
               
               right = mid-1;
            }
        }
        return new int[]{first,last};
    }
}
        // int n = nums.length;
        // int left  = -1;
        // int right = -1;
         
        //  for ( int i = 0; i < n; i++)
        //  {
        //     if( nums[i] == target)
        //     {
        //         left = i;
           
        //        break;
        //     }
        //  }

        //  for ( int i = n -1; i>=0; i--)
        //  {
        //     if( nums[i] == target)
        //     {
        //         right = i;
        //         break;
        //     }
        //  }
        // return new int[] {left,right};
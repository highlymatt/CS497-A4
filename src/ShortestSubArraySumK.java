public class ShortestSubArraySumK {

    //O(n^2)
    public int shortestSubArray(int[] nums, int k){
        int min = -1;
        for (int x = 0; x < nums.length; x++){
            int count = 0;
            int total = 0;
            for (int i = x; i < nums.length; i++){
                count++;
                total += nums[i];
                if (total >= k){
                    if(min == -1 || count < min){
                        min = count;
                    }
                }
            }
        }
        return min;
    }


    public static void main(String[] args){
        ShortestSubArraySumK obj = new ShortestSubArraySumK();
        int[] nums = {1};
        int k = 1;
        System.out.println(obj.shortestSubArray(nums,k));
        nums = new int[]{1,2};
        k = 4;
        System.out.println(obj.shortestSubArray(nums,k));
        nums = new int[]{2,-1,2};
        k = 3;
        System.out.println(obj.shortestSubArray(nums,k));


    }
}

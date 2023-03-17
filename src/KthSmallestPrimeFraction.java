import java.util.*;

public class KthSmallestPrimeFraction {


    public int[] findKthSmallestPrimeFraction(int[] nums, int k){
        Map<Double, int[]> map = new HashMap<>();
        List<Double> list = new ArrayList<>();
        for(int x = 0; x < nums.length - 1; x++){
            for( int i = x + 1; i < nums.length; i++){
                Double frac = (double) (nums[x]) / nums[i];
                int[] res = {nums[x], nums[i]};
                list.add(frac);
                map.put(frac, res);
            }
        }
        Collections.sort(list);
        return map.get(list.get(k - 1));
    }


    public void print(int[] nums){
        for(int x : nums){
            System.out.println(x);
        }
    }

    public static void main(String[] args){
        KthSmallestPrimeFraction obj = new KthSmallestPrimeFraction();
        int[] arr = {1,2,3,5};
        int k = 3;
        obj.print(obj.findKthSmallestPrimeFraction(arr, k));
        arr = new int[] {1,7};
        k = 1;
        obj.print(obj.findKthSmallestPrimeFraction(arr, k));

    }
}

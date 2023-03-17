import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {

    // Use bucketSort to store elements by number of occurrences (least-most)
    // O(n)
    public int[] topKFrequent(int[] nums, int k) {
        List<List<Integer>> buckets = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        // Create buckets
        for (int x  = 0; x <= nums.length; x++){
            buckets.add(new ArrayList<>());
        }
        // Store number of occurrences in hashmap
        for (int n : nums){
            map.putIfAbsent(n, 0);
            map.put(n, map.get(n) + 1);
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            buckets.get(entry.getValue()).add(entry.getKey());
        }
        int[] result = new int[k];
        int i = 0;

        for(int x = buckets.size() - 1; x > 0 && i <= k; x--){
            if(buckets.get(x).size() == 0){
                continue;
            }
            for(int element : buckets.get(x)){
                if(i == k) break;
                result[i++] = element;
            }
        }
        return result;
    }

    public void printArray(int[] nums){
        for(int n : nums){
            System.out.println(n);
        }
    }

    public static void main(String[] args){
        TopKFrequentElements obj = new TopKFrequentElements();
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        obj.printArray(obj.topKFrequent(nums, k));
        nums = new int[]{1};
        k =1;
        obj.printArray(obj.topKFrequent(nums, k));
    }
}

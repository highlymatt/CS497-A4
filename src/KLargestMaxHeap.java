import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KLargestMaxHeap {

    // naive approach
    // O(n*(n-1)) - > O(n^2)
    public List<Integer> peekTopK(int[] arr, int k){
        List<Integer> res = new ArrayList<>(k);
        for(int x = 0; x < arr.length; x++){
            int count = 0;
            for(int i = x + 1; i < arr.length; i++){
                if(arr[i] > arr[x]){
                    count++;
                }
            }
            if(res.size() + count < k){
                res.add(arr[x]);
            }
        }
        return res;
    }
    // O(k*log(n))
    // O(n)
    public List<Integer> peekTopKV2(int[] arr, int k) {
        // Use lambda function to make max PQ (gets largest element instead of smallest)
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((a,b) -> b.compareTo(a));
        List<Integer> res = new ArrayList<>();
        // Since it is a max heap the first element will be the largest
        if(k > 0){
            maxPQ.add(arr[0]);
        }
        int index = 0;
        while(!maxPQ.isEmpty() && k > 0){
            // add max element in maxPQ
            res.add(maxPQ.poll());
            // Find index's for children
            int l = 2 * index + 1, r = l +1;
            // Add children to maxPQ as long as pointers haven't surpassed the maxHeap size
            if(l < arr.length){
                maxPQ.add(arr[l]);
            }
            if(r < arr.length){
                maxPQ.add(arr[r]);
            }
            // Increase index by 1 to get next set of children
            index++;
            k--;
        }
        return res;
    }

    public void print(List<Integer> nums){
        for(int x : nums){
            System.out.println(x);
        }
        System.out.println("");
    }


    public static void main(String[] args){
        KLargestMaxHeap obj = new KLargestMaxHeap();
        int[] arr = new int[]{15,13,12,10,8,9};
        int k = 5;
        obj.print(obj.peekTopKV2(arr, k));
    }
}

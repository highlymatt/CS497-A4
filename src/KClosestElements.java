import java.util.ArrayList;
import java.util.List;

public class KClosestElements {

    public List<Integer> findKClosestElements(int[] arr, int k, int x){
        List<Integer> res = new ArrayList<>();
        int xIndex = 0, l = 0, r = arr.length - 1;
        // find element x's index
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == x){
                xIndex = i;
                res.add(arr[xIndex]);
                break;
            }
            if(arr[i] < x){
                xIndex = i;
            }
        }
        k -= 1;
        boolean moveL = false, moveR = false;
        if(res.isEmpty()){
            l = xIndex;
        }
        else if(xIndex -1 > 0) {
            moveL = true;
            l = xIndex - 1;
        }
        if(xIndex + 1 < arr.length - 1) {
            moveR = true;
            r = xIndex + 1;
        }
        while(k != 0){
            if(!moveR || (moveL && (arr[l] - x < arr[r] - x || arr[l] - x == arr[r] - x))){
                res.add(0, arr[l]);
                if(l == 0){
                    moveL = false;
                }
                l -= 1;
            }else{
                res.add(arr[r]);
                if(r == arr.length - 1){
                    moveR = false;
                }
                r += 1;
            }
            k--;
        }
        return res;
    }

    //time: O(n-k)
    // space: O(1)
    public List<Integer> findClosestElements(int[] arr, int k, int x){
        int l = 0, r = arr.length - 1;
        while(r - l >= k){
            if(Math.abs(arr[l] - x) > Math.abs(arr[r] - x)){
                l++;
            }else{
                r--;
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i = l; i <= r; i++){
            res.add(arr[i]);
        }
        return res;
    }

    public void printArray(List<Integer> nums){
        for(int n : nums){
            System.out.println(n);
        }
    }

    public static void main(String[] args){
        KClosestElements obj = new KClosestElements();
        int[] arr = {1,2,3,4,5};
        int k = 4, x = 3;
        obj.printArray(obj.findClosestElements(arr,k,x));
        x = -1;
        obj.printArray(obj.findClosestElements(arr,k,x));
    }
}

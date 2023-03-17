#CS497 - Assignment 4
Matthew Jelonek

## 1)  Top K Frequent Elements 
### Using Bucket Sort
- store the number of occurrences of each element from array in a hashmap
- make a bucket the size of array + 1
- store elements in hashmap in bucket based on count value
- loop from end of array to the start adding k number of elements in a new integer array
- return int array

Time complexity: O(n)  
Space complexity: O(n+k)

## 2)  Find K Closest Elements 
- create two pointers. One pointing at the beginning of the array the other at the end. (l = 0, r= arr.length()-1)
- use a while loop that stops when r-l >= k. (means there is only k elements left)
- if the difference of left element is > right move the left pointer up by 1. |arr[l] - x| > |arr[r] - x|
- if right pointer difference is > left. Move right pointer down by 1
- once left and right pointers are at appropriate range add the elements to an arrayList
- return arrayList

Time complexity: O(n-k)    
Space complexity: O(1)   

## 3) K Largest Elements of a Max Heap 
- create a maximum priority queue to store array elements
- Add first element of maxHeap array in maxPQ since it will be the largest
- Use a while loop that stops when maxPQ is empty or k == 0
- in loop add head of maxPQ into an arrayList. Then add the left and right children into maxPQ
- repeat until while loop conditions are no longer met and return arrayList

Time complexity: O(k*log(n))   
Space Complexity: O(n)     


## 4)  Shortest Subarray with Sum at least K
- loop through array
- at start of each loop initialize count and total to 0
- have nested loop that starts at outer loops index
- keep a count of the length of the current sub array and calculate total. If total >= k and is smaller that current min value make min = count
- return min
 
Time complexity: O(n^2)  
Space complexity: O(1)  

## 5)  Kth Smallest Prime Fraction 
- create hashmap and arraylist
- loop through array
- have a nested loop that loops through all indicies after outer loop index
- calculate fraction and store value in arraylist
- use fraction as key in map and store int[] containing fractions p and q (p/q)
- sort arrayList
- find kth element in arraylist and use it to get the value stored in map 
- return value


Time complexity: O(n^2)  
Space complexity: O(n)  
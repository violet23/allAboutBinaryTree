import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Jianzhi40 {
    public Jianzhi40(){}
    public int[] getLeastNumbers(int[] arr, int k) {
        //MAX-HEAP
        int n = arr.length;
        int[] ans = new int[k];
        if (n == k || n == 0) {
            return arr;
        }
        if (k == 0) {
            return ans;
        }
        //min heap
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer e1, Integer e2) {
                return e2 - e1;
            }
        });
        for (int i = 0; i < k; i++) {
            heap.offer(arr[i]);
        }
        for (int i = k; i < n; i++) {
            int curr_head = heap.peek();
            int curr_insert = arr[i];
            if (curr_head > curr_insert) {
                heap.poll();
                heap.offer(curr_insert);
            }
        }
        for (int i = 0; i < k; i++) {
            ans[i] = heap.poll();
        }
        return ans;
    }
    public static void main(String[] args){
        Jianzhi40 solution = new Jianzhi40();
        int[] nums = {4,5,1,6,2,7,3,8};
        int[] ans  = solution.getLeastNumbers(nums, 4);
        for(int num:ans){
            System.out.println(num);
        }
    }
}

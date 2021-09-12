import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Permutation {
    public List<List<Integer>> Permutation(int [] nums){
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> curr_ans = new ArrayList<Integer>();
        for(int num : nums){
            curr_ans.add(num);
        }
        return backtrace(0, nums.length, curr_ans, ans);
    }
    public List<List<Integer>> backtrace(int curr_head, int n, List<Integer> curr_ans, List<List<Integer>> ans){
        if(curr_head == n){
            ans.add(new ArrayList<Integer>(curr_ans));
        }
        for(int i = curr_head; i<n ; i++){
            Collections.swap(curr_ans, curr_head, i);
            backtrace(curr_head+1, n, curr_ans, ans);
            Collections.swap(curr_ans,curr_head, i);
        }
        return ans;
    }

    public static void main(String[] args){
        Permutation permutation = new Permutation();
        int [] nums = {1,2,3};
        List<List<Integer>> ans = permutation.Permutation(nums);
        System.out.println(ans);
    }

}

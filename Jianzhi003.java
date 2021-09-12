import java.util.HashMap;
import java.util.Map;

public class Jianzhi003 {
    public Jianzhi003(){}
    public int findRepeatNumber(int [] nums){
        Map<Integer, Integer> dic = new HashMap<Integer, Integer>();
        if(nums.length == 1){
            return -1;
        }
        int ans = -1;
        for(int num: nums){
            if(dic.get(num) == null){
                dic.put(num,1);
            }
            else{
                ans = num;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args){
        Jianzhi003 solution = new Jianzhi003();
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(solution.findRepeatNumber(nums));
    }
}


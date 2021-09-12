public class WinnerPredict {
    public WinnerPredict(){}
    public boolean winnerPredict(int[] nums){
        int n = nums.length;
        int[][] dp = new int[n][n];
        for(int i = 0; i<n; i++){
            dp[i][i] = nums[i];
        }
        int gap =1;
        while(gap<n){
            for(int i = 0; i+gap<n; i++){
                int j = i+gap;
                dp[i][j] = Math.max(nums[i]-dp[i+1][j], nums[j]-dp[i][j-1]);
            }
            gap++;
        }
        if(dp[0][n-1] >=0){
            return true;
        }
        return false;
    }
    public static void main(String [] args){
        WinnerPredict solution = new WinnerPredict();
        int[] nums = {1,5,233,7};
        System.out.println(solution.winnerPredict(nums));
    }
}

package DP;

import java.util.Arrays;

class Job_Schedule {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;

        if(d > n) return -1;

        int memo[][] = new int[d+1][n];
        for(int[] row:memo){
            Arrays.fill(row,-1);
        }
        return dfs(jobDifficulty, memo, d, 0);
    }
    private int dfs(int[] jobDifficulty, int[][] memo, int d, int index){
        if(d == 1){
            int max = 0;
            while(index < jobDifficulty.length){
                max = Math.max(max, jobDifficulty[index++]);
            }
            return max;
        }
        if(memo[d][index] != -1){
            return memo[d][index];
        }
        int leftMax=0;
        int res = Integer.MAX_VALUE;

        for(int i = index; i < jobDifficulty.length-d+1; i++){
            leftMax = Math.max(leftMax, jobDifficulty[i]);
            res = Math.min(res, leftMax + dfs(jobDifficulty, memo, d-1, i+1));
        }
        return memo[d][index] = res;
    }
}

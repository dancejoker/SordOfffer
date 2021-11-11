package Algorithm.DynamicProgramming;

import java.util.ArrayList;

/**
 * 描述
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个 n 级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class JumpFloor {
    public int jumpFloorRecursion(int target) {
        if(target == 1 || target ==2){
            return target;
        }
        return jumpFloorRecursion(target - 1) + jumpFloorRecursion(target - 2);
    }

    public int jumpFloor(int target){
        if(target == 1 || target ==2){
            return target;
        }
        int[] dp = new int[target + 1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<=target;++i){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[target];
    }
    public int jumpFloorBest(int target){
        if(target == 1 || target ==2){
            return target;
        }
        int first = 1;
        int second = 2;
        int sum =0;
        for(int i = 3;i<=target;++i){
            sum = first + second;
            first = second;
            second = sum;
        }
        return sum;
    }
}

class Solution {
    /*
    We start at either step 0 or step 1.
    The target is to reach either last or second last step, whichever is minimum.
     */
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] minCost = new int[n];
        minCost[0] = cost[0];
        minCost[1] = cost[1];
        for (int i = 2; i < n; i++) {
            minCost[i] = Math.min(minCost[i - 1], minCost[i - 2]) + cost[i];

        }
        return Math.min(minCost[n - 1], minCost[n - 2]);
    }
    

}
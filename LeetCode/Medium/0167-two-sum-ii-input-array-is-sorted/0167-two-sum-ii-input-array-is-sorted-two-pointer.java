class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers == null || numbers.length < 2){
            return new int[]{};
        }
        int i = 0;
        int j = numbers.length - 1;      
        while(i < j){
           if( numbers[i] + numbers[j] > target){
            j --;
           }else if(numbers[i] + numbers[j] < target){
            i ++;
           }else{
            return new int[]{i+1, j+1};
           }
        }
         return new int[]{};
        
    }
}
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] cumulativeCount=new int[words.length+1] ;
        int counter=0;
        int[] ans=new int[queries.length];
        ArrayList<Character> vowels= new ArrayList<>(Arrays.asList('a','e','i','o','u'));

        for (int i = 0; i < words.length; i++) {
            String currentWord=words[i];
            if (vowels.contains(currentWord.charAt(0))&&
                    vowels.contains(
                            currentWord.charAt(
                                    currentWord.length()-1
                            )
                    )
            ) {
                cumulativeCount[i]=counter;
                counter++;
            }
            else{
                cumulativeCount[i]=counter;
            }
        }
        cumulativeCount[cumulativeCount.length-1]=counter;


        for (int j = 0; j < queries.length; j++) {
            int  queryStart=queries[j][0];
            int  queryEnd=queries[j][1];
            if (queryEnd>=cumulativeCount.length-1){
                queryEnd--;
            }

            ans[j]=cumulativeCount[queryEnd+1]-cumulativeCount[queryStart];

        }
        return ans;
    }
    public int waysToSplitArray(int[] nums) {
        int count=0;
        long[] sumsList=new long[nums.length];
        long cumulativeSum=0;
        for (int i = 0; i < nums.length; i++) {
            cumulativeSum+=nums[i];
            sumsList[i]=cumulativeSum;
        }
        for (int i = 0; i < sumsList.length-1; i++) {
            long leftSum=sumsList[i];
            long rightSum=cumulativeSum-leftSum;
            if (leftSum>=rightSum){
                count++;
            }
        }
    return count;
    }
}

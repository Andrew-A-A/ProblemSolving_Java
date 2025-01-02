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
}

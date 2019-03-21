package concurrency;

import java.util.HashMap;
import java.util.Map;

public class lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        for(int i = 0;i<s.length();i++){
            Map<String,Integer> map = new HashMap();
            for(int j = i;j<s.length();j++){
                String r = s.substring(j, j+1);
                int isin=map.getOrDefault(r,-1);
                if(isin>0){
//                    max = Math.max(max,j-i+1);
                    break;
                }
                map.put(s.substring(j,j+1),1);
                max = Math.max(max,j-i+1);
            }

        }
        return max;
    }

    public static void main(String[] args) {
        new lengthOfLongestSubstring().lengthOfLongestSubstring("bbbb");
    }
}

package mike.sample;

import java.util.HashSet;
import java.util.Set;

/**
 * @author caizeming
 * @email caizeming@cvte.com
 * @date 2021/1/15
 * @description:
 */
class Solution {
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<Character>();
        int right = -1;
        int nextCharIndex = -1;
        Character nextChar;
        int max = 0;
        int length = s.length();
        for (int left = 0; left < length; left++) {
            nextCharIndex = right + 1;
            while (nextCharIndex < length) {
                nextChar = s.charAt(nextCharIndex);
                if (!set.contains(nextChar)) {
                    set.add(nextChar);
                    right++;
                } else {
                    set.remove(s.charAt(left));
                    break;
                }
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

}

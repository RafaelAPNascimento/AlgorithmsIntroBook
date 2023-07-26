package _04AdvancedDesignAnalisys;

// explaining the approaches
// ref code: https://www.scaler.com/topics/longest-palindromic-substring/
public class LongestPalindromeSubstring {

    // This function prints the
    // longest palindrome subString
    // It also returns the length
    // of the longest palindrome
    public String longestPalindromeBruteforce(String str) {
        String longest = "";
        for (int i = 0; i < str.length(); i++) {

            for (int j = 0; j <= i; j++) {

                String local = str.substring(j, i);

                for (int k = 0; k < local.length() / 2; k++) {
                    if (local.toLowerCase().charAt(k) != local.toLowerCase().charAt(local.length() - k - 1)) {
                        local = null;
                        break;
                    }
                }
                if (local != null && local.length() > longest.length())
                    longest = local;
            }
        }
        return longest;
    }

    public String longestPalindromeDP(String s) {

        int length = s.length();
        // creating boolean table
        boolean dp[][] = new boolean[length][length];
        int max_pal_length = 1;
        // setting the value of substrings of length 1 to True in dp table (i.e. same character)
        for (int i = 0; i < length; i++){
            dp[i][i] = true;
        }
        // for substrings of length 2
        int start = 0;
        for (int j = 0; j < length - 1; j++){
            // checking if there are 2 consecutive characters that are same
            if (s.charAt(j) == s.charAt(j + 1)){
                dp[j][j + 1] = true;
                start = j;
                max_pal_length = 2;
            }
        }
        // now for longer length palindromes
        for (int k = 3; k <= length; ++k) {
            // Fix the starting index
            for (int i = 0; i < length - k + 1; ++i) {
                // Get the end index of the substring from start index i and length k
                int j = i + k - 1;

                // check the sub-string from ith index to the jth index if s[i+1] to s[j-1] is a palindrome
                if (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    // if current palindrome length is larger than previous largest length, update the maximum length
                    if (k > max_pal_length) {
                        start = i;
                        max_pal_length = k;
                    }
                }
            }
        }
        // return longest palindromic substring
        return s.substring(start, start + max_pal_length);
    }
}

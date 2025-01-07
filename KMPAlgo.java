class KMPAlgo{

    private int[] createLPS(String pattern){
        int m = pattern.length();
        int[] lps = new int[m];
        lps[0] = 0;
        int len = 0; // stores the length of the longest prefix (with same pattern)
        for(int i=1;i<m;){
            int val = 0;
            if(pattern.charAt(i)==pattern.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }
            else{
                // if no match found and len != 0
                if(len!=0){
                    len = lps[len-1];
                }
                else{
                    // if no match is found
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }

    public int strStr(String haystack, String needle) {
        int[] lps = createLPS(needle);
        int m = needle.length();
        int n = haystack.length();
        // Pointers i and j, for traversing 
        // the text and pattern
        int i = 0;
        int j = 0;

        while (i < n) {
            // If characters match, move both pointers forward
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;

                // If the entire pattern is matched 
                // store the start index in result
                if (j == m) {
                    return i-j;
                    
                    // Use LPS of previous index to 
                    // skip unnecessary comparisons
                    // j = lps[j - 1];
                }
            }
            
            // If there is a mismatch
            else {
                
                // Use lps value of previous index
                // to avoid redundant comparisons
                if (j != 0)
                    j = lps[j - 1];
                else
                    i++;
            }
        }
        return -1; 
    }
}
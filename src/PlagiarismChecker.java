/**
 * Plagiarism Checker
 * A tool for finding the longest shared substring between two documents.
 *
 * @author Zach Blick
 * @author Lucas Ying
 */
public class PlagiarismChecker {

    /**
     * This method finds the longest sequence of characters that appear in both texts in the same order,
     * although not necessarily contiguously.
     * @param doc1 the first document
     * @param doc2 the second
     * @return The length of the longest shared substring.
     */
    public static int longestSharedSubstring(String doc1, String doc2) {

        // Create a 2D table to store lengths of longest common subsequence.
        int[][] table = new int[doc1.length()+1][doc2.length()+1];

        // Build the table from the bottom-up because this solution utilizes tabulation.
        for (int i = 1; i <= doc1.length(); i++) {
            for (int j = 1; j <= doc2.length(); j++) {
                // If current characters match, increase the count from the last matching state.
                if (doc1.charAt(i-1) == doc2.charAt(j-1)){
                    table[i][j] = table[i-1][j-1] + 1;
                }
                // If not matching, take the maximum of left and upper cell's values.
                else {
                    table[i][j] = Math.max(table[i][j-1],table[i-1][j]);
                }
            }
        }
        // The value in the bottom right corner of the matrix is the length of the longest shared substring.
        return table[doc1.length()][doc2.length()];
    }
}

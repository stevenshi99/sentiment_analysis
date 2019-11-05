/**
 * Holds each word with total score and number of occurences
 * 
 * @author Steven
 * @version 2017.12.04
 */
public class WordScores implements Comparable<WordScores> {
    private String word;
    private double totalScore;
    private int occurrences;

    /**
     * constructor method
     * 
     * @param word
     * @param totalScore
     */
    public WordScores(String word, int totalScore) {
        this.word = word;
        this.totalScore = totalScore;
        this.occurrences = 1;
    }

    /**
     * constructor method used by test class for custom occurrence input
     * 
     * @param word
     * @param totalScore
     * @param occurrences
     */
    public WordScores(String word, int totalScore, int occurrences) {
        this.word = word;
        this.totalScore = totalScore;
        this.occurrences = occurrences;
    }

    /**
     * O(1)
     * 
     * get word variable
     * 
     * @return the word variable
     */

    public String getWord() {
        return this.word;
    }

    /**
     * O(1) gets number of occurrences
     * 
     * @return the occurrences variable
     */

    public int getOccurrences() {
        return occurrences;
    }

    /**
     * O(1)
     * 
     * increases totalScore and occurrences
     * 
     * @param x
     *            the amount to increase by
     */
    public void increaseTotalScore(int x) {
        totalScore += x;
        occurrences++;
    }

    /**
     * O(1)
     * 
     * compare only the word (alphabetical)
     */
    public int compareTo(WordScores arg0) {
        if (word.compareTo(arg0.word) < 0) {
            return -1;
        }
        if (word.compareTo(arg0.word) > 0) {
            return 1;
        } else {
            return 0;
        }

    }

    /**
     * O(1)
     * 
     * @return the average score of the word
     */
    public double avgScore() {
        return totalScore / occurrences;
    }

}
/**
 * Indexes reviews from text file and guesses the score of user inputed reviews
 * 
 * @author Steven
 * @version 2017.12.04
 *
 */
public class Indexing {
    private BinarySearchTree<WordScores> tree;
    
    /**
     * constructor method that initializes tree
     */
    public Indexing() {
        tree = new BinarySearchTree<WordScores>();
    }

    /**
     * O(log n)
     * 
     * assigns a score to a string and adds it to the binary tree; this method is
     * called by parseWords to add words to the tree
     * 
     * @param s
     *            String to add
     * @param x
     *            Score to add
     * 
     */
    public void addScore(String s, int x) {
        if (findString(s, tree.getRoot()) != null) {
            findString(s, tree.getRoot()).increaseTotalScore(x);
        }

        else {
            tree.insert(new WordScores(s, x));
        }
    }

    /**
     * checks if a node already exists with string "x" used by addScore to determine
     * whether to add new node or to update an existing one
     * 
     * @param x
     *            string to search for
     * @param node
     *            root node
     * @return the existing node or null
     */
    public WordScores findString(String x, BinaryNode<WordScores> node) {
        if (node == null) {
            return null; // Not found
        }

        else if (x.compareTo(node.getElement().getWord()) < 0) {
            // Search in the left subtree
            return findString(x, node.getLeft());
        }

        else if (x.compareTo(node.getElement().getWord()) > 0) {
            // Search in the right subtree
            return findString(x, node.getRight());
        }

        else {
            return node.getElement(); // Match
        }
    }

    /**
     * O(n log n)
     * 
     * Takes in an array of strings Assigns the score of the line to each word after
     * the first word (which is the score) Checks if each word already exists in the
     * tree If the word does not exist, it is inserted such that the tree is
     * alphabetically sorted Otherwise, the occurrence count of the word is
     * increased by one
     * 
     * @param arr
     *            string array input
     */
    public void parseWords(String[] arr) {
        for (int i = 1; i < arr.length; i++) {
            addScore(arr[i], Integer.parseInt(arr[0]));
        }
    }

    /**
     * O(log n)
     * 
     * finds a specified word and returns its average score; if the string does not
     * exist, then return -1
     * 
     * @param s
     *            the word score to find
     * @return the average score
     */
    public double scoreWord(String s) {
        if (findString(s, tree.getRoot()) != null) {
            return findString(s, tree.getRoot()).avgScore();
        }

        return -1;
    }

    /**
     * O(n log n)
     * 
     * takes user input for a movie review breaks up the words and adds; if the
     * score for a word is -1, it makes no change to the score
     * 
     * @param s
     *            the string input from the user
     * @return the average score of the review based on scores assigned to words the
     *         user inputed that have already been used before
     */
    public double reviewScore(String s) {
        double score = 0;
        int num = 0;
        int a = 0;
        int b = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                b = i;
                if (scoreWord(s.substring(a, b)) != -1) {
                    score += scoreWord(s.substring(a, b));
                    num++;
                }
                a = i + 1;
            }
        }
        if (scoreWord(s.substring(a, s.length())) != -1) {
            score += scoreWord(s.substring(a, s.length()));
            num++;
        }

        return score / num;
    }

}

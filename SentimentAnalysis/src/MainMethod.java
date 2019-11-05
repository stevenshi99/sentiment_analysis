
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Main method that calls other methods and reads movieReviews.txt
 * 
 * @author Steven
 * @version 2017.12.11
 */

public class MainMethod {

    /**
     * main method
     * 
     * @param args
     *            arguments
     */
    public static void main(String[] args) {
        Indexing index = new Indexing();

        String filename = "movieReviews.txt"; // enter the full path to movieReviews.txt
        try (BufferedReader br = new BufferedReader(
                new FileReader(filename))) {
            String line;
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] parts = line.replaceAll("\\p{Punct}", "")
                        .toLowerCase().split("\\s+");
                // .split("\\s+"); //remove punctuation, change to lowercase and put all words
                // in parts
                // YOU SHOULD GO THROUGH PARTS AND STORE THE WORD, SCORE
                // AND NUMBER OF OCCURENCES
                // IN THE BST HERE
                index.parseWords(parts);
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        System.out.print("Enter a review and press enter: ");
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        System.out.println("The review has an average score of "
                + index.reviewScore(name));
        if (index.reviewScore(name) < 2) {
            System.out.println("Negative Sentiment");
        }

        else {
            System.out.println("Positive Sentiment");
        }

    }

}

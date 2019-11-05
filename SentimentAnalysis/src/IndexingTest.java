
public class IndexingTest extends student.TestCase {
    private Indexing index;
    private String[] s1;
    private String[] s2;
    private String[] s3;

    public IndexingTest() {
        // empty
    }

    /**
     * sets up variables
     */
    
    public void setUp() {
        s1 = new String[] { "5", "this", "movie", "is", "great" };
        s2 = new String[] { "4", "this", "film", "is", "good" };
        s3 = new String[] { "3", "I", "think", "it", "is", "alright"};
        index = new Indexing();
    }

    /**
     * tests addScore, parseWords, and scoreWord
     * tests reviewScore
     */
    
    public void testMethods() {
        index.parseWords(s1);
        index.parseWords(s2);
        index.parseWords(s3);
        //System.out.println(index.findString("this", ));
        assertEquals(4.5, index.scoreWord("this"), 0.01);
        assertEquals(5, index.scoreWord("great"), 0.01);
        assertEquals(4, index.scoreWord("is"), 0.01);
        assertEquals(-1, index.scoreWord("nonexistentword"), 0.01);
        assertEquals(3.91667, index.reviewScore("I think this movie is good"), 0.01);
    }
}

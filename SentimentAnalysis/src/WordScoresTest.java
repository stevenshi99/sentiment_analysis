/**
 * test class for WordScores
 * 
 * @author Steven
 * @version 2017.12.04
 */
public class WordScoresTest extends student.TestCase {
    private WordScores ws;
    private WordScores ws2;

    public WordScoresTest() {
        // empty
    }

    /**
     * sets up ws
     */
    public void setUp() {
        ws = new WordScores("word", 50, 10);
        ws2 = new WordScores("aaa", 30, 5);

    }

    /**
     * tests compareTo method
     */
    public void testCompareTo() {
        assertEquals(1, ws.compareTo(ws2));
        assertEquals(-1, ws2.compareTo(ws));
        assertEquals(0, ws.compareTo(ws));
    }

    /**
     * tests avgScore method
     */
    public void testAvgScore() {
        assertEquals(5.0, ws.avgScore(), .01);
    }
}

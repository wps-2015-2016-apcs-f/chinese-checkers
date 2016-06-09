/*
 * LocationTest.java
 *
 * @author 2015-2016 APCS F-Block
 * @author David C. Petty <dpetty@winchesterps.org>
 */
package chinesecheckers;

import org.junit.*;

/**
 * Unit test for {@link Location}s, including {@link Hole} and {@link Marble}.
 */
public class LocationTest {

    private Location m0, h1, h2, h3, h4, m5, m6, m7, m8, m9;
    private Location[] actual, expected, holes, marbles;

    /**
     * Set up before every test.
     */
    @Before
    public void setUp() {
        m0 = new Marble(0, 0);

        h1 = new Hole(0, 47);
        h2 = new Hole(47, 0);
        h3 = new Hole(47, 47);
        h4 = new Hole(0, 47);

        m5 = new Marble(3, 6);
        m6 = new Marble(4, 6);
        m7 = new Marble(3, 7);
        m8 = new Marble(4, 7);
    }

    /**
     * Tear down after every test.
     */
    @After
    public void tearDown() {
        m0 = h1 = h2 = h3 = h4 = m5 = m6 = m7 = m8 = m9 = null;
        actual = expected = holes = marbles = null;
    }

    /**
     * Test accessors.
     */
    @Test
    public void testAccessors() {
        int[] expectedRow = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, };
        int[] expectedCol = new int[] { 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, };
        assert expectedRow.length == expectedCol.length : "testAccessors: bad data";
        for (int i = 0; i < expectedRow.length; i++) {
            int row = expectedRow[i], col = expectedCol[i];
            Location c = new Hole(row, col);
            Assert.assertTrue("(" + row + "," + col + ") != " + c + ".",
                c.getRow() == row && c.getCol() == col);
        }
        for (int i = 0; i < expectedRow.length; i++) {
            int row = expectedRow[i], col = expectedCol[i];
            Location c = new Marble(row, col);
            Assert.assertFalse("(" + row + "," + col + ") == " + c + ".",
                c.getRow() == col && c.getCol() == row);
        }
    }
    /**
     * Test equals.
     */
    @Test
    public void testEquals() {
        expected = new Location[] { h1, h2, h3, h1, };
        actual = new Location[] { h1, h2, h3, h4, };
        assert expected.length == actual.length : "testEquals: bad data";
        for (int i = 0; i < expected.length; i++)
            Assert.assertTrue(expected[i] + " != " + actual[i] + ".",
                expected[i].equals(actual[i]));
        expected = new Location[] { h1, h1, h2, h2, h3, };
        actual = new Location[] { h2, h3, h3, h4, h4, };
        assert expected.length == actual.length : "testEquals: bad data";
        for (int i = 0; i < expected.length; i++)
            Assert.assertFalse(expected[i] + " == " + actual[i] + ".",
                expected[i].equals(actual[i]));
    }

    /**
     * Test isEmpty.
     */
    @Test
    public void testIsEmpty() {
        holes = new Location[] { h1, h2, h3, h4, };
        for (int i = 0; i < holes.length; i++)
            Assert.assertTrue("!(" + holes[i] + ").isEmpty().",
                holes[i].isHole());
        marbles = new Location[] { m0, m5, m6, m7, m8 };
        for (int i = 0; i < marbles.length; i++)
            Assert.assertFalse("(" + marbles[i] + ").isEmpty().",
                marbles[i].isHole());
    }
}

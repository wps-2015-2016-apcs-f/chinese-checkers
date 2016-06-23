/*
 * LocationTest.java
 *
 * @author 2015-2016 APCS F-Block
 * @author David C. Petty <dpetty@winchesterps.org>
 */
package chinesecheckers;

import java.awt.Color;
import javax.swing.UIManager;
import org.junit.*;

/**
 * Unit test for {@link Location}s, including {@link Hole} and {@link Marble}.
 */
public class LocationTest {

    private Location m0, h1, h2, h3, h4, m5, m6, m7, m8, m9;
    private Location[] actual, expected, holes, marbles;
    private int[] rows, cols;
    private Color[] colors;
    private static final Color DEFAULT_COLOR = Color.PINK;
    private static final Color BACKGROUND_COLOR = UIManager.getColor("Panel.background");

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

        m5 = new Marble(3, 6, Color.RED);
        m6 = new Marble(4, 6, Color.WHITE);
        m7 = new Marble(3, 7, Color.BLUE);
        m8 = new Marble(4, 7);

        rows = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, };
        cols = new int[] { 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, };
        colors = new Color[] {
            Color.RED, Color.WHITE, Color.BLUE, Color.BLACK, Color.WHITE, 
            Color.GRAY, Color.PINK, Color.ORANGE, Color.YELLOW, Color.GREEN, };
    }

    /**
     * Tear down after every test.
     */
    @After
    public void tearDown() {
        m0 = h1 = h2 = h3 = h4 = m5 = m6 = m7 = m8 = m9 = null;
        actual = expected = holes = marbles = null;
        rows = cols = null;
        colors = null;
    }

    /**
     * Test {@link Hole} accessors.
     */
    @Test
    public void testHoleAccessors() {
        // Test Hole accessors equal.
        for (int i = 0; i < rows.length; i++) {
            int row = rows[i], col = cols[i];
            Location c = new Hole(row, col);
            Assert.assertTrue(c.getClass().getName() + "@(" + row + "," + col + ") != " + c + ".",
                c.getRow() == row || c.getCol() == col);
        }
        // Test Hole accessors not equal.
        for (int i = 0; i < rows.length; i++) {
            int row = rows[i], col = cols[i];
            Location c = new Hole(row, col);
            Assert.assertFalse(c.getClass().getName() + "@(" + row + "," + col + ") == " + c + ".",
                c.getRow() == col || c.getCol() == row);
        }
    }

    /**
     * Test {@link Marble} accessors.
     */
    @Test
    public void testMarbleAccessors() {
        assert rows.length == cols.length 
            && rows.length == colors.length : "testAccessors: bad data";
        // Test Marble accessors equal.
        for (int i = 0; i < rows.length; i++) {
            int row = rows[i], col = cols[i];
            Color color = colors[i];
            Marble c = new Marble(row, col, color);
            Assert.assertTrue(String.format("%s@(%s,%s,%s) != %s", c.getClass().getName(), row, col, color, c),
                c.getRow() == row && c.getCol() == col && c.getColor().equals(color));
        }
        // Test Marble accessors not equal.
        for (int i = 0; i < rows.length; i++) {
            int row = rows[i], col = cols[i];
            Color color = colors[i], wrongColor = colors[colors.length - i - 1];
            Marble c = new Marble(row, col, color);
            Assert.assertFalse(String.format("%s@(%s,%s,%s) == %s", c.getClass().getName(), col, row, wrongColor, c),
                c.getRow() == col || c.getCol() == row || c.getColor().equals(wrongColor));
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
     * Test isHole.
     */
    @Test
    public void testIsHole() {
        holes = new Location[] { h1, h2, h3, h4, };
        for (int i = 0; i < holes.length; i++)
            Assert.assertTrue("!(" + holes[i] + ").isHole().",
                holes[i].isHole());
        marbles = new Location[] { m0, m5, m6, m7, m8 };
        for (int i = 0; i < marbles.length; i++)
            Assert.assertFalse("(" + marbles[i] + ").isHole().",
                marbles[i].isHole());
    }

    /**
     * Test Marble.
     */
    @Test
    public void testMarble() {
        marbles = new Location[] { m0, m5, m6, m7, m8 };
        colors = new Color[] { DEFAULT_COLOR, Color.RED, Color.WHITE, Color.BLUE, DEFAULT_COLOR, };
        assert marbles.length == colors.length : "testMarble: bad data";
        for (int i = 0; i < marbles.length; i++) {
            // Test that marbles are all marbles.
            Assert.assertTrue("!((" + marbles[i] + ") instanceof Marble).",
                marbles[i] instanceof Marble);
            // Test that the constructed color matches the accessed color.
            Assert.assertTrue("!(" + ((Marble) marbles[i]).getColor() + ").equals(" + colors[i] + ").",
                ((Marble) marbles[i]).getColor().equals(colors[i]));
            // Test that getOppositeColor() generates the opposite color.
            final int mask = 0xffffff;
            int rgbColor = ((Marble) marbles[i]).getColor().getRGB() & mask;
            int rgbOpposite = ((Marble) marbles[i]).getOppositeColor().getRGB() & mask;
            Assert.assertTrue(
                String.format("0x%06x & 0x%06x != 0x%06x", rgbColor, rgbOpposite, 0),
                (rgbColor & rgbOpposite) == 0);
            Assert.assertTrue(
                String.format("0x%06x | 0x%06x != 0x%06x", rgbColor, rgbOpposite, mask),
                (rgbColor | rgbOpposite) == mask);
        }
    }
}

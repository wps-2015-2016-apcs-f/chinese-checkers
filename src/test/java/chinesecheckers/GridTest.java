/*
 * GridTest.java
 *
 * @author 2015-2016 APCS F-Block
 * @author David C. Petty <dpetty@winchesterps.org>
 */
package chinesecheckers;

import org.junit.*;

/**
 * Unit test for {@link Grid}.
 */
public class GridTest {
    
    private Grid grid;
    private Location lC, lL, lAL, lAR, lR, lBR, lBL, lB;
    private Location[] fromA, toA;
    private boolean[] boolA;

    /**
     * Set up before every test.
     */
    @Before
    public void setUp() {
        grid = new Grid();
        lC = grid.getLocation(8, 12);   // Hole (center of the next six)
        lL = grid.getLocation(8, 11);   // Hole
        lAL = grid.getLocation(7, 12);  // Hole
        lAR = grid.getLocation(7, 13);  // Marble (black)
        lR = grid.getLocation(8, 13);   // null
        lBR = grid.getLocation(9, 12);  // Marble (blue)
        lBL = grid.getLocation(9, 11);  // Hole

        lB = grid.getLocation(7, 13);   // Marble (black)
        fromA = new Location[] { lAR, lAR, lB, };
        toA = new Location[] { lAL, lC, lC, };
        boolA = new boolean[] { true, true, true, };
    }
    /**
     * Tear down after every test.
     */
    @After
    public void tearDown() {
        grid = null;
    }
    /**
     * Test the 'at' direction methods.
     */
    @Test
    public void testAt() {
        Assert.assertTrue(lL + " != " + grid.atLeft(lC), lL == grid.atLeft(lC));
        Assert.assertTrue(lAL + " != " + grid.atAboveLeft(lC), lAL == grid.atAboveLeft(lC));
        Assert.assertTrue(lAR + " != " + grid.atAboveRight(lC), lAR == grid.atAboveRight(lC));
        Assert.assertTrue(lR + " != " + grid.atRight(lC), lR == grid.atRight(lC));
        Assert.assertTrue(lBR + " != " + grid.atBelowRight(lC), lBR == grid.atBelowRight(lC));
        Assert.assertTrue(lBL + " != " + grid.atBelowLeft(lC), lBL == grid.atBelowLeft(lC));
    }
    /**
     * Test the 'check' direction methods.
     */
    @Test
    public void testCheck() {
        // RED_FLAG: isValidMove requires start, land to be: marble, hole.
        assert fromA.length == toA.length && toA.length == boolA.length;
        for (int i = 0; i < toA.length; i++)
            Assert.assertTrue("grid.checkMove(" + fromA[i] + ", " + toA[i] + ") != " + boolA[i],
                grid.isValidMove(fromA[i], toA[i]) == boolA[i]);
    }
}

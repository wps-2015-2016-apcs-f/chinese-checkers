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
    private Location lC, lL, lAL, lAR, lR, lBR, lBL;

    /**
     * Set up before every test.
     */
    @Before
    public void setUp() {
        grid = new Grid();
        lC = grid.getLocation(8, 12);
        lL = grid.getLocation(8, 11);
        lAL = grid.getLocation(7, 12);
        lAR = grid.getLocation(7, 13);
        lR = grid.getLocation(8, 13);
        lBR = grid.getLocation(9, 12);
        lBL = grid.getLocation(9, 11);
    }
    /**
     * Tear down after every test.
     */
    @After
    public void tearDown() {
        grid = null;
    }
    /**
     * Rigourous Test :-)
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
}

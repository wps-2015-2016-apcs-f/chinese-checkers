/*
 * ChineseCheckersTest.java
 *
 * @author 2015-2016 APCS A-Block
 * @author David C. Petty <dpetty@winchesterps.org>
 */
package chinesecheckers;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for ChineseCheckers.
 */
public class ChineseCheckersTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ChineseCheckersTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(ChineseCheckersTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        assertTrue( true );
    }
}

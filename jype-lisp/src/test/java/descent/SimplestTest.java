package descent;

import junit.framework.TestCase;

import java.util.logging.Logger;
import static java.lang.System.nanoTime;
import static java.lang.String.valueOf;

/**
 * User: jim
 * Date: Sep 9, 2008
 * Time: 7:47:40 PM
 */
public class SimplestTest  extends TestCase {             
    static final Boolean[] seq = new Boolean[]
            {
                    true, false, true, true, false, false, null, true, false, false, null, true, false, false, null, true, false, false, null, true, false, false, null, true, false, false, null, true, false, false, true,
                    false, false, null, true, false, false, null, true, false, false, null, true, false, false, true, false, false, null, true, false, false, null, true, false, false, null, true, false, false, true, false,
                    false, null, true, false, false, null, true, false, false, null, true, false, false, true, false, false, null, true, false, false, null, true, false, false, null, true, false, false, true, false, false,
                    null, true, false, false, null, true, false, false, null, true, false, false, true, false, false, null, true, false, false, null, true, false, false, null, true, false, false, true, false, false, null,
                    true, false, false, null, true, false, false, null, true, false, false, true, false, false, null, true, false, false, null, true, false, false, null, true, false, false, true, false, false, null, true,
                    false, false, null, true, false, false, null, true, false, false, true, false, false, null, true, false, false, null, true, false, false, null, true, false, false, true, false, false, null, true, false,
                    false, null, true, false, false, null, true, false, false, true, false, false, null, true, false, false, null, true, false, false, null, true, false, false, true, false, false, null, true, false, false,
                    null, true, false, false, null, true, false, false, null, true, false, false, null, null, null, null, null, null, null, null, null, null, true, false, false, true, true, false, null, null, null, null,
                    true, true, false, false, true, true, false, false, true, true, false, false, true, true, false, false, true, true, false, false, true, false, false, null, null, null, true, false, false, null, null,
                    null, true, false, false, null, null, null, true, false, false, null, null, null, true, false, false, null, null, null, true, false, false, null, null, null, true, false, false, null, null, null, true,
                    false, false, null, null, null, true, false, false, null, null, null, true, false, false, null, null, null, true, false, false, null, null, null, true, false, false, null, null, null, true, false,
                    false, null, null, null, true, false, false, null, null, null, true, false, false, null, null, null, null, true, false, false, null, null, null, null, true, false, false, null, null, null, null, true,
                    false, false, null, null, null, null, true, false, false, null, null, null, null, true, false, false, null, null, null, null, true, false, false, null, null, null, null, true, false, false, null, null,
                    null, null, true, false, false, null, null, null, true, false, false, null, true, false, false, null, true, false, false, null, true, false, false, null, true, false, false, null, true, false, false,
                    null, true, false, false, null, true, false, false, null, null, true, false, false, null, null, null, null, null, null, null, null, null, null, true, false, false, true, true, false, null, null, null,
                    null, true, true, false, false, true, true, false, false, true, true, false, false, true, true, false, false, true, true, false, false, true, false, false, null, null, null, true, false, false, null,
                    null, null, true, false, false, null, null, null, true, false, false, null, null, null, true, false, false, null, null, null, true, false, false, null, null, null, true, false, false, null, null, null,
                    true, false, false, null, null, null, true, false, false, null, null, null, true, false, false, null, null, null, true, false, false, null, null, null, true, false, false, null, null, null, true, false,
                    false, null, null, null, true, false, false, null, null, null, true, false, false, null, null, null, null, true, false, false, null, null, null, null, true, false, false, null, null, null, null, true,
                    false, false, null, null, null, null, true, false, false, null, null, null, null, true, false, false, null, null, null, null, true, false, false, null, null, null, null, true, false, false, null, null,
                    null, null, true, false, false, null, null, null, true, false, false, null, true, false, false, null, true, false, false, null, true, false, false, null, true, false, false, null, true, false, false,
                    null, true, false, false, null, true, false, false, null, null, true, false, false, null, null, null, null, null, null, null, null, null, null, true, false, false, true, true, false, null, null, null,
                    null, true, true, false, false, true, true, false, false, true, true, false, false, true, true, false, false, true, true, false, false, true, false, false, null, null, null, true, false, false, null,
                    null, null, true, false, false, null, null, null, true, false, false, null, null, null, true, false, false, null, null, null, true, false, false, null, null, null, true, false, false, null, null, null,
                    true, false, false, null, null, null, true, false, false, null, null, null, true, false, false, null, null, null, true, false, false, null, null, null, true, false, false, null, null, null, true, false,
                    false, null, null, null, true, false, false, null, null, null, true, false, false, null, null, null, null, true, false, false, null, null, null, null, true, false, false, null, null, null, null, true,
                    false, false, null, null, null, null, true, false, false, null, null, null, null, true, false, false, null, null, null, null, true, false, false, null, null, null, null, true, false, false, null, null,
                    null, null, true, false, false, null, null, null, true, false, false, null, true, false, false, null, true, false, false, null, true, false, false, null, true, false, false, null, true, false, false,
                    null, true, false, false, null, true, false, false, null, null, true, false, false, null, null, null, null, null, null, null, null, null, null, true, false, false, true, true, false, null, null, null,
                    null, true, true, false, false, true, true, false, false, true, true, false, false, true, true, false, false, true, true, false, false, true, false, false, null, null, null, true, false, false, null,
                    null, null, true, false, false, null, null, null, true, false, false, null, null, null, true, false, false, null, null, null, true, false, false, null, null, null, true, false, false, null, null, null,
                    true, false, false, null, null, null, true, false, false, null, null, null, true, false, false, null, null, null, true, false, false, null, null, null, true, false, false, null, null, null, true, false,
                    false, null, null, null, true, false, false, null, null, null, true, false, false, null, null, null, null, true, false, false, null, null, null, null, true, false, false, null, null, null, null, true,
                    false, false, null, null, null, null, true, false, false, null, null, null, null, true, false, false, null, null, null, null, true, false, false, null, null, null, null, true, false, false, null, null,
                    null, null, true, false, false, null, null, null, true, false, false, null, true, false, false, null, true, false, false, null, true, false, false, null, true, false, false, null, true, false, false,
                    null, true, false, false, null, true, false, false, null, null, true, false, false, null, null, null, null, null, null, null, null, null, null, true, false, false, true, true, false, null, null, null,
                    null, true, true, false, false, true, true, false, false, true, true, false, false, true, true, false, false, true, true, false, false, true, false, false, null, null, null, true, false, false, null,
                    null, null, true, false, false, null, null, null, true, false, false, null, null, null, true, false, false, null, null, null, true, false, false, null, null, null, true, false, false, null, null, null,
                    true, false, false, null, null, null, true, false, false, null, null, null, true, false, false, null, null, null, true, false, false, null, null, null, true, false, false, null, null, null, true, false,
                    false, null, null, null, true, false, false, null, null, null, true, false, false, null, null, null, null, true, false, false, null, null, null, null, true, false, false, null, null, null, null, true,
                    false, false, null, null, null, null, true, false, false, null, null, null, null, true, false, false, null, null, null, null, true, false, false, null, null, null, null, true, false, false, null, null,
                    null, null, true, false, false, null, null, null, true, false, false, null, true, false, false, null, true, false, false, null, true, false, false, null, true, false, false, null, true, false, false,
                    null, true, false, false, null, true, false, false, null, null, true, false, false, null, null, null, null, null, null, null, null, null, null, true, false, false, true, true, false, null, null, null,
                    null, true, true, false, false, true, true, false, false, true, true, false, false, true, true, false, false, true, true, false, false, true, false, false, null, null, null, true, false, false, null,
                    null, null, true, false, false, null, null, null, true, false, false, null, null, null, true, false, false, null, null, null, true, false, false, null, null, null, true, false, false, null, null, null,
                    true, false, false, null, null, null, true, false, false, null, null, null, true, false, false, null, null, null, true, false, false, null, null, null, true, false, false, null, null, null, true, false,
                    false, null, null, null, true, false, false, null, null, null, true, false, false, null, null, null, null, true, false, false, null, null, null, null, true, false, false, null, null, null, null, true,
                    false, false, null, null, null, null, true, false, false, null, null, null, null, true, false, false, null, null, null, null, true, false, false, null, null, null, null, true, false, false, null, null,
                    null, null, true, false, false, null, null, null, true, false, false, null, true, false, false, null, true, false, false, null, true, false, false, null, true, false, false, null, true, false, false,
                    null, true, false, false, null, true, false, false, null,
            };
    private static final Logger LOG = Logger.getAnonymousLogger();
    private static long begin;
    private static final int ITER = 1000000;

    public void testLoopIter() {
        int carrier = 0;
        long t = nanoTime();
        for (int r = 0; r < 10; r++) {
            LOG.info("+" + (nanoTime() - begin) / 100000 + " : " + r + " : begin iter  ");
            LOG.info("" + valueOf(begin = nanoTime()) + " : " + r + " : begin adjacent");
            for (int i = 0; i < ITER; i++) for (Boolean aBoolean : seq) try { if (testIf(aBoolean) && testNpe(!aBoolean)) ++carrier; } catch (final NullPointerException e) { }
            LOG.info("===================      " + (nanoTime() - begin) / 100000 + " : " + r + " : " + carrier + " : end adjacent ");
            LOG.info("" + valueOf(begin = nanoTime()) + " : " + r + " : begin npe");
            for (int i = 0; i < ITER; i++)
                for (Boolean aBoolean : seq)
                    try { if (testNpe(!aBoolean)) ++carrier; } catch (final NullPointerException e) { }
            LOG.info("===================      " + (nanoTime() - begin) / 100000 + " : " + r + " : " + carrier + " : end npe ");
            LOG.info("" + valueOf(begin = nanoTime()) + " : " + r + " : begin cmp");
            for (int i = 0; i < ITER; i++)
                for (Boolean aBoolean : seq)
                    if (testIf(aBoolean)) ++carrier;


            LOG.info("===================      " + (nanoTime() - begin) / 100000 + " : " + r + " : " + carrier + "  : end cmp");

            LOG.info("-" + valueOf(begin = nanoTime() - t) + " : " + r + " : end iter");
        }
    }

    private static boolean testIf(final Boolean i) {
        return i != null ? i : false;
    }

    private static boolean testNpe(final Boolean i) {
        return !i;
    }
}

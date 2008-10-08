package descent;

import java.util.logging.Logger;
import static java.lang.System.nanoTime;

class asdfadf {


    static Boolean[] seq = new Boolean[]
            {
                    true, false, true, true, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, true, true, false, false, true, true, false, false, true, true, false, false, true, true, false, false, true, true, false, false, true, false, false, null, null, null, true, false, false, null, null, null, true, false, false, null, null, null, true, false, false, null, null, null, true, false, false, null, null, null, true, false, false, null, null, null, true, false, false, null, null, null, true, false, false, null, null, null, true, false, false, null, null, null, true, false, false, null, null, null, true, false, false, null, null, null, true, false, false, null, null, null, true, false, false, null, null, null, true, false, false, null, null, null, true, false, false, null, null, null, null, true, false, false, null, null, null, null, true, false, false, null, null, null, null, true, false, false, null, null, null, null, true, false, false, null, null, null, null, true, false, false, null, null, null, null, true, false, false, null, null, null, null, true, false, false, null, null, null, null, true, false, false, null, null, null
            };

    static int ifcount = 0;
    static int npecount = 0;
    private static final Logger LOG = Logger.getAnonymousLogger();

    private static void warmup() {
        for (int i = 0; i < 1000; i++) {
            for (Boolean aBoolean : seq) {
                try {
                    ifcount += testIf(aBoolean) ? 1 : -1;

                    npecount += testNpe(!aBoolean) ? 1 : -1;
                } catch (final NullPointerException e) {
                }
            }
        }
        //LOG.fine("warmup id: " + ifcount + ", npe: " + npecount + ", time: " + nanoTime());
    }

    private static void npe() {
        /* for (int i = 0; i < 1000; i++) */
        {
            for (Boolean aBoolean : seq) {
                try {
                    npecount += testNpe(!aBoolean) ? 1 : -1;
                } catch (final NullPointerException e) {
                }
            }
        }
        //LOG.finer("npe: " + npecount + ", time: " + nanoTime());
    }

    private static void wif() {
        /*     for (int i = 0; i < 1000; i++) */
        {


            for (Boolean aBoolean : seq) {
                ifcount += testIf(aBoolean) ? 1 : -1;
            }
        }
        //LOG.finest("id: " + ifcount + ", time: " + nanoTime());
    }

    public static void main(final String[] args) {

        System.out.println(testIf(null));
        System.out.println(testIf(false));
        System.out.println(testIf(true));


        long s = nanoTime();
        for (int r = 0; r < 1000000; r++) {
            warmup();
            npe();
            wif();
        }
        long e = nanoTime();
        LOG.info("wtime: " + (e - s));

        s = nanoTime();
        for (int r = 0; r < 1000000; r++) {
            npe();
        }
        e = nanoTime();
        LOG.info("npetime: " + (e - s));

        s = nanoTime();
        for (int r = 0; r < 1000000; r++) {
            wif();
        }
        e = nanoTime();
        LOG.info("iftime: " + (e - s));

        LOG.info("if: " + ifcount + ", npe: " + npecount);
    }


    private static boolean testIf(final Boolean i) {


        return i != null ? true ? i : false : false;
    }

    private static boolean testNpe(final Boolean i) {
        return i;
    }

    ;
}
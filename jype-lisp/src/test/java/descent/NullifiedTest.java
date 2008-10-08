package descent;

import junit.framework.TestCase;
import static java.lang.System.nanoTime;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.util.logging.Logger;

public class NullifiedTest extends TestCase {
    private static final String END_ADJ = "adjacent";
    private static final int SCALE = 100000;
    private static int draw = 0;
    private static final String END_NPE = "npe";
    private static final String END_CMP = "cmp";
    private static final String END_IND_ADJACENT = "->adjacent ";
    private static final String END_IND_NPE = "->npe";
    private static final String END_IND_CMP = "->cmp";
    private static final String END_VAR_ADJACENT = "adjacent ...";
    private static final String END_VAR_NPE = "npe ... ";
    private static final String END_VAR_CMP = "cmp ...";


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

    static long begin=nanoTime();
    private static final int ITER = 2000;
    private Logger LOG=Logger.getAnonymousLogger();

    public void testLoopIter() {
        int carrier = 0;
        for (int r = 0; r < 10; r++) {
            for (int i = 0; i < ITER; i++)
                for (Boolean aBoolean : seq)
                    try {
                        if (testIf(aBoolean) && testNpe(!aBoolean)) ++carrier;
                    } catch (final NullPointerException e) {
                    }

            cerr(carrier, r, END_ADJ);
            begin = nanoTime();

            for (int i = 0; i < ITER; i++)
                for (Boolean aBoolean : seq)
                    try {
                        if (testNpe(!aBoolean)) ++carrier;
                    } catch (final NullPointerException e) {
                    }
            cerr(carrier, r, END_NPE);
            begin = nanoTime();

            begin = nanoTime();
            for (int i = 0; i < ITER; i++)
                for (Boolean aBoolean : seq)
                    if (testIf(aBoolean)) ++carrier;


            cerr(carrier, r, END_CMP);
            begin = nanoTime();

        }
    }

    public void testSoftIter() {


        Reference<Boolean>[] rseq = new Reference[seq.length];

        for (int i = 0; i < seq.length; i++) {
            Boolean aBoolean = seq[i];
            rseq[i] = new SoftReference<Boolean>(aBoolean);
        }
        int carrier = 0;
        for (int r = 0; r < 10; r++) {
            LOG.info("iter "+r);
            for (int i = 0; i < ITER; i++)
                for (Reference<Boolean> aBoolean : rseq)
                    try {
                        if (testIf(aBoolean.get()) &&
                                testNpe(!aBoolean.get())) ++carrier;
                    } catch (final NullPointerException e) {
                    }

            cerr(carrier, r, "ref adjacent");
            begin = nanoTime();


            for (int i = 0; i < ITER; i++)
                for (Reference<Boolean> aBoolean : rseq)
                    try {
                        if (testNpe(!aBoolean.get())) ++carrier;
                    } catch (final NullPointerException e) {
                    }

            cerr(carrier, r, END_NPE);
            begin = nanoTime();

            for (int i = 0; i < ITER; i++)
                for (Reference<Boolean> aBoolean : rseq)
                    if (testIf((Boolean) aBoolean.get())) ++carrier;


            cerr(carrier, r, END_CMP);
            begin = nanoTime();


        }
    }

    public void testEarlyBailoutIter() {

        Reference<Boolean>[] rseq = new Reference[seq.length];
        for (int i = 0; i < seq.length; i++) {
            Boolean aBoolean = seq[i];
            rseq[i] = aBoolean == null ? null : new SoftReference<Boolean>(aBoolean);
        }
        int carrier = 0;
        for (int r = 0; r < 10; r++) {
            LOG.info("iter "+r);
            begin = nanoTime();
            for (int i = 0; i < ITER; i++)
                for (Reference<Boolean> aBoolean : rseq)
                    try {
                        if (testIf(aBoolean.get()) &&
                                testNpe(!aBoolean.get())) ++carrier;
                    } catch (final NullPointerException e) {
                    }

            cerr(carrier, r, "bailout adj");
            begin = nanoTime();

            for (int i = 0; i < ITER; i++)
                for (Reference<Boolean> aBoolean : rseq)
                    try {
                        if (testNpe(!aBoolean.get())) ++carrier;
                    } catch (final NullPointerException e) {
                    }

            cerr(carrier, r, "bailout npe");
            begin = nanoTime();

            for (int i = 0; i < ITER; i++)
                for (Reference<Boolean> aBoolean : rseq)
                    if (testIf(!aBoolean.get())) ++carrier;


            cerr(carrier, r, "bailout npe");
            begin = nanoTime();


        }
    }

    public void testOuterIter() {
        int carrier = 0;

        for (int r = 0; r < 10; r++) {
            LOG.info("iter "+r);
            for (int i = 0; i < ITER; i++)
                for (Boolean aBoolean : seq)
                    try {
                        if (testIf(aBoolean) &&
                                testNpe(!aBoolean)) ++carrier;
                    } catch (final NullPointerException e) {
                    }

            cerr(carrier, r,"outer "+ END_ADJ);
            begin = nanoTime();

            for (int i = 0; i < ITER; i++)
                for (Boolean aBoolean : seq)
                    try {
                        if (testNpe(!aBoolean)) ++carrier;
                    } catch (final NullPointerException e) {
                    }
            cerr(carrier, r, "outer "+END_NPE);
            begin = nanoTime();


            for (int i = 0; i < ITER; i++)
                for (Boolean aBoolean : seq)
                    if (testIf(aBoolean)) ++carrier;


            cerr(carrier, r,"outer "+ END_CMP);
            begin = nanoTime();

            for (int i = 0; i < ITER; i++)
                carrier = adjacent(carrier);


            cerr(carrier, r, END_IND_ADJACENT);
            begin = nanoTime();


            for (int i = 0; i < ITER; i++)
                carrier = npe(carrier);


            cerr(carrier, r, END_IND_NPE);
            begin = nanoTime();

            for (int i = 0; i < ITER; i++)
                carrier = cmp(carrier);

            cerr(carrier, r, END_IND_CMP);
            begin = nanoTime();


            for (int i = 0; i < ITER; i++)
                carrier = npe___(carrier);

            cerr(carrier, r, END_VAR_NPE);
            begin = nanoTime();


            begin = nanoTime();
            for (int i = 0; i < ITER; i++)
                carrier = cmp___(carrier);

            cerr(carrier, r, END_VAR_CMP);
            begin = nanoTime();


        }
    }

    private static int cmp___(int... carrier) {
        int c = 0;
        for (int i : carrier) {
            c = i;
            break;
        }
        for (Boolean aBoolean : seq) {
            if (testIf(aBoolean)) ++c;
        }
        return c;
    }

    private static int cmp(int carrier) {
        for (Boolean aBoolean : seq) {
            if (testIf(aBoolean)) ++carrier;
        }
        return carrier;
    }

    private static int npe(int carrier) {
        for (Boolean aBoolean : seq) {
            try {

                if (testNpe(!aBoolean)) ++carrier;
            } catch (final NullPointerException e) {
            }
        }
        return carrier;
    }

    private static int npe___(int... carrier) {
        int c = 0;

        for (int i : carrier) {
            c = i;
            break;
        }

        for (Boolean aBoolean : seq) {
            try {
                if (testNpe(!aBoolean)) ++c;
            } catch (final NullPointerException e) {
            }
        }
        return c;
    }

    private static int adjacent(int carrier) {
        for (Boolean aBoolean : seq) {
            try {
                if (testIf(aBoolean) &&
                        testNpe(!aBoolean))
                    ++carrier;
            } catch (final NullPointerException e) {
            }
        }
        return carrier;
    }

    private static boolean testIf(final Boolean i) {
        return i != null ? i : false;
    }

    private static boolean testNpe(final Boolean i) {
        return !i;
    }

    final static void cerr(int carrier, int r, String tname) {
        System.err.println(" *** " + (nanoTime() - begin) / SCALE + " *** : " + tname);
        draw = r + carrier | 0xdeadbeef;
    }

}
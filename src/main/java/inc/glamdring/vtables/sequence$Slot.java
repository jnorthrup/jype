package inc.glamdring.vtables;

import inc.glamdring.EnumPackageAssemblyUtil;

import java.util.concurrent.*;
import java.util.EnumMap;

/**
 * User: jim
* Date: Sep 14, 2008
* Time: 4:46:52 PM
*/
public enum sequence$Slot {
    $as$extent$length(4),
    $as$extent$offset(4),
    $as$comment(0),
    $as$type(0) {
        Future<?> $(sequence$Slot theSlot, final EnumMap<sequence$Slot, Future<?>> state) throws ExecutionException, InterruptedException {
            final Future<?> result;
            result = state.get(this);
            if (null == result.get()) {
                return REFLECTION_POOL.submit(new Callable<Object>() {
                    public Object call() throws Exception {
                        return EnumPackageAssemblyUtil.guessIntTypes((Integer) ((Future<?>) state.get($as$extent$length)).get());
                    }
                });
            }
            return result;
        }},
    $as$symbol(0),
    /**
     * when storing this attribute, record the size of the struct at the moment of definition during <clinit>
     *
     */
    $as$sequence$length(4), $as$sourcecode(0),;


    private static ExecutorService REFLECTION_POOL = Executors.newCachedThreadPool();

    sequence$Slot(int i) {
        //To change body of created methods use File | Settings | File Templates.
    }

    Future<?> $(final sequence$Slot sequence$Slot, final EnumMap<sequence$Slot, Future<?>> $o) throws ExecutionException, InterruptedException {
        return REFLECTION_POOL.submit(new Callable<Object>() {
            public Object call() throws Exception {
                return $o.put(sequence$Slot.this, (Future<?>) REFLECTION_POOL.submit(new Callable<Object>() {
                    public Object call() throws Exception {
                        return ((Enum<?>) sequence$Slot).getDeclaringClass().getDeclaredField(name()).get(sequence$Slot);
                    }
                }));
            }
        });
    }

    public static EnumMap<sequence$Slot, Future<?>> $() {
        final EnumMap<sequence$Slot, Future<?>> $ = new EnumMap<sequence$Slot, Future<?>>(sequence$Slot.class) {
            Future<?> get(sequence$Slot k) throws ExecutionException, InterruptedException {
                return containsKey(k) ? get(k) : _($);
            }
        };
        return $;
    }
}

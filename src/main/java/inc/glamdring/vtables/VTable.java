package inc.glamdring.vtables;

import javolution.lang.Reference;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * vtable has a bag of traits, an array following a bitmap
 * <p/>
 * the Traits are indicated on a vtable caps" bitmap 0...63 important traits matter.
 * <p/>
 * vtable *thinks* it knows it's
 * traits and will populate the traits
 * it thinks it has, as vtables in the array per
 * trait.  unset trait bits would
 * presumably start out empty.
 * <p/>
 * vtables unkowingly carry around any other vtables asserted upon them by other traits and vtable interactions TODO
 * 
 */
interface VTable {
    /**
     * @param heap     struct backing store
     * @param register {@link inc.glamdring.vtables.RegisterFrame} manage heap cursors, {@link Triple#$tuple} s,p,o and heap-pointing trampoline boundaries
     * @param stack    heap autonomous data conveniently taking advantage of nio builtins:  {@link IntBuffer#mark }{@link IntBuffer#put }{@link IntBuffer#reset }{@link IntBuffer#get() }{@link IntBuffer#reset() } {@link IntBuffer#flip};
     * @return a vtable, typically itself.
     */
    public Reference<? extends VTable> _(ByteBuffer heap, byte[] register, IntBuffer stack);

    boolean isA(Traits isA);

    boolean isA(Traits... isA);
}
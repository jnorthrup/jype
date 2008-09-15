package inc.glamdring.vtables;

import javolution.lang.Reference;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * vtable has a bag of traits, an array following a bitmap
 * <p/>
 * the Traits are indicated on a vtable caps" bitmap 0...63 important traits matter.
 */
interface VTable {
    /**
     * @param heap     struct backing store
     * @param register {@link inc.glamdring.vtables.RegisterFrame} manage heap cursors, {@link Triple#$tuple} s,p,o and heap-pointing trampoline boundaries
     * @param stack    heap autonomous data conveniently taking advantage of nio builtins:  {@link java.nio.IntBuffer#mark }{@link java.nio.IntBuffer#put }{@link java.nio.IntBuffer#reset }{@link java.nio.IntBuffer#get() }{@link java.nio.IntBuffer#reset() } {@link java.nio.IntBuffer#flip};
     * @return a {@link inc.glamdring.vtables.VTable}, typically itself.
     */
    public Reference<? extends VTable> $(ByteBuffer heap, byte[] register, IntBuffer stack);

    /**
     * cast operation
     * @param as desired list of {@link Traits traits} the caller deires call sites for
     * @return a {@link inc.glamdring.vtables.VTable}
     */
    VTable as(Traits... as);

    /**
     *
     * @param is does {@link inc.glamdring.vtables.VTable}.this *think* it fulfills the array of {@link Traits traits}  requested?
     * @return vtable honors the entire list
     */
    boolean is(Traits... is);


}
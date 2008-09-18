package inc.glamdring.vtables;
 
import javolution.lang.Reference;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.EnumMap;

/**
 * User: jim
 * Date: Sep 14, 2008
 * Time: 2:32:51 AM
 */
class SubLReference<T> {
    final EnumMap<_ptrait, _vtable> traits = null;

    final boolean IsA(_ptrait trait) {
        _vtable vTable = null;
        if (traits.containsKey(trait))
            vTable = traits.get(trait);
        return vTable != null && vTable.is(trait);

    }


    public <T extends _ptrait>
    Reference<?> _(ByteBuffer mmapHeapWindow, int[] registers, IntBuffer heapIndex_as_Stack) {return null;}
}

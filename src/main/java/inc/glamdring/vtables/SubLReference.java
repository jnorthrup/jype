package inc.glamdring.vtables;
 
import java.util.EnumMap;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import javolution.lang.Reference;

/**
 * User: jim
 * Date: Sep 14, 2008
 * Time: 2:32:51 AM
 */
class SubLReference<T> {
    final EnumMap<Primary, VTable> traits = null;

    final boolean IsA(Primary trait) {
        VTable vTable = null;
        if (traits.containsKey(trait))
            vTable = traits.get(trait);
        return vTable != null && vTable.is(trait);

    }


    public <T extends Primary>
    Reference<?> _(ByteBuffer mmapHeapWindow, int[] registers, IntBuffer heapIndex_as_Stack) {return null;}
}

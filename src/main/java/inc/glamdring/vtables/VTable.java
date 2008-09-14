package inc.glamdring.vtables;

import javolution.lang.Reference;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.EnumMap;

import inc.glamdring.vtables.LispTraits;


interface VTable {
    public Reference<? super LispTraits> _(ByteBuffer mmapHeapWindow, int[] registers, IntBuffer heapIndex_as_Stack);

    boolean isA(LispTraits IsA);

    boolean isA(LispTraits... IsA);
}
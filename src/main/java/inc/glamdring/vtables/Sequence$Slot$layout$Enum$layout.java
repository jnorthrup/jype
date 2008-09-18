package inc.glamdring.vtables;

import javolution.util.FastMap;
import javolution.util.FastSet;

import java.lang.ref.Reference;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.EnumMap;

/**
 * User: jim
 * Date: Sep 14, 2008
 * Time: 4:46:52 PM
 */
public enum Sequence$Slot$layout$Enum$layout    {
    $as$extent$length$int(4) {{ $$as$comment$String = "the number of bytes this Slot occupies";}},
    $as$extent$offset$int(4) {{ $$as$comment$String = "the number of bytes from the beginning of the method state byte[] to the slot "; }},
    $as$comment$String(0) {{ $$as$comment$String = "self docs"; }},
    $as$Value$Type$Class(0) {
        {
            $$as$comment$String = "The semantically linked visitor delegate which is bound at either of source code or <clinit> by inference";
        }
        public Enum<? extends _vtable> $(final Class<Enum<? extends _vtable>> Sequence$slot, final EnumMap<Sequence$Slot$layout$Enum$layout, Enum<? extends _vtable>> state) {
            final FastMap<Object, Object> map = FastMap.newInstance();
            final String name1 = Sequence$slot.getName();
            map.put("name", name1);
            map.put("class", Sequence$slot);
            final FastSet<? extends Class<?>> classes = Function$infer$Type.$(map);
            return null;
        }

        {
            $$as$sourcecode$String = "        public Enum<? extends _$> $(final Class<Enum<? extends _$>> Sequence$slot, final EnumMap<Sequence$Slot$layout$Enum$layout, Enum<? extends _$>> state) {\n" +
                                     "            final FastMap<Object, Object> map = FastMap.newInstance();\n" +
                                     "            final String name1 = Sequence$slot.getName();\n" +
                                     "            map.put(\"name\", name1);\n" +
                                     "            map.put(\"class\", Sequence$slot);\n" +
                                     "            final FastSet<? extends Class<?>> classes = Function$infer$Type.$(map);\n" +
                                     "\n" +
                                     "            return null;\n" +
                                     "        }";
        }
    },
    $as$Visitor$VTable$Symbol$String(0) {{
    }},
    /**
     * when storing this attribute, record the size of the struct at the moment of definition during <clinit>
     */
    $as$Sequence$length$int(4),
    $as$Sequence$Member$sourcecode$String(0);
    public String $$as$sourcecode$String = "";
//    private final Class<? extends List & _$> $$as$Visitor$_$$Symbol=null;

    Class<? extends Enum<? extends _vtable>> as$Visitor$VTable$Symbol() {
        return null;
    }

    public Enum<? extends _vtable> $(final Class<Enum<? extends _vtable>> Slot$Class, final EnumMap<Sequence$Slot$layout$Enum$layout, Enum<? extends _vtable>> state) {
        try {
            return (Enum<? extends _vtable>) Slot$Class.getDeclaringClass().getDeclaredField(name()).get(Slot$Class);
        } catch (Exception e) {
        }
        return null;
    }

    String $$as$comment$String ="the next generation.";
    final int $$as$extent$length$int;
    final int $$as$extent$offset$int;
    private static int $$as$Sequence$length$int;

    /**
     * <h1>union function constructor</h1>
     * these initializers allow struct-wide manipulation of the data using seperate functors indexed by seperate ordinals/symbols and abbreviate the effort required to add groups of functions to a single struct.
     * <p/>
     * <p/>
     * the goal here is to provide a simple way to add functors to a struct that know exactly which range of bytes they are working with and operate on a union byte range of the whole.
     *
     * @param keepOffset whether to reuse previous block(true), or create a successive block(false), or reblock (NULL or Primary#prior ) whole or part of the struct
     * @param mark       optional defaults of reblocking params.  mark supplies first and last blocks to encompass a new block byte-union.  default marks are first and last, respectively.   if omitted, this provides the enum class a means of delivering itself into it's functor as a single current-rerdSize chunk.
     */
      Sequence$Slot$layout$Enum$layout(Boolean keepOffset, Sequence$Slot$layout$Enum$layout... mark) {
        if (keepOffset == null) {
            $$as$extent$offset$int = mark.length > 1 ? mark[1].$$as$extent$offset$int + mark[1].$$as$extent$length$int :
                                     0;
            $$as$extent$length$int = mark.length > 0 ? $$as$extent$offset$int - mark[0].$$as$extent$offset$int : getRecordLen();


        } else {
            Sequence$Slot$layout$Enum$layout prev = Sequence$Slot$layout$Enum$layout.values()[ordinal() - 1];
            if (!keepOffset) $$as$extent$offset$int = init($$as$extent$length$int = prev.$$as$extent$length$int);
            else $$as$extent$offset$int = init($$as$extent$length$int = prev.$$as$extent$length$int, prev.$$as$extent$length$int + prev.$$as$extent$offset$int);
        }
    }

    private int getRecordLen() {return $$as$Sequence$length$int;}

    private int init(int... dim) {
        int offset = dim.length > 1 ? dim[1] : getRecordLen();
        $$as$Sequence$length$int = Math.max(
                getRecordLen(), offset + $$as$extent$length$int);
        return offset;
    }


    public Reference<? extends _vtable> $(ByteBuffer heap, byte[] register, IntBuffer stack) {
        return null;  //todo: verify for a purpose
    }

    public boolean is(_ptrait... a) {
        return false;  //todo: verify for a purpose
    }

    public _vtable as(_ptrait... as) {
        return null;  //todo: verify for a purpose
    }

    public static String $(Enum $s) {
        return $s.toString();
    }

    /**
     * provide
     *
     * @param prototype
     * @param dim
     */

    private Sequence$Slot$layout$Enum$layout(Sequence$Slot$layout$Enum$layout prototype, Integer... dim) {
        $$as$extent$offset$int = init($$as$extent$length$int = (dim.length > 0 && dim[0] != null && dim[0] >= 0 ? dim[0] : prototype.$$as$extent$length$int),
                                      dim.length > 1 && dim[1] != null && dim[1] >= 0 ? dim[1] : prototype.$$as$extent$offset$int);
    }

    Sequence$Slot$layout$Enum$layout(int... dim) {
//        this.$$as$extent$length$int =$$as$extent$length$int;
        $$as$extent$offset$int = init($$as$extent$length$int = dim.length > 1 ? dim[1] : 1, dim.length > 1 ? dim[1] : 1);
    }

    public boolean is(_ptrait $traits) {
        return false;  //todo: verify for a purpose
    }


}
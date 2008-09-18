package inc.glamdring.vtables;

import static javolution.lang.Reflection.Method;
import javolution.util.FastSet;

import java.lang.reflect.Field;
import static java.lang.Class.*;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.util.Arrays;
import java.util.Map;

/**
 * User: jim
 * Date: Sep 14, 2008
 * Time: 5:19:58 PM
 */
public enum Function$infer$Type  {
    $as$Function(Method.class, 0),
    $as$byte(byte.class, 1),
    $as$short(short.class, 2),
    $as$int(int.class, 4),
    $as$long(long.class, 8),
    $as$Sequence$Array$byte(byte[].class, true, 64),
    $as$Sequence$Buffer$byte(ByteBuffer.class, true, 64, 1024 * 1024 * 8 - 1),
    $as$Channel$byte(ByteChannel.class, true, 1024 * 1024 * 8),
    $as$float$class(float.class, 4),
    $as$double$class(double.class, 10),
    $as$byte$prefixes$Sequence$byte$char(ByteBuffer.class, 256);

    static {
    final Boolean exact = null;
        final Boolean min = false;
        final Boolean max = true;
    }
    private Boolean $ternary$is$max$min = null;
    private final int[] $as$Sequence$range$int;

    Function$infer$Type(Class<?> $Type$as$Class, Boolean $ternary$is$max$min, int... $as$Sequence$range$int) {
        this($Type$as$Class, $as$Sequence$range$int);
        this.$ternary$is$max$min = $ternary$is$max$min;
        if (null == $ternary$is$max$min) Arrays.sort($as$Sequence$range$int);
    }

    Function$infer$Type(Class<?> $Type$as$Class, int... $as$Sequence$range$int) {
        this.$as$Sequence$range$int = $as$Sequence$range$int;
        Function$infer$Type result = null;
        for (Function$infer$Type function$infer$Type : values()) {
            final Function$infer$Type $Type = function$infer$Type.$($as$Sequence$range$int);
            if ($Type != null) {
                result = function$infer$Type;
                break;
            }
        }
    }


    /**
     * @param field
     * @return
     */

    static FastSet<? extends Class<?>> $(Map<?, ?> field) {

        FastSet<Class<?>> bag = new FastSet<Class<?>>();
        for (Function$infer$Type $ : values()) {


            final FastSet<? extends Class<?>> classes = $.$$(field);
            for (Class<?> aClass : classes) {
                bag.add(aClass);
            }


        }
        return (
                bag.isEmpty() ? null : bag);
    }

    /**
     * the default behavior;
     *
     * @param field a field
     * @return some number of candidate classes
     */

    FastSet<Class<?>> $$(Map<?, ?> field) {

        FastSet<Class<?>> results = FastSet.newInstance();


        Package[] testme = new Package[]{
                this.getClass().getPackage(),
                ((Class) field.get("class")).getPackage(),
                field.getClass().getPackage(),
                Method.class.getPackage(),
                Field.class.getPackage(),
                Object.class.getPackage()
        };


        final String name1 = (String) field.get("name");

        for (String s : name1.split("$_$")) {
            for (Package aPackage : testme) {
                final String cTest = aPackage.getName() + "." + s;
                try {
                    results.add(forName(cTest)) ;
                } catch (ClassNotFoundException e) {
                }
            }

        }

        return results;
    }

    /**
     * if using max/min, we alternate
     * max 1024, min 64
     *
     * @param $extent$length$int
     * @return null if not a match
     */
    Function$infer$Type $(int[] $extent$length$int) {

        if (null == $ternary$is$max$min) {
            if (0 >= Arrays.binarySearch($as$Sequence$range$int, $extent$length$int[0]))

                return this;
        } else {

            boolean inverse = true;

            for (int i : $as$Sequence$range$int) {
                inverse = !inverse;
                final int i1 =
                        (inverse ^ $ternary$is$max$min) ? Math.max(i, $extent$length$int[0])
                        : Math.min(i, $extent$length$int[0]);
                if (i1 == i)
                    return this;
            }

        }


        return null;
    }
}

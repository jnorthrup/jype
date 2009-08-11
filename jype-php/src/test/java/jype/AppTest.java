package jype;

import junit.framework.*;
import jype.php.*;

import static java.lang.System.*;
import java.lang.reflect.*;
import java.nio.*;
import static java.util.Arrays.*;
import java.util.*;

/**
 * Unit test for simple App.
 */
public class AppTest
        extends TestCase {

    boolean myBool = true;
    private static final String STRING = "string";
    private char[] chars;
    Boolean b;
    ;
    private Class[] classes;
    private static final Set<Class> HAS_BOOL = new HashSet<Class>(asList(Boolean.class, boolean.class));
    private static final Set<Class> HAS_STRING = new HashSet<Class>(asList(CharSequence.class, char[].class, String.class, CharBuffer.class));

    public void testClassReflection() {

        final Field[] fields = AppTest.class.getDeclaredFields();
        for (Field field : fields) {

            out.print("var $" + field.getName());

            final Class<?> type = field.getType();
            if ((field.getModifiers() & Modifier.FINAL) != 0) {
                try {
                    Object o = field.get(field);
                    if (HAS_STRING.contains(type)
                            ) {
                        String s = (String) o;
                        s.replace("\"", "\\\"");
                        o = "\"" + s + "\"";
                    }
                    ;
                    Object v;
                    try {
                        o = type.getMethod("valueOf", o.getClass()).invoke(null, o);


//                        String.valueOf()
                    } catch (InvocationTargetException e) {
//                        e.printStackTrace();
                    } catch (NoSuchMethodException e) {
//                        e.printStackTrace();  //TODO: Verify for a purpose
                    }
                    v = String.valueOf(o);
                    out.print("=" + v);
                } catch (IllegalAccessException e) {
//                    e.printStackTrace();

                }
            }
            out.println(";");

        }


    }

    public void testAasdasd() {


        new Java2PHP().getPHPCode(AppTest.class);

    }

}

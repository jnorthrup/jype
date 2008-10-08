package inc.glamdring.vtables;

import java.nio.ByteBuffer;

/**
 * 
 * ref<String>
 * User: jim
* Date: Sep 30, 2008
* Time: 7:56:55 PM
*/
public class £String extends £<String> {

    public Û<String, $> bind(String t, $ $void) {
        l = t;
        byte[] bytes = t.getBytes();
        ByteBuffer buffer = $void.l$();
        r = ($) $void.bind(buffer.putInt(t.getBytes().length).put(bytes), $void.$r());
        return this;  
    }

    public String reify($ $void) {
        ByteBuffer heap = $void.l$();
        Integer address = $void.$r();
        heap.getInt(address);
        return ((ByteBuffer) heap.slice().limit(address)).asCharBuffer().toString();  
    }
}

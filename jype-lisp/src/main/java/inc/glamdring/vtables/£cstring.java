package inc.glamdring.vtables;

import java.nio.ByteBuffer;

class £cstring implements Û<CharSequence, $> {


    public CharSequence l$(Û<CharSequence, $> p) {
        final $ $ = p.$r(p);
        final ByteBuffer buffer = $.l$($);
        return buffer.asCharBuffer();         

    }

    public $ $r(Û<CharSequence, $> p) {
        return p.$r(this);
    }

    public Û<CharSequence, $> bind(CharSequence charSequence, $ $) {
        return new £cstr();
    }

    public CharSequence reify($ void$) {
        return null;  //todo: verify for a purpose
    }
}
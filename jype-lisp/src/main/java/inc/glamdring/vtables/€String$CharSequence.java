package inc.glamdring.vtables;

class ÛString$CharSequence implements Û<String,CharSequence>{

    public String l$(Û<String, CharSequence> p) {
        return p.$r(p).toString();
    }

    public CharSequence $r(Û<String, CharSequence> p) {
            return p.l$(p) ;  
    }

    public Û<String, CharSequence> bind(final String s, final CharSequence charSequence) {
        return new Û<String, CharSequence>() {
            public String l$(Û<String, CharSequence> p) {
                return s;
            }

            public CharSequence $r(Û<String, CharSequence> p) {
                return s;  
            }

            public Û<String, CharSequence> bind(String s, CharSequence charSequence) {
                return ÛString$CharSequence.this.bind(s, charSequence);  
            }

            public String reify($ void$) {
                return s;  
            }
        };  
    }

    public String reify($ void$) {
        return void$.l$().asCharBuffer().toString();  //todo: verify for a purpose
    }
}
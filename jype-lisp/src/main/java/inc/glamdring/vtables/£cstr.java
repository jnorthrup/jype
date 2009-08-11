package inc.glamdring.vtables;

class £cstr implements €<String,CharSequence>{

    public String Ω(€<String, CharSequence> p) {
        return p.µ(p).toString();
    }

    public CharSequence µ(€<String, CharSequence> p) {
            return p.Ω(p) ;  
    }

    public €<String, CharSequence> €(final String s, final CharSequence charSequence) {
        return new €<String, CharSequence>() {
            public String Ω(€<String, CharSequence> p) {
                return s;
            }

            public CharSequence µ(€<String, CharSequence> p) {
                return s;  
            }

            public €<String, CharSequence> €(String s, CharSequence charSequence) {
                return £cstr.this.€(s, charSequence);  
            }

            public String reify(µ void$) {
                return s;  
            }
        };  //todo: verify for a purpose
    }

    public String reify(µ void$) {
        return void$.l$().asCharBuffer().toString();  //todo: verify for a purpose
    }
}
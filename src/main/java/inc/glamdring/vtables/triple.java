package inc.glamdring.vtables;

import java.util.EnumSet;

/**
             * exploring symbolic unions
 */
public enum Triple implements _vtable.$binding<Triple, _vtable.$narrow<String, _ptrait.$$String>> {
$s(4) {{$as$comment$String = "a nondescript element describing 4 bytes.";}
},
$p(4) {{$as$comment$String = "the root predicate metadata";}},
$spkey((Boolean) null) {{$as$comment$String = "depending on how you look at it, this either creates an opaque 8-byte long or a union long value";}},
$o(4),
$tuple(null) {{$as$comment$String = " <u>this</u> functor works against a tuple that is the length of the 3 prior elements.";}},
subject($s),
subject$as$Integer(true) {{
$as$comment$String = "   a declaration in the form of a s,p,o triple\n" +
                     "     the previous block keeps its init'd $as$extent$length$int and struct definition proceeds as normal." +
                     " <ul>\n" +
                     " <li>{@link subject } - the {@link subject } (recursively)\n" +
                     " <li>$as$ - a {@link predicate }\n" +
                     " <li> {@link Integer} - the {@link object}";
}},
subject$as$Uri(true),
subject$as$Graph(true),
subject$as$Triple(true),
predicate($p),
predicate$as$Uri(true),
predicate$as$Function(true),
Triple$index$subjectPredicateKey(null) {{
$as$comment$String = "      this is an 8 byte union and not 12, using 'null' (aka \"prior\") union constructor option.\n" + "<p> why?\n" +
                     "<p>the <clinit>'s \"forward cursor\"  always uses the previous block\n" +
                     "to know what to do. thus even though we have a 12 byte\n" +
                     "struct the previous function element\n" +
                     "only used the first 8 as the object data.\n" +
                     "<p/>\n" + "using the name of the ename \"triple\" implies this is semantically\n" +
                     "a triple reference and not an arbitrary symbol or union.\n" +
                     "<p/>\n" + "$key$ has a different semantic connotation to $as$";
}},
object(false),
object$as$Uri(true),
object$as$Stream(true),
object$as$IndexPointer(true),
triple(null) {{$as$comment$String = "identical to $tuple structurally with its own method(s)";}},
triple$as$Cons(null) {{
$as$comment$String = " change gears to different semantics.\n"
                     + " this gives us CONS data pointer.    ";
}},
car(true) {{$as$comment$String = "we we just cloned \n" + "the entire structure and now we have Triple[2];";}
},
car$as$Triple(car, $tuple.$as$extent$length$int),
cdr(false) {{$as$comment$String = " we just cloned the whole CONS+car {};\n" + "      now Triple[0] started in an array of Triple[4].\n";}},
cdr$as$Triple(cdr, $tuple.$as$extent$length$int) {{$as$comment$String = "a sample functor to return a re-positioned byteBuffer.";}};
String $as$comment$String = "an atomic graph vertice.";
final int $as$extent$length$int;
final int $as$extent$offset$int;
private static int $as$Sequence$length$int;

/**
* the magic happens by this *legal* trickery
*/
private int init(int... dim) {
int offset = dim.length > 1 ? dim[1] : getRecordLen();
$as$Sequence$length$int = Math.max(getRecordLen(), offset + $as$extent$length$int);
return offset;
}

/**
* copy-on-write
*/
private Triple(Triple prototype, Integer... dim) {
$as$extent$offset$int = init($as$extent$length$int = (dim.length > 0 && dim[0] != null && dim[0] >= 0 ? dim[0] : prototype.$as$extent$length$int),
                             dim.length > 1 && dim[1] != null && dim[1] >= 0 ? dim[1] : prototype.$as$extent$offset$int);
}

Triple(int... dim) {
$as$extent$offset$int = init($as$extent$length$int = dim.length > 1 ? dim[1] : 1, dim.length > 1 ? dim[1] : 1);
}

/**
* <h1>union function constructor</h1>
* these initializers allow struct-wide manipulation of the data using seperate functors indexed by seperate ordinals/symbols and abbreviate the effort required to add groups of functions to a single struct.
* the goal here is to provide a simple syntax to add functors to a struct that know exactly which range of bytes they are working with and operate on a union byte extent or the whole.
*
* @param keepOffset whether to reuse previous block(true), or create a successive block(false), or reblock (NULL,[first,last] ) whole or part of the struct
* @param mark       optional defaults of reblocking params.  mark supplies first and last blocks to encompass a new block byte-union.  default marks are first and last, respectively.   if omitted, this provides the enum class a means of delivering itself into it's functor as a single current-rerdSize chunk.
*/
private Triple(Boolean keepOffset, Triple... mark) {
if (keepOffset == null) {
    $as$extent$offset$int = mark.length > 1 ? mark[1].$as$extent$offset$int + mark[1].$as$extent$length$int : 0;
    $as$extent$length$int = mark.length > 0 ? $as$extent$offset$int - mark[0].$as$extent$offset$int : getRecordLen();
    return;
}
Triple prev = values()[ordinal() - 1];
$as$extent$offset$int =
        !keepOffset ? init($as$extent$length$int = prev.$as$extent$length$int) : init($as$extent$length$int = prev.$as$extent$length$int, prev.$as$extent$length$int + prev.$as$extent$offset$int);
}

public int getRecordLen() {return $as$Sequence$length$int;}

public Enum $(_ptrait $) {
return null;  //todo: verify for a purpose
}


public Triple $($narrow<String, _ptrait.$$String> string$$String$narrow) {
return null;  //todo: verify for a purpose
}

public Triple $(Triple triple) {
return null;  //todo: verify for a purpose
}

public <$ extends _ptrait> boolean is(_ptrait $) {
return false;  //todo: verify for a purpose
}

public EnumSet<_ptrait> getPrimaryTraits() {
return null;  //todo: verify for a purpose
}
}

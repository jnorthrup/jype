package inc.glamdring.vtables;

import javolution.lang.Reference;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * exploring symbolic unions
 */
enum Triple implements VTable {
    /**
     *
     */
    $s() {{
        ___doc___ = "a nondescript element describing 4 bytes.";
    }},
    /**
     *
     */
    $p() {{
        ___doc___ = "the root predicate metadata";
    }},
    /**
     *
     */
    $spkey((Boolean) null) {{
        ___doc___ = "depending on how you look at it, this either creates an opaque 8-byte long or a union long value";
    }},
    /**
     *
     */
    $o(),
    $tuple(null) {{
        ___doc___ = " <u>this</u> functor works against a tuple that is the length of the 3 prior elements."
                ;
    }},
    subject($s),
    /**
     */
    subject$as$Integer(true) {{
        ___doc___ = "   a declaration in the form of a s,p,o triple\n" +
                    "           the previous block keeps its init'd size and struct definition proceeds as normal." +
                    "       <ul>\n" +
                    "       <li>{@link subject } - the {@link subject } (recursively)\n" +
                    "       <li>$as$ - a {@link predicate }\n" +
                    "       <li> {@link Integer} - the {@link object}";
    }},
    subject$as$Uri(true),
    subject$as$Graph(true),
    /**
     * this should take us to the subject's graph origin decl (the big IsA)
     */
    subject$as$Triple(true),
    predicate($p),
    predicate$as$Uri(true),
    predicate$as$Function(true),
    /**
     * this is an 8 byte union and not 12, using 'null' (aka "prior") union constructor option.
     * <p> why?
     * <p>the <clinit>'s "cursor"  always uses the previous block
     * to know what to do. thus even though we have a 12 byte
     * struct the previous function element
     * only used the first 8 as the object data.
     * <p/>
     * using the name of the ename "triple" implies this is semantically
     * a triple reference and not an arbitrary symbol or union.
     * <p/>
     * $key$ has a different semantic connotation to $as$
     */
    Triple$index$subjectPredicateKey(null) {{
        ___doc___ = "      this is an 8 byte union and not 12, using 'null' (aka \"prior\") union constructor option.\n" +
                    "      <p> why?\n" +
                    "      <p>the <clinit>'s \"cursor\"  always uses the previous block\n" +
                    "      to know what to do. thus even though we have a 12 byte\n" +
                    "      struct the previous function element\n" +
                    "      only used the first 8 as the object data.\n" +
                    "      <p/>\n" +
                    "      using the name of the ename \"triple\" implies this is semantically\n" +
                    "      a triple reference and not an arbitrary symbol or union.\n" +
                    "      <p/>\n" +
                    "      $key$ has a different semantic connotation to $as$";
    }},
    object(false),
    object$as$Uri(true),
    object$as$Stream(true),
    object$as$IndexPointer(true),

    /**
     *
     */
    triple(null) {{___doc___ = "identical to $tuple structurally with its own method(s)";}},
    /**



     */
    triple$as$Cons(null) {{
        ___doc___ = " change gears to different semantics.\n" +
                    " <p/>                                \n" +
                    " this gives us CONS data pointer.    ";
    }},
    /**
     * we just cloned
     * the entire structure
     */
    car(true) {{
        ___doc___ = "we we just cloned \n" +
                    "the entire structure and now we have Triple[2];";
    }
    },
    car$as$Triple(car, $tuple.size),

    /**
     * we just cloned the whole CONS+car {};
     * <p/>
     * now triple[0] started in an array of triple[4].
     */
    cdr(false) {
        {
            ___doc___ = " we just cloned the whole CONS+car {};\n" +
                        "      now Triple[0] started in an array of Triple[4].\n";
        }
    },
    cdr$as$Triple(cdr, $tuple.size) {
        {
            ___doc___ = "a sample functor to return a re-positioned byteBuffer.";

        }
    };

    String ___doc___ = "an atomic fopl graph vertice.";
    final int size;
    final int offset;
    private static int recordLen;


    /**
     * <h1>union function constructor</h1>
     * these initializers allow struct-wide manipulation of the data using seperate functors indexed by seperate ordinals/symbols and abbreviate the effort required to add groups of functions to a single struct.
     * <p/>
     * <p/>
     * the goal here is to provide a simple way to add functors to a struct that know exactly which range of bytes they are working with and operate on a union byte range of the whole.
     *
     * @param keepOffset whether to reuse previous block(true), or create a successive block(false), or reblock (NULL or {@link Traits#prior }) whole or part of the struct
     * @param mark       optional defaults of reblocking params.  mark supplies first and last blocks to encompass a new block byte-union.  default marks are first and last, respectively.   if omitted, this provides the enum class a means of delivering itself into it's functor as a single current-rerdSize chunk.
     */
    private Triple(Boolean keepOffset, Triple... mark) {
        if (keepOffset == null) {
            offset = mark.length > 1 ? mark[1].offset + mark[1].size :
                     0;
            size = mark.length > 0 ? offset - mark[0].offset : getRecordLen();


        } else {
            Triple prev = values()[ordinal() - 1];
            if (!keepOffset) offset = init(size = prev.size);
            else offset = init(size = prev.size, prev.size + prev.offset);
        }
    }

    private int getRecordLen() {return recordLen;}

    private Triple(Triple prototype, Integer... dim) {

        offset = init(size = (dim.length > 0 && dim[0] != null && dim[0] >= 0 ? dim[0] : prototype.size),
                      dim.length > 1 && dim[1] != null && dim[1] >= 0 ? dim[1] : prototype.offset);
    }

    private int init(int... dim) {
        int offset = dim.length > 1 ? dim[1] : getRecordLen();
        recordLen = Math.max(
                getRecordLen(), offset + size);
        return offset;
    }

    Triple(int... dim) {
//        this.size =size;
        offset = init(size = dim.length > 1 ? dim[1] : 1, dim.length > 1 ? dim[1] : 1);
    }

    public Reference<? extends VTable> $(ByteBuffer heap, byte[] register, IntBuffer stack) {
        return null;  //todo: verify for a purpose
    }

    public boolean is(Traits... isA) {
        return false;  //todo: verify for a purpose
    }

    public VTable as(Traits... as) {
        return null;  //todo: verify for a purpose
    }
}

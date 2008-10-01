package inc.glamdring.vtables;


import java.util.EnumSet;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;


/**
 * User: jim
 * Date: Sep 14, 2008
 * Time: 2:31:31 AM
 */
public enum _ptrait implements _vtable<_ptrait> {
    $Access,
    $Arg,
    $Arity,
    $Array,
    $Big,
    $Binary,
    $Bind,
    $Broadcast,
    $Catchable,
    $Cdestructuring,
    $Compiled,
    $Complex,
    $Complex$Special,
    $Condition,
    $Declaration,
    $Expression,
    $Facade,
    $Factory,
    $File,
    $Form,
    $High,
    $In,
    $Info,
    $Input($In),
    $Interpreted,
    $Invalid,
    $IO,
    $Iterator,
    $Keyword,
    $Low,
    $LTiny,
    $Math,
    $Name,
    $Native,
    $Out,
    $Output($Out),
    $Print,
    $Quarternary,
    $Quintenary,
    $Random,
    $Read,
    $Socket,
    $Special,
    $Synonym,
    $System,
    $Ternary,
    $Test,
    $Text,
    $Throw,
    $Trampoline,
    $Translated,
    $Unary,
    $Unit,
    $User,
    $Utility,
    $Zero,
    $Object {{
        deref = new _deref<Object>();
    }},
    $Sequence($Object) {{
        deref = new _deref<$$Sequence>();
    }class $$Sequence {
    }},
    $List($Sequence) {{
        deref = new _deref<$$List>();
    }class $$List {
    }},
    $Cons($List) {{
        deref = new _deref<$$Cons>();
    }private class $$Cons {
    }},
    $Operator($Object) {{
        deref = new _deref<$$Operator>();
    }class $$Operator {
    }},
    $Function($Operator) {{
        deref = new _deref<$$Function>();
    }class $$Function {
    }},
    $Stream {{
        deref = new _deref<$$Stream>();
    }class $$Stream {
    }},

    $Number {{
        deref = new _deref<Number>();
    }},
    $Input$Stream,
    $Alien,
    $Any {{
        deref = new _deref<$$Any>();
    }class $$Any {
    }},
    $Array$List,
    $Array$Sequence,
    $Benchmark,
    $Big$Int$Bignum,
    $Bignum,
    $Binary$Function,
    $Binary$Stream,
    $Boolean {{
        deref = new _deref<Boolean>();
    }},
    $Broadcast$Stream($Stream) {{
        class $$Broadcast$Stream {
        }
        deref = new _deref<$$Broadcast$Stream>();
    }},
    $Byte,
    $Catchable$Throw,
    $Cdestructuring$Bind,
    $Character($Object) {{
        deref = new _deref<Character>();
    }},
    $Char($Character) {{
        deref = new _deref<Character>();
    }},
    $Character$Name,
    $Compatibility,
    $Compiled$Function($Function, $Operator) {{
        class $$Compiled$Function {
        }
        deref = new _deref<$$Compiled$Function>();
    }},
    $Complex$Special$Form,
    $Condition$Macro,
    $Cons$Facade,
    $Cons$High,
    $Cons$Low,
    $Cons$Pair($Cons) {{
        class $$Cons$Pair {
        }
        deref = new _deref<$$Cons$Pair>();
    }},
    $Double {{
        deref = new _deref<Double>();
    }},
    $Double$Float {{
        class $$Double$Float {
        }
        deref = new _deref<$$Double$Float>();
    }},
    $Dynamic,
    $Environment() {{
        deref = new _deref<$$Environment>();
    }class $$Environment {
    }},
    $Equality,
    $Eval,
    $Exception,
    $Filesys,
    $Fixnum,
    $Float {{
        deref = new _deref<Float>();
    }},
    $Foreign,
    $Format,
    $Function$Arg$List$Description,
    $Guid {{
        deref = new _deref<$$Guid>();
    }class $$Guid {
    }},
    $Hashtable$High,
    $Hashtable$Iterator {{
        class $$Hashtable$Iterator {
        }
        deref = new _deref<$$Hashtable$Iterator>();
    }},
    $Hashtable,
    $In$Out$Binary$Stream($Stream) {{
        class $$In$Out$Binary$Stream {
        }
        deref = new _deref<$$In$Out$Binary$Stream>();
    }},
    $In$Out$Text$Stream($Stream) {{
        class $$In$Out$Text$Stream {
        }
        deref = new _deref<$$In$Out$Text$Stream>();
    }},
    $Input$Binary$Stream($Input$Stream, $Object, $Stream) {{
        class $$Input$Binary$Stream {
        }
        deref = new _deref<$$Input$Binary$Stream>();
    }},
    $Input$Text$Stream($Input$Binary$Stream, $Input$Stream, $Object, $Stream) {{
        class $$Input$Text$Stream {
        }
        deref = new _deref<$$Input$Text$Stream>();
    }},
    $Integer($Number) {{
        deref = new _deref<Integer>();
    }},
    $Int($Integer) {{
        deref = new _deref<Integer>();
    }},
    $Integer$Bignum,
    $Interpreted$Function($Function),
    $Invalid$Expression$Exception,
    $Keyhash {{
        deref = new _deref<$$Keyhash>();
    }class $$Keyhash {
    }},
    $Keyhash$Iterator,
    $Lock {{
        deref = new _deref<Lock>();
    }},
    $Long($Integer) {{
        deref = new _deref<Long>();
    }},
    $Long$Bignum,
    $Macro {{
        deref = new _deref<$$Macro>();
    }class $$Macro {
    }},
    $Mapper,
    $Mapping,
    $Math$Utility,
    $Nil($List) {{
        deref = new _deref<$$Nil>();
    }class $$Nil {
    }},
    $Output$Binary$Stream($Stream) {{
        class $$Output$Binary$Stream {
        }
        deref = new _deref<$$Output$Binary$Stream>();
    }},
    $Output$Stream,
    $Output$Text$Stream($Stream) {{
        class $$Output$Text$Stream {
        }
        deref = new _deref<$$Output$Text$Stream>();
    }},
    $Package {{
        deref = new _deref<$$Package>();
    }class $$Package {
    }},
    $Parser,
    $Print$Function,
    $Print$High,
    $Print$Low,
    $Print$Macro,
    $Process {{
        deref = new _deref<Process>();
    }},
    $Quarternary$Function,
    $Quintenary$Function,
    $Quote,
    $Random$Access$Stream,
    $Read$Write$Lock {{
        class $$Read$Write$Lock {
        }
        deref = new _deref<$$Read$Write$Lock>();
    }},
    $Reader,
    $Regex$Pattern {{
        class $$Regex$Pattern {
        }
        deref = new _deref<$$Regex$Pattern>();
    }},
    $Regex,
    $Resourcer,
    $Semaphore {{
        deref = new _deref<Semaphore>();
    }},
    $Socket$Stream($Object, $In$Out$Text$Stream, $Input$Binary$Stream, $Input$Stream, $Input$Text$Stream, $Output$Binary$Stream, $Output$Stream, $Output$Text$Stream, $Stream) {
        {
            class $$Socket$Stream {
            }
            deref = new _deref<$$Socket$Stream>();
        }
    },
    $Sort,
    $Special$Operator$Declaration,
    $Special$Operator,
    $Storage,
    $Stream$Factory,
    $Stream$Macro,
    $Stream$Nil$Exception,
    $Streams$High,
    $Streams$Low,
    $String($Sequence) {{
        deref = new $$String();
    }},
    $Struct$Interpreted,
    $Struct$Native,
    $Struct($Object) {{
        deref = new _deref<$$Struct>();
    }class $$Struct {
    }},
    $Structure,
    $Sxhash,
    $Symbol$Keyword,
    $Symbol($Object) {{
        deref = new _deref<$$Symbol>();
    }class $$Symbol {
    }},
    $Synonym$Stream($Stream) {{
        class $$Synonym$Stream {
        }
        deref = new _deref<$$Synonym$Stream>();
    }},
    $System$Info,
    $T,
    $Tcp,
    $Ternary$Function,
    $Text$Stream,
    $Thread$Macro,
    $Thread,
    $Time,
    $Time$High,
    $Trampoline$File,
    $Translated$File,
    $Type,
    $Unary$Function,
    $Unit$Test,
    $Unit$Test_Cyc$LTiny,
    $User$IO,
    $Value,
    $Vector($Sequence) {{
        deref = new _deref<$$Vector>();
    }class $$Vector {
    }},
    $Zero$Arity$Function,;


    /**
     * uses its own name as a composition of traits, as well as adding from that which is passed in.
     * <p/>
     * this is almost certainly unfit
     * for general consumption but
     * the metaphoir is desired as
     * a baseline.
     */
    _ptrait(_ptrait... as) {

        for (_ptrait a : as) {
            traits.addAll(a.traits);
        }

        final String[] strings = name().split("$");
        for (String string : strings) {
            final _ptrait ptrait = valueOf("$" + string);
            traits.addAll(ptrait.traits);
        }
    }

    public boolean is(_ptrait ptrait) {
        return false;
    }

    public EnumSet<_ptrait> getPrimaryTraits() {
        return null;
    }

    public int $as$extent$offset$int() {
        return 0;
    }

    public int $as$extent$length$int() {
        return 0;
    }

    public _vtable<?> $(_ptr... p) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }


    _deref deref;

    EnumSet traits;


}



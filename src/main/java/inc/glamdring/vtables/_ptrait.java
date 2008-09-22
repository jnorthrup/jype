package inc.glamdring.vtables;


import java.util.EnumSet;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;

class Operator {
}

class Any {
}

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
    $Streams,
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
    $Object {{deref = new _deref<Object>();}},
    $Sequence($Object) {{deref = new _deref<Sequence>();}},
    $List($Sequence) {{deref = new _deref<List>();}},
    $Cons($List) {{deref = new _deref<Cons>();}},
    $Operator($Object) {{deref = new _deref<Operator>();}},
    $Function($Operator) {{deref = new _deref<Function>();}},
    $Stream {{deref = new _deref<Stream>();}},
    $Input$Stream,
    $Alien,
    $Any {{deref = new _deref<Any>();}},
    $Array$List,
    $Array$Sequence,
    $Benchmark,
    $Big$Int$Bignum,
    $Bignum,
    $Binary$Function,
    $Binary$Stream,
    $Boolean {{deref = new _deref<Boolean>();}},
    $Broadcast$Stream($Stream) {{deref = new _deref<$$Broadcast$Stream>();}class $$Broadcast$Stream {
    }},
    $Byte,
    $Catchable$Throw,
    $Cdestructuring$Bind,
    $Character($Object) {{deref = new _deref<Character>();}},
    $Char($Character) {{deref = new _deref<Character>();}},
    $Character$Name,
    $Compatibility,
    $Compiled$Function($Function, $Operator) {{deref = new _deref<$$Compiled$Function>();}class $$Compiled$Function {
    }},
    $Complex$Special$Form,
    $Condition$Macro,
    $Cons$Facade,
    $Cons$High,
    $Cons$Low,
    $Cons$Pair($Cons) {{deref = new _deref<$$Cons$Pair>();}class $$Cons$Pair {
    }},
    $Double {{deref = new _deref<Double>();}},
    $Double$Float {{deref = new _deref<$$Double$Float>();}class $$Double$Float {
    }},
    $Dynamic,
    $Environment() {{deref = new _deref<Environment>();}},
    $Equality,
    $Eval,
    $Exception,
    $Filesys,
    $Fixnum,
    $Float {{deref = new _deref<Float>();}},
    $Foreign,
    $Format,
    $Function$Arg$List$Description,
    $Guid {{deref = new _deref<Guid>();}},
    $Hashtable$High,
    $Hashtable$Iterator {{deref = new _deref<$$Hashtable$Iterator>();}class $$Hashtable$Iterator {
    }},
    $Hashtable,
    $In$Out$Binary$Stream($Stream) {{deref = new _deref<$$In$Out$Binary$Stream>();}class $$In$Out$Binary$Stream {
    }},
    $In$Out$Text$Stream($Stream) {{deref = new _deref<$$In$Out$Text$Stream>();}class $$In$Out$Text$Stream {
    }},
    $Input$Binary$Stream($Input$Stream, $Object, $Stream) {{deref = new _deref<$$Input$Binary$Stream>();}class $$Input$Binary$Stream {
    }},
    $Input$Text$Stream($Input$Binary$Stream, $Input$Stream, $Object, $Stream) {{deref = new _deref<$$Input$Text$Stream>();}class $$Input$Text$Stream {
    }},
    $Int() {{deref = new _deref<Integer>();}},
    $Integer {{deref = new _deref<Integer>();}},
    $Integer$Bignum,
    $Interpreted$Function($Function),
    $Invalid$Expression$Exception,
    $Keyhash {{deref = new _deref<Keyhash>();}},
    $Keyhash$Iterator,
    $Lock {{deref = new _deref<Lock>();}},
    $Long {{deref = new _deref<Long>();}},
    $Long$Bignum,
    $Macro {{deref = new _deref<Macro>();}},
    $Mapper,
    $Mapping,
    $Math$Utility,
    $Nil($List) {{deref = new _deref<Nil>();}},
    $Number {{deref = new _deref<Number>();}},
    $Output$Binary$Stream($Stream) {{deref = new _deref<$$Output$Binary$Stream>();}class $$Output$Binary$Stream {
    }},
    $Output$Stream,
    $Output$Text$Stream($Stream) {{deref = new _deref<$$Output$Text$Stream>();}class $$Output$Text$Stream {
    }},
    $Package {{deref = new _deref<Package>();}},
    $Parser,
    $Print$Function,
    $Print$High,
    $Print$Low,
    $Print$Macro,
    $Process {{deref = new _deref<Process>();}},
    $Quarternary$Function,
    $Quintenary$Function,
    $Quote,
    $Random$Access$Stream,
    $Read$Write$Lock {{deref = new _deref<$$Read$Write$Lock>();}class $$Read$Write$Lock {
    }},
    $Reader,
    $Regex$Pattern {{deref = new _deref<$$Regex$Pattern>();}class $$Regex$Pattern {
    }},
    $Regex,
    $Resourcer,
    $Semaphore {{deref = new _deref<Semaphore>();}},
    $Socket$Stream($Object, $In$Out$Text$Stream, $Input$Binary$Stream, $Input$Stream, $Input$Text$Stream, $Output$Binary$Stream, $Output$Stream, $Output$Text$Stream, $Stream) {{
        deref = new _deref<$$Socket$Stream>();
    }class $$Socket$Stream {
    }},
    $Sort,
    $Special$Operator$Declaration,
    $Special$Operator,
    $Storage,
    $Stream$Factory,
    $Stream$Macro,
    $Stream$Nil$Exception,
    $Streams$High,
    $Streams$Low,
    $String($Sequence) {{deref = new _deref<String>();}},
    $Struct$Interpreted,
    $Struct$Native,
    $Struct($Object) {{deref = new _deref<Struct>();}},
    $Structure,
    $Sxhash,
    $Symbol$Keyword,
    $Symbol($Object) {{deref = new _deref<Symbol>();}},
    $Synonym$Stream($Stream) {{deref = new _deref<$$Synonym$Stream>();}class $$Synonym$Stream {
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
    $Vector($Sequence) {{deref = new _deref<Vector>();}},
    $Zero$Arity$Function,;

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

    public <$ extends _ptrait> boolean is(_ptrait $) {
        return false;
    }

    public EnumSet<_ptrait> getPrimaryTraits() {
        return null;
    }

    public int getOffset() {
        return 0;
    }

    public int getSize() {
        return 0;
    }

    _deref deref;

    EnumSet traits;


}


class Sequence {
}

class Symbol {
};

class Function {
};

class HashtableIterator {
}

class Struct {
};

class Environment {
}
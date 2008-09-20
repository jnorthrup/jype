package inc.glamdring.vtables;

import java.util.EnumSet;


/**
 * User: jim
 * Date: Sep 14, 2008
 * Time: 2:31:31 AM
 */
public enum  _ptrait implements _vtable  <_ptrait>
{
    $Any,
    $Cons(),
    $ConsPair($Cons),
    $Sequence($Cons),
    $Vector($Sequence),
    $List($Sequence),
    $String($List),
    $Guid,
    $Hashtable,
    $HashtableIterator,
    $Keyhash,
    $Lock,
    $Semaphore($Lock),
    $ReadWriteLock($Lock),
    $Operator,
    $Macro($Operator),
    $Object,
    $Package,
    $Process,
    $RegexPattern,
    $Stream,
    $SocketStream($Stream),
    $BroadcastStream($Stream),
    $OutputBinaryStream($Stream),
    $OutputTextStream($Stream),
    $InOutBinaryStream($Stream),
    $InOutTextStream($Stream),
    $InputBinaryStream($Stream),
    $InputTextStream($Stream),
    $Struct($Cons),
    $Symbol,
    $SynonymStream($Stream),
    $Number,
    $Float($Number),
    $Double($Number),
    $DoubleFloat($Number),
    $Integer($Number),
    $Boolean($Symbol),
    $Character($Integer),
    $Char($Integer, $Character),
    $Int($Integer),
    $Long($Integer),
    $Function,
    $CompiledFunction($Function),
    $Nil($Boolean),;
/*, _$<?>*/


    long caps;

    _ptrait(long caps) {
        this.caps = caps;
    }


    _ptrait(_ptrait... lineage) {
        int c = 1 << ordinal();
        caps = init(c, lineage);
    }



    private static long init(int c, _ptrait[] lineage) {
        for (_ptrait $traits : lineage) {
//            c |= caps;
        }
        return c;
    }

    public <$ extends _ptrait> boolean is(_ptrait $) {
        return false;  //todo: verify for a purpose
    }

    public EnumSet<_ptrait> getPrimaryTraits() {
        return null;  //todo: verify for a purpose
    }

    public int getOffset() {
        return 0;  //todo: verify for a purpose
    }

    public int getSize() {
        return 0;  //todo: verify for a purpose
    }


}


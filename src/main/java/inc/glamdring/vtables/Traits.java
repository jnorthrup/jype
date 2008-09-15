package inc.glamdring.vtables;

/**
 * User: jim
 * Date: Sep 14, 2008
 * Time: 2:31:31 AM
 */
enum Traits {
    $Any, $Cons(),
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
    $Double($Number), $DoubleFloat($Number), $Integer($Number),
    $Boolean($Symbol),
    $Character($Integer),
    $Char($Integer, $Character),
    $Int($Integer),
    $Long($Integer),
    $Function,
    $CompiledFunction($Function),
    $Nil($Boolean),;

    final long caps;

    Traits(long caps) {
        this.caps = caps;
    }


    Traits(Traits... lineage) {
        int c = 1 << ordinal();
        caps = init(c, lineage);
    }

    private static long init(int c, Traits... lineage) {
        for (Traits traits : lineage) {
            c |= traits.caps;
        }
        return c;
    }
}

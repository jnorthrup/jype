package inc.glamdring.vtables;

import com.sun.org.apache.xpath.internal.functions.Function;
import com.sun.tools.internal.xjc.reader.gbind.Sequence;
import javolution.io.Struct;
import org.omg.CORBA.Any;
import sun.awt.Symbol;
import sun.tools.jstat.Operator;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;


/**
 * User: jim
 * Date: Sep 14, 2008
 * Time: 2:31:31 AM
 */
public enum Primary implements $Traits{
    $Any,
    $Cons(),
    $ConsPair($Cons),
    $Sequence($Cons),
    $Vector($Sequence),
    $List($Sequence),
    $String($List),
    $Guid, $Hashtable,
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
/*, VTable<?>*/


    long caps;

    Primary(long caps) {
        this.caps = caps;
    }


    Primary(Primary... lineage) {
        int c = 1 << ordinal();
        caps = init(c, lineage);
    }



    private static long init(int c, Primary[] lineage) {
        for (Primary $traits : lineage) {
//            c |= caps;
        }
        return c;
    }

    public boolean is(Primary primary) {
        return false;  //todo: verify for a purpose
    }

    public long getPrimaryTraits() {
        return 0;  //todo: verify for a purpose
    }


    interface $$Any extends $Traits, VTable.$narrow<Any, $Traits> {<$ extends VTable.$binding.$narrow, $$ extends Any, $$$ extends Class<$$> > $$ $($ $,$$$ $$$); }

    interface $$Cons extends $Traits, VTable.$narrow<Cons, $Traits> {<$ extends VTable.$narrow, $$ extends Cons, $$$ extends Class<$$> > $$ $($ $,$$$ $$$); }

    interface $$ConsPair extends $Traits, VTable.$narrow<ConsPair, $Traits> {<$ extends VTable.$narrow, $$ extends ConsPair, $$$ extends Class<$$> > $$ $($ $,$$$ $$$); }

    interface $$Sequence extends $Traits, VTable.$narrow<Sequence, $Traits> {<$ extends VTable.$narrow, $$ extends Sequence, $$$ extends Class<$$> > $$ $($ $,$$$ $$$); }

    interface $$Vector extends $Traits, VTable.$narrow<Vector, $Traits> {<$ extends VTable.$narrow, $$ extends Vector, $$$ extends Class<$$> > $$ $($ $,$$$ $$$); }

    interface $$List extends $Traits, VTable.$narrow<List, $Traits> {<$ extends VTable.$narrow, $$ extends List, $$$ extends Class<$$> > $$ $($ $,$$$ $$$); }

    interface $$String extends $Traits, VTable.$narrow<String, $Traits> {<$ extends VTable.$narrow, $$ extends String, $$$ extends Class<$$> > $$ $($ $,$$$ $$$); }

    interface $$Guid extends $Traits, VTable.$narrow<Guid, $Traits> {<$ extends VTable.$narrow, $$ extends Guid, $$$ extends Class<$$> > $$ $($ $,$$$ $$$); }

    interface $$HashtableIterator extends $Traits, VTable.$narrow<Iterator<Map.Entry<?,?>>, $Traits> {<$ extends VTable.$narrow, $$ extends Iterator<Map.Entry>, $$$ extends Class<$$> > $$ $($ $,$$$ $$$); }

    interface $$Keyhash extends $Traits, VTable.$narrow<Keyhash, $Traits> {<$ extends VTable.$narrow, $$ extends Keyhash, $$$ extends Class<$$> > $$ $($ $,$$$ $$$); }

    interface $$Lock extends $Traits, VTable.$narrow<Lock, $Traits> {<$ extends VTable.$narrow, $$ extends Lock, $$$ extends Class<$$> > $$ $($ $,$$$ $$$); }

    interface $$Semaphore extends $Traits, VTable.$narrow<Semaphore, $Traits> {<$ extends VTable.$narrow, $$ extends Semaphore, $$$ extends Class<$$> > $$ $($ $,$$$ $$$); }

    interface $$ReadWriteLock extends $Traits, VTable.$narrow<ReadWriteLock, $Traits> {<$ extends VTable.$narrow, $$ extends ReadWriteLock, $$$ extends Class<$$> > $$ $($ $,$$$ $$$); }

    interface $$Operator extends $Traits, VTable.$narrow<Operator, $Traits> {<$ extends VTable.$narrow, $$ extends Operator, $$$ extends Class<$$> > $$ $($ $,$$$ $$$); }

    interface $$Macro extends $Traits, VTable.$narrow<Macro, $Traits> {<$ extends VTable.$narrow, $$ extends Macro, $$$ extends Class<$$> > $$ $($ $,$$$ $$$); }

    interface $$Object extends $Traits, VTable.$narrow<Object, $Traits> {<$ extends VTable.$narrow, $$ extends Object, $$$ extends Class<$$> > $$ $($ $,$$$ $$$); }

    interface $$Package extends $Traits, VTable.$narrow<Package, $Traits> {<$ extends VTable.$narrow, $$ extends Package, $$$ extends Class<$$> > $$ $($ $,$$$ $$$); }

    interface $$Process extends $Traits, VTable.$narrow<Process, $Traits> {<$ extends VTable.$narrow, $$ extends Process, $$$ extends Class<$$> > $$ $($ $,$$$ $$$); }

    interface $$RegexPattern extends $Traits, VTable.$narrow<RegexPattern, $Traits> {<$ extends VTable.$narrow, $$ extends RegexPattern, $$$ extends Class<$$> > $$ $($ $,$$$ $$$); }

    interface $$Stream extends $Traits, VTable.$narrow<Stream, $Traits> {<$ extends VTable.$narrow, $$ extends Stream, $$$ extends Class<$$> > $$ $($ $,$$$ $$$); }

    interface $$SocketStream extends $Traits, VTable.$narrow<SocketStream, $Traits> {<$ extends VTable.$narrow, $$ extends SocketStream, $$$ extends Class<$$> > $$ $($ $,$$$ $$$); }

    interface $$BroadcastStream extends $Traits, VTable.$narrow<BroadcastStream, $Traits> {<$ extends VTable.$narrow, $$ extends BroadcastStream, $$$ extends Class<$$> > $$ $($ $,$$$ $$$); }

    interface $$OutputBinaryStream extends $Traits, VTable.$narrow<OutputBinaryStream, $Traits> {<$ extends VTable.$narrow, $$ extends OutputBinaryStream, $$$ extends Class<$$> > $$ $($ $,$$$ $$$); }

    interface $$OutputTextStream extends $Traits, VTable.$narrow<OutputTextStream, $Traits> {<$ extends VTable.$narrow, $$ extends OutputTextStream, $$$ extends Class<$$> > $$ $($ $,$$$ $$$); }

    interface $$InOutBinaryStream extends $Traits, VTable.$narrow<InOutBinaryStream, $Traits> {<$ extends VTable.$narrow, $$ extends InOutBinaryStream, $$$ extends Class<$$> > $$ $($ $,$$$ $$$); }

    interface $$InOutTextStream extends $Traits, VTable.$narrow<InOutTextStream, $Traits> {<$ extends VTable.$narrow, $$ extends InOutTextStream, $$$ extends Class<$$> > $$ $($ $,$$$ $$$); }

    interface $$InputBinaryStream extends $Traits, VTable.$narrow<InputBinaryStream, $Traits> {<$ extends VTable.$narrow, $$ extends InputBinaryStream, $$$ extends Class<$$> > $$ $($ $,$$$ $$$); }

    interface $$InputTextStream extends $Traits, VTable.$narrow<InputTextStream, $Traits> {<$ extends VTable.$narrow, $$ extends InputTextStream, $$$ extends Class<$$> > $$ $($ $,$$$ $$$); }

    interface $$Struct extends $Traits, VTable.$narrow<Struct, $Traits> {<$ extends VTable.$narrow, $$ extends Struct, $$$ extends Class<$$> > $$ $($ $,$$$ $$$); }

    interface $$Symbol extends $Traits, VTable.$narrow<Symbol, $Traits> {<$ extends VTable.$narrow, $$ extends Symbol, $$$ extends Class<$$> > $$ $($ $,$$$ $$$); }

    interface $$SynonymStream extends $Traits, VTable.$narrow<SynonymStream, $Traits> {<$ extends VTable.$narrow, $$ extends SynonymStream, $$$ extends Class<$$> > $$ $($ $,$$$ $$$); }

    interface $$Number extends $Traits, VTable.$narrow<Number, $Traits> {<$ extends VTable.$narrow, $$ extends Number, $$$ extends Class<$$> > $$ $($ $,$$$ $$$); }

    interface $$Float extends $Traits, VTable.$narrow<Float, $Traits> {<$ extends VTable.$narrow, $$ extends Float, $$$ extends Class<$$> > $$ $($ $,$$$ $$$); }

    interface $$Double extends $Traits, VTable.$narrow<Double, $Traits> {<$ extends VTable.$narrow, $$ extends Double, $$$ extends Class<$$> > $$ $($ $,$$$ $$$); }

    interface $$DoubleFloat extends $Traits, VTable.$narrow<DoubleFloat, $Traits> {<$ extends VTable.$narrow, $$ extends DoubleFloat, $$$ extends Class<$$> > $$ $($ $,$$$ $$$); }

    interface $$Integer extends $Traits, VTable.$narrow<Integer, $Traits> {<$ extends VTable.$narrow, $$ extends Integer, $$$ extends Class<$$> > $$ $($ $,$$$ $$$); }

    interface $$Boolean extends $Traits, VTable.$narrow<Boolean, $Traits> {<$ extends VTable.$narrow, $$ extends Boolean, $$$ extends Class<$$> > $$ $($ $,$$$ $$$); }

    interface $$Character extends $Traits, VTable.$narrow<Character, $Traits> {<$ extends VTable.$narrow, $$ extends Character, $$$ extends Class<$$> > $$ $($ $,$$$ $$$); }

    interface $$Char extends $Traits, VTable.$narrow<Character, $Traits> {<$ extends VTable.$narrow, $$ extends Character, $$$ extends Class<$$> > $$ $($ $,$$$ $$$); }

    interface $$Int extends $Traits, VTable.$narrow<Integer, $Traits> {<$ extends VTable.$narrow, $$ extends Integer, $$$ extends Class<$$> > $$ $($ $,$$$ $$$); }

    interface $$Long extends $Traits, VTable.$narrow<Long, $Traits> {<$ extends VTable.$narrow, $$ extends Long, $$$ extends Class<$$> > $$ $($ $,$$$ $$$); }

    interface $$Function extends $Traits, VTable.$narrow<Function, $Traits> {<$ extends VTable.$narrow, $$ extends Function, $$$ extends Class<$$> > $$ $($ $,$$$ $$$); }

    interface $$CompiledFunction extends $Traits, VTable.$narrow<CompiledFunction, $Traits> {<$ extends VTable.$narrow, $$ extends CompiledFunction, $$$ extends Class<$$> > $$ $($ $,$$$ $$$); }

    interface $$Nil extends $Traits, VTable.$narrow<Nil, $Traits> {<$ extends VTable.$narrow, $$ extends Nil, $$$ extends Class<$$> > $$ $($ $,$$$ $$$); }


}


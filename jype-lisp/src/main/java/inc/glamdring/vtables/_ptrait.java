package inc.glamdring.vtables;


import java.lang.reflect.*;
import java.util.EnumSet;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;


/**
 * User: jim
 * Date: Sep 14, 2008
 * Time: 2:31:31 AM
 */
public enum _ptrait implements _vtable<_ptrait>, _proto<Ω> {
    $Object {{
        Ω = new Ω<Object>();
    }}, $Access,
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

    $Sequence($Object) {{
        Ω = new Ω<£Sequence>();
    }class £Sequence {
    }},
    $List($Sequence) {{
        Ω = new Ω<£List>();
    }class £List {
    }},
    $Cons($List) {{
        Ω = new Ω<£Cons>();
    }class £Cons {
    }},
    $Operator($Object) {{
        Ω = new Ω<£Operator>();
    }class £Operator {
    }},
    $Function($Operator) {{
        Ω = new Ω<£Function>();
    }class £Function {
    }},
    $Stream {{
        Ω = new Ω<£Stream>();
    }class £Stream {
    }},

    $Number {{
        Ω = new Ω<Number>();
    }},
    $Input$Stream,
    $Alien,
    $Any {{
        Ω = new Ω<£Any>();
    }class £Any {
    }},
    $Array$List,
    $Array$Sequence,
    $Benchmark,
    $Big$Int$Bignum,
    $Bignum,
    $Binary$Function,
    $Binary$Stream,
    $Boolean {{
        Ω = new Ω<Boolean>();
    }},
    $Broadcast$Stream($Stream) {{
        class £Broadcast$Stream {
        }
        Ω = new Ω<£Broadcast$Stream>();
    }},
    $Byte,
    $Catchable$Throw,
    $Cdestructuring$Bind,
    $Character($Object) {{
        Ω = new Ω<Character>();
    }},
    $Char($Character) {{
        Ω = new Ω<Character>();
    }},
    $Character$Name,
    $Compatibility,
    $Compiled$Function($Function, $Operator) {{
        class £Compiled$Function {
        }
        Ω = new Ω<£Compiled$Function>();
    }},
    $Complex$Special$Form,
    $Condition$Macro,
    $Cons$Facade,
    $Cons$High,
    $Cons$Low,
    $Cons$Pair($Cons) {{
        class £Cons$Pair {
        }
        Ω = new Ω<£Cons$Pair>();
    }},
    $Double {{
        Ω = new Ω<Double>();
    }},
    $Double$Float {{
        class £Double$Float {
        }
        Ω = new Ω<£Double$Float>();
    }},
    $Dynamic,
    $Environment() {{
        Ω = new Ω<£Environment>();
    }class £Environment {
    }},
    $Equality,
    $Eval,
    $Exception,
    $Filesys,
    $Fixnum,
    $Float {{
        Ω = new Ω<Float>();
    }},
    $Foreign,
    $Format,
    $Function$Arg$List$Description,
    $Guid {{
        Ω = new Ω<£Guid>();
    }class £Guid {
    }},
    $Hashtable$High,
    $Hashtable$Iterator {{
        class £Hashtable$Iterator {
        }
        Ω = new Ω<£Hashtable$Iterator>();
    }},
    $Hashtable,
    $In$Out$Binary$Stream($Stream) {{
        class £In$Out$Binary$Stream {
        }
        Ω = new Ω<£In$Out$Binary$Stream>();
    }},
    $In$Out$Text$Stream($Stream) {{
        class £In$Out$Text$Stream {
        }
        Ω = new Ω<£In$Out$Text$Stream>();
    }},
    $Input$Binary$Stream($Input$Stream, $Object, $Stream) {{
        class £Input$Binary$Stream {
        }
        Ω = new Ω<£Input$Binary$Stream>();
    }},
    $Input$Text$Stream($Input$Binary$Stream, $Input$Stream, $Object, $Stream) {{
        class £Input$Text$Stream {
        }
        Ω = new Ω<£Input$Text$Stream>();
    }},
    $Integer($Number) {{
        Ω = new Ω<Integer>();
    }},
    $Int($Integer) {{
        Ω = new Ω<Integer>();
    }},
    $Integer$Bignum,
    $Interpreted$Function($Function),
    $Invalid$Expression$Exception,
    $Keyhash {{
        Ω = new Ω<£Keyhash>();
    }class £Keyhash {
    }},
    $Keyhash$Iterator,
    $Lock {{
        Ω = new Ω<Lock>();
    }},
    $Long($Integer) {{
        Ω = new Ω<Long>();
    }},
    $Long$Bignum,
    $Macro {{
        Ω = new Ω<£Macro>();
    }class £Macro {
    }},
    $Mapper,
    $Mapping,
    $Math$Utility,
    $Nil($List) {{
        Ω = new Ω<£Nil>();
    }class £Nil {
    }},
    $Output$Binary$Stream($Stream) {{
        class £Output$Binary$Stream {
        }
        Ω = new Ω<£Output$Binary$Stream>();
    }},
    $Output$Stream,
    $Output$Text$Stream($Stream) {{
        class £Output$Text$Stream {
        }
        Ω = new Ω<£Output$Text$Stream>();
    }},
    $Package {{
        Ω = new Ω<£Package>();
    }class £Package {
    }},
    $Parser,
    $Print$Function,
    $Print$High,
    $Print$Low,
    $Print$Macro,
    $Process {{
        Ω = new Ω<Process>();
    }},
    $Quarternary$Function,
    $Quintenary$Function,
    $Quote,
    $Random$Access$Stream,
    $Read$Write$Lock {{
        class £Read$Write$Lock {
        }
        Ω = new Ω<£Read$Write$Lock>();
    }},
    $Reader,
    $Regex$Pattern {{
        class £Regex$Pattern {
        }
        Ω = new Ω<£Regex$Pattern>();
    }},
    $Regex,
    $Resourcer,
    $Semaphore {{
        Ω = new Ω<Semaphore>();
    }},
    $Socket$Stream($Object, $In$Out$Text$Stream, $Input$Binary$Stream, $Input$Stream, $Input$Text$Stream, $Output$Binary$Stream, $Output$Stream, $Output$Text$Stream, $Stream) {
        {
            class £Socket$Stream {
            }
            Ω = new Ω<£Socket$Stream>();
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
//        Ω = new ΩString();
    }},
    $Struct$Interpreted,
    $Struct$Native,
    $Struct($Object) {{
        Ω = new Ω<£Struct>();
    }class £Struct {
    }},
    $Structure,
    $Sxhash,
    $Symbol$Keyword,
    $Symbol($Object) {{
        Ω = new Ω<£Symbol>();
    }class £Symbol {
    }},
    $Synonym$Stream($Stream) {{
        class £Synonym$Stream {
        }
        Ω = new Ω<£Synonym$Stream>();
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
        Ω = new Ω<£Vector>();
    }class £Vector {
    }},
    $Zero$Arity$Function,;


    Ω Ω;
    private EnumSet<_ptrait> traits;
    private _ptrait[] as;

    /**
     * uses its own name as a composition of traits, as well as adding from that which is passed in.
     * <p/>
     * this is almost certainly unfit
     * for general consumption but
     * the metaphoir is desired as
     * a baseline.
     */
    _ptrait(_ptrait... as) {
        this.as = as;
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

    public Ω<?> $() {
        return Ω;
    }

    public Ω reify(µ void$) {
        return Ω;  //todo: verify for a purpose
    }


    public static void main(String[] a) {

        final Class<_ptrait> ptraitClass = _ptrait.class;
        final Package aPackage = ptraitClass.getPackage();


        classMeta(ptraitClass);

        final Enum<?>[] constants = ptraitClass.getEnumConstants();

        for (
                Enum<?> constant
                : constants)

        {

            final Class<? extends Enum<?>> declaringClass = constant.getDeclaringClass();
            final int modifiers = declaringClass.getModifiers();
            final String s = Modifier.toString(modifiers);
//            System.err.println(" + " + s);
        }
    }

    private static void classMeta(Class ptraitClass) {
        if (null == ptraitClass) return;
        final TypeVariable[] typeVariables = ptraitClass.getTypeParameters();
        System.err.println("" + ptraitClass);
//        System.err.println("" + Arrays.toString(typeVariables));
        for (TypeVariable typeVariable : typeVariables) {
            System.err.println("" + typeVariable);
            final Type[] bounds = typeVariable.getBounds();

            for (Type bound : bounds) {
                System.err.println("" + bound);
                if (bound instanceof ParameterizedType)
                    System.err.println("" + bound );//+ "" + Arrays.toString(((ParameterizedType)
                            //(bound)).getActualTypeArguments()));
                else {
                    final Type type = ((Class) bound).getSuperclass();
                    classMeta((Class) type);
                }
            }
            final GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();
            final TypeVariable<?>[] typeVariables1 = genericDeclaration.getTypeParameters();
            for (TypeVariable<?> variable : typeVariables1) {
                System.err.println("" + variable);
            }
        }

        for (Type type : ptraitClass.getInterfaces()) {
            System.err.println("" + type);
            if (type instanceof Class)
                classMeta((Class) type);
            else {
                final Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();

                for (Type actualTypeArgument : actualTypeArguments) {
                    System.err.println("" + actualTypeArgument);
                }
            }
        }

    }


    public EnumSet<_ptrait> getTraits() {
        if (traits == null) {
            traits = EnumSet.of(this);
            for (_ptrait a : as) {
                traits.add(a);
            }

            System.err.println("" + String.valueOf(traits) + "");
            final String[] strings = name().split("$");
            for (String string : strings) {
                _ptrait ptrait = null;
                try {
                    ptrait = valueOf("$" + string);
                    traits.addAll(ptrait.getTraits());
                } catch (IllegalArgumentException e) {
                }
            }
        }
        System.err.println("" + String.valueOf(traits) + "");
        return this.traits;
    }
}




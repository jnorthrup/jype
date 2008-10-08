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
public enum _ptrait implements _vtable<_ptrait>, _proto<£> {
    $Object {{
        £ = new £<Object>();
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
        £ = new £<£Sequence>();
    }class £Sequence {
    }},
    $List($Sequence) {{
        £ = new £<£List>();
    }class £List {
    }},
    $Cons($List) {{
        £ = new £<£Cons>();
    }class £Cons {
    }},
    $Operator($Object) {{
        £ = new £<£Operator>();
    }class £Operator {
    }},
    $Function($Operator) {{
        £ = new £<£Function>();
    }class £Function {
    }},
    $Stream {{
        £ = new £<£Stream>();
    }class £Stream {
    }},

    $Number {{
        £ = new £<Number>();
    }},
    $Input$Stream,
    $Alien,
    $Any {{
        £ = new £<£Any>();
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
        £ = new £<Boolean>();
    }},
    $Broadcast$Stream($Stream) {{
        class £Broadcast$Stream {
        }
        £ = new £<£Broadcast$Stream>();
    }},
    $Byte,
    $Catchable$Throw,
    $Cdestructuring$Bind,
    $Character($Object) {{
        £ = new £<Character>();
    }},
    $Char($Character) {{
        £ = new £<Character>();
    }},
    $Character$Name,
    $Compatibility,
    $Compiled$Function($Function, $Operator) {{
        class £Compiled$Function {
        }
        £ = new £<£Compiled$Function>();
    }},
    $Complex$Special$Form,
    $Condition$Macro,
    $Cons$Facade,
    $Cons$High,
    $Cons$Low,
    $Cons$Pair($Cons) {{
        class £Cons$Pair {
        }
        £ = new £<£Cons$Pair>();
    }},
    $Double {{
        £ = new £<Double>();
    }},
    $Double$Float {{
        class £Double$Float {
        }
        £ = new £<£Double$Float>();
    }},
    $Dynamic,
    $Environment() {{
        £ = new £<£Environment>();
    }class £Environment {
    }},
    $Equality,
    $Eval,
    $Exception,
    $Filesys,
    $Fixnum,
    $Float {{
        £ = new £<Float>();
    }},
    $Foreign,
    $Format,
    $Function$Arg$List$Description,
    $Guid {{
        £ = new £<£Guid>();
    }class £Guid {
    }},
    $Hashtable$High,
    $Hashtable$Iterator {{
        class £Hashtable$Iterator {
        }
        £ = new £<£Hashtable$Iterator>();
    }},
    $Hashtable,
    $In$Out$Binary$Stream($Stream) {{
        class £In$Out$Binary$Stream {
        }
        £ = new £<£In$Out$Binary$Stream>();
    }},
    $In$Out$Text$Stream($Stream) {{
        class £In$Out$Text$Stream {
        }
        £ = new £<£In$Out$Text$Stream>();
    }},
    $Input$Binary$Stream($Input$Stream, $Object, $Stream) {{
        class £Input$Binary$Stream {
        }
        £ = new £<£Input$Binary$Stream>();
    }},
    $Input$Text$Stream($Input$Binary$Stream, $Input$Stream, $Object, $Stream) {{
        class £Input$Text$Stream {
        }
        £ = new £<£Input$Text$Stream>();
    }},
    $Integer($Number) {{
        £ = new £<Integer>();
    }},
    $Int($Integer) {{
        £ = new £<Integer>();
    }},
    $Integer$Bignum,
    $Interpreted$Function($Function),
    $Invalid$Expression$Exception,
    $Keyhash {{
        £ = new £<£Keyhash>();
    }class £Keyhash {
    }},
    $Keyhash$Iterator,
    $Lock {{
        £ = new £<Lock>();
    }},
    $Long($Integer) {{
        £ = new £<Long>();
    }},
    $Long$Bignum,
    $Macro {{
        £ = new £<£Macro>();
    }class £Macro {
    }},
    $Mapper,
    $Mapping,
    $Math$Utility,
    $Nil($List) {{
        £ = new £<£Nil>();
    }class £Nil {
    }},
    $Output$Binary$Stream($Stream) {{
        class £Output$Binary$Stream {
        }
        £ = new £<£Output$Binary$Stream>();
    }},
    $Output$Stream,
    $Output$Text$Stream($Stream) {{
        class £Output$Text$Stream {
        }
        £ = new £<£Output$Text$Stream>();
    }},
    $Package {{
        £ = new £<£Package>();
    }class £Package {
    }},
    $Parser,
    $Print$Function,
    $Print$High,
    $Print$Low,
    $Print$Macro,
    $Process {{
        £ = new £<Process>();
    }},
    $Quarternary$Function,
    $Quintenary$Function,
    $Quote,
    $Random$Access$Stream,
    $Read$Write$Lock {{
        class £Read$Write$Lock {
        }
        £ = new £<£Read$Write$Lock>();
    }},
    $Reader,
    $Regex$Pattern {{
        class £Regex$Pattern {
        }
        £ = new £<£Regex$Pattern>();
    }},
    $Regex,
    $Resourcer,
    $Semaphore {{
        £ = new £<Semaphore>();
    }},
    $Socket$Stream($Object, $In$Out$Text$Stream, $Input$Binary$Stream, $Input$Stream, $Input$Text$Stream, $Output$Binary$Stream, $Output$Stream, $Output$Text$Stream, $Stream) {
        {
            class £Socket$Stream {
            }
            £ = new £<£Socket$Stream>();
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
        £ = new £String();
    }},
    $Struct$Interpreted,
    $Struct$Native,
    $Struct($Object) {{
        £ = new £<£Struct>();
    }class £Struct {
    }},
    $Structure,
    $Sxhash,
    $Symbol$Keyword,
    $Symbol($Object) {{
        £ = new £<£Symbol>();
    }class £Symbol {
    }},
    $Synonym$Stream($Stream) {{
        class £Synonym$Stream {
        }
        £ = new £<£Synonym$Stream>();
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
        £ = new £<£Vector>();
    }class £Vector {
    }},
    $Zero$Arity$Function,;


    £ £;
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

    public £<?> $() {
        return £;
    }

    public £ reify($ void$) {
        return £;  //todo: verify for a purpose
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



package inc.glamdring;

//import inc.glamdring.bitecode.TableRecord;

import static inc.glamdring.EnumPackageAssemblyUtil.Backbone.*;
import javolution.util.FastMap;

import java.io.*;
import static java.io.File.createTempFile;
import static java.lang.Package.getPackage;
import static java.lang.System.currentTimeMillis;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.*;


public class EnumPackageAssemblyUtil {
    private static final String EOL = "\n";
    private static final Map<CharSequence, String> INTRINSICS = new FastMap<CharSequence, String>();
    private static final String[] ISAREFS = new String[]{"Record", "Value", "Header", "Ref", "Info"};
    private static final String ISA_MODS = Modifier.toString(Modifier.STATIC | Modifier.FINAL | Modifier.PUBLIC);
    static final Map<Class<?>, Pair<String, Pair<String, String>>> bBufWrap = new LinkedHashMap<Class<?>, Pair<String, Pair<String, String>>>();

    static {
        bBufWrap.put(char.class, new Pair<String, Pair<String, String>>("Char", new Pair<String, String>("char", "")));
        bBufWrap.put(int.class, new Pair<String, Pair<String, String>>("Int", new Pair<String, String>("int", "")));
        bBufWrap.put(long.class, new Pair<String, Pair<String, String>>("Long", new Pair<String, String>("long", "")));
        bBufWrap.put(short.class, new Pair<String, Pair<String, String>>("Short", new Pair<String, String>("short", " & 0xffff")));
        bBufWrap.put(double.class, new Pair<String, Pair<String, String>>("Double", new Pair<String, String>("double", "")));
        bBufWrap.put(float.class, new Pair<String, Pair<String, String>>("Float", new Pair<String, String>("float", "")));
        bBufWrap.put(byte[].class, new Pair<String, Pair<String, String>>("", new Pair<String, String>("byte", " & 0xff")));
        bBufWrap.put(byte.class, new Pair<String, Pair<String, String>>("", new Pair<String, String>("byte", " & 0xff")));
        INTRINSICS.put("___recordlen___",
                       "/**\n" +
                       "     * the length of one record\n" +
                       "     */\n\t" +
                       Modifier.toString(Modifier.STATIC | Modifier.PUBLIC) + " int ___recordlen___;");
        INTRINSICS.put("___size___",
                       "/**\n" +
                       "     * the size per field, if any\n" +
                       "     */\n\t" +
                       Modifier.toString(Modifier.FINAL | Modifier.PUBLIC) + " int ___size___;");
        INTRINSICS.put("___seek___",
                       "/**\n" +
                       "     * the offset from record-start of the field\n" +
                       "     */\n\t" +
                       Modifier.toString(Modifier.FINAL | Modifier.PUBLIC) + " int ___seek___;");
        INTRINSICS.put("___subrecord___",
                       "/**\n" +
                       "     * a delegate class which will perform sub-indexing on behalf of a field once it has marked its initial starting\n" +
                       "     * offset into the stack.\n" +
                       "     */\n" +
                       "\tpublic Class<? extends Enum> ___subrecord___;");
        INTRINSICS.put("___valueclass___",
                       "/**\n" +
                       "     * a hint class for bean-wrapper access to data contained.\n" +
                       "     */\n" +
                       "\tpublic Class ___valueclass___;");
        for (String isaref : ISAREFS)
            INTRINSICS.put("___is" + isaref + "___", "");
    }
//
//    public String getEnumsStructsForPackage() throws Exception {
//        return createEnumStructSourceFiles(TableRecord.class);
//    }

    public static String createEnumStructSourceFiles(final Class tableRecordClass) throws Exception {

        Map<Class<? extends Enum>, Iterable<? extends Enum>> map = PackageAssembly.getEnumsStructsForPackage(tableRecordClass.getPackage());
        Set<Entry<Class<? extends Enum>, Iterable<? extends Enum>>> entries = map.entrySet();

        String generated = "";
        String enumName = "";
        for (Entry<Class<? extends Enum>, Iterable<? extends Enum>> entry : entries)
            generated += createEnumMiddle(tableRecordClass, entry);
        return generated;
    }


    static String createEnumMiddle(Class<Enum<?>> tableRecordClass, Entry<Class<? extends Enum>, Iterable<? extends Enum>> entry) throws IOException {

        String generated = "";
        String enumName;
        Class<? extends Enum> enumClazz = entry.getKey();
        Iterable<? extends Enum> parentEnum = entry.getValue();
        enumName = enumClazz.getSimpleName();
        String fn = ("src/main/hybrid/" + tableRecordClass.getPackage().getName() + "/" + enumName).replace(".", "/") + ".java";
        System.err.println("attempting to open " + fn);
        final File file = new File(fn);
        file.getParentFile().mkdirs();
        file.createNewFile();
        OutputStreamWriter ostream = new FileWriter(file);
        System.err.println("*** Dumping " + file.getCanonicalPath() + "\t" + file.toURI().toASCIIString());

        generated += "public enum " + enumName + " { " + EOL;


        generated += renderConstantFields(enumClazz) + ";\n";
        String result = renderBaseEnumFields(enumClazz);

        generated += result + "    /** " + enumName + " templated Byte Struct \n" +
                     "     * @param dimensions [0]=___size___,[1]= forced ___seek___\n" +
                     "     */\n";


        generated += "\t" + enumName + " ";

        generated += "(int... dimensions) {\n" +
                     "        int[] dim = init(dimensions);\n" +
                     "        ___size___ = dim[0];\n" +
                     "        ___seek___ = dim[1];\n" +
                     "\n" +
                     "    }\n" +
                     "\n" +
                     "    int[] init(int... dimensions) {\n" +
                     "        int size = dimensions.length > 0 ? dimensions[0] : 0,\n" +
                     "                seek= dimensions.length > 1 ? dimensions[1] : 0;\n" +
                     "\n" +
                     "        if (___subrecord___ == null) {\n" +
                     "            final String[] indexPrefixes = {\"\", \"s\", \"_\", \"Index\", \"Length\", \"Ref\", \"Header\", \"Info\", \"Table\"};\n" +
                     "            for (String indexPrefix : indexPrefixes) {\n" +
                     "                try {\n" +
                     "                    ___subrecord___ = (Class<? extends Enum>) Class.forName(getClass().getPackage().getName() + '.' + name() + indexPrefix);\n" +
                     "                    try {\n" +
                     "                        size = ___subrecord___.getField(\"___recordlen___\").getInt(null);\n" +
                     "                    } catch (Exception e) {\n" +
                     "                    }\n" +
                     "                    break;\n" +
                     "                } catch (ClassNotFoundException e) {\n" +
                     "                }\n" +
                     "            }\n" +
                     "        }\n" +
                     "\n" +
                     "        for (String vPrefixe1 : new String[]{\"_\", \"\", \"$\", \"Value\",}) {\n" +
                     "            if (___valueclass___ != null) break;\n" +
                     "            String suffix = vPrefixe1;\n" +
                     "            for (String name1 : new String[]{name().toLowerCase(), name(),}) {\n" +
                     "                if (___valueclass___ != null) break;\n" +
                     "                final String trailName = name1;\n" +
                     "                if (trailName.endsWith(suffix)) {\n" +
                     "                    for (String aPackage1 : new String[]{\"\",\n" +
                     "                            getClass().getPackage().getName() + \".\",\n" +
                     "                            \"java.lang.\",\n" +
                     "                            \"java.util.\",\n" +
                     "                    })\n" +
                     "                        if (___valueclass___ == null) break;\n" +
                     "                        else\n" +
                     "                            try {\n" +
                     "                                ___valueclass___ = Class.forName(aPackage1 + name().replace(suffix, \"\"));\n" +
                     "                            } catch (ClassNotFoundException e) {\n" +
                     "                            }\n" +
                     "                }\n" +
                     "            }\n" +
                     "        }\n" +
                     "\n" +
                     "        seek = ___recordlen___;\n" +
                     "        ___recordlen___ += size;\n" +
                     "\n" +
                     "        return new int[]{size, seek};\n" +
                     "    }" +
                     "\n" +
                     "    /**\n" +
                     "     * The struct's top level method for indexing 1 record. Each Enum field will call SubIndex\n" +
                     "     *\n" +
                     "     * @param src      the ByteBuffer of the input file\n" +
                     "     * @param register array holding values pointing to Stack offsets\n" +
                     "     * @param stack    A stack of 32-bit pointers only to src positions\n" +
                     "     */\n" +
                     "    static void index\n" +
                     "            (ByteBuffer src, int[] register, IntBuffer stack) {\n" +
                     "        for (" + enumName + " " + enumName + "_ : values()) {\n" +
                     "            String hdr = " + enumName + "_.name();\n" +
                     "            System.err.println(\"hdr:pos \" + hdr + ':' + stack.position());\n" +
                     "            " + enumName + "_.subIndex(src, register, stack);\n" +
                     "        }\n" +
                     "    }\n" +
                     "\n" +
                     "    /**\n" +
                     "     * Each of the Enums can override thier deault behavior of \"___seek___-past\"\n" +
                     "     *\n" +
                     "     * @param src      the ByteBuffer of the input file\n" +
                     "     * @param register array holding values pointing to Stack offsets\n" +
                     "     * @param stack    A stack of 32-bit pointers only to src positions\n" +
                     "     */\n" +
                     "    private void subIndex(ByteBuffer src, int[] register, IntBuffer stack) {\n" +
                     "        System.err.println(name() + \":subIndex src:stack\" + src.position() + ':' + stack.position());\n" +
                     "        int begin = src.position();\n" +
                     "        int stackPtr = stack.position();\n" +
                     "        stack.put(begin);\n" +
                     "        if (___isRecord___ && ___subrecord___ != null) { \n" +
                     "            /* " +
                     "                try {\n" +
                     "                final " + tableRecordClass.getCanonicalName() + " table = " + tableRecordClass.getCanonicalName() + ".valueOf(___subrecord___.getSimpleName());\n" +
                     "                if (table != null) {\n" +
                     "                    //stow the original location\n" +
                     "                    int mark = stack.position();\n" +
                     "                    stack.position((register[TopLevelRecord.TableRecord.ordinal()] + table.___seek___) / 4);\n" +
                     "                    ___subrecord___.getMethod(\"index\", ByteBuffer.class, int[].class, IntBuffer.class).invoke(null);\n" +
                     "                    //resume the lower stack activities\n" +
                     "                    stack.position(mark);\n" +
                     "                }\n" +
                     "            } catch (Exception e) {\n" +
                     "                throw new Error(e.getMessage());\n" +
                     "            }\n*/" +
                     "        }\n" +
                     "    }";

        final String postScript = generated += "}\n" +
                                               "//@@ #end" + enumName + "";

        try {

            String t = "";
            t += "package " + "" + enumClazz.getPackage().getName() + ";";
            t += "\n" + "import java.nio.*;";
            t += "\n" + "import java.lang.reflect.*;";


            String eclazz = genHeader(enumClazz);
            generated = t + eclazz + generated;
//        } catch (NoSuchFieldException e) {
        } catch (Exception e) {
            e.printStackTrace();
        }

        ostream.write(generated);
        ostream.close();
        generated = "";
        return generated;
    }

    private static String renderBaseEnumFields(Class<? extends Enum> enumClazz) {
        String result = "";

        try {

            final Field[] fields = enumClazz.getFields();

            String s1 = "";
            for (Field field : fields) {
                String z = field.toGenericString().replaceAll(enumClazz.getCanonicalName() + ".", "");
                if (field.getType() != enumClazz && !INTRINSICS.containsKey(field.getName()))
                    s1 += "\t" + z + ";" + EOL;
            }

            if (s1.length() > 4)
                result += s1 + EOL;

            for (String isaref : ISAREFS) {
                INTRINSICS.put("is" + isaref, ISA_MODS + " boolean " + "___is" + isaref + "___=" + enumClazz.getSimpleName().endsWith(isaref) + ';');
            }


            for (String field : INTRINSICS.values()) {

                result += "\t" + field + EOL;
            }

        } catch (SecurityException e) {
            e.printStackTrace();  //todo: verify for a purpose
        } catch (Exception e) {
        }
        return result;
    }

    static String renderConstantFields(Class<? extends Enum> enumClazz) {
        boolean first = true;

        String result = "";
        String pname = enumClazz.getPackage().getName();
        for (Enum instance : enumClazz.getEnumConstants()) {
            try {
                String symbol = instance.name();


                result += (first ? "" : ",") + symbol.replaceAll(pname + ".", "(");
                first = false;
                try {
                    final Field[] fields = enumClazz.getFields();
                    String tmpString = "";
                    for (Field field : fields) {
                        try {
                            Field doc = enumClazz.getField("___doc___");
                            Object o1 = doc.get(enumClazz);
                            if (null != o1) {
                                tmpString += o1.toString();
                            }
                        } catch (Exception e) {
                        }

                        String attrName = field.getName().replaceAll(enumClazz.getCanonicalName(), "");
                        if (attrName.equals("___size___")) {
                            final Integer integer = (Integer) field.get(instance);
                            if (integer != 0)
                                result = result + "(0x" + Integer.toHexString(integer) + ")";
                        } else {
                            if (field.getType() != enumClazz && (field.getModifiers() & (Modifier.STATIC | Modifier.FINAL)) == 0) {
                                final Object o = field.get(instance);
                                if (o != null && !o.equals(0))
                                    tmpString += "\n\t\t" + attrName + "=" + (field.getType() == Class.class
                                                                              ? ((Class) o).getCanonicalName() + ".class" :
                                                                              field.getType() == String.class
                                                                              ? '"' + String.valueOf(o).trim() + '"' :
                                                                              String.valueOf(o)) + ";";
                            }
                        }
                    }
                    if (tmpString.length() > 4)
                        result += "\t{{" + tmpString + "\n\t}}" + EOL;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static String genHeader(Class<? extends Enum> docEnum) throws NoSuchFieldException {

        String generated = "";
        final Enum[] enums = docEnum.getEnumConstants();

        int recordLen = 0;
        try {
            recordLen = (Integer) docEnum.getDeclaredField("___recordlen___").get(null);
        } catch (Exception e) {
            recordLen = 0;
        }
        generated += "\n\n/**\n * <p>recordSize: " + recordLen + "\n * <table><tr> " +
                     "<th>name</th>" +
                     "<th>size</th>" +
                     "<th>seek</th>" +
                     "<th>description</th>" +
                     "<th>Value Class</th>" +
                     "<th>Sub-Index</th>" +
                     "</tr>\n";

        for (final Enum theSlot : enums) {
/*
            int ___size___ = 0, ___seek___ = 0;
            Class ___subrecord___ = null;
            Class ___valueclass___ = null;

            final String[] strings = {"___subrecord___", "___valueclass___", "___size___", "___seek___", "___doc___"};

            final Object[] objects = reflectedState(theSlot, strings);
            int j = 0;
            ___subrecord___ = (Class) objects[j++];
            ___valueclass___ = (Class) objects[j++];
            try {
                ___size___ = (Integer) objects[j++];
            } catch (Exception e) {
                ___size___ = 4;
            }
            try {
                ___seek___ = (Integer) objects[j++];
            } catch (Exception e) {
                ___seek___ = 0;
            }

            String ___doc___ = "";
            try {
                ___doc___ = (String) objects[j++];
            } catch (Exception e) {
            }

            if (___valueclass___ == null) {
                ___valueclass___ = guessIntTypes(___size___);
            }

*/

            try {
                final EnumMap<Backbone, Future<?>> map = _();
                generated += new Callable<String>() {
                    public String call() throws Exception {

                        final Class<?> ___valueclass___ = (Class<?>) map.get(Backbone.___valueclass___).get();
                        final Integer seek = (Integer) map.get(___seek___).get();
                        final Class<? extends Enum<?>> ___subrecord___ = (Class<? extends Enum<?>>) map.get(Backbone.___subrecord___).get();
                        final Integer ___size___ = (Integer) map.get(Backbone.___size___).get();
                        final String ___doc___ = (String) map.get(Backbone.___doc___).get();
                        final Pair<String, Pair<String, String>> pair = bBufWrap.get(___valueclass___);

                        return " * <tr>" + "<td>" + theSlot.name() + "</td>" + "<td>0x" + Integer.toHexString(___size___)
                               + "</td>" + "<td>0x" + Integer.toHexString(seek)
                               + "</td>" + "<td>" + (___doc___ == null ? "" : ___doc___)
                               + "</td>" + "<td>"
                               + (___valueclass___ == null ? " (" + pair.getSecond().getFirst()
                                                   + ") " + theSlot.name()
                                                   + "=src.get" + pair.getFirst()
                                                   + "(0x" + Integer.toHexString(seek)
                                                   + ")" + pair.getSecond().getSecond() : ___valueclass___.getCanonicalName())
                               + "</td>" + "<td>{@link " + (___subrecord___ == null
                                                            ? theSlot.getDeclaringClass().getSimpleName()
                                                              + "Visitor#" + theSlot.name()
                                                              + "(ByteBuffer, int[], IntBuffer)"
                                                            : (___subrecord___).getCanonicalName())
                               + "}</td>" + "</tr>\n";
                    }
                }.call();
            } catch (Exception e) {
                e.printStackTrace();  //TODO: verify for a purpose
            }

        }

        generated += " * \n";

        for (
                Enum theSlot
                : enums)

        {
            generated += " * @see " + docEnum.getCanonicalName() + "#" + theSlot.name() + '\n';
        }

        generated += " * </table>\n";

        generated += " */\n";


        return generated;
    }

    private static Object[] reflectedState(Enum theSlot, String... strings) {
        final Object[] objects = new Object[strings.length];


        for (int i = 0; i < strings.length; i++) {
            String string = strings[i];
            shootMe(theSlot, objects, i, string);
        }
        return objects;
    }

    private static void shootMe(Enum theSlot, Object[] objects, int i, String string) {
        try {
            objects[i] = theSlot.getDeclaringClass().getDeclaredField(string).get(theSlot);
        } catch (Exception e) {
        }
    }


    private Object[] getSubRecord(Enum enum_) {
        final String[] suffixes = {"", "s", "_", "Index", "Value", "Ref", "Header", "Info"};
        for (String indexPrefix : suffixes) {
            try {
                final String p = enum_.getDeclaringClass().getPackage().getName();
                final String name = p + '.' + enum_.name() + indexPrefix;
                final Class<?> aClass = Class.forName(name);
                final int anInt = aClass.getField("___recordlen___").getInt(null);
                if (aClass != null)
                    return new Object[]{aClass, anInt};

            } catch (Exception e) {
            }
        }
        return null;
    }

    public static Class guessIntTypes(int size, Class... clazz) {
        Class layout_clazz;
        if (clazz.length == 0) {
            switch (size) {
                case 1:
                    layout_clazz = byte.class;
                    break;
                case 2:
                    layout_clazz = short.class;
                    break;
                case 4:
                    layout_clazz = int.class;
                    break;
                case 8:
                    layout_clazz = long.class;
                    break;
                default:
                    layout_clazz = byte[].class;
                    break;
            }
        } else {
            layout_clazz = clazz[0];
        }
        return layout_clazz;
    }

    public void testPackage(Package... p) throws Exception {
        String packageName = (p.length > 0 ? p[0] : getClass().getPackage()).getName();
        for (Class<? extends Enum> aClass : PackageAssembly.getEnumsForPackage(getPackage(packageName))) {

            Field[] fields = aClass.getFields();
            String[] fn = new String[fields.length];

            for (int i = 0; i < fn.length; i++)
                fn[i] = fields[i].toGenericString();

            System.err.println(aClass.getSimpleName() + Arrays.toString(fn).replaceAll(",", ",\n\t").replaceAll(packageName + ".", ""));
        }
    }

    public static void main(String... args) throws Exception {
        final String dirName = args.length > 0 ? "target/classes" : args[0];
        final String indexName = (String) ((args.length < 1) ?
                                           new File(createTempFile("__BC__" + currentTimeMillis(), "rw"), "bitecode").getAbsolutePath() : args[1]);

        File index = getIndexFile(indexName);

    }

    /**
     * make a best-attempt at creating or opening an index file for later sizing
     *
     * @param indexName -
     * @return a file for index writings/reads
     * @throws FileNotFoundException
     */
    static File getIndexFile(String indexName) throws FileNotFoundException {
        for (int i = 0; i < 2; i++)
            try {
                File raf = new File(indexName, "rw");
                if (!raf.isFile()) {
                    raf.getParentFile().mkdirs();
                } else return raf;
            } catch (Exception e) {
                System.err.println("");
            }
        return null;
    }

    enum Backbone {
        ___subrecord___,
        ___valueclass___ {
            Future _(Backbone theSlot, final EnumMap<Backbone, Future<?>> state) throws ExecutionException, InterruptedException {
                final Future<?> result;
                result = state.get(this);
                if (null == result.get()) {
                    return REFLECTION_POOL.submit(new Callable<Object>() {
                        public Object call() throws Exception {
                            return guessIntTypes((Integer) ((Future<?>) state.get(___size___)).get());
                        }
                    });
                }
                return result;
            }},
        ___size___,
        ___seek___,
        ___doc___,;
        private static ExecutorService REFLECTION_POOL= Executors.newCachedThreadPool();

        Future _(final Backbone theSlot, final EnumMap<Backbone, Future<?>> state) throws ExecutionException, InterruptedException {
            return REFLECTION_POOL.submit(new Callable<Object>() {
                public Object call() throws Exception {
                    return state.put(Backbone.this, (Future<?>) REFLECTION_POOL.submit(new Callable<Object>() {
                        public Object call() throws Exception {
                            return ((Enum<?>) theSlot).getDeclaringClass().getDeclaredField(name()).get(theSlot);
                        }
                    }));
                }
            });
        }

        public static EnumMap<Backbone, Future<?>> _() {
            return new EnumMap<Backbone, Future<?>>(Backbone.class) {
                Future<? > get(Backbone k) throws ExecutionException, InterruptedException {
                    return (Future<?>) (containsKey(k) ? get(k) : _());
                }
            };
        }
    }
}

//
//package inc.glamdring.util;
//
//import java.io.*;
//import java.net.*;
//import java.util.*;
//import java.util.jar.*;
//import java.util.logging.*;


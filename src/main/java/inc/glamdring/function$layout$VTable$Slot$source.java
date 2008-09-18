package inc.glamdring;

//import inc.glamdring.bitecode.TableRecord;


import inc.glamdring.vtables.Sequence$Slot$layout$Enum$layout;
import inc.glamdring.vtables.Function$infer$Type;
import static inc.glamdring.vtables.Sequence$Slot$layout$Enum$layout.*;

import java.io.*;
import static java.io.File.createTempFile;
import static java.lang.Integer.toHexString;
import static java.lang.Package.getPackage;
import static java.lang.System.currentTimeMillis;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.*;

//private static final String[] ISAREFS = new String[]{"Record", "Value", "Header", "Ref", "Info"};
//enum ISAREFS {
//    Record, Value, Header, Ref, Info;
//
//
//
//    }
//    static {        for (ISAREFS isaref : ISAREFS.values())
//            TRAITMARKERS.put("$IsA$"+isaref+"$", "");
//}
//
//    private final static FastMap<String, String> TRAITMARKERS;
//
//    static {TRAITMARKERS = new FastMap<String, String>();}


public class function$layout$VTable$Slot$source {
    private static final String EOL = "\n";
    private static final ExecutorService REFLECTION_POOL = Executors.newCachedThreadPool();
//    private static final EnumMap< , String> INTRINSICS = new EnumMap<Sequence$Slot, String>(sequence$Slot.class);


    static {
//        static.$$$();
//         INTRINSICS.put($as$extent$length$int,
//                       "/**\n" + $as$extent$length$int.$(new Object()));
//
//        Modifier.toString(Modifier.STATIC | Modifier.PUBLIC) + " int $as$Sequence$length;");
//        INTRINSICS.put($as$extent$length$int,
//                       "/**\n" +
//                       "     * the size per field, if any\n" +
//                       "     */\n\t" +
//                       Modifier.toString(Modifier.FINAL | Modifier.PUBLIC) + " int $as$length;");
//        INTRINSICS.put(sequence$Slot.$as$extent$offset$int,
//                       "/**\n" +
//                       "     * the offset from record-start of the field\n" +
//                       "     */\n\t" +
//                       Modifier.toString(Modifier.FINAL | Modifier.PUBLIC) + " int $as$offset;");
//        INTRINSICS.put(sequence$Slot.$as$Symbol$String,
//                       "/**\n" +
//                       "     * a delegate class which will perform sub-indexing on behalf of a field once it has marked its initial starting\n" +
//                       "     * offset into the stack.\n" +
//                       "     */\n" +
//                       "\tpublic Class<? extends Enum> $as$symbol;");
//        INTRINSICS.put(sequence$Slot.$as$value$type$class,
//                       "/**\n" +
//                       "     * a hint class for bean-wrapper access to data contained.\n" +
//                       "     */\n" +
//                       "\tpublic Class $as$type;");
    }

    //    public String getEnumsStructsForPackage() throws Exception {
//        return createEnumStructSourceFiles(TableRecord.class);
//    }

    public static String createEnumStructSourceFiles(final Class tableRecordClass) throws Exception {

        Map<Class<? extends Enum>, Iterable<? extends Enum>> map = PackageAssembly.getEnumsStructsForPackage(tableRecordClass.getPackage());
        Set<Entry<Class<? extends Enum>, Iterable<? extends Enum>>> entries = map.entrySet();

        String generated = "";
        String enumName = "";
        for (Entry<Class<? extends Enum>, Iterable<? extends Enum>> entry : entries)
            generated += createEnumMiddle(
                    tableRecordClass, entry);
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
                     "     * @param dimensions [0]=$as$length,[1]= forced $as$offset\n" +
                     "     */\n";


        generated += "\t" + enumName + " ";

        generated += "(int... dimensions) {\n" +
                     "        int[] dim = init(dimensions);\n" +
                     "        $as$length = dim[0];\n" +
                     "        $as$offset = dim[1];\n" +
                     "\n" +
                     "    }\n" +
                     "\n" +
                     "    int[] init(int... dimensions) {\n" +
                     "        int size = dimensions.length > 0 ? dimensions[0] : 0,\n" +
                     "                seek= dimensions.length > 1 ? dimensions[1] : 0;\n" +
                     "\n" +
                     "        if ($as$symbol == null) {\n" +
                     "            final String[] indexPrefixes = {\"\", \"s\", \"$\", \"Index\", \"Length\", \"Ref\", \"Header\", \"Info\", \"Table\"};\n" +
                     "            for (String indexPrefix : indexPrefixes) {\n" +
                     "                try {\n" +
                     "                    $as$symbol = (Class<? extends Enum>) Class.forName(getClass().getPackage().getName() + '.' + name() + indexPrefix);\n" +
                     "                    try {\n" +
                     "                        size = $as$symbol.getField(\"$as$Sequence$length\").getInt(null);\n" +
                     "                    } catch (Exception e) {\n" +
                     "                    }\n" +
                     "                    break;\n" +
                     "                } catch (ClassNotFoundException e) {\n" +
                     "                }\n" +
                     "            }\n" +
                     "        }\n" +
                     "\n" +
                     "        for (String vPrefixe1 : new String[]{\"$\", \"\", \"$\", \"Value\",}) {\n" +
                     "            if ($as$type != null) break;\n" +
                     "            String suffix = vPrefixe1;\n" +
                     "            for (String name1 : new String[]{name().toLowerCase(), name(),}) {\n" +
                     "                if ($as$type != null) break;\n" +
                     "                final String trailName = name1;\n" +
                     "                if (trailName.endsWith(suffix)) {\n" +
                     "                    for (String aPackage1 : new String[]{\"\",\n" +
                     "                            getClass().getPackage().getName() + \".\",\n" +
                     "                            \"java.lang.\",\n" +
                     "                            \"java.util.\",\n" +
                     "                    })\n" +
                     "                        if ($as$type == null) break;\n" +
                     "                        else\n" +
                     "                            try {\n" +
                     "                                $as$type = Class.forName(aPackage1 + name().replace(suffix, \"\"));\n" +
                     "                            } catch (ClassNotFoundException e) {\n" +
                     "                            }\n" +
                     "                }\n" +
                     "            }\n" +
                     "        }\n" +
                     "\n" +
                     "        seek = $as$Sequence$length;\n" +
                     "        $as$Sequence$length += size;\n" +
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
                     "        for (" + enumName + " " + enumName + "$ : values()) {\n" +
                     "            String hdr = " + enumName + "$.name();\n" +
                     "            System.err.println(\"hdr:pos \" + hdr + ':' + stack.position());\n" +
                     "            " + enumName + "$.subIndex(src, register, stack);\n" +
                     "        }\n" +
                     "    }\n" +
                     "\n" +
                     "    /**\n" +
                     "     * Each of the Enums can override thier deault behavior of \"$as$offset-past\"\n" +
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
                     "        if (___isRecord___ && $as$symbol != null) { \n" +
                     "            /* " +
                     "                try {\n" +
                     "                final " + tableRecordClass.getCanonicalName() + " table = " + tableRecordClass.getCanonicalName() + ".valueOf($as$symbol.getSimpleName());\n" +
                     "                if (table != null) {\n" +
                     "                    //stow the original location\n" +
                     "                    int mark = stack.position();\n" +
                     "                    stack.position((register[TopLevelRecord.TableRecord.ordinal()] + table.$as$offset) / 4);\n" +
                     "                    $as$symbol.getMethod(\"index\", ByteBuffer.class, int[].class, IntBuffer.class).invoke(null);\n" +
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

    private static String renderBaseEnumFields(final Class<? extends Enum> enumClazz) {
        String result = "";

        try {

            final Field[] fields = enumClazz.getFields();

            String s1 = "";
            for (Field field : fields) {
                String z = field.toGenericString().replaceAll(enumClazz.getCanonicalName() + ".", "");
                if (enumClazz != field.getType()
                    && null != Sequence$Slot$layout$Enum$layout.valueOf(field.getName())) {
                    s1 += "\t" + z + ";" + EOL;
                    //TODO -- handle symbol collisions with $as$comment$String and others by using $$as$comment$String
                }

            }

            if (s1.length() > 4)
                result += s1 + EOL;

/*
            for (ISAREFS isaref : ISAREFS.values()) {
                TRAITMARKERS.put("is" + isaref, ISA_MODS + " boolean " + "$IsA$" + isaref + "$=" + enumClazz.getSimpleName().endsWith(isaref) + ';');
            }
*/


            for (Sequence$Slot$layout$Enum$layout field : Sequence$Slot$layout$Enum$layout.values()) {

                    result += "\t" + field + EOL;
            }

//            for (String field : TRAITMARKERS.values()) {
//                result += "\t" + field + EOL;
//            }

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
                            Field doc = enumClazz.getField("$as$comment");
                            Object o1 = doc.get(enumClazz);
                            if (null != o1) {
                                tmpString += o1.toString();
                            }
                        } catch (Exception e) {
                        }

                        String attrName = field.getName().replaceAll(enumClazz.getCanonicalName(), "");
                        if (attrName.equals("$as$length")) {
                            final Integer integer = (Integer) field.get(instance);
                            if (integer != 0)
                                result = result + "(0x" + toHexString(integer) + ")";
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
            recordLen = (Integer) docEnum.getDeclaredField("$as$Sequence$length").get(null);
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
            int $as$length = 0, $as$offset = 0;
            Class $as$symbol = null;
            Class $as$type = null;

            final String[] strings = {"$as$symbol", "$as$type", "$as$length", "$as$offset", "$as$comment"};

            final Object[] objects = reflectedState(theSlot, strings);
            int j = 0;
            $as$symbol = (Class) objects[j++];
            $as$type = (Class) objects[j++];
            try {
                $as$length = (Integer) objects[j++];
            } catch (Exception e) {
                $as$length = 4;
            }
            try {
                $as$offset = (Integer) objects[j++];
            } catch (Exception e) {
                $as$offset = 0;
            }

            String $as$comment = "";
            try {
                $as$comment = (String) objects[j++];
            } catch (Exception e) {
            }

            if ($as$type == null) {
                $as$type = guessIntTypes($as$length);
            }

*/

            try {
                final String map = Sequence$Slot$layout$Enum$layout.$(theSlot);
//                generated += new Callable<String>() {
//                    public String call() throws Exception {
//
//                        final Class<?> $as$value = (Class<?>) map.get($as$Value$Type$Class).get();
//                        final Integer $as$offset = (Integer) map.get($as$extent$offset$int).get();
//                        final Class<? extends Enum<?>> ___subrecord___ = (Class<? extends Enum<?>>) map.get( $as$Visitor$VTable$Symbol$String).get();
//                        final Integer $as$length = (Integer) map.get($as$extent$length$int
//                        ).get();
//                        final String $as$comment = (String) map.get($as$comment$String).get();
////                        final Pair<String, Pair<String, String>> pair = Function$infer$Type.$(Sequence$Slot$layout$Enum$layout.$as$Value$Type$Class.$(map));
//                        Class futureValtype =
//                                Function$infer$Type.$($as$length);
//
//                        final String slotOpen = " * <tr>";
//                        final String attributeOpen = "<td>";
//                        final String attributeClose = "</td>";
//                        final Class<?> $value$Type = futureValtype.get();
//                        final String longClassName = $value$Type.getCanonicalName();
//                        return slotOpen + attributeOpen + theSlot.name() + attributeClose + attributeOpen +
//                               (as$String$as$Hex($as$length))
//                               + attributeClose + attributeOpen + (as$String$as$Hex($as$offset))
//                               + attributeClose + attributeOpen + ($as$comment == null ? "" : $as$comment)
//                               + attributeClose + attributeOpen
//                               + ($as$value == null
//                                  ? " (" + longClassName
//                                    + ") " + theSlot.name()
//                                    + "=src.get" + $value$Type.getName()
//                                    + "(" +
//                                    (as$String$as$Hex($as$offset))
//                                    + ")" + pair.getSecond().getSecond() : $as$value.getCanonicalName())
//                               + attributeClose + attributeOpen +
//                               "{@link " + (___subrecord___ == null
//                                            ? theSlot.getDeclaringClass().getSimpleName()
//                                              + "Visitor#" + theSlot.name()
//                                              + "(ByteBuffer, int[], IntBuffer)"
//                                            : (___subrecord___).getCanonicalName())
//                               + "}</td>" + "</tr>\n";
//                    }
//                }.call();
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

    private static String as$String$as$Hex(Integer $s) {
        return "0x" + toHexString($s);
    }

    @Deprecated
    private static Object[] reflectedState(Enum theSlot, String... strings) {
        final Object[] objects = new Object[strings.length];


        for (int i = 0; i < strings.length; i++) {
            String string = strings[i];
            shootMe(theSlot, objects, i, string);
        }
        return objects;
    }

    @Deprecated
    private static void shootMe(Enum theSlot, Object[] objects, int i, String string) {
        try {
            objects[i] = theSlot.getDeclaringClass().getDeclaredField(string).get(theSlot);
        } catch (Exception e) {
        }
    }


    private Object[] getSubRecord(Enum enum_) {
        final String[] suffixes = {"", "s", "$", "Index", "Value", "Ref", "Header", "Info"};
        for (String indexPrefix : suffixes) {
            try {
                final String p = enum_.getDeclaringClass().getPackage().getName();
                final String name = p + '.' + enum_.name() + indexPrefix;
                final Class<?> aClass = Class.forName(name);
                final int anInt = aClass.getField("$as$Sequence$length").getInt(null);
                if (aClass != null)
                    return new Object[]{aClass, anInt};

            } catch (Exception e) {
            }
        }
        return null;
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
     * @param indexName filename
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

}

//
//package inc.glamdring.util;
//
//import java.io.*;
//import java.net.*;
//import java.util.*;
//import java.util.jar.*;
//import java.util.logging.*;


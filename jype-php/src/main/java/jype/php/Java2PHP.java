package jype.php;

import java.io.*;
import java.lang.reflect.*;
import java.nio.*;
import static java.util.Arrays.*;
import java.util.*;

public class Java2PHP {
    boolean myBool = true;
    static final String STRING = "string";
    char[] chars;
    Boolean b;
    Class[] classes;
    static final Set<Class> HAS_BOOL = new HashSet<Class>(asList(Boolean.class, boolean.class));
    static final Set<Class> HAS_STRING = new HashSet<Class>(asList(CharSequence.class, char[].class, String.class, CharBuffer.class));

    /**
     * converts Java camel case to PHP lower case and underscores. 
     * @param javaName
     * @return
     */
    public static String getPhpName(String javaName) {
        String phpName;
        String upperCaseName = javaName.toUpperCase();
        if (upperCaseName.equals(javaName)) {
            phpName = javaName.toLowerCase();
        } else {
            phpName = "" + (char) (javaName.toLowerCase().charAt(0));
            char[] javaNameChars = javaName.toCharArray();
            for (int i = 1; i < javaNameChars.length; i++) {
                char ch = javaNameChars[i];
                if (Character.isUpperCase(ch)) {
                    phpName += "_" + (char) (ch + 32);
                } else {
                    phpName += (char) ch;
                }
            }
        }

        return phpName;
    }

    /**
     * This method does all the hard yards
     * @param cl
     */
    public static void getPHPCode(Class<?> cl) {
        HashMap<String, String> functionNames = new HashMap<String, String>();

        try {
            if (!cl.isInterface()) {
                String fileName = cl.getCanonicalName().replace('.', '/');
                int index = fileName.lastIndexOf('/');
                String dirName = fileName.substring(0, index);
                File directory = new File(dirName);
                if (!directory.exists()) {
                    System.out.println("Making Directory: '" + dirName + "'");
                    directory.mkdirs();
                }

                final String simpleName = cl.getSimpleName();
                String name = simpleName;
                final String name1 = name + ".php";
                name = getPhpName(name1);
                final String fname = dirName + "/" + name;
                final Writer out = new OutputStreamWriter(System.out);

                Class parent = cl.getSuperclass();

                writePreamble(simpleName, out, parent);


                for (Field field : cl.getDeclaredFields()) {

                    out.write("var $" + field.getName());

                    final Class<?> type = field.getType();
                    if (isFinal(field)) {
                        try {
                            Object o = field.get(field);
                            if (HAS_STRING.contains(type)
                                    ) {
                                String s = (String) o;
                                s.replace("\"", "\\\"");
                                o = "\"" + s + "\"";
                            }
                            ;
                            Object v;
                            try {
                                o = type.getMethod("valueOf", o.getClass()).invoke(null, o);


//                        String.valueOf()
                            } catch (InvocationTargetException e) {
//                        e.printStackTrace();
                            } catch (NoSuchMethodException e) {
//                        e.printStackTrace();  //TODO: Verify for a purpose
                            }
                            v = String.valueOf(o);
                            out.write("=" + v);
                        } catch (IllegalAccessException e) {
//                    e.printStackTrace();

                        }
                    }
                    out.write(";\n");

                }

                out.write("\n");

                //process constructor
                out.write("  function " + getPhpName(simpleName) + "(\n");
//                Field last = fields[fields.length - 1];
//                boolean first=true;
//               final  boolean first = true;

                Field first = null;
                for (Field field : cl.getDeclaredFields()) {
                    if (first==null ) first=field;
                    
                    if (!isFinal(field)) {
                        String name2 = getPhpName(getPhpName(field.getName()));



                        if (field !=first) out.write(",\n");

                        out.write("  \t$" + ("new_") + name2);
                        
                    }
                }
                out.write("  ){\n");

                //parameter type check
                out.write("    if(\n");

                boolean isFirst = true;
//                first=true;
                for (Field field : cl.getDeclaredFields()) {
                    Type t = field.getType();
                    if (!isFinal(field)) {
                        boolean isClass = t.toString().indexOf("class") >= 0;
                        boolean isString = t.toString().indexOf("class java.lang.String") >= 0;

                        if (isClass && isString || !isClass) {
                            if (isFirst) {
                                isFirst = false;
                                out.write("      ");
                            } else {
                                out.write("      || ");
                            }

                            String name2 = getPhpName(getPhpName(field.getName()));

                            out.write("!is_" + field.getType().getName() + "( $" + ("new_") + name2 + ")\n");
                        }
                    }
                }
                out.write("    )\n");
                out.write("    {\n");
                out.write("      $error = \"Error creating class of type " + simpleName + ". Invalid Variable Type\";\n");
                out.write("      trigger_error($error, E_USER_ERROR);\n");
                out.write("      return new exception($error);\n");
                out.write("    }\n");
                out.write("\n");

                for (Field field : cl.getDeclaredFields()) {
                    if (!isFinal(field)) {
                        String name2 = getPhpName(getPhpName(field.getName()));


                        String name3 = getPhpName(field.getName());

                        out.write("    $this->" +
                                name3 + " = $" + ("new_") +
                                name2 + ";\n");
                    }
                }

                out.write("  }\n");
                out.write("\n");

                for (Field field : cl.getDeclaredFields()) {
                    name = field.getName();
                    if (0 != (field.getModifiers() & Modifier.FINAL)) {
//                        name = getPhpName(field.getName());

                        String functionName = ("get_") + name;
                        functionNames.put(functionName, functionName);
                        out.write("  function " + functionName + "()\n");
                        out.write("  {\n");

                        if (!isFinal(field)) {
                            out.write("    return $this->" + name + ";\n");
                        } else {
                            {

//                            throw new Error();
                            }
                        }
                        out.write("  }\n");
                        out.write("\n");

                        functionName = "set_" + name;
                        functionNames.put(functionName, functionName);


                        out.write("  function " + functionName + "($" + ("new_") + name + ")\n");
                        out.write("  {\n");


                        out.write("    $this->" + ("") + name +
                                " = $" + ("new_") +
                                name + ";\n");
                        out.write("  }\n");
                        out.write("\n");
                    }
                }

                //out.writeln("Function Names: '"+functionNames+"'");
                 for (Method method : cl.getMethods()) {

                    Type[] parameterTypes = method.getParameterTypes();
                    Type returnType = method.getReturnType();
                    String returnTypeStr = (returnType.toString().equals("class java.lang.String") ? "string" : returnType.toString());
                    String methodName = getPhpName(method.getName());
                    if (functionNames.get(methodName) == null && !methodName.equals("to_string")) {
                        out.write("  /**\n");
                        out.write("   * This method ...\n");
                        for (Type parameterType : parameterTypes) {
                            out.write("   * @param $" + parameterType + "\n");
                        }
                        out.write("   * @return " + returnTypeStr + "\n");
                        out.write("   */\n");
                        out.write("  function " + methodName + "(");
                        for (int j = 0; j < parameterTypes.length; j++) {
                            out.write(parameterTypes[j].toString());
                            out.write((j < parameterTypes.length - 1 ? "," : ""));
                        }
                        out.write(")\n");
                        out.write("  {\n");
                        if (!returnTypeStr.equals("void")) {
                            out.write("    $return_value = null;\n");
                        }

                        out.write("    //todo\n");
                        out.write("\n");
                        out.write("\n");
                        if (!returnTypeStr.equals("void")) {
                            out.write("    return $return_value;\n");
                        }
                        out.write("  }\n");
                        out.write("\n");
                    }

                }

                //output is_<object> function
                out.write("}\n");
                out.write("\n");
                out.write("function is_" + getPhpName(simpleName) + "( $object )\n");
                out.write("{\n");
                out.write("  return ( get_class ( $object ) == \"" + getPhpName(simpleName) + "\" );\n");
                out.write("}\n");
                out.write("\n");

                //output to_string function                        
                out.write("function get_" + getPhpName(simpleName) + "_string()\n");
                out.write("{\n");
                out.write("  $string = \"" + getPhpName(simpleName) + "_class[\" .\n");
//                first = true;
                for (Field field : cl.getDeclaredFields()) {


                    String name2 = getPhpName(field.getName());
                    String name3 = getPhpName(field.getName());

                    out.write("  \"" + name3 +
                            "=[\" . " + ("get_") + name2 + "() . \"]");
                    if (field!=first) {
                        out.write(("\" .") + "\n");
                    }

                }
                out.write("]");
                out.write("\n");
                out.write("  return $string;\n");
                out.write("}\n");
                out.write("\n");

                out.write("?>\n");
                out.close();
            }

        } catch (IOException ioEx) {
            ioEx.printStackTrace();
        }
    }

    private static boolean isFinal(Field field) {

        return (field.getModifiers() & Modifier.FINAL) != 0;
    }

    public static void writePreamble(String simpleName, Writer out, Class parent) throws IOException {
        out.write("<?php\n");
        out.write("\n");
        out.write("/**\n");
        out.write(" * Title: " + simpleName + "\n");
        out.write(" * Description: \n");
        out.write(" * Copyright: Copyright (c) 2006\n");
        out.write(" *\n");
        out.write(" * $Author:\n");
        out.write(" * $Date:\n");
        out.write(" * $Revision:\n");
        out.write(" */\n");
        out.write("\n");
        out.write("class " + getPhpName(simpleName) + (parent.getName().equals("java.lang.Object") ? "" : " extends " + getPhpName(parent.getSimpleName())) + "\n");
        out.write("{\n");
    }

    public static void main(String[] args) {


        getPHPCode(Appendable.class);


    }
}

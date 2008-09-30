/*
 * Created by IntelliJ IDEA.
 * User: root
 * Date: May 27, 2002
 * Time: 3:20:09 PM
 * To change template for new class use
 * Code Style | Class Templates options (Tools | IDE Options).
 */
package net.sourceforge.gui;

import javax.swing.*;
import static javax.swing.JOptionPane.YES_OPTION;
import static javax.swing.JOptionPane.showConfirmDialog;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;


public class TextPanel extends JPanel {
    private JLabel label;
    private JTextComponent textField;

    public TextPanel(String name) {
        super(new BorderLayout());

        this.label = new JLabel(name);
        this.textField = new JTextField();
        label.setLabelFor(textField);
        this.add(label, BorderLayout.WEST);
        this.add(textField, BorderLayout.CENTER);
        doLayout();
    }

    public JLabel getLabel() {
        return label;
    }

    public JTextComponent getTextField() {
        return textField;
    }

    public String getText() {
        return getTextField().getText();
    }

    public void setText(String text) {
        getTextField().setText(text);
    }


}

class Subject {

    int age = new Random(System.currentTimeMillis()).nextInt(99);
    String city = "SmallVille";

    Subject(int age, String city) {
        this.age = age;
        this.city = city;
    }

    public Subject() {
        this(new Random(System.currentTimeMillis()).nextInt(99), "AnyTown");

    }

    public String toString() {

//        XStream x = new XStream();
//        final String s = x.toXML(this);
//        return s;
        String s = "";
        try {
            final Class<?> aClass = Class.forName("com.thoughtworks.xstream.XStream");

            final Object xstream = aClass.newInstance();
            final Method method = aClass.getMethod("toXML", Object.class);
            final Object o = method.invoke(xstream, this);
            s += "" + o+
                    "\n";
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  //TODO: verify for a purpose
        } catch (InstantiationException e) {
            e.printStackTrace();  //TODO: verify for a purpose
        } catch (IllegalAccessException e) {
            e.printStackTrace();  //TODO: verify for a purpose
        } catch (NoSuchMethodException e) {
            e.printStackTrace();  //TODO: verify for a purpose
        } catch (InvocationTargetException e) {
            e.printStackTrace();  //TODO: verify for a purpose
        } finally {


            return s + "{ Subject: " +
                   " age: " + age +
                                  " city: " + city +
                                                   " }";
        }
    }
}

class PojoForm {
    private Field[] declaredFields;
    private final Object pojo;
    private final int length;
    private final TextPanel[] panels;
    private final JPanel panel;
    private final Class<? extends Object> pojoClass;


    static public void main(String[] a) {


        Subject subject = new Subject();

        System.err.println("before:" + subject.toString());

        new PojoForm(subject);

        System.err.println("   after: " + subject.toString());

    }

    PojoForm(final Object pojo) {
        this.pojo = pojo;

        pojoClass = pojo.getClass();
        declaredFields = pojoClass.getDeclaredFields();
        length = pojoClass.getDeclaredFields().length;
        panels = new TextPanel[length];
        panel = new JPanel(new GridLayout(1, length));

        for (int i = 0; i < panels.length; i++) {

            TextPanel textPanel = panels[i] = new TextPanel("sasdsdasdasda");
            textPanel.setText(String.valueOf(pojo));
            textPanel.getLabel().setText(toString());
            panel.add(textPanel, 0, i);

        }
        panel.doLayout();
        final int i = editPojo();
        if (i == YES_OPTION)
            updatePojo();
    }

    private void updatePojo() {
//        declaredFields = pojo.getClass().getDeclaredFields();
//        int length = declaredFields.length;
//        panels = new TextPanel[length];

        for (int i = 0; i < this.length; i++) {

            Field declaredField = declaredFields[i];
            try {


                Class fClass;
                Object orig = declaredField.get(pojo);

                if (null == orig)
                    fClass = (Class) declaredField.getGenericType();
                else
                    fClass = orig.getClass();

                Method method = null;
                String newVal = panels[i].getText();

                Object boxed = newVal;
                try {
                    method = fClass.getMethod("valueOf", String.class);
                    boxed = method.invoke(orig, newVal);
                } catch (NoSuchMethodException e) {
                } catch (SecurityException e) {
                }

                declaredField.set(pojo, boxed);

            } catch (IllegalAccessException e) {
            } catch (InvocationTargetException e) {
            }
        }
    }

    private int editPojo() {

        //        TextPanel textPanel;

        for (int i = 0; i < length; i++) {
            Field declaredField = declaredFields[i];
            String fname = declaredField.getName();
            String ftype = declaredField.toGenericString();
            TextPanel textPanel = panels[i];
            JLabel jLabel = textPanel.getLabel();
            jLabel.setText(fname);
            jLabel.setToolTipText(ftype);
            try {
                Object fval = declaredField.get(this.pojo);
                String fstr = String.valueOf(fval);
                textPanel.getTextField().setToolTipText("orig: " + fstr);
                textPanel.setText(fstr);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return showConfirmDialog(null, panel);
    }


}


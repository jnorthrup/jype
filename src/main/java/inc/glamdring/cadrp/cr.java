package inc.glamdring.cadrp; /**
 * User: jim
 * Date: Aug 28, 2008
 * Time: 9:15:24 PM
 */

import java.util.Arrays;
import static java.util.Arrays.copyOfRange;
import java.util.Collection;

public enum cr {
    car {public <T> T[] _(T... s) {return (T[]) a(s);}
        public <T> T _(T[]... s) {return (T) a(s);}},
    caar {public <T> T[] _(T... s) {return (T[]) a(a(s));}},
    caaar {public <T> T[] _(T... s) {return (T[]) a(a(a(s)));}},
    caaaar {public <T> T[] _(T... s) {return (T[]) a(a(a(a(s))));}},
    caaadr {public <T> T[] _(T... s) {return (T[]) d(a(a(a(s))));}},
    caadr {public <T> T[] _(T... s) {return (T[]) d(a(a(s)));}},
    caadar {public <T> T[] _(T... s) {return (T[]) a(d(a(a(s))));}},
    caaddr {public <T> T[] _(T... s) {return (T[]) d(d(a(a(s))));}},
    cadr {public <T> T[] _(T... s) {return (T[]) d(a(s));}},
    cadar {public <T> T[] _(T... s) {return (T[]) a(d(a(s)));}},
    cadaar {public <T> T[] _(T... s) {return (T[]) a(a(d(a(s))));}},
    cadadr {public <T> T[] _(T... s) {return (T[]) d(a(d(a(s))));}},
    caddr {public <T> T[] _(T... s) {return (T[]) d(d(a(s)));}},
    caddar {public <T> T[] _(T... s) {return (T[]) a(d(d(a(s))));}},
    cadddr {public <T> T[] _(T... s) {return (T[]) d(d(d(a(s))));}},
    cdr {public <T> T[] _(T... s) {return (T[]) d(s);}},
    cdar {public <T> T[] _(T... s) {return (T[]) a(d(s));}},
    cdaar {public <T> T[] _(T... s) {return (T[]) a(a(d(s)));}},
    cdaaar {public <T> T[] _(T... s) {return (T[]) a(a(a(d(s))));}},
    cdaadr {public <T> T[] _(T... s) {return (T[]) d(a(a(d(s))));}},
    cdadr {public <T> T[] _(T... s) {return (T[]) d(a(d(s)));}},
    cdadar {public <T> T[] _(T... s) {return (T[]) a(d(a(d(s))));}},
    cdaddr {public <T> T[] _(T... s) {return (T[]) d(d(a(d(s))));}},
    cddr {public <T> T[] _(T... s) {return (T[]) d(d(s));}},
    cddar {public <T> T[] _(T... s) {return (T[]) a(d(d(s)));}},
    cddaar {public <T> T[] _(T... s) {return (T[]) a(a(d(d(s))));}},
    cddadr {public <T> T[] _(T... s) {return (T[]) d(a(d(d(s))));}},
    cdddr {public <T> T[] _(T... s) {return (T[]) d(d(d(s)));}},
    cdddar {public <T> T[] _(T... s) {return (T[]) a(d(d(d(s))));}},
    cddddr {public <T> T[] _(T... s) {return (T[]) d(d(d(d(s))));}},;

public <T> T[] _(T... s) {return s;}
//public <T> T first      (T...list)  {return car(list);}
//public <T> T second     (T...list)  {return  (car (cdr                  (list))      )                 ;};
//public <T> T third      (T...list)  {return  (car (cddr                 (list))      )               ;};
//public <T> T fourth     (T...list)  {return  (car (cdddr                (list))      )               ;};
//public <T> T fifth      (T...list)  {return  (car (cddddr               (list))      )             ;};
//public <T> T sixth      (T...list)  {return  (car (cdr (cddddr          (list)))     )        ;};
//public <T> T seventh    (T...list)  {return  (car (cddr (cddddr         (list)))     )         ;};
//public <T> T eighth     (T...list)  {return  (car (cdddr (cddddr        (list)))     )       ;};
//public <T> T ninth      (T...list)  {return  (car (cddddr (cddddr       (list)))     )     ;};
//public <T> T tenth      (T...list)  {return  (car (cdr (cddddr (cddddr  (list))))    );};

    public static <T> T[] ___a(T... s) {return s;}
     public static <T> T[] a(T[]... s) {
        try {for (T[] ts : s) return ___a(a(ts));} catch (RuntimeException e) {}
        return null;
    }

    public static <T> T a(T... s) {
        for (T t : s) return t;
        return null;
    }

    public static <T> T a(Collection<?> s) {
        try {return (T) a(s.toArray());} catch (RuntimeException e) {}
        return null;
    }

    public static <T> T[] d(Collection<?> s) {
        try {return (T[]) d(s.toArray());} catch (RuntimeException e) {}
        return null;
    }

    public static <T> T[] d(final T... s) {
        try {return copyOfRange(s, 1, s.length - 1);} catch (RuntimeException e) {}
        return null;
    }


    public static <T> Collection<?> d(T[]... s) {
        try {return Arrays.asList(d(a(s)));} catch (RuntimeException e) {}
        return null;
    }

    public static Collection<?> d(Collection<?>... s) {
        try {return Arrays.asList(d(a(s).toArray()));} catch (RuntimeException e) {}
        return null;
    }
    /*
    #public <T> T _$(T[]... $s) {return (T) a($s);}}
    :
    function adgen () {
    rm .impl;
    z=($(for i in {a,d}{,a,d}{,a,d}{,a,d} ;
    do echo $i;
    done|sort -fu));
    echo enum 'ad{';
    for i in ${z[*]};
    do
    echo -n c${i}r'{
    public <T>T[] _$(T ... $s) {
    return (T[])';
    for j in $(seq ${#i});
    do
            echo -n ${i:$[${#i}-$j]:1}'(';
             done;
            echo -n $s;
            for j in $(seq ${#i});
            do
                echo -n ')';
            done;
            echo ';}},';
            echo -e "\n" >> .impl;
            echo -e ' //public static <T>'{Collection\<\?\>,T\[\]}' c'${i}'r('{Collection\<T\>,T...}'$s){return c'${i}'r._$($s);};'"\n" >> .impl;
            echo -e ' //  public static <T> T[] c'${i}'r(Collection<?> $s) {return c'${i}'r._$($s);};'"\n" >> .impl;
            echo -e ' //public static <T> T[] c'${i}'r(Collection<?> $s) {return c'${i}'r._$($s);};'"\n" >> .impl;
            echo -e ' public static <T> T[] c'${i}'r(final T... $s) {return c'${i}'r._$($s);};'"\n" >> .impl;
            echo -e  ' // public static <T> Collection<?> c'${i}'r(T[]... $s) {return c'${i}'r._$($s);};'"\n" >> .impl;
            echo -e ' // public static Collection<?> c'${i}'r(Collection<?>... $s) {return c'${i}'r._$($s);};'"\n" >> .impl;
        done;
        echo -e '; \n public <T>T _$(T...$s){return (T)$s;}';
        echo "};//gen by ${0}" >> .impl;
        gcat .impl
    }

    </pre>
    */
    //public static <T>Collection<?> car(Collection<T>$s){return car._$($s);};
    //public static <T>Collection<?> car(T...$s){return car._$($s);};
    //public static <T>T[] car(Collection<T>$s){return car._$($s);};
    //public static <T>T[] car(T...$s){return car._$($s);};

    //  public static <T> T[] car(Collection<?> $s) {return car._$($s);};

    //public static <T> T[] car(Collection<?> $s) {return car._$($s);};

    public static <T> T[] car(final T... s) {return car._(s);}


    // public static <T> Collection<?> car(T[]... $s) {return car._$($s);};

    // public static Collection<?> car(Collection<?>... $s) {return car._$($s);};

    //public static <T>Collection<?> caar(Collection<T>$s){return caar._$($s);};
    //public static <T>Collection<?> caar(T...$s){return caar._$($s);};
    //public static <T>T[] caar(Collection<T>$s){return caar._$($s);};
    //public static <T>T[] caar(T...$s){return caar._$($s);};

    //  public static <T> T[] caar(Collection<?> $s) {return caar._$($s);};

    //public static <T> T[] caar(Collection<?> $s) {return caar._$($s);};

    public static <T> T[] caar(final T... s) {return caar._(s);}


    // public static <T> Collection<?> caar(T[]... $s) {return caar._$($s);};

    // public static Collection<?> caar(Collection<?>... $s) {return caar._$($s);};

    //public static <T>Collection<?> caaar(Collection<T>$s){return caaar._$($s);};
    //public static <T>Collection<?> caaar(T...$s){return caaar._$($s);};
    //public static <T>T[] caaar(Collection<T>$s){return caaar._$($s);};
    //public static <T>T[] caaar(T...$s){return caaar._$($s);};

    //  public static <T> T[] caaar(Collection<?> $s) {return caaar._$($s);};

    //public static <T> T[] caaar(Collection<?> $s) {return caaar._$($s);};

    public static <T> T[] caaar(final T... s) {return caaar._(s);}

    ;

    // public static <T> Collection<?> caaar(T[]... $s) {return caaar._$($s);};

    // public static Collection<?> caaar(Collection<?>... $s) {return caaar._$($s);};

    //public static <T>Collection<?> caaaar(Collection<T>$s){return caaaar._$($s);};
    //public static <T>Collection<?> caaaar(T...$s){return caaaar._$($s);};
    //public static <T>T[] caaaar(Collection<T>$s){return caaaar._$($s);};
    //public static <T>T[] caaaar(T...$s){return caaaar._$($s);};

    //  public static <T> T[] caaaar(Collection<?> $s) {return caaaar._$($s);};

    //public static <T> T[] caaaar(Collection<?> $s) {return caaaar._$($s);};

    public static <T> T[] caaaar(final T... s) {return caaaar._(s);}

    ;

    // public static <T> Collection<?> caaaar(T[]... $s) {return caaaar._$($s);};

    // public static Collection<?> caaaar(Collection<?>... $s) {return caaaar._$($s);};

    //public static <T>Collection<?> caaadr(Collection<T>$s){return caaadr._$($s);};
    //public static <T>Collection<?> caaadr(T...$s){return caaadr._$($s);};
    //public static <T>T[] caaadr(Collection<T>$s){return caaadr._$($s);};
    //public static <T>T[] caaadr(T...$s){return caaadr._$($s);};

    //  public static <T> T[] caaadr(Collection<?> $s) {return caaadr._$($s);};

    //public static <T> T[] caaadr(Collection<?> $s) {return caaadr._$($s);};

    public static <T> T[] caaadr(final T... s) {return caaadr._(s);}

    ;

    // public static <T> Collection<?> caaadr(T[]... $s) {return caaadr._$($s);};

    // public static Collection<?> caaadr(Collection<?>... $s) {return caaadr._$($s);};

    //public static <T>Collection<?> caadr(Collection<T>$s){return caadr._$($s);};
    //public static <T>Collection<?> caadr(T...$s){return caadr._$($s);};
    //public static <T>T[] caadr(Collection<T>$s){return caadr._$($s);};
    //public static <T>T[] caadr(T...$s){return caadr._$($s);};

    //  public static <T> T[] caadr(Collection<?> $s) {return caadr._$($s);};

    //public static <T> T[] caadr(Collection<?> $s) {return caadr._$($s);};

    public static <T> T[] caadr(final T... s) {return caadr._(s);}


    // public static <T> Collection<?> caadr(T[]... $s) {return caadr._$($s);};

    // public static Collection<?> caadr(Collection<?>... $s) {return caadr._$($s);};

    //public static <T>Collection<?> caadar(Collection<T>$s){return caadar._$($s);};
    //public static <T>Collection<?> caadar(T...$s){return caadar._$($s);};
    //public static <T>T[] caadar(Collection<T>$s){return caadar._$($s);};
    //public static <T>T[] caadar(T...$s){return caadar._$($s);};

    //  public static <T> T[] caadar(Collection<?> $s) {return caadar._$($s);};

    //public static <T> T[] caadar(Collection<?> $s) {return caadar._$($s);};

    public static <T> T[] caadar(final T... s) {return caadar._(s);}

    // public static <T> Collection<?> caadar(T[]... $s) {return caadar._$($s);};

    // public static Collection<?> caadar(Collection<?>... $s) {return caadar._$($s);};

    //public static <T>Collection<?> caaddr(Collection<T>$s){return caaddr._$($s);};
    //public static <T>Collection<?> caaddr(T...$s){return caaddr._$($s);};
    //public static <T>T[] caaddr(Collection<T>$s){return caaddr._$($s);};
    //public static <T>T[] caaddr(T...$s){return caaddr._$($s);};

    //  public static <T> T[] caaddr(Collection<?> $s) {return caaddr._$($s);};

    //public static <T> T[] caaddr(Collection<?> $s) {return caaddr._$($s);};

    public static <T> T[] caaddr(final T... s) {return caaddr._(s);}


    // public static <T> Collection<?> caaddr(T[]... $s) {return caaddr._$($s);};

    // public static Collection<?> caaddr(Collection<?>... $s) {return caaddr._$($s);};

    //public static <T>Collection<?> cadr(Collection<T>$s){return cadr._$($s);};
    //public static <T>Collection<?> cadr(T...$s){return cadr._$($s);};
    //public static <T>T[] cadr(Collection<T>$s){return cadr._$($s);};
    //public static <T>T[] cadr(T...$s){return cadr._$($s);};

    //  public static <T> T[] cadr(Collection<?> $s) {return cadr._$($s);};

    //public static <T> T[] cadr(Collection<?> $s) {return cadr._$($s);};

    public static <T> T[] cadr(final T... s) {return cadr._(s);}

    // public static <T> Collection<?> cadr(T[]... $s) {return cadr._$($s);};

    // public static Collection<?> cadr(Collection<?>... $s) {return cadr._$($s);};

    //public static <T>Collection<?> cadar(Collection<T>$s){return cadar._$($s);};
    //public static <T>Collection<?> cadar(T...$s){return cadar._$($s);};
    //public static <T>T[] cadar(Collection<T>$s){return cadar._$($s);};
    //public static <T>T[] cadar(T...$s){return cadar._$($s);};

    //  public static <T> T[] cadar(Collection<?> $s) {return cadar._$($s);};

    //public static <T> T[] cadar(Collection<?> $s) {return cadar._$($s);};

    public static <T> T[] cadar(final T... s) {return cadar._(s);}


    // public static <T> Collection<?> cadar(T[]... $s) {return cadar._$($s);};

    // public static Collection<?> cadar(Collection<?>... $s) {return cadar._$($s);};

    //public static <T>Collection<?> cadaar(Collection<T>$s){return cadaar._$($s);};
    //public static <T>Collection<?> cadaar(T...$s){return cadaar._$($s);};
    //public static <T>T[] cadaar(Collection<T>$s){return cadaar._$($s);};
    //public static <T>T[] cadaar(T...$s){return cadaar._$($s);};

    //  public static <T> T[] cadaar(Collection<?> $s) {return cadaar._$($s);};

    //public static <T> T[] cadaar(Collection<?> $s) {return cadaar._$($s);};

    public static <T> T[] cadaar(final T... s) {return cadaar._(s);}


    // public static <T> Collection<?> cadaar(T[]... $s) {return cadaar._$($s);};

    // public static Collection<?> cadaar(Collection<?>... $s) {return cadaar._$($s);};

    //public static <T>Collection<?> cadadr(Collection<T>$s){return cadadr._$($s);};
    //public static <T>Collection<?> cadadr(T...$s){return cadadr._$($s);};
    //public static <T>T[] cadadr(Collection<T>$s){return cadadr._$($s);};
    //public static <T>T[] cadadr(T...$s){return cadadr._$($s);};

    //  public static <T> T[] cadadr(Collection<?> $s) {return cadadr._$($s);};

    //public static <T> T[] cadadr(Collection<?> $s) {return cadadr._$($s);};

    public static <T> T[] cadadr(final T... s) {return cadadr._(s);}

    // public static <T> Collection<?> cadadr(T[]... $s) {return cadadr._$($s);};

    // public static Collection<?> cadadr(Collection<?>... $s) {return cadadr._$($s);};

    //public static <T>Collection<?> caddr(Collection<T>$s){return caddr._$($s);};
    //public static <T>Collection<?> caddr(T...$s){return caddr._$($s);};
    //public static <T>T[] caddr(Collection<T>$s){return caddr._$($s);};
    //public static <T>T[] caddr(T...$s){return caddr._$($s);};

    //  public static <T> T[] caddr(Collection<?> $s) {return caddr._$($s);};

    //public static <T> T[] caddr(Collection<?> $s) {return caddr._$($s);};

    public static <T> T[] caddr(final T... s) {return caddr._(s);}
     // public static <T> Collection<?> caddr(T[]... $s) {return caddr._$($s);};

    // public static Collection<?> caddr(Collection<?>... $s) {return caddr._$($s);};

    //public static <T>Collection<?> caddar(Collection<T>$s){return caddar._$($s);};
    //public static <T>Collection<?> caddar(T...$s){return caddar._$($s);};
    //public static <T>T[] caddar(Collection<T>$s){return caddar._$($s);};
    //public static <T>T[] caddar(T...$s){return caddar._$($s);};

    //  public static <T> T[] caddar(Collection<?> $s) {return caddar._$($s);};

    //public static <T> T[] caddar(Collection<?> $s) {return caddar._$($s);};

    public static <T> T[] caddar(final T... s) {return caddar._(s);}
     // public static <T> Collection<?> caddar(T[]... $s) {return caddar._$($s);};

    // public static Collection<?> caddar(Collection<?>... $s) {return caddar._$($s);};

    //public static <T>Collection<?> cadddr(Collection<T>$s){return cadddr._$($s);};
    //public static <T>Collection<?> cadddr(T...$s){return cadddr._$($s);};
    //public static <T>T[] cadddr(Collection<T>$s){return cadddr._$($s);};
    //public static <T>T[] cadddr(T...$s){return cadddr._$($s);};

    //  public static <T> T[] cadddr(Collection<?> $s) {return cadddr._$($s);};

    //public static <T> T[] cadddr(Collection<?> $s) {return cadddr._$($s);};

    public static <T> T[] cadddr(final T... s) {return cadddr._(s);}
     // public static <T> Collection<?> cadddr(T[]... $s) {return cadddr._$($s);};

    // public static Collection<?> cadddr(Collection<?>... $s) {return cadddr._$($s);};

    //public static <T>Collection<?> cdr(Collection<T>$s){return cdr._$($s);};
    //public static <T>Collection<?> cdr(T...$s){return cdr._$($s);};
    //public static <T>T[] cdr(Collection<T>$s){return cdr._$($s);};
    //public static <T>T[] cdr(T...$s){return cdr._$($s);};

    //  public static <T> T[] cdr(Collection<?> $s) {return cdr._$($s);};

    //public static <T> T[] cdr(Collection<?> $s) {return cdr._$($s);};

    public static <T> T[] cdr(final T... s) {return cdr._(s);}


    // public static <T> Collection<?> cdr(T[]... $s) {return cdr._$($s);};

    // public static Collection<?> cdr(Collection<?>... $s) {return cdr._$($s);};

    //public static <T>Collection<?> cdar(Collection<T>$s){return cdar._$($s);};
    //public static <T>Collection<?> cdar(T...$s){return cdar._$($s);};
    //public static <T>T[] cdar(Collection<T>$s){return cdar._$($s);};
    //public static <T>T[] cdar(T...$s){return cdar._$($s);};

    //  public static <T> T[] cdar(Collection<?> $s) {return cdar._$($s);};

    //public static <T> T[] cdar(Collection<?> $s) {return cdar._$($s);};

    public static <T> T[] cdar(final T... s) {return cdar._(s);}


    // public static <T> Collection<?> cdar(T[]... $s) {return cdar._$($s);};

    // public static Collection<?> cdar(Collection<?>... $s) {return cdar._$($s);};

    //public static <T>Collection<?> cdaar(Collection<T>$s){return cdaar._$($s);};
    //public static <T>Collection<?> cdaar(T...$s){return cdaar._$($s);};
    //public static <T>T[] cdaar(Collection<T>$s){return cdaar._$($s);};
    //public static <T>T[] cdaar(T...$s){return cdaar._$($s);};

    //  public static <T> T[] cdaar(Collection<?> $s) {return cdaar._$($s);};

    //public static <T> T[] cdaar(Collection<?> $s) {return cdaar._$($s);};

    public static <T> T[] cdaar(final T... s) {return cdaar._(s);}


    // public static <T> Collection<?> cdaar(T[]... $s) {return cdaar._$($s);};

    // public static Collection<?> cdaar(Collection<?>... $s) {return cdaar._$($s);};

    //public static <T>Collection<?> cdaaar(Collection<T>$s){return cdaaar._$($s);};
    //public static <T>Collection<?> cdaaar(T...$s){return cdaaar._$($s);};
    //public static <T>T[] cdaaar(Collection<T>$s){return cdaaar._$($s);};
    //public static <T>T[] cdaaar(T...$s){return cdaaar._$($s);};

    //  public static <T> T[] cdaaar(Collection<?> $s) {return cdaaar._$($s);};

    //public static <T> T[] cdaaar(Collection<?> $s) {return cdaaar._$($s);};

    public static <T> T[] cdaaar(final T... s) {return cdaaar._(s);}


    // public static <T> Collection<?> cdaaar(T[]... $s) {return cdaaar._$($s);};

    // public static Collection<?> cdaaar(Collection<?>... $s) {return cdaaar._$($s);};

    //public static <T>Collection<?> cdaadr(Collection<T>$s){return cdaadr._$($s);};
    //public static <T>Collection<?> cdaadr(T...$s){return cdaadr._$($s);};
    //public static <T>T[] cdaadr(Collection<T>$s){return cdaadr._$($s);};
    //public static <T>T[] cdaadr(T...$s){return cdaadr._$($s);};

    //  public static <T> T[] cdaadr(Collection<?> $s) {return cdaadr._$($s);};

    //public static <T> T[] cdaadr(Collection<?> $s) {return cdaadr._$($s);};

    public static <T> T[] cdaadr(final T... s) {return cdaadr._(s);}


    // public static <T> Collection<?> cdaadr(T[]... $s) {return cdaadr._$($s);};

    // public static Collection<?> cdaadr(Collection<?>... $s) {return cdaadr._$($s);};

    //public static <T>Collection<?> cdadr(Collection<T>$s){return cdadr._$($s);};
    //public static <T>Collection<?> cdadr(T...$s){return cdadr._$($s);};
    //public static <T>T[] cdadr(Collection<T>$s){return cdadr._$($s);};
    //public static <T>T[] cdadr(T...$s){return cdadr._$($s);};

    //  public static <T> T[] cdadr(Collection<?> $s) {return cdadr._$($s);};

    //public static <T> T[] cdadr(Collection<?> $s) {return cdadr._$($s);};

    public static <T> T[] cdadr(final T... s) {return cdadr._(s);}


    // public static <T> Collection<?> cdadr(T[]... $s) {return cdadr._$($s);};

    // public static Collection<?> cdadr(Collection<?>... $s) {return cdadr._$($s);};

    //public static <T>Collection<?> cdadar(Collection<T>$s){return cdadar._$($s);};
    //public static <T>Collection<?> cdadar(T...$s){return cdadar._$($s);};
    //public static <T>T[] cdadar(Collection<T>$s){return cdadar._$($s);};
    //public static <T>T[] cdadar(T...$s){return cdadar._$($s);};

    //  public static <T> T[] cdadar(Collection<?> $s) {return cdadar._$($s);};

    //public static <T> T[] cdadar(Collection<?> $s) {return cdadar._$($s);};

    public static <T> T[] cdadar(final T... s) {return cdadar._(s);}


    // public static <T> Collection<?> cdadar(T[]... $s) {return cdadar._$($s);};

    // public static Collection<?> cdadar(Collection<?>... $s) {return cdadar._$($s);};

    //public static <T>Collection<?> cdaddr(Collection<T>$s){return cdaddr._$($s);};
    //public static <T>Collection<?> cdaddr(T...$s){return cdaddr._$($s);};
    //public static <T>T[] cdaddr(Collection<T>$s){return cdaddr._$($s);};
    //public static <T>T[] cdaddr(T...$s){return cdaddr._$($s);};

    //  public static <T> T[] cdaddr(Collection<?> $s) {return cdaddr._$($s);};

    //public static <T> T[] cdaddr(Collection<?> $s) {return cdaddr._$($s);};

    public static <T> T[] cdaddr(final T... s) {return cdaddr._(s);}


    // public static <T> Collection<?> cdaddr(T[]... $s) {return cdaddr._$($s);};

    // public static Collection<?> cdaddr(Collection<?>... $s) {return cdaddr._$($s);};

    //public static <T>Collection<?> cddr(Collection<T>$s){return cddr._$($s);};
    //public static <T>Collection<?> cddr(T...$s){return cddr._$($s);};
    //public static <T>T[] cddr(Collection<T>$s){return cddr._$($s);};
    //public static <T>T[] cddr(T...$s){return cddr._$($s);};

    //  public static <T> T[] cddr(Collection<?> $s) {return cddr._$($s);};

    //public static <T> T[] cddr(Collection<?> $s) {return cddr._$($s);};

    public static <T> T[] cddr(final T... s) {return cddr._(s);}


    // public static <T> Collection<?> cddr(T[]... $s) {return cddr._$($s);};

    // public static Collection<?> cddr(Collection<?>... $s) {return cddr._$($s);};

    //public static <T>Collection<?> cddar(Collection<T>$s){return cddar._$($s);};
    //public static <T>Collection<?> cddar(T...$s){return cddar._$($s);};
    //public static <T>T[] cddar(Collection<T>$s){return cddar._$($s);};
    //public static <T>T[] cddar(T...$s){return cddar._$($s);};

    //  public static <T> T[] cddar(Collection<?> $s) {return cddar._$($s);};

    //public static <T> T[] cddar(Collection<?> $s) {return cddar._$($s);};

    public static <T> T[] cddar(final T... s) {return cddar._(s);}

     // public static <T> Collection<?> cddar(T[]... $s) {return cddar._$($s);};

    // public static Collection<?> cddar(Collection<?>... $s) {return cddar._$($s);};

    //public static <T>Collection<?> cddaar(Collection<T>$s){return cddaar._$($s);};
    //public static <T>Collection<?> cddaar(T...$s){return cddaar._$($s);};
    //public static <T>T[] cddaar(Collection<T>$s){return cddaar._$($s);};
    //public static <T>T[] cddaar(T...$s){return cddaar._$($s);};

    //  public static <T> T[] cddaar(Collection<?> $s) {return cddaar._$($s);};

    //public static <T> T[] cddaar(Collection<?> $s) {return cddaar._$($s);};

    public static <T> T[] cddaar(final T... s) {return cddaar._(s);}

    ;

    // public static <T> Collection<?> cddaar(T[]... $s) {return cddaar._$($s);};

    // public static Collection<?> cddaar(Collection<?>... $s) {return cddaar._$($s);};

    //public static <T>Collection<?> cddadr(Collection<T>$s){return cddadr._$($s);};
    //public static <T>Collection<?> cddadr(T...$s){return cddadr._$($s);};
    //public static <T>T[] cddadr(Collection<T>$s){return cddadr._$($s);};
    //public static <T>T[] cddadr(T...$s){return cddadr._$($s);};

    //  public static <T> T[] cddadr(Collection<?> $s) {return cddadr._$($s);};

    //public static <T> T[] cddadr(Collection<?> $s) {return cddadr._$($s);};

    public static <T> T[] cddadr(final T... s) {return cddadr._(s);}

    ;

    // public static <T> Collection<?> cddadr(T[]... $s) {return cddadr._$($s);};

    // public static Collection<?> cddadr(Collection<?>... $s) {return cddadr._$($s);};

    //public static <T>Collection<?> cdddr(Collection<T>$s){return cdddr._$($s);};
    //public static <T>Collection<?> cdddr(T...$s){return cdddr._$($s);};
    //public static <T>T[] cdddr(Collection<T>$s){return cdddr._$($s);};
    //public static <T>T[] cdddr(T...$s){return cdddr._$($s);};

    //  public static <T> T[] cdddr(Collection<?> $s) {return cdddr._$($s);};

    //public static <T> T[] cdddr(Collection<?> $s) {return cdddr._$($s);};

    public static <T> T[] cdddr(final T... s) {return cdddr._(s);}

    ;

    // public static <T> Collection<?> cdddr(T[]... $s) {return cdddr._$($s);};

    // public static Collection<?> cdddr(Collection<?>... $s) {return cdddr._$($s);};

    //public static <T>Collection<?> cdddar(Collection<T>$s){return cdddar._$($s);};
    //public static <T>Collection<?> cdddar(T...$s){return cdddar._$($s);};
    //public static <T>T[] cdddar(Collection<T>$s){return cdddar._$($s);};
    //public static <T>T[] cdddar(T...$s){return cdddar._$($s);};

    //  public static <T> T[] cdddar(Collection<?> $s) {return cdddar._$($s);};

    //public static <T> T[] cdddar(Collection<?> $s) {return cdddar._$($s);};

    public static <T> T[] cdddar(final T... s) {return cdddar._(s);}

    ;

    // public static <T> Collection<?> cdddar(T[]... $s) {return cdddar._$($s);};

    // public static Collection<?> cdddar(Collection<?>... $s) {return cdddar._$($s);};

    //public static <T>Collection<?> cddddr(Collection<T>$s){return cddddr._$($s);};
    //public static <T>Collection<?> cddddr(T...$s){return cddddr._$($s);};
    //public static <T>T[] cddddr(Collection<T>$s){return cddddr._$($s);};
    //public static <T>T[] cddddr(T...$s){return cddddr._$($s);};

    //  public static <T> T[] cddddr(Collection<?> $s) {return cddddr._$($s);};

    //public static <T> T[] cddddr(Collection<?> $s) {return cddddr._$($s);};

    public static <T> T[] cddddr(final T... s) {return cddddr._(s);}

    ;

    // public static <T> Collection<?> cddddr(T[]... $s) {return cddddr._$($s);};

    // public static Collection<?> cddddr(Collection<?>... $s) {return cddddr._$($s);};

};//gen by -bash

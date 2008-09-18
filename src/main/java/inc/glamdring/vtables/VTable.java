package inc.glamdring.vtables;

import javolution.lang.Reference;

import java.util.EnumSet;

/**
 * vtable has a bag of traits, an array following a bitmap
 * <p/>
 * the Traits are indicated on a vtable caps" bitmaCp 0...63 important traits matter.
 */
public interface VTable<$ extends Enum<$>> {
    <$ extends Primary> boolean is($ $);

    EnumSet<Primary> getPrimaryTraits();

    ;

    /**
     * User: jim
     * Date: Sep 18, 2008
     * Time: 6:05:14 AM
     */
    public static interface $narrow<$, $$ extends $Traits> extends $Traits {
        $ $();
        <$$$ extends Reference<$>> $$$ $($$ $$);
        <$$$ extends Iterable<$>> $ $($$$... $$$);
        <$$$ extends Iterable<?>> $$$ $(Class<? super Iterable<$>>... $$$);
    }

    /**
 * User: jim
    * Date: Sep 18, 2008
    * Time: 6:05:18 AM
    */
    public static interface $binding<$ extends Enum<$>,$$>   extends $as<$,$> {

        $ $($$ $$);
    }

    /**
 * User: jim
    * Date: Sep 18, 2008
    * Time: 6:05:27 AM
    */
    public static interface $as<$ extends Enum<$>,$$ extends Enum<$$>> extends VTable<$>{

        $ $($$ $$);

    }
}
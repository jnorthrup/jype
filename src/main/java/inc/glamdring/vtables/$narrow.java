package inc.glamdring.vtables;

import javolution.lang.Reference;

import java.util.Iterator;

/**
     * User: jim
 * Date: Sep 18, 2008
 * Time: 6:05:14 AM
 */
public   interface $narrow<$, $$  > extends _trait  {
    $ $();
     $ $ ($$ $$);
//        Class<$> $($$ $$);

    <$$> $ ctor(Iterator<?> first, $$ last);

    <$$$ extends Reference<?>> $ revive($$$ $$$);

    $ $(Iterable $$$);


}

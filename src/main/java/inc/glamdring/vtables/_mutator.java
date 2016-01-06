package inc.glamdring.vtables;

import java.util.function.Function;

/**
 * ref class -- approximation of c++ '&'
 * User: jim
 * Date: Sep 20, 2008
 * Time: 12:27:26 AM
 */

public abstract class _mutator<endPojo> extends _edge<endPojo,_ptr> implements Function<_ptr, endPojo> {}

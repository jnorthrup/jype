package inc.glamdring.vtables;

/**
 * User: jim
 * Date: Sep 18, 2008
 * Time: 6:05:14 AM
 */
public interface _arc<l, r> extends _proto<l> {

    //getter
    l l$(_arc<l, r>... p);
    //getter

    //setter
    r $r(_arc<l, r>... ses);
    //setter

    //factory
    _arc<l, r> bind(l l, r... r);
    //factory

}

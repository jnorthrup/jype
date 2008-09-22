package inc.glamdring.vtables;

/**
 * User: jim
 * Date: Sep 18, 2008
 * Time: 6:05:14 AM
 */
public interface _arc<l, r> extends _proto<l> {

    //getter
    l rol(_arc<l, r>... p);
    //getter

    //setter
    r ror(_arc<l, r>... ses);
    //setter

    //factory
    _arc<l, r> join(l l, r... r);
    //factory
 
}

package inc.glamdring.vtables;

import java.util.EnumSet;

/**
 * vtable has a bag of traits, an array following a bitmap
 * <p/>
 * the Traits are indicated on a vtable caps" bitmaCp 0...63 important traits matter.
 */
public interface _vtable<$ extends Enum<$> & _vtable<? super $>> {
    <$ extends _ptrait> boolean is(_ptrait $);

    EnumSet<_ptrait> getPrimaryTraits();
    int getOffset();
    int getSize();


}
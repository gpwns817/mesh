/**
 * ADOBE SYSTEMS INCORPORATED
 * Copyright 2009-2013 Adobe Systems Incorporated
 * All Rights Reserved.
 *
 * NOTICE: Adobe permits you to use, modify, and distribute
 * this file in accordance with the terms of the MIT license,
 * a copy of which can be found in the LICENSE.txt file or at
 * http://opensource.org/licenses/MIT.
 */
package runtime.intrinsic.tran;

import runtime.intrinsic.IntrinsicLambda;
import runtime.rep.Tuple;
import runtime.tran.TransactionManager;

/**
 * Tuplized version of put().
 *
 * @author Basil Hosmer
 */
public final class _puts extends IntrinsicLambda
{
    public static final _puts INSTANCE = new _puts(); 
    public static final String NAME = "puts";

    public String getName()
    {
        return NAME;
    }

    public Object apply(final Object arg)
    {
        final Tuple args = (Tuple)arg;
        return invoke((Tuple)args.get(0), (Tuple)args.get(1));
    }

    public static Tuple invoke(final Tuple boxes, final Tuple vals)
    {
        TransactionManager.puts(boxes, vals);
        return Tuple.UNIT;
    }
}

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
package runtime.intrinsic;

import compile.type.Type;
import compile.type.Types;
import runtime.rep.lambda.IntrinsicLambda;
import runtime.rep.Tuple;

/**
 * sleep the current thread a given number of millis
 *
 * @author Basil Hosmer
 */
public final class Sleep extends IntrinsicLambda
{
    public static final String NAME = "sleep";

    public static final Type TYPE = Types.fun(Types.INT, Types.unit());

    public String getName()
    {
        return NAME;
    }

    public Type getType()
    {
        return TYPE;
    }

    public Object apply(final Object arg)
    {
        return invoke((Integer)arg);
    }

    public static Tuple invoke(final int i)
    {
        try
        {
            Thread.sleep(i);
        }
        catch (InterruptedException ignored)
        {
        }

        return Tuple.UNIT;
    }
}
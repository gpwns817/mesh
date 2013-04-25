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

/**
 * take floor of double, return int
 *
 * @author Basil Hosmer
 */
public final class F2I extends IntrinsicLambda
{
    public static final String NAME = "f2i";

    public static final Type TYPE = Types.fun(Types.DOUBLE, Types.INT);

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
        return invoke((Double)arg);
    }

    public static int invoke(final double d)
    {
        return (int)Math.floor(d);
    }
}
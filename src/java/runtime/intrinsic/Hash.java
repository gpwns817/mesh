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
import compile.type.TypeParam;
import compile.type.Types;
import runtime.rep.lambda.IntrinsicLambda;

/**
 * Hash code, defined over all values. Structural hash for
 * everything except lamdas and boxes, identity hash for those.
 *
 * @author Basil Hosmer
 */
public final class Hash extends IntrinsicLambda
{
    public static final String NAME = "hash";

    private static Type T = new TypeParam("T");
    public static final Type TYPE = Types.fun(T, Types.INT);

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
        return invoke(arg);
    }

    public static int invoke(final Object arg)
    {
        return arg.hashCode();
    }
}
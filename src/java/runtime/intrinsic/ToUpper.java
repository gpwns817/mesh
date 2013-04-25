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
 * string toupper
 *
 * @author Basil Hosmer
 */
public final class ToUpper extends IntrinsicLambda
{
    public static final String NAME = "toupper";

    public static final Type TYPE = Types.fun(Types.STRING, Types.STRING);

    public String getName()
    {
        return NAME;
    }

    public Type getType()
    {
        return TYPE;
    }

    public final String apply(final Object arg)
    {
        return invoke((String)arg);
    }

    public static String invoke(final String s)
    {
        return s.toUpperCase();
    }
}
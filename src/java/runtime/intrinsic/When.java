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
import runtime.rep.lambda.Lambda;
import runtime.rep.Tuple;

/**
 * conditional execution: when(cond, block) == guard(!cond, (), {block();()})
 *
 * @author Basil Hosmer
 */
public final class When extends IntrinsicLambda
{
    public static final String NAME = "when";

    private static final Type T = new TypeParam("T");
    private static final Type BLOCK_T = Types.fun(Types.unit(), T);
    public static final Type TYPE =
        Types.fun(Types.tup(Types.BOOL, BLOCK_T), Types.unit());

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
        final Tuple args = (Tuple)arg;
        return invoke((Boolean)args.get(0), (Lambda)args.get(2));
    }

    public static Tuple invoke(final boolean cond, final Lambda block)
    {
        if (cond)
            block.apply(Tuple.UNIT);

        return Tuple.UNIT;
    }
}
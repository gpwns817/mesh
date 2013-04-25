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
package runtime.intrinsic.demo.processing;

import compile.type.Type;
import compile.type.Types;
import runtime.rep.lambda.IntrinsicLambda;
import runtime.rep.Tuple;

/**
 * Demo support, Processing hook
 *
 * @author Basil Hosmer
 */
public final class PrLine3D extends IntrinsicLambda
{
    public static final String NAME = "prline3d";

    public static final Type TYPE =
        Types.fun(Types.tup(
            Types.DOUBLE, Types.DOUBLE, Types.DOUBLE,
            Types.DOUBLE, Types.DOUBLE, Types.DOUBLE),
            Types.unit());

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
        return invoke(
            (Double)args.get(0), (Double)args.get(1), (Double)args.get(2),
            (Double)args.get(3), (Double)args.get(4), (Double)args.get(5));
    }

    /**
     * CAUTION not thread safe when called outside of setup/draw func
     */
    public static Tuple invoke(
        final double x1, final double y1, final double x2,
        final double y2, final double x3, final double y3)
    {
        if (Processing.INSTANCE != null)
        {
            Processing.INSTANCE.line(
                (float)x1, (float)y1, (float)x2,
                (float)y2, (float)x3, (float)y3);
        }

        return Tuple.UNIT;
    }
}
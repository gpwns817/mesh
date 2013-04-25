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
public final class PrTranslate extends IntrinsicLambda
{
    public static final String NAME = "prtranslate";

    public static final Type TYPE =
        Types.fun(Types.tup(Types.DOUBLE, Types.DOUBLE), Types.unit());

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
        return invoke((Double)args.get(0), (Double)args.get(1));
    }

    /**
     * CAUTION not thread safe when called outside of setup/draw func
     */
    public static Tuple invoke(final double x, final double y)
    {
        if (Processing.INSTANCE != null)
        {
            Processing.INSTANCE.translate((float)x, (float)y);
        }

        return Tuple.UNIT;
    }
}
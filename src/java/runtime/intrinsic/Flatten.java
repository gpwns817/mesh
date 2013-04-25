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

import compile.type.*;
import runtime.rep.list.ChainedLists;
import runtime.rep.lambda.IntrinsicLambda;
import runtime.rep.list.ListValue;

/**
 * Concatenate multiple lists together.
 *
 * @author Basil Hosmer
 */
public final class Flatten extends IntrinsicLambda
{
    public static final String NAME = "flatten";

    private static final Type A = new TypeParam("A");
    private static final Type LIST_A = Types.list(A);
    private static final Type LIST_LIST_A = Types.list(LIST_A);

    public static final Type TYPE = Types.fun(LIST_LIST_A, LIST_A);

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
        return invoke((ListValue) arg);
    }

    public static ListValue invoke(final ListValue lists)
    {
        return ChainedLists.create(lists);
    }
}
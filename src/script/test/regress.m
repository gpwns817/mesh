
import * from std;
import * from unittest;

// regression tests for simple (fixed) issues.
// issue numbers from BB repo, currently. in fix order.
// TODO expand into a directory with one test script per issue?
// may need for more involved issues

// issue 13: intran() broken
assert_false(intran);

// issue 11: assertion error compiling nested record literals
assert_equals({"hey"}, { a = (#b: (#c: "hey"), #d: false); a.b.c });

// issue 10: Typedef inside a lambda crashes
assert_equals({(0, 1)}, { type A = (Int, Int); x : A = (0, 1); x });

// issue ??: rangen has trouble with negative step sizes
// TODO move these to library tests
assert_equals({[0, 1, 2, 3]}, {rangen(0, 4, 1)});
assert_equals({[0, 1, 2, 3]}, {rangen(0, 4, -1)});
assert_equals({[0, -1, -2, -3]}, {rangen(0, -4, 1)});
assert_equals({[0, -1, -2, -3]}, {rangen(0, -4, -1)});
assert_equals({[0, 3, 6, 9]}, {rangen(0, 10, 3)});
assert_equals({[0, 3, 6, 9]}, {rangen(0, 10, -3)});
assert_equals({[0, -3, -6, -9]}, {rangen(0, -10, 3)});
assert_equals({[0, -3, -6, -9]}, {rangen(0, -10, -3)});

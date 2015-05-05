# Simple shopping basket

A simple checkout system, built just as a technical exercise.

## Running the tests

The implementation approach has been outside-in, writing first a [feature test using cucumber](https://github.com/siliconcat/shopping-basket/blob/master/features/checkout.feature) 
to illustrate the acceptance criteria.

A [set of Specs](https://github.com/siliconcat/shopping-basket/tree/master/src/test/scala/shoppingbasket) cover the implementation at the Unit level.

To run both tests, simply execute SBT:

    sbt test fun:test

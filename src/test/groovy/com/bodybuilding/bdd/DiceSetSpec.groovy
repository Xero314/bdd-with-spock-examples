package com.bodybuilding.bdd

import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

import java.util.function.Consumer


class DiceSetSpec extends Specification {

    @Subject
    private DiceSet diceset

    //Collaborators
    private Consumer<Long> callback

    def setup()
    {
        given: "a callback"
        callback = Mock()
    }

    @Unroll("#featureName where rolls are [#one, #two, #three] and expected value is #expected")
    def "Rolling a Dice Set should result in the sum of the generated values of the dice it contains"(long one, long two, long three, long expected)
    {
        given: "a set of dice"
        Die die = Mock()
        diceset = new DiceSet(callback, die, die, die);

        when: "dice are rolled"
        def result = diceset.roll()

        then: "dice in set are rolled"
        3 * die.roll() >>> [one,two,three]

        and: "rolled result is sum of result of dice in set"
        result == expected

        where:
        one |   two |   three   ||   expected
        1   |   2   |   3       ||   6
        10  |   100 |  1000     ||   1110
    }

    def "Dice set rolls should notify the supplied callback"()
    {
        given: "a set of dice"
        diceset = new DiceSet(callback, new Die(6))

        when: "dice are rolled"
        diceset.roll()

        then: "callback function is executed with rolled result"
        1 * callback.accept(_)

    }
}
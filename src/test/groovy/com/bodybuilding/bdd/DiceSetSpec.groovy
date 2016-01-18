package com.bodybuilding.bdd

import spock.lang.Specification
import spock.lang.Subject

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

    def "Rolling a Dice Set should result in the sum of the generated values of the dice it contains"()
    {
        given: "a set of dice"
        Die die = Stub()
        die.roll() >> 11
        diceset = new DiceSet(callback,die);

        when: "dice are rolled"
        def result = diceset.roll()

        then: "rolled result is sum of result of dice in set"
        result == 11

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
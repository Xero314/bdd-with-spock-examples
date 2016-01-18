package com.bodybuilding.bdd

import spock.lang.Specification

import java.util.function.Consumer


class DiceSetSpec extends Specification {

    def "Dice set rolls should notify the supplied callback"()
    {
        given: "a callback"
        Consumer<Long> callback = Mock()

        and: "a set of dice"
        DiceSet diceset = new DiceSet(callback, new Die(6))

        when: "dice are rolled"
        diceset.roll()

        then: "callback function is executed with rolled result"
        1 * callback.accept(_)

    }
}
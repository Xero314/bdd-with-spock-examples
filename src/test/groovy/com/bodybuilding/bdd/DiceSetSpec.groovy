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
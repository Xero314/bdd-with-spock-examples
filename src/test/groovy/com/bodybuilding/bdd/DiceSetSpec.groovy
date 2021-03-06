package com.bodybuilding.bdd

import spock.genesis.Gen
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

    @Unroll("#featureName where rolls are #rolls")
    def "Rolling a Dice Set should result in the sum of the generated values of the dice it contains"(List<Long> rolls)
    {
        given: "a set of dice"
        Die die = Mock()
        diceset = new DiceSet(callback,[die]*rolls.size() as Die[]);

        when: "dice are rolled"
        def result = diceset.roll()

        then: "dice in set are rolled"
        rolls.size() * die.roll() >>> rolls

        and: "rolled result is sum of result of dice in set"
        result == rolls.sum()

        where:
        rolls << Gen.integer(1, 100).map{ (Gen.integer(1, Integer.MAX_VALUE/it as Integer) * it).collect()} * 10
    }

    @Unroll("#featureName where roll is #roll")
    def "Dice set rolls should notify the supplied callback"(long roll)
    {
        given: "a set of dice"
        Die die = Mock()
        1 * die.roll() >> roll
        diceset = new DiceSet(callback, die)

        when: "dice are rolled"
        diceset.roll()

        then: "callback function is executed with rolled result"
        1 * callback.accept(roll)

        where:
        roll << Gen.integer(1, Integer.MAX_VALUE)  * 10

    }
}
package com.bodybuilding.bdd

import spock.lang.Specification

class DieSpec extends Specification {
    def "Rolling a Die should produce a random number no less than 1 and no greater than the number of facets of the die" ()
    {
        given: "a die"
        Die die = new Die(6)

        when: "die is rolled"
        def result = die.roll()

        then: "result is greater than or equal to 1"
        result >= 1

        and: "result is less than or equal to number of facets on the die"
        result <= 6

    }
}
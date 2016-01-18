package com.bodybuilding.bdd

import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll


class DieSpec extends Specification {

    @Subject
    private Die die;

    @Unroll("#featureName where number of facets is #facets")
    def "Rolling a Die should produce a random number no less than 1 and no greater than the number of facets of the die" (long facets)
    {
        given: "a die"
        die = new Die(facets)

        when: "die is rolled"
        def result = die.roll()

        then: "result is greater than or equal to 1"
        result >= 1

        and: "result is less than or equal to number of facets on the die"
        result <= facets

        where:
        facets << (2..100).findAll{it % 2 == 0}
    }

}
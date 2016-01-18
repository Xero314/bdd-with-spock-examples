package com.bodybuilding.bdd

import spock.lang.Specification

class DieSpec extends Specification {
    def "Rolling a Die should produce a random number no less than 1 and no greater than the number of facets of the die" ()
    {
        given: "a die"
        when: "die is rolled"
        then: "result is greater than or equal to 1"
        and: "result is less than or equal to number of facets on the die"
    }
}
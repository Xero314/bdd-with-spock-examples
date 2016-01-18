package com.bodybuilding.bdd;

import java.util.concurrent.ThreadLocalRandom;

/**
 * A Rollable that represents a single game Die, producing a value between 1 and the number of facets on the die, inclusive.
 */
public class Die implements Rollable
{
    private long facets;

    /**
     * Constructs a new Die with a specific number of facets
     * @param facets
     */
    public Die(long facets)
    {
        this.facets = facets;
    }

    /**
     * Generates a random value between 1 and the number of facets on the Die, inclusive
     * @return a random value between 1 and the number of facets on the Die, inclusive
     * @see com.bodybuilding.bdd.Rollable#roll()
     */
    @Override
    public long roll()
    {
        return 0;
    }
}

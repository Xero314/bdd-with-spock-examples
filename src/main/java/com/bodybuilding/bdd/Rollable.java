package com.bodybuilding.bdd;

/**
 * An object that generates a random long value
 */
public interface Rollable
{
    /**
     * Generates a random value
     * @return random value
     */
    public long roll();
}

package com.bodybuilding.bdd;

import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * A set of Die objects utilized as a single unit
 */
public class DiceSet implements Rollable
{
    private Die[] dice;
    private Consumer<Long> callback;

    /**
     * Constructs a DiceSet with a callback function and set of Die objects
     * @param callback function to be called when the DiceSet is rolled
     * @param dice a set of dice contained in the DiceSet
     * @see com.bodybuilding.bdd.DiceSet#roll
     */
    public DiceSet(Consumer callback, Die... dice)
    {
        this.callback = callback;
        this.dice = dice;
    }

    /**
     * Generates a random value that is the sum of the generated random values of the dice in the set and calls the DiceSet's callback
     * @return a random value that is the sum of the generated random values of the dice in the set
     * @see com.bodybuilding.bdd.Die#roll()
     * @see com.bodybuilding.bdd.Rollable#roll()
     */
    @Override
    public long roll()
    {
        long roll =  Stream.of(dice).mapToLong( die -> die.roll()).sum();
        callback.accept(roll);
        return roll;
    }
}

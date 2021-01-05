package com.sparta.utility;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RandomizerTest {

    @Test
    void RandomArrayGeneratorTest(){
        Assertions.assertEquals(1, Randomizer.generateRandomInt(1,1));
    }

}
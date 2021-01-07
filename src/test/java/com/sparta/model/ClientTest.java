package com.sparta.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    private Client client = new Client();
    private Client client1 = new Client();
    private Client client2 = new Client();
    private Trainee trainee = new Trainee();


    @Test
    void checkIfClientIDsAreUnique() {
        Assertions.assertNotEquals(client.getClientID(), client1.getClientID());
    }

    @Test
    void checkIfClientCountIsCorrect() {
        Assertions.assertEquals(3, client2.getCount());
    }

    @Test
    void checkIfIsClientHappyReturnsExpected(){Assertions.assertTrue(client.isClientHappy());}
}
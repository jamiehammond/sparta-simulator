package com.sparta.IO;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;
class InputControllerTest {

    @Test
    void DoesYReturnTrue(){
        ByteArrayInputStream in = new ByteArrayInputStream("Y".getBytes());
        System.setIn(in);
        Assertions.assertTrue(InputController.isUserAnsweringPositive());
    }
    @Test
    void DoesNReturnFalse(){
        ByteArrayInputStream in = new ByteArrayInputStream("N".getBytes());
        System.setIn(in);
        Assertions.assertFalse(InputController.isUserAnsweringPositive());
    }
}
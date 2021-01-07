package com.sparta.IO;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;
class InputControllerTest {

    @Test
    void DoesYReturnTrue(){
        InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("Y".getBytes());
        System.setIn(in);
        Assertions.assertTrue(InputController.isUserAnsweringPositive());
    }
    @Test
    void DoesNReturnFalse(){
        InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("N".getBytes());
        System.setIn(in);
        Assertions.assertFalse(InputController.isUserAnsweringPositive());
    }
}
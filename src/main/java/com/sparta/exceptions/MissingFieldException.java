package com.sparta.exceptions;

import com.sparta.configuration.Settings;

import java.util.Collection;

/**
 * Thrown to indicate that the configuration file has missing fields.
 *
 * @author Samurah
 * @since 1.0
 */

public class MissingFieldException extends Exception {
    private final Collection<Settings> missingFields;

    public MissingFieldException(Collection<Settings> missingFields){
        this.missingFields = missingFields;
    }

    public void printMissingFields(){
        for (Settings missingField : missingFields) {
            System.err.println(missingField.getPropertyName() + " is missing.");
        }
    }

    public Collection<Settings> getMissingFields(){
        return missingFields;
    }
}

package com.sparta.utility;

import com.sparta.IO.InputController;
import com.sparta.configuration.Settings;

/**
 * The class {@code ModeChooser} is handling the way simulation will work.
 */
public class ModeChooser {

    /**
     * Asks user if the simulation should be run month-by-month
     * @return {@code SimulationMode}
     */
    public static SimulationMode getUserSimulationMode(){
        System.out.println("Do you want to run the simulation month-by-month?");
        if(InputController.isUserAnsweringPositive()){
            return SimulationMode.STEP_BY_STEP;
        }
        return SimulationMode.FAST_FORWARD;
    }

    /**
     * Gathers the configuration from Settings.SIMULATION_STEP_BY_STEP
     * @return {@code SimulationMode}
     */
    public static SimulationMode getConfigurationSimulationMode(){
        if(Settings.SIMULATION_STEP_BY_STEP.getValue() == 0){
            return SimulationMode.FAST_FORWARD;
        }
        return SimulationMode.STEP_BY_STEP;
    }

}

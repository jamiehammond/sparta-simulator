package com.sparta.utility;

import com.sparta.configuration.Settings;

/**
 * The class {@code ModeChooser} is handling the way simulation will work.
 */
public class ModeChooser {

    private static SimulationMode chosenMode;

    static {
        chosenMode = null;
    }

    public static SimulationMode getSimulationMode() {
        if (chosenMode == null) {
            chosenMode = getConfigurationSimulationMode();
        }
        return chosenMode;
    }

//    /**
//     * Asks user if the simulation should be run month-by-month
//     * @return {@code SimulationMode}
//     */
//    public static SimulationMode getUserSimulationMode(){
//        System.out.println("Do you want to run the simulation month-by-month?");
//        if(InputController.isUserAnsweringPositive()){
//            return SimulationMode.STEP_BY_STEP;
//        }
//        return SimulationMode.FAST_FORWARD;
//    }

    /**
     * Gathers the configuration from Settings.SIMULATION_STEP_BY_STEP
     *
     * @return {@code SimulationMode}
     */
    public static SimulationMode getConfigurationSimulationMode() {
        if (Settings.SIMULATION_STEP_BY_STEP.getValue() == 0) {
            return SimulationMode.FAST_FORWARD;
        }
        return SimulationMode.STEP_BY_STEP;
    }

}

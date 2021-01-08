package com.sparta.configuration;

/**
 * The class {@code Settings} is defining the configuration fields
 * expected to be found in {@link SimulatorConfiguration}. Whenever
 * a new configuration field is required, it has to be given a default
 * value that will be applied in case
 * {@link SimulatorConfiguration#loadCustomConfiguration()} fails.
 *
 * @since 1.0
 * @author Samurah
 */

public enum Settings {
    SIMULATION_MONTHS ("simulation_months", 12),
    CENTER_OPENING_FREQUENCY("center_opening_frequency_in_months", 2),
    CENTER_CAPACITY("center_capacity", 100),
    NEW_TRAINEE_MIN("new_trainee_min", 20),
    NEW_TRAINEE_MAX("new_trainee_max", 30),
    NEW_TRAINEE_FREQUENCY("new_trainee_frequency_in_months", 1),
    CENTER_ADMITTANCE_MIN("center_admittance_min", 10),
    CENTER_ADMITTANCE_MAX("center_admittance_max", 20),
    CENTER_ADMITTANCE_FREQUENCY("center_admittance_frequency_in_months", 1),
    MONTH_IN_MS("month_delay_in_milliseconds", 1000);

    private final String propertyName;
    private final int defaultValue;

    Settings(String propertyName,int defaultValue){
        this.propertyName = propertyName;
        this.defaultValue = defaultValue;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public int getValue(){
        return SimulatorConfiguration.getConfiguration(this);
    }

    protected int getDefaultValue(){
        return defaultValue;
    }

    public void reload(){
        SimulatorConfiguration.loadCustomConfiguration();
    }
}

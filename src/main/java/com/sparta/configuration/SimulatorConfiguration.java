package com.sparta.configuration;

import com.sparta.exceptions.MissingFieldException;
import com.sparta.utility.Delayer;
import com.sparta.utility.TextColor;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

/**
 * The class {@code SimulatorConfiguration} is checking the integrity
 * of the configuration file found at {@code src/main/resources/settings.properties}.
 * Also, it offers a backup configuration which will be statically loaded.
 *
 * @author Samurah
 * @since 1.0
 */

class SimulatorConfiguration {
/**
 * Persists loaded configuration
 */
    private static final HashMap<Settings,Integer> configuration;

    static {
        configuration = new HashMap<>();
        loadCustomConfiguration();
    }


    protected static void loadCustomConfiguration(){
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("src/main/resources/settings.properties"));
            loadConfiguration(properties);
        } catch (IOException e) {
            System.err.println("Custom configuration couldn't be loaded.");
            e.printStackTrace();
        }
    }

    protected static void loadConfiguration(Properties properties) {
        configuration.clear();
        try{
            System.out.println(TextColor.ANSI_YELLOW + "Loading configuration." + TextColor.ANSI_YELLOW);
            tryLoadConfiguration(properties);
            System.out.println(TextColor.ANSI_GREEN + "Configuration loaded." + TextColor.ANSI_GREEN);
        }catch (NumberFormatException e){
            System.err.println("Custom configuration couldn't get loaded!");
            System.err.println("Please make sure all fields are integer values.");
            loadBackupConfiguration();
        }catch (MissingFieldException e){
            System.err.println("SimulatorConfiguration file is missing fields:");
            e.printMissingFields();
            loadBackupConfiguration();
        }
    }

    protected static void tryLoadConfiguration(Properties properties) throws MissingFieldException, NumberFormatException{
            ArrayList<Settings> missingFields = new ArrayList<>();
            for (Settings settings : Settings.values()) {
                if(properties.getProperty(settings.getPropertyName()) != null) {
                    int value = Integer.parseInt(properties.getProperty(settings.getPropertyName()));
                    configuration.put(settings, value);
                }else{
                    missingFields.add(settings);
                }
            }
            if(missingFields.size()>0){
                throw new MissingFieldException(missingFields);
            }
    }

    protected static int getConfiguration(Settings settings){
        return configuration.get(settings);
    }

    private static void loadBackupConfiguration(){
        //TODO("Method not yet existent"); - ASK FOR INPUT ("Do you wanna load backup configuration?");
        Delayer.delay(1000);
        System.out.println(TextColor.ANSI_YELLOW + "Loading default configuration." + TextColor.ANSI_YELLOW);
        configuration.clear();
        for (Settings settings : Settings.values()) {
            configuration.put(settings, settings.getDefaultValue());
        }
        System.out.println(TextColor.ANSI_GREEN + "Default configuration loaded." + TextColor.ANSI_GREEN);
    }

}

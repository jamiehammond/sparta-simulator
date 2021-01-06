package com.sparta.configuration;

import com.sparta.exceptions.MissingFieldException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

class SimulatorConfigurationTest {

    Properties loadingProperties(FileReader fileReader) throws Exception {
        Properties properties = new Properties();
        properties.load(fileReader);
        return properties;
    }

    @Test
    void getConfigurationShouldEqualWithProprietyFromFile() throws Exception {
        boolean allMatching = true;
        Properties goodProperties = loadingProperties(new FileReader("src/test/resources/goodSettings.properties"));
        for (Settings settings : Settings.values()) {
            if (settings.getValue() != Integer.parseInt(goodProperties.getProperty(settings.getPropertyName()))) {
                allMatching = false;
            }
        }
        Assertions.assertTrue(allMatching);
    }

    @Test
    void goodConfiguration() throws Exception {
        Properties goodProperties = loadingProperties(new FileReader("src/test/resources/goodSettings.properties"));
        Assertions.assertDoesNotThrow(() -> SimulatorConfiguration.tryLoadConfiguration(goodProperties));
    }

    @Test
    void invalidEntryConfiguration() throws Exception {
        Properties properties = new Properties();
        properties.load(new FileReader("src/test/resources/invalidEntrySettings.properties"));
        Assertions.assertThrows(NumberFormatException.class, () -> SimulatorConfiguration.tryLoadConfiguration(properties));
    }

    @Test
    void missingFieldsConfiguration() throws Exception {
        Properties properties = loadingProperties(new FileReader("src/test/resources/settingsMissingFields.properties"));
        Assertions.assertThrows(MissingFieldException.class, () -> SimulatorConfiguration.tryLoadConfiguration(properties));
    }

    @Test
    void ifCustomInvalidEntriesSettingsFailLoadBackup() throws Exception{
        Properties goodProperties = loadingProperties(new FileReader("src/test/resources/invalidEntrySettings.properties"));
        SimulatorConfiguration.loadConfiguration(goodProperties);
        boolean allMatching = true;
        for (Settings settings : Settings.values()) {
            if (settings.getValue() != settings.getDefaultValue()) {
                allMatching = false;
            }
        }
        Assertions.assertTrue(allMatching);
    }

    @Test
    void ifCustomMissingFieldsSettingsFailLoadBackup() throws Exception{
        Properties goodProperties = loadingProperties(new FileReader("src/test/resources/settingsMissingFields.properties"));
        SimulatorConfiguration.loadConfiguration(goodProperties);
        boolean allMatching = true;
        for (Settings settings : Settings.values()) {
            if (settings.getValue() != settings.getDefaultValue()) {
                allMatching = false;
            }
        }
        Assertions.assertTrue(allMatching);
    }

    @Test
    void ifCustomSettingsFailAndAreMissingFieldsItShouldBeShown() throws Exception {
        Properties goodProperties = loadingProperties(new FileReader("src/test/resources/settingsMissingFields.properties"));
        MissingFieldException exception = Assertions.assertThrows(MissingFieldException.class, ()->SimulatorConfiguration.tryLoadConfiguration(goodProperties));
        int size = exception.getMissingFields().size();
        //2 missing fields hardcoded
        Assertions.assertEquals(2, size);
    }
}
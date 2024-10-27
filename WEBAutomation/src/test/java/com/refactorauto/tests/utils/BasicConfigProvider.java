package com.refactorauto.tests.utils;

import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

public class BasicConfigProvider {

    private String testingMode = "local";
    private String hostName = "localhost";
    private int port = 4444;
    private List<Platform> platforms;

    public String getTestingMode() {
        return testingMode;
    }

    public void setTestingMode(String testingMode) {
        this.testingMode = testingMode;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public List<Platform> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(List<Platform> platforms) {
        this.platforms = platforms;
    }

    public static class Platform {
        private String os;
        private String browserName;

        public String getOs() {
            return os;
        }

        public void setOs(String os) {
            this.os = os;
        }

        public String getBrowserName() {
            return browserName;
        }

        public void setBrowserName(String browserName) {
            this.browserName = browserName;
        }

    }

    // Method to load configuration from a YAML file
    public static BasicConfigProvider loadConfig(String filePath) {
        Yaml yaml = new Yaml(new Constructor(BasicConfigProvider.class,new LoaderOptions()));
        try (InputStream inputStream = new FileInputStream(filePath)) {
            return yaml.load(inputStream);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load configuration from YAML file: " + filePath, e);
        }
    }

}

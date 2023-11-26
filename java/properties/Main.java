import java.io.*;
import java.util.Objects;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Properties props = loadProperties("app.properties", null);
        props = overrideProperties("override.properties", props);
        System.out.println(props.getProperty("app.name"));
    }

    public static Properties loadProperties(String propertiesFile, Properties defaults) {
        Properties props;
        if (defaults != null) {
            props = new Properties(defaults);
        } else {
            props = new Properties();
        }

        try (InputStream input = Main.class.getClassLoader().getResourceAsStream(propertiesFile)) {
            Objects.requireNonNull(props).load(input);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return props;
    }

    public static Properties overrideProperties(String propertiesFile, Properties defaults) {
        Properties props;
        if (defaults != null) {
            props = new Properties(defaults);
        } else {
            props = new Properties();
        }

        try (InputStream input = new FileInputStream(new File(propertiesFile))){
            Objects.requireNonNull(props).load(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return props;
    }
}
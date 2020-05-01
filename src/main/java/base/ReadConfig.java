package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;

public class ReadConfig {

//    Properties prop = new Properties();
//    InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties");
    private static ResourceBundle rb = ResourceBundle.getBundle("config");

//    public void property() throws IOException {
//        prop.load(input);
//
//        System.out.println(prop.getProperty("browser"));
//
//    }

    public ReadConfig() throws FileNotFoundException {
    }

    public String loadConfig(String prop) {

        String browser = rb.getString(prop);
        if (!browser.equals("")) return browser;
        else throw new RuntimeException("Browser property not found. Please specify a browser in config.properties");

    }


}

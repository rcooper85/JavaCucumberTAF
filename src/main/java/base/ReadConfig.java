package base;

import java.util.ResourceBundle;

public class ReadConfig {

    private static ResourceBundle rb = ResourceBundle.getBundle("config");

    public String loadConfig(String prop) {

        String browser = rb.getString(prop);
        if (browser!=null) return browser;
        else throw new RuntimeException("Browser property not found. Please specify a browser in config.properties");

        //return rb.getString(prop);
    }


}

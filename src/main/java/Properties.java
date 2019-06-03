import java.io.IOException;
import java.io.InputStream;

public class Properties {

    public static void loadProperties()  {
        java.util.Properties p = new java.util.Properties(System.getProperties());
        InputStream input = Properties.class.getClassLoader().getResourceAsStream("config.properties");

        try {
            p.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        // for loop voor het overschrijven van properties die vanaf de command line worden meegegeven.
        for (String propertyName : p.stringPropertyNames()) {
            if (System.getProperty(propertyName) == null) {
                System.setProperty(propertyName, p.getProperty(propertyName));
            }
        }
    }

}

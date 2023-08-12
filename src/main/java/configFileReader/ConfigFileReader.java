package configFileReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    private Properties properties;
    private final String propertyFilePath= "config/config.properties";

    public ConfigFileReader()
    {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public String getBaseURI()
    {
        String baseURI=properties.getProperty("baseURI");
        if(baseURI!= null)
            return baseURI;
        else
            throw new RuntimeException("baseURI not specified in the config.properties file.");
    }

    public String getAuthTokenCreationPathParam()
    {
        String authTokenCreationPathParam=properties.getProperty("authTokenCreationPathParam");
        if(authTokenCreationPathParam!= null)
            return authTokenCreationPathParam;
        else
            throw new RuntimeException("authTokenCreationPathParam not specified in the config.properties file.");
    }

    public String getPingHealthCheckPathParam()
    {
        String pingHealthCheckPathParam=properties.getProperty("pingHealthCheckPathParam");
        if(pingHealthCheckPathParam!= null)
            return pingHealthCheckPathParam;
        else
            throw new RuntimeException("pingHealthCheckPathParam not specified in the config.properties file.");
    }

    public String getCreateBookingIDPathParam()
    {
        String createBookingIDPathParam=properties.getProperty("createBookingIDPathParam");
        if(createBookingIDPathParam!= null)
            return createBookingIDPathParam;
        else
            throw new RuntimeException("createBookingIDPathParam not specified in the config.properties file.");
    }
}

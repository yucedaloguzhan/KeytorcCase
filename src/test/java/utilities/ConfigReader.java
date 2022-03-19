package utilities;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static Properties properties;

    static {

        String path="C:\\Users\\Oğuz\\IdeaProjects\\SampleCaseTr\\configurations.properties";

        try {

            FileInputStream fis=new FileInputStream(path);
            properties=new Properties();
            properties.load(fis);
            fis.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public static String getProperty(String key){

        return properties.getProperty(key);
    }


}
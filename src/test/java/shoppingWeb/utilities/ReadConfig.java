package shoppingWeb.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
    Properties pro;
    public ReadConfig() {
        File myfile = new File("./projConfiguration/config.properties");
        try {
            FileInputStream fis = new FileInputStream(myfile);
            pro = new Properties();
            pro.load(fis);
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }
    public String getURL(){
        String url = pro.getProperty("baseURL");
        return url;
    }

    public String getUsername(){
        String username = pro.getProperty("username");
        return username;
    }
    public String getPassword(){
        String pass = pro.getProperty("password");
        return pass;
    }
    public String getChromePath(){
        String chromepath = pro.getProperty("chromepath");
        return chromepath;
    }
    public String getFirefoxPath(){
        String firefoxpath = pro.getProperty("firefoxpath");
        return firefoxpath;
    }
    public String getIEPath(){
        String iepath = pro.getProperty("iepath");
        return  iepath;
    }


}

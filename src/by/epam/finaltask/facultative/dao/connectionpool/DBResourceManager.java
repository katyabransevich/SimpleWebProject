package by.epam.finaltask.facultative.dao.connectionpool;

import java.util.ResourceBundle;

/**
 * Created by Admin on 08.04.2016.
 */
public class DBResourceManager {
    private final static DBResourceManager instance= new DBResourceManager();
    private ResourceBundle bundle= ResourceBundle.getBundle("by.epam.finaltask.facultative.dao.connectionpool.db");
    public static DBResourceManager getInstance(){
        return instance;
    }
    public String getValue(String key){
        return bundle.getString(key);
    }
}

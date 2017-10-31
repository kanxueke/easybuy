package com.easybuy.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {

	private static ConfigManager configManager;
	private static Properties properties;
	
	//单例模式
	private ConfigManager(){
		try {
			properties=new Properties();
			//类加载器
			InputStream is = ConfigManager.class.getClassLoader().getResourceAsStream("database.properties");
			
			properties.load(is);
			is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//获得实例的静态方�?
	public static ConfigManager getInstance(){
		if(configManager==null){
			configManager=new ConfigManager();
		}
		return configManager;
	}
	
	public String getString(String key){
		return properties.getProperty(key);
	}
	
	/**
	 * 加载properties的第二种方法
	 */
	private static Properties props = null;

    static {
        InputStream is = null;
        is = ConfigManager.class.getClassLoader().getResourceAsStream(
                "database.properties");
        if (is == null)
            throw new RuntimeException("找不到数据库参数配置文件�?");
        props = new Properties();
        try {
            props.load(is);
        } catch (IOException e) {
            throw new RuntimeException("数据库配置参数加载错误！", e);
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getProperty(String key) {
        return props.getProperty(key);
    }
	
}

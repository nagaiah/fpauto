package seleniumauto;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigManager {
	
	private static Properties p;
	public static Properties getProperties(String fileName)
	{
		try{
		//String path=System.getProperty("user.dir");
			String path="F:\\naga\\seleniumauto\\src\\seleniumauto\\";
		String filePath=path+"\\"+fileName;
		p=new Properties();
		p.load(new FileInputStream(new File(filePath)));
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return p;
	}

}

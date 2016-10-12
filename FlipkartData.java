package seleniumauto;

import java.util.Properties;

public class FlipkartData {

	static Properties con=ConfigManager.getProperties("fp.properties");
	
	
	public static final String mobileNo=con.getProperty("loginEmail");
	public static final String password=con.getProperty("loginPwd");
}

package framework;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class PropertiesResourceManager {

	private Properties properties = new Properties();

	public PropertiesResourceManager() {
		properties = new Properties();
	}

	public PropertiesResourceManager(final String resourceName) {
		appendFromResource(properties, resourceName);
	}

	public PropertiesResourceManager(final String defaultResourceName, final String resourceName) {
		this(defaultResourceName);
		properties = appendFromResource(new Properties(properties), resourceName);
	}

	private Properties appendFromResource(final Properties objProperties, final String resourceName) {
		InputStream inStream = this.getClass().getClassLoader().getResourceAsStream(resourceName);

		if (inStream != null) {
			try {
				objProperties.load(inStream);
				inStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.err.printf("Resource \"%1$s\" could not be found%n", resourceName);
		}
		return objProperties;
	}

	public String getProperty(final String key) {
		return properties.getProperty(key);
	}

	public String getProperty(final String key, final String defaultValue) {
		return properties.getProperty(key, defaultValue);
	}

	public void setProperty(final String key, final String value) {
		properties.setProperty(key, value);
	}
}

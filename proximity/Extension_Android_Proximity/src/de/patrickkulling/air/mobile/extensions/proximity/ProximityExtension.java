package de.patrickkulling.air.mobile.extensions.proximity;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREExtension;

public class ProximityExtension implements FREExtension
{
	private ProximityContext context;

	public FREContext createContext(String arg0)
	{
		context = new ProximityContext();
		
		return context;
	}

	public void dispose()
	{
		context.dispose();
		
		context = null;
	}

	public void initialize()
	{
	}
}
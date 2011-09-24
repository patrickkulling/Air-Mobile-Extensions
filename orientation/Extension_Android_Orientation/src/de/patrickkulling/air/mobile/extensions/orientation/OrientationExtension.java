package de.patrickkulling.air.mobile.extensions.orientation;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREExtension;

public class OrientationExtension implements FREExtension
{
	private OrientationContext context;

	public FREContext createContext(String arg0)
	{
		context = new OrientationContext();
		
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
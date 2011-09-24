package de.patrickkulling.air.mobile.extensions.ambientlight;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREExtension;

public class AmbientLightExtension implements FREExtension
{
	private AmbientLightContext context;

	public FREContext createContext(String arg0)
	{
		context = new AmbientLightContext();
		
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
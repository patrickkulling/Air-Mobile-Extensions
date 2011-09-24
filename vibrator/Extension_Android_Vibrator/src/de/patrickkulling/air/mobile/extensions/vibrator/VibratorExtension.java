package de.patrickkulling.air.mobile.extensions.vibrator;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREExtension;

public class VibratorExtension implements FREExtension
{
	private VibratorContext context;

	public FREContext createContext(String arg0)
	{
		context = new VibratorContext();

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
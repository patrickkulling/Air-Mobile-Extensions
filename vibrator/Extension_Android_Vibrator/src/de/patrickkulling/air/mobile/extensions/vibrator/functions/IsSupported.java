package de.patrickkulling.air.mobile.extensions.vibrator.functions;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.adobe.fre.FREWrongThreadException;

import de.patrickkulling.air.mobile.extensions.vibrator.VibratorContext;

public class IsSupported implements FREFunction
{
	public FREObject call(FREContext context, FREObject[] params)
	{
		FREObject result = null;

		VibratorContext vibratorContext = (VibratorContext) context;

		try
		{
			if (vibratorContext.vibrator == null)
				result = FREObject.newObject(false);
			else
				result = FREObject.newObject(true);
		}
		catch (FREWrongThreadException exception)
		{
			exception.printStackTrace();
		}

		return result;
	}
}
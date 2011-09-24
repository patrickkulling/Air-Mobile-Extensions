package de.patrickkulling.air.mobile.extensions.vibrator.functions;

import android.os.Vibrator;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREInvalidObjectException;
import com.adobe.fre.FREObject;
import com.adobe.fre.FRETypeMismatchException;
import com.adobe.fre.FREWrongThreadException;

import de.patrickkulling.air.mobile.extensions.vibrator.VibratorContext;

public class Vibrate implements FREFunction
{
	public FREObject call(FREContext context, FREObject[] params)
	{
		int milliseconds = getMilliseconds(params);

		if (milliseconds != -1)
		{
			VibratorContext vibratorContext = (VibratorContext)context;
			Vibrator vibrator = vibratorContext.vibrator;

			if(vibrator != null)
				vibrator.vibrate(milliseconds);
		}

		return null;
	}

	private int getMilliseconds(FREObject[] params)
	{
		int milliseconds = -1;

		try
		{
			milliseconds = params[0].getAsInt();
		} catch (IllegalStateException e)
		{
			e.printStackTrace();
		} catch (FRETypeMismatchException e)
		{
			e.printStackTrace();
		} catch (FREInvalidObjectException e)
		{
			e.printStackTrace();
		} catch (FREWrongThreadException e)
		{
			e.printStackTrace();
		}

		return milliseconds;
	}
}
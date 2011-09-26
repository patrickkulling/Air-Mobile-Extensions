package de.patrickkulling.air.mobile.extensions.vibrator.functions;

import android.os.Vibrator;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

import de.patrickkulling.air.mobile.extensions.vibrator.VibratorContext;

public class Cancel implements FREFunction
{

	public FREObject call(FREContext context, FREObject[] params)
	{
		VibratorContext vibratorContext = (VibratorContext) context;
		Vibrator vibrator = vibratorContext.vibrator;

		if (vibrator != null)
			vibrator.cancel();

		return null;
	}

}
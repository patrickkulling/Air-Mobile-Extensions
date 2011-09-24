package de.patrickkulling.air.mobile.extensions.vibrator.functions;

import android.app.Activity;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

import de.patrickkulling.air.mobile.extensions.vibrator.VibratorContext;

import android.os.Vibrator;
import android.content.Context;

public class Initialize implements FREFunction
{

	public FREObject call(FREContext context, FREObject[] params)
	{
		VibratorContext vibratorContext = (VibratorContext) context;
		
		Activity activity = vibratorContext.getActivity();

		vibratorContext.vibrator = (Vibrator)activity.getSystemService(Context.VIBRATOR_SERVICE);

		return null;
	}
}
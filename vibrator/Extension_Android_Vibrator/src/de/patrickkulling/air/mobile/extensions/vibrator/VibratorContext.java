package de.patrickkulling.air.mobile.extensions.vibrator;

import java.util.HashMap;
import java.util.Map;

import android.os.Vibrator;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;

import de.patrickkulling.air.mobile.extensions.vibrator.functions.Initialize;
import de.patrickkulling.air.mobile.extensions.vibrator.functions.IsSupported;
import de.patrickkulling.air.mobile.extensions.vibrator.functions.Vibrate;

public class VibratorContext extends FREContext
{
	private HashMap<String, FREFunction> availableFunctions;
	
	public Vibrator vibrator;

	@Override
	public void dispose()
	{
		availableFunctions = null;
	}

	@Override
	public Map<String, FREFunction> getFunctions()
	{
		availableFunctions = new HashMap<String, FREFunction>();

		availableFunctions.put("initialize", new Initialize());

		availableFunctions.put("isSupported", new IsSupported());
		availableFunctions.put("vibrate", new Vibrate());
		
		return availableFunctions;
	}
}
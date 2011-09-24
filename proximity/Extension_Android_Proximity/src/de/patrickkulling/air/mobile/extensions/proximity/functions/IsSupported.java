package de.patrickkulling.air.mobile.extensions.proximity.functions;

import android.hardware.Sensor;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

import de.patrickkulling.air.mobile.extensions.proximity.ProximityContext;

public class IsSupported implements FREFunction
{
	public FREObject call(FREContext context, FREObject[] params)
	{
		ProximityContext orientationContext = (ProximityContext) context;

		Sensor orientationSensor = orientationContext.proximitySensor;

		boolean isSupported = false;

		if (orientationSensor != null)
			isSupported = true;

		FREObject returnObject = null;

		try
		{
			returnObject = FREObject.newObject(isSupported);

		} catch (Exception e)
		{
		}

		return returnObject;
	}
}
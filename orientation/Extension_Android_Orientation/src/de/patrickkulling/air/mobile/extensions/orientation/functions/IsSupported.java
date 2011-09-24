package de.patrickkulling.air.mobile.extensions.orientation.functions;

import android.hardware.Sensor;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

import de.patrickkulling.air.mobile.extensions.orientation.OrientationContext;

public class IsSupported implements FREFunction
{
	public FREObject call(FREContext context, FREObject[] params)
	{
		OrientationContext orientationContext = (OrientationContext) context;

		Sensor orientationSensor = orientationContext.orientationSensor;

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
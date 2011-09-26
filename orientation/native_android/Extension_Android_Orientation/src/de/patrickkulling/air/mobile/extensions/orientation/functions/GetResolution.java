package de.patrickkulling.air.mobile.extensions.orientation.functions;

import android.hardware.Sensor;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

import de.patrickkulling.air.mobile.extensions.orientation.OrientationContext;

public class GetResolution implements FREFunction
{

	public FREObject call(FREContext context, FREObject[] params)
	{
		OrientationContext orientationContext = (OrientationContext) context;

		Sensor orientationSensor = orientationContext.orientationSensor;

		FREObject returnObject = null;

		if (orientationSensor != null)
		{
			try
			{
				returnObject = FREObject.newObject(orientationSensor.getResolution());
			} catch (Exception e)
			{
			}
		}
		
		return returnObject;
	}

}
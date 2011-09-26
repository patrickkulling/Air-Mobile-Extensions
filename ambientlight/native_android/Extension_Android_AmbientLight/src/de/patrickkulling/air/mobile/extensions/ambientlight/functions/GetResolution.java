package de.patrickkulling.air.mobile.extensions.ambientlight.functions;

import android.hardware.Sensor;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

import de.patrickkulling.air.mobile.extensions.ambientlight.AmbientLightContext;

public class GetResolution implements FREFunction
{

	public FREObject call(FREContext context, FREObject[] params)
	{
		AmbientLightContext ambientLightContext = (AmbientLightContext) context;

		Sensor ambientLightSensor = ambientLightContext.ambientLightSensor;

		FREObject returnObject = null;

		if (ambientLightSensor != null)
		{
			try
			{
				returnObject = FREObject.newObject(ambientLightSensor.getResolution());
			} catch (Exception e)
			{
			}
		}
		
		return returnObject;
	}

}
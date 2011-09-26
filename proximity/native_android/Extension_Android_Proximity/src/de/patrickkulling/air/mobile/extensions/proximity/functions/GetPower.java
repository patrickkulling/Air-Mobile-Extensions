package de.patrickkulling.air.mobile.extensions.proximity.functions;

import android.hardware.Sensor;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

import de.patrickkulling.air.mobile.extensions.proximity.ProximityContext;

public class GetPower implements FREFunction
{

	public FREObject call(FREContext context, FREObject[] params)
	{
		ProximityContext proximityContext = (ProximityContext) context;

		Sensor proximitySensor = proximityContext.proximitySensor;

		FREObject returnObject = null;

		if (proximitySensor != null)
		{
			try
			{
				returnObject = FREObject.newObject(proximitySensor.getPower());
			} catch (Exception e)
			{
			}
		}
		
		return returnObject;
	}

}
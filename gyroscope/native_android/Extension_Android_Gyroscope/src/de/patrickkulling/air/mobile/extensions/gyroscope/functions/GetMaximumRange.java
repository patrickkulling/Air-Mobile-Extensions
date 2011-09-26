package de.patrickkulling.air.mobile.extensions.gyroscope.functions;

import android.hardware.Sensor;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

import de.patrickkulling.air.mobile.extensions.gyroscope.GyroscopeContext;

public class GetMaximumRange implements FREFunction
{

	public FREObject call(FREContext context, FREObject[] params)
	{
		GyroscopeContext gyroscopeContext = (GyroscopeContext) context;

		Sensor gyroscopeSensor = gyroscopeContext.gyroscopeSensor;

		FREObject returnObject = null;

		if (gyroscopeSensor != null)
		{
			try
			{
				returnObject = FREObject.newObject(gyroscopeSensor.getMaximumRange());
			} catch (Exception e)
			{
			}
		}
		
		return returnObject;
	}

}
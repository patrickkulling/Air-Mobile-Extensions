package de.patrickkulling.air.mobile.extensions.ambientlight.functions;

import android.hardware.Sensor;
import android.hardware.SensorManager;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

import de.patrickkulling.air.mobile.extensions.ambientlight.AmbientLightContext;
import de.patrickkulling.air.mobile.extensions.ambientlight.listener.AmbientLightListener;

public class StopAmbientLight implements FREFunction
{
	public FREObject call(FREContext context, FREObject[] params)
	{
		AmbientLightContext proximityContext = (AmbientLightContext) context;

		SensorManager sensorManager = proximityContext.sensorManager;
		Sensor ambientLightSensor = proximityContext.ambientLightSensor;
		AmbientLightListener ambientLightListener = proximityContext.ambientLightListener;

		if (ambientLightSensor != null)
			sensorManager.unregisterListener(ambientLightListener, ambientLightSensor);

		return null;
	}
}
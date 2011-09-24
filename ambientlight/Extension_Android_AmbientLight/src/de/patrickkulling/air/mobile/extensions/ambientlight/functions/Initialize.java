package de.patrickkulling.air.mobile.extensions.ambientlight.functions;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

import de.patrickkulling.air.mobile.extensions.ambientlight.AmbientLightContext;
import de.patrickkulling.air.mobile.extensions.ambientlight.listener.AmbientLightListener;

public class Initialize implements FREFunction
{
	public FREObject call(FREContext context, FREObject[] params)
	{
		AmbientLightContext proximityContext = (AmbientLightContext) context;

		SensorManager sensorManager = (SensorManager) proximityContext.getActivity().getSystemService(Context.SENSOR_SERVICE);

		proximityContext.sensorManager = sensorManager;
		proximityContext.ambientLightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
		proximityContext.ambientLightListener = new AmbientLightListener((AmbientLightContext) context);

		return null;
	}
}
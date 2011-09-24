package de.patrickkulling.air.mobile.extensions.proximity.functions;

import android.hardware.Sensor;
import android.hardware.SensorManager;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

import de.patrickkulling.air.mobile.extensions.proximity.ProximityContext;
import de.patrickkulling.air.mobile.extensions.proximity.listener.ProximityListener;

public class StartProximity implements FREFunction
{

	public FREObject call(FREContext context, FREObject[] params)
	{
		ProximityContext proximityContext = (ProximityContext) context;

		SensorManager sensorManager = proximityContext.sensorManager;
		Sensor proximitySensor = proximityContext.proximitySensor;
		ProximityListener proximityListener = proximityContext.proximityListener;

		if (proximitySensor != null)
			sensorManager.registerListener(proximityListener, proximitySensor, SensorManager.SENSOR_DELAY_FASTEST);

		return null;
	}
}
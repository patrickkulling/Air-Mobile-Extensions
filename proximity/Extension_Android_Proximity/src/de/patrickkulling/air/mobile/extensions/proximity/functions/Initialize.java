package de.patrickkulling.air.mobile.extensions.proximity.functions;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

import de.patrickkulling.air.mobile.extensions.proximity.ProximityContext;
import de.patrickkulling.air.mobile.extensions.proximity.listener.ProximityListener;

public class Initialize implements FREFunction
{
	public FREObject call(FREContext context, FREObject[] params)
	{
		ProximityContext proximityContext = (ProximityContext) context;

		SensorManager sensorManager = (SensorManager) proximityContext.getActivity().getSystemService(Context.SENSOR_SERVICE);

		proximityContext.sensorManager = sensorManager;
		proximityContext.proximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
		proximityContext.proximityListener = new ProximityListener((ProximityContext) context);

		return null;
	}
}
package de.patrickkulling.air.mobile.extensions.orientation.functions;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

import de.patrickkulling.air.mobile.extensions.orientation.OrientationContext;
import de.patrickkulling.air.mobile.extensions.orientation.listener.OrientationListener;

public class Initialize implements FREFunction
{
	public FREObject call(FREContext context, FREObject[] params)
	{
		OrientationContext orientationContext = (OrientationContext) context;

		SensorManager sensorManager = (SensorManager) orientationContext.getActivity().getSystemService(Context.SENSOR_SERVICE);

		orientationContext.sensorManager = sensorManager;
		orientationContext.orientationSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);
		orientationContext.orientationListener = new OrientationListener((OrientationContext) context);

		return null;
	}
}
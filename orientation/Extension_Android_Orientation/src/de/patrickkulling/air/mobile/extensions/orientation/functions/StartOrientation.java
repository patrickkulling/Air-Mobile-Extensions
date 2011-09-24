package de.patrickkulling.air.mobile.extensions.orientation.functions;

import android.hardware.Sensor;
import android.hardware.SensorManager;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

import de.patrickkulling.air.mobile.extensions.orientation.OrientationContext;
import de.patrickkulling.air.mobile.extensions.orientation.listener.OrientationListener;

public class StartOrientation implements FREFunction
{

	public FREObject call(FREContext context, FREObject[] params)
	{
		OrientationContext orientationContext = (OrientationContext) context;

		SensorManager sensorManager = orientationContext.sensorManager;
		Sensor orientationSensor = orientationContext.orientationSensor;
		OrientationListener orientationListener = orientationContext.orientationListener;

		if (orientationSensor != null)
			sensorManager.registerListener(orientationListener, orientationSensor, SensorManager.SENSOR_DELAY_FASTEST);

		return null;
	}
}
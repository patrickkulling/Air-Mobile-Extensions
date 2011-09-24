package de.patrickkulling.air.mobile.extensions.orientation.listener;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.util.Log;
import de.patrickkulling.air.mobile.extensions.orientation.OrientationContext;
import de.patrickkulling.air.mobile.extensions.orientation.events.OrientationStatus;

public class OrientationListener implements SensorEventListener
{
	private final OrientationContext context;

	public OrientationListener(OrientationContext context)
	{
		this.context = context;
	}

	public void onAccuracyChanged(Sensor sensor, int accuracy)
	{
		if (context != null)
		{
			try
			{
				context.dispatchStatusEventAsync(OrientationStatus.ACCURACY_CHANGE, Integer.toString(accuracy));
			} catch (IllegalArgumentException e)
			{
				Log.e("OrientationListener", "context is not available anymore.");
			}
		}
	}

	public void onSensorChanged(SensorEvent event)
	{
		if (context != null)
		{
			StringBuilder orientationValues = new StringBuilder(Float.toString(event.values[0]));

			orientationValues.append("&").append(Float.toString(event.values[1])).append("&").append(Float.toString(event.values[2]));

			try
			{
				context.dispatchStatusEventAsync(OrientationStatus.SENSOR_CHANGE, orientationValues.toString());
			} catch (IllegalArgumentException e)
			{
				Log.e("OrientationListener", "context is not available anymore.");
			}
		}
	}
}
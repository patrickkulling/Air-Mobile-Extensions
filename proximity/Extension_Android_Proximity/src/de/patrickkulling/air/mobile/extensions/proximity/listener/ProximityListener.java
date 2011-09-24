package de.patrickkulling.air.mobile.extensions.proximity.listener;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.util.Log;
import de.patrickkulling.air.mobile.extensions.proximity.ProximityContext;
import de.patrickkulling.air.mobile.extensions.proximity.events.ProximityStatus;

public class ProximityListener implements SensorEventListener
{
	private final ProximityContext context;

	public ProximityListener(ProximityContext context)
	{
		this.context = context;
	}

	public void onAccuracyChanged(Sensor sensor, int accuracy)
	{
		if (context != null)
		{
			try
			{
				context.dispatchStatusEventAsync(ProximityStatus.ACCURACY_CHANGE, Integer.toString(accuracy));
			} catch (IllegalArgumentException e)
			{
				Log.e("ProximityListener", "context is not available anymore.");
			}
		}
	}

	public void onSensorChanged(SensorEvent event)
	{
		if (context != null)
		{
			float distance = event.values[0];

			try
			{
				context.dispatchStatusEventAsync(ProximityStatus.SENSOR_CHANGE, Float.toString(distance));
			} catch (IllegalArgumentException e)
			{
				Log.e("ProximityListener", "context is not available anymore.");
			}
		}
	}
}
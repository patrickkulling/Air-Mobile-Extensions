package de.patrickkulling.air.mobile.extensions.battery.functions;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

import de.patrickkulling.air.mobile.extensions.battery.BatteryContext;
import de.patrickkulling.air.mobile.extensions.battery.broadcast.BatteryBroadcastReceiver;

public class Initialize implements FREFunction
{

	public FREObject call(FREContext context, FREObject[] params)
	{
		BatteryContext batteryContext = (BatteryContext) context;
		Activity activity = batteryContext.getActivity();

		batteryContext.batteryBroadcastReceiver = new BatteryBroadcastReceiver(batteryContext);

		activity.registerReceiver(batteryContext.batteryBroadcastReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
		
		return null;
	}

}
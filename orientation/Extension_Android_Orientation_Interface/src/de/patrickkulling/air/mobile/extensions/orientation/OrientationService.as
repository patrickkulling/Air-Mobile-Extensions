package de.patrickkulling.air.mobile.extensions.orientation
{
	import de.patrickkulling.air.mobile.extensions.orientation.event.OrientationStatus;

	import flash.events.StatusEvent;

	import de.patrickkulling.air.mobile.extensions.orientation.event.OrientationEvent;

	import flash.events.EventDispatcher;
	import flash.events.TimerEvent;
	import flash.utils.Timer;
	import flash.external.ExtensionContext;

	[Event(name="OrientationEvent.UPDATE", type="de.patrickkulling.air.mobile.extensions.orientation.event.OrientationEvent")]
	public class OrientationService extends EventDispatcher
	{
		private static const EXTENSION_ID : String = "de.patrickkulling.air.mobile.extensions.orientation";

		private static var context : ExtensionContext;

		private var intervalTimer : Timer;
		private var interval : Number = 200;

		private var _azimuth : Number = 0;
		private var _pitch : Number = 0;
		private var _roll : Number = 0;
		private var _accuracy : Number = 0;

		public function OrientationService()
		{
			if (context == null)
				initContext();

			context.addEventListener(StatusEvent.STATUS, handleOrientationStatus);

			createIntervalTimer();
		}

		public static function isSupported() : Boolean
		{
			if (context == null)
				initContext();

			return context.call("isSupported") as Boolean;
		}

		public function setRequestedUpdateInterval(interval : Number) : void
		{
			this.interval = interval;

			disposeIntervalTimer();

			createIntervalTimer();
		}

		public function dispose() : void
		{
			if (context == null)
				return;

			context.call("stopOrientation");
			context.removeEventListener(StatusEvent.STATUS, handleOrientationStatus);
			context.dispose();
			context = null;
		}

		private static function initContext() : void
		{
			context = ExtensionContext.createExtensionContext(EXTENSION_ID, null);

			context.call("initialize");
			context.call("startOrientation");
		}

		private function disposeIntervalTimer() : void
		{
			if (intervalTimer != null)
			{
				intervalTimer.removeEventListener(TimerEvent.TIMER, handleIntervalTimer);
				intervalTimer.stop();
				intervalTimer = null;
			}
		}

		private function createIntervalTimer() : void
		{
			intervalTimer = new Timer(interval);
			intervalTimer.addEventListener(TimerEvent.TIMER, handleIntervalTimer);
			intervalTimer.start();
		}

		private function handleIntervalTimer(event : TimerEvent) : void
		{
			if (context != null)
				dispatchEvent(new OrientationEvent(OrientationEvent.UPDATE, _azimuth, _pitch, _roll, _accuracy));
		}

		private function handleOrientationStatus(event : StatusEvent) : void
		{
			switch(event.code)
			{
				case OrientationStatus.ACCURACY_CHANGE:
					_accuracy = parseInt(event.level);

					break;
				case OrientationStatus.SENSOR_CHANGE:
					var values : Array = event.level.split("&");

					_azimuth = Number(values[0]);
					_pitch = Number(values[1]);
					_roll = Number(values[2]);

					break;

				default:
			}
		}
	}
}
/*
 * Copyright (c) 2011 Patrick Kulling
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package de.patrickkulling.air.mobile.extensions.proximity
{
	import de.patrickkulling.air.mobile.extensions.proximity.event.ProximityEvent;
	import de.patrickkulling.air.mobile.extensions.proximity.event.ProximityStatus;

	import flash.events.EventDispatcher;
	import flash.events.StatusEvent;
	import flash.events.TimerEvent;
	import flash.external.ExtensionContext;
	import flash.utils.Timer;

	[Event(name="ProximityEvent.UPDATE", type="de.patrickkulling.air.mobile.extensions.proximity.event.ProximityEvent")]
	public class Proximity extends EventDispatcher
	{
		private static const EXTENSION_ID : String = "de.patrickkulling.air.mobile.extensions.proximity";

		private static var context : ExtensionContext;
		private static var referenceCount : int = 0;
		
		private static var _distance : Number = 0;
		private static var _accuracy : Number = 0;
		private var intervalTimer : Timer;
		private var interval : Number = 200;


		public function Proximity()
		{
			if (context == null)
				initContext();

			if (context.hasEventListener(StatusEvent.STATUS) == false)
				context.addEventListener(StatusEvent.STATUS, handleProximityStatus);

			createIntervalTimer();

			referenceCount++;
		}

		public static function isSupported() : Boolean
		{
			var isOrientationSupported : Boolean = false;

			var localContext : ExtensionContext = ExtensionContext.createExtensionContext(EXTENSION_ID, null);

			if (localContext != null)
			{
				localContext.call("initialize");
				isOrientationSupported = localContext.call("isSupported") as Boolean;

				localContext.dispose();
				localContext = null;
			}

			return isOrientationSupported;
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

			disposeIntervalTimer();

			referenceCount--;

			if (referenceCount < 0)
				referenceCount = 0;

			if (referenceCount == 0)
			{
				context.removeEventListener(StatusEvent.STATUS, handleProximityStatus);
				context.call("stopProximity");
				context.dispose();
				context = null;
			}
		}

		private static function initContext() : void
		{
			context = ExtensionContext.createExtensionContext(EXTENSION_ID, null);

			context.call("initialize");
			context.call("startProximity");
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
				dispatchEvent(new ProximityEvent(ProximityEvent.UPDATE, _distance, _accuracy));
		}

		private function handleProximityStatus(event : StatusEvent) : void
		{
			switch(event.code)
			{
				case ProximityStatus.ACCURACY_CHANGE:
					_accuracy = parseInt(event.level);

					break;
				case ProximityStatus.SENSOR_CHANGE:
					_distance = parseFloat(event.level);

					break;

				default:
			}
		}
	}
}
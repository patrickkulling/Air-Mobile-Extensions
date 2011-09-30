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
package de.patrickkulling.air.mobile.extensions.battery
{
	import de.patrickkulling.air.mobile.extensions.battery.event.BatteryEvent;

	import flash.events.EventDispatcher;

	import de.patrickkulling.air.mobile.extensions.battery.event.BatteryStatus;

	import flash.events.StatusEvent;
	import flash.external.ExtensionContext;

	[Event(name="BatteryEvent.UPDATE", type="de.patrickkulling.air.mobile.extensions.battery.event.BatteryEvent")]
	public class Battery extends EventDispatcher
	{
		protected static const EXTENSION_ID : String = "de.patrickkulling.air.mobile.extensions.battery";

		protected static var context : ExtensionContext;
		protected static var referenceCount : int = 0;

		protected static var level : Number;
		protected static var scale : Number;
		protected static var temperature : Number;
		protected static var voltage : Number;

		public function Battery()
		{
			if (context == null)
				initContext();

			if (context.hasEventListener(StatusEvent.STATUS) == false)
				context.addEventListener(StatusEvent.STATUS, handleBatteryStatus);

			referenceCount++;
		}

		protected function handleBatteryStatus(event : StatusEvent) : void
		{
			switch(event.code)
			{
				case BatteryStatus.BATTERY_CHANGE:
					var values : Array = event.level.split("&");

					level = Number(values[0]);
					scale = Number(values[1]);
					temperature = Number(values[2]);
					voltage = Number(values[3]);

					dispatchEvent(new BatteryEvent(BatteryEvent.UPDATE, level, scale, temperature, voltage));

					break;
			}
		}

		public function dispose() : void
		{
			if (context == null)
				return;


			referenceCount--;

			if (referenceCount < 0)
				referenceCount = 0;

			if (referenceCount == 0)
			{
				context.removeEventListener(StatusEvent.STATUS, handleBatteryStatus);
				context.dispose();
				context = null;
			}
		}

		protected static function initContext() : void
		{
			context = ExtensionContext.createExtensionContext(EXTENSION_ID, null);

			context.call("initialize");
		}
	}
}
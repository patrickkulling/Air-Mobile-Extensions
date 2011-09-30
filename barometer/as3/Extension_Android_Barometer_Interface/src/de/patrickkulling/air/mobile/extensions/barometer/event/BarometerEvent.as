/*
 * Copyright (c) 2011 Patrick Kulling, Philipp Arnolds
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
package de.patrickkulling.air.mobile.extensions.barometer.event
{
	import flash.events.Event;

	public class BarometerEvent extends Event
	{
		public static const UPDATE : String = "BarometerEvent.UPDATE";

		private var _accuracy : int;
		private var _pressure : Number;

		public function BarometerEvent(type : String, pressure : Number,  accuracy : int, bubbles : Boolean = false, cancelable : Boolean = false)
		{
			super(type, bubbles, cancelable);

			_pressure = pressure;

			_accuracy = accuracy;
		}

		public function get accuracy() : int
		{
			return _accuracy;
		}

		public override function clone() : Event
		{
			return new BarometerEvent(type, _pressure, _accuracy, bubbles, cancelable);
		}

		public function get pressure() : Number
		{
			return _pressure;
		}
	}
}
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
package de.patrickkulling.air.mobile.extensions.orientation.event
{
	import flash.events.Event;

	public class OrientationEvent extends Event
	{
		public static const UPDATE : String = "OrientationEvent.UPDATE";
		
		private var _azimuth : Number;
		private var _pitch : Number;
		private var _roll : Number;
		private var _accuracy : int;

		public function OrientationEvent(type : String, azimuth : Number, pitch : Number, roll : Number, accuracy : int, bubbles : Boolean = false, cancelable : Boolean = false)
		{
			super(type, bubbles, cancelable);

			_azimuth = azimuth;
			_pitch = pitch;
			_roll = roll;

			_accuracy = accuracy;
		}

		public function get azimuth() : Number
		{
			return _azimuth;
		}

		public function get pitch() : Number
		{
			return _pitch;
		}

		public function get roll() : Number
		{
			return _roll;
		}

		public function get accuracy() : int
		{
			return _accuracy;
		}

		public override function clone() : Event
		{
			return new OrientationEvent(type, _azimuth, _pitch, _roll, _accuracy, bubbles, cancelable);
		}
	}
}
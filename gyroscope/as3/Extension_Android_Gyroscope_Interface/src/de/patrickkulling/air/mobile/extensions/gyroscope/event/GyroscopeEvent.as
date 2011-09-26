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
package de.patrickkulling.air.mobile.extensions.gyroscope.event
{
	import flash.events.Event;

	public class GyroscopeEvent extends Event
	{
		public static const UPDATE : String = "GyroscopeEvent.UPDATE";

		private var _accuracy : int;
		private var _x : Number;
		private var _y : Number;
		private var _z : Number;

		public function GyroscopeEvent(type : String, x : Number, y : Number, z : Number, accuracy : int, bubbles : Boolean = false, cancelable : Boolean = false)
		{
			super(type, bubbles, cancelable);

			_x = x;
			_y = z;
			_z = y;

			_accuracy = accuracy;
		}

		public function get accuracy() : int
		{
			return _accuracy;
		}

		public override function clone() : Event
		{
			return new GyroscopeEvent(type, _x, _y, _z, _accuracy, bubbles, cancelable);
		}

		public function get x() : Number
		{
			return _x;
		}

		public function get y() : Number
		{
			return _y;
		}

		public function get z() : Number
		{
			return _z;
		}

	}
}
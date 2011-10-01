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
 package de.patrickkulling.air.mobile.extensions.notification
{
	public class NotificationDefaults
	{
		protected var _defaults : Vector.<NotificationDefault> = new Vector.<NotificationDefault>();

		public function addNotificationDefault(notificationDefault : NotificationDefault) : void
		{
			if (containsDefaultAllItem() == true)
				return;

			var wasItemAlreadyAdded : Boolean = (_defaults.indexOf(notificationDefault) != -1);

			if (wasItemAlreadyAdded == false)
				_defaults.push(notificationDefault);
		}

		public function get defaultValues() : Vector.<int>
		{
			var _defaultValues : Vector.<int> = new Vector.<int>();

			for each (var notificationDefault : NotificationDefault in _defaults)
				_defaultValues.push(notificationDefault.value);

			return _defaultValues;
		}

		protected function containsDefaultAllItem() : Boolean
		{
			return (_defaults.indexOf(NotificationDefault.DEFAULT_ALL) != -1);
		}
	}
}
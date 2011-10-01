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
package de.patrickkulling.air.mobile.extensions.notification.functions;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;

import com.adobe.fre.FREArray;
import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREInvalidObjectException;
import com.adobe.fre.FREObject;
import com.adobe.fre.FRETypeMismatchException;
import com.adobe.fre.FREWrongThreadException;

import de.patrickkulling.air.mobile.extensions.notification.NotificationContext;

public class Notify implements FREFunction
{
	public FREObject call(FREContext context, FREObject[] params)
	{
		String title = getString(params[0]);
		String message = getString(params[1]);
		int notificationID = getInt(params[2]);
		int notificationDefaults = getDefaults(params[3]);
		String iconName = getString(params[4]);

		if (title != null && message != null && iconName != null)
		{
			NotificationContext notificationContext = (NotificationContext) context;
			NotificationManager notificationManager = notificationContext.notificationManager;
			PendingIntent notificationIntent = createIntent(context);

			int ressourceID = context.getResourceId("drawable." + iconName);

			Notification notification = createNotification(title, message, ressourceID, notificationDefaults, context, notificationIntent);

			notificationManager.notify(notificationID, notification);
		}

		return null;
	}

	private int getDefaults(FREObject defaultsObject)
	{
		int defaultsValues = Notification.DEFAULT_VIBRATE;

		if (defaultsObject instanceof FREArray)
		{
			FREArray defaults = (FREArray) defaultsObject;

			try
			{
				if(defaults.getLength() > 0)
					defaultsValues = 0;
				
				for (int index = 0; index < defaults.getLength(); index++)
				{
					int defaultsValue = (defaults.getObjectAt(index)).getAsInt();

					defaultsValues += defaultsValue;
				}

				return defaultsValues;

			} catch (FREInvalidObjectException e)
			{
				e.printStackTrace();
			} catch (FREWrongThreadException e)
			{
				e.printStackTrace();
			} catch (IllegalStateException e)
			{
				e.printStackTrace();
			} catch (IllegalArgumentException e)
			{
				e.printStackTrace();
			} catch (FRETypeMismatchException e)
			{
				e.printStackTrace();
			}
		}

		return defaultsValues;
	}

	protected Notification createNotification(CharSequence title, CharSequence message, int ressourceID, int notificationDefaults, FREContext context, PendingIntent contentIntent)
	{
		Notification notification = new Notification(ressourceID, message, System.currentTimeMillis());
		notification.setLatestEventInfo(context.getActivity(), title, message, contentIntent);

		notification.defaults = notificationDefaults;

		return notification;
	}

	protected PendingIntent createIntent(FREContext context)
	{
		return PendingIntent.getActivity(context.getActivity(), 0, new Intent(), 0);
	}

	protected String getString(FREObject textObject)
	{
		String text = null;

		try
		{
			text = textObject.getAsString();
		} catch (IllegalStateException e)
		{
			e.printStackTrace();
		} catch (FRETypeMismatchException e)
		{
			e.printStackTrace();
		} catch (FREInvalidObjectException e)
		{
			e.printStackTrace();
		} catch (FREWrongThreadException e)
		{
			e.printStackTrace();
		}

		return text;
	}

	protected int getInt(FREObject numberObject)
	{
		int number = 1;

		try
		{
			number = numberObject.getAsInt();
		} catch (IllegalStateException e)
		{
			e.printStackTrace();
		} catch (FRETypeMismatchException e)
		{
			e.printStackTrace();
		} catch (FREInvalidObjectException e)
		{
			e.printStackTrace();
		} catch (FREWrongThreadException e)
		{
			e.printStackTrace();
		}

		return number;
	}

}
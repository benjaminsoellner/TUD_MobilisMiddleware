/**
 * Copyright (C) 2009 Technische Universität Dresden
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.tudresden.inf.rn.mobilis.mxa.util;

import java.util.HashMap;
import java.util.HashSet;

import org.jivesoftware.smack.filter.PacketFilter;

import android.os.IBinder;
import android.os.RemoteCallbackList;

/**
 * A single callback interface can handle different namespaces and tokens. This
 * class provides a convenient way of managing these callbacks.
 * 
 * @author Istvan Koren
 * 
 */
public class FilteredCallbackList<E extends android.os.IInterface> extends
		RemoteCallbackList<E> {

	private HashMap<IBinder, HashSet<PacketFilter>> mFilters = new HashMap<IBinder, HashSet<PacketFilter>>();

	/**
	 * Registers a callback and the associated filter.
	 * 
	 * @param callback
	 * @param filter
	 * @return
	 */
	public boolean register(E callback, PacketFilter filter) {
		if (super.register(callback)) {
			synchronized (mFilters) {
				if (mFilters.containsKey(callback.asBinder())) {
					if (!mFilters.get(callback.asBinder()).contains(filter)) {
						// add it if not already present
						mFilters.get(callback.asBinder()).add(filter);
					}
				} else {
					HashSet<PacketFilter> filters = new HashSet<PacketFilter>();
					filters.add(filter);
					mFilters.put(callback.asBinder(), filters);
				}
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns all the filters that are available for this callback. Works on
	 * asBinder().
	 * 
	 * @param callback
	 * @return
	 */
	public HashSet<PacketFilter> getFilters(E callback) {
		return mFilters.get(callback.asBinder());
	}

	/**
	 * Removes the callback if there are no more filters for it.
	 * 
	 * @param callback
	 * @param filter
	 * @return
	 */
	public boolean unregister(E callback, PacketFilter filter) {
		synchronized (mFilters) {
			if (mFilters.containsKey(callback.asBinder())) {
				// check if there is more than one filter
				if (mFilters.get(callback.asBinder()).size() > 1) {
					// remove the filter if it is present
					return mFilters.get(callback.asBinder()).remove(filter);
				} else {
					// only one filter available, if it is the current one,
					// remove
					// it both from the super and our filters list
					if (mFilters.get(callback.asBinder()).contains(filter)) {
						mFilters.remove(callback.asBinder());
						return super.unregister(callback);
					}
					return false;
				}
			}
		}
		return false;
	}

	@Override
	public void onCallbackDied(E callback) {
		synchronized (mFilters) {
			mFilters.remove(callback.asBinder());
		}
		super.onCallbackDied(callback);
	}
}

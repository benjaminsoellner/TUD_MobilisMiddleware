/**
 * Copyright (C) 2009 Technische Universitšt Dresden
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

package de.tudresden.inf.rn.mobilis.mxa.services.servicediscovery;

import android.os.Messenger;

interface IServiceDiscoveryService {

	/**
	 * Sends out a ServiceDiscovery request to the given JID. 
	 */
	void discoverItem(in Messenger acknowledgement, in Messenger result, in int requestCode, in String jid, in String node);
}
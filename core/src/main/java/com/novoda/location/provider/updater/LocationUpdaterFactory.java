/**
 * Copyright 2011 Google Inc.
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
 * 
 * Code modified by Novoda Ltd, 2011.
 */
package com.novoda.location.provider.updater;

import android.location.LocationManager;
import com.novoda.location.provider.store.SettingsDao;
import com.novoda.location.provider.store.SharedPreferenceSettingsDao;
import com.novoda.location.util.ApiLevelDetector;

public class LocationUpdaterFactory {

    public LocationUpdater getLocationUpdater(LocationManager locationManager) {

        //TODO include legacy updater
    	if(ApiLevelDetector.supportsGingerbread()) {
            return new GingerbreadLocationUpdater(locationManager);
    	}
        return new FroyoLocationUpdater(locationManager);
    }

    //TODO remove this from here
    public SettingsDao getSettingsDao() {
    	return new SharedPreferenceSettingsDao();
    }

}
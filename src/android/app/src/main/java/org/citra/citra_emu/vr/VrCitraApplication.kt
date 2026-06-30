package org.citra.citra_emu.vr

import androidx.preference.PreferenceManager
import org.citra.citra_emu.BuildConfig
import org.citra.citra_emu.CitraApplication
import org.citra.citra_emu.R
import org.citra.citra_emu.utils.Log
import org.citra.citra_emu.vr.utils.VRUtils
import org.citra.citra_emu.vr.utils.VrMainActivityUtils

class VrCitraApplication : CitraApplication() {
    override fun onCreate() {
        super.onCreate()
        updateLaunchVersionPrefs()
        VrMainActivityUtils.doVersionUpdates()
    }

    private fun updateLaunchVersionPrefs() {
        val preferences = PreferenceManager.getDefaultSharedPreferences(applicationContext)
        val previousVersion = preferences.getString(
            VRUtils.PREF_RELEASE_VERSION_NAME_LAUNCH_CURRENT,
            ""
        )!!
        val currentVersion = BuildConfig.VERSION_NAME

        preferences.edit()
            .putString(VRUtils.PREF_RELEASE_VERSION_NAME_LAUNCH_PREV, previousVersion)
            .putString(VRUtils.PREF_RELEASE_VERSION_NAME_LAUNCH_CURRENT, currentVersion)
            .apply()

        Log.info(
            "${getString(R.string.app_name)} Version: " +
                "\"$previousVersion\" (prev) -> \"$currentVersion\" (current)"
        )
    }
}

package org.citra.citra_emu.vr.utils

import org.citra.citra_emu.features.settings.utils.SettingsFile

object VrMainActivityUtils {
    fun doVersionUpdates() {
        // Delete V0.3.2 settings file if present.
        try {
            SettingsFile.getSettingsFile(SettingsFile.FILE_NAME_CONFIG, "ini.vr0").delete()
        } catch (_: Exception) {
            // The legacy file usually does not exist.
        }
    }
}

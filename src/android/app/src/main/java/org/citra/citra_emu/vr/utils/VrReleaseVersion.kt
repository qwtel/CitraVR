package org.citra.citra_emu.vr.utils

/**
 * Represents a release version of AzaharXR.
 * These version codes started being used in v0.4.0.
 */
class VrReleaseVersion(version: String) {
    private val isRealVersion: Boolean = isReleaseVersion(version)
    private val major: Int = getVersionMajor(version)
    private val minor: Int = getVersionMinor(version)
    private val patch: Int = getVersionPatch(version)

    fun isRealVersion(): Boolean = isRealVersion
    fun getMajor(): Int = major
    fun getMinor(): Int = minor
    fun getPatch(): Int = patch

    fun hasLowerVersionThan(versionComp: VrReleaseVersion): Boolean {
        if (major != versionComp.major) return major < versionComp.major
        if (minor != versionComp.minor) return minor < versionComp.minor
        return patch < versionComp.patch
    }

    companion object {
        val RELEASE_VERSION_0_4_0 = VrReleaseVersion("v0.4.0")

        private fun isReleaseVersion(version: String): Boolean = version.startsWith("v")

        private fun getVersionMajor(version: String): Int =
            if (isReleaseVersion(version)) version.split(".")[0].removePrefix("v").toInt() else -1

        private fun getVersionMinor(version: String): Int =
            if (isReleaseVersion(version)) version.split(".")[1].toInt() else -1

        private fun getVersionPatch(version: String): Int =
            if (isReleaseVersion(version)) version.split(".")[2].toInt() else -1
    }
}

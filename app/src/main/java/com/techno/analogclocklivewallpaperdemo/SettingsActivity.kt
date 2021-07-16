package com.techno.analogclocklivewallpaperdemo

import android.os.Bundle
import android.preference.Preference
import android.preference.Preference.OnPreferenceChangeListener
import android.preference.PreferenceActivity
import android.widget.Toast

class SettingsActivity : PreferenceActivity() {
    private var displayHandSecPref: Preference? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addPreferencesFromResource(R.xml.prefs)
        displayHandSecPref = findPreference(DISPLAY_HAND_SEC_KEY)
        displayHandSecPref?.onPreferenceChangeListener = prefChangeListener
    }

    private val prefChangeListener =
        OnPreferenceChangeListener { preference, newValue ->
            if (DISPLAY_HAND_SEC_KEY == preference.key) {
                val value = newValue as Boolean
                Toast.makeText(
                    applicationContext,
                    R.string.display_hand_sec_txt.toString() + " "
                            + if (value) R.string.enabled else R.string.disabled,
                    Toast.LENGTH_SHORT
                ).show()
                return@OnPreferenceChangeListener true
            }
            false
        }
    companion object {
        /** Key for display hand sec.  */
        const val DISPLAY_HAND_SEC_KEY = "displayHandSec"
    }
}

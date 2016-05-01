package com.polarxiong.camerademo;

import android.hardware.Camera;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.PreferenceFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhantong on 16/4/30.
 */
public class SettingsFragment extends PreferenceFragment {
    static Camera mCamera;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);

        loadPreviewSize(mCamera);
    }
    static SettingsFragment newInstance(Camera camera){
        SettingsFragment settingsFragment=new SettingsFragment();
        mCamera=camera;
        return settingsFragment;
    }
    private void  loadPreviewSize(Camera camera){
        List<Camera.Size> listSupportedPreviewSize=camera.getParameters().getSupportedPreviewSizes();
        List<String> listEntries=new ArrayList<>();
        for(Camera.Size size:listSupportedPreviewSize){
            String stringSize=size.width+"x"+size.height;
            listEntries.add(stringSize);
        }
        final CharSequence[] supportedPreviewSize=listEntries.toArray(new CharSequence[listEntries.size()]);
        ListPreference prefPreviewSize=(ListPreference)getPreferenceScreen().findPreference("preview_size");
        prefPreviewSize.setEntries(supportedPreviewSize);
        prefPreviewSize.setEntryValues(supportedPreviewSize);
    }
}

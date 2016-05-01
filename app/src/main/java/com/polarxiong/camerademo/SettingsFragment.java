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

        loadSupportedPreviewSize(mCamera);
        loadSupportedPictureSize(mCamera);
        loadSupportedVideoeSize(mCamera);
        loadSupportedFlashMode(mCamera);
        loadSupportedFocusMode(mCamera);
        loadSupportedWhiteBalance(mCamera);
        loadSupportedSceneMode(mCamera);
    }
    static SettingsFragment newInstance(Camera camera){
        SettingsFragment settingsFragment=new SettingsFragment();
        mCamera=camera;
        return settingsFragment;
    }
    private void  loadSupportedPreviewSize(Camera camera){
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
    private void  loadSupportedPictureSize(Camera camera){
        List<Camera.Size> listSupportedPreviewSize=camera.getParameters().getSupportedPictureSizes();
        List<String> listEntries=new ArrayList<>();
        for(Camera.Size size:listSupportedPreviewSize){
            String stringSize=size.width+"x"+size.height;
            listEntries.add(stringSize);
        }
        final CharSequence[] supportedPreviewSize=listEntries.toArray(new CharSequence[listEntries.size()]);
        ListPreference prefPreviewSize=(ListPreference)getPreferenceScreen().findPreference("picture_size");
        prefPreviewSize.setEntries(supportedPreviewSize);
        prefPreviewSize.setEntryValues(supportedPreviewSize);
    }
    private void  loadSupportedVideoeSize(Camera camera){
        List<Camera.Size> listSupportedPreviewSize=camera.getParameters().getSupportedVideoSizes();
        List<String> listEntries=new ArrayList<>();
        for(Camera.Size size:listSupportedPreviewSize){
            String stringSize=size.width+"x"+size.height;
            listEntries.add(stringSize);
        }
        final CharSequence[] supportedPreviewSize=listEntries.toArray(new CharSequence[listEntries.size()]);
        ListPreference prefPreviewSize=(ListPreference)getPreferenceScreen().findPreference("video_size");
        prefPreviewSize.setEntries(supportedPreviewSize);
        prefPreviewSize.setEntryValues(supportedPreviewSize);
    }
    private void  loadSupportedFlashMode(Camera camera){
        List<String> listSupportedPreviewSize=camera.getParameters().getSupportedFlashModes();
        final CharSequence[] supportedPreviewSize=listSupportedPreviewSize.toArray(new CharSequence[listSupportedPreviewSize.size()]);
        ListPreference prefPreviewSize=(ListPreference)getPreferenceScreen().findPreference("flash_mode");
        prefPreviewSize.setEntries(supportedPreviewSize);
        prefPreviewSize.setEntryValues(supportedPreviewSize);
    }
    private void  loadSupportedFocusMode(Camera camera){
        List<String> listSupportedPreviewSize=camera.getParameters().getSupportedFocusModes();
        final CharSequence[] supportedPreviewSize=listSupportedPreviewSize.toArray(new CharSequence[listSupportedPreviewSize.size()]);
        ListPreference prefPreviewSize=(ListPreference)getPreferenceScreen().findPreference("focus_mode");
        prefPreviewSize.setEntries(supportedPreviewSize);
        prefPreviewSize.setEntryValues(supportedPreviewSize);
    }
    private void  loadSupportedWhiteBalance(Camera camera){
        List<String> listSupportedPreviewSize=camera.getParameters().getSupportedWhiteBalance();
        final CharSequence[] supportedPreviewSize=listSupportedPreviewSize.toArray(new CharSequence[listSupportedPreviewSize.size()]);
        ListPreference prefPreviewSize=(ListPreference)getPreferenceScreen().findPreference("white_balance");
        prefPreviewSize.setEntries(supportedPreviewSize);
        prefPreviewSize.setEntryValues(supportedPreviewSize);
    }
    private void  loadSupportedSceneMode(Camera camera){
        List<String> listSupportedPreviewSize=camera.getParameters().getSupportedSceneModes();
        final CharSequence[] supportedPreviewSize=listSupportedPreviewSize.toArray(new CharSequence[listSupportedPreviewSize.size()]);
        ListPreference prefPreviewSize=(ListPreference)getPreferenceScreen().findPreference("scene_mode");
        prefPreviewSize.setEntries(supportedPreviewSize);
        prefPreviewSize.setEntryValues(supportedPreviewSize);
    }
}

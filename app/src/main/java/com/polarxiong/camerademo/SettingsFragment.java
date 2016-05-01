package com.polarxiong.camerademo;

import android.content.SharedPreferences;
import android.hardware.Camera;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.PreferenceFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhantong on 16/4/30.
 */
public class SettingsFragment extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener{
    public static final String KEY_PREF_PREV_SIZE="preview_size";
    public static final String KEY_PREF_PIC_SIZE="picture_size";
    public static final String KEY_PREF_VIDEO_SIZE="video_size";
    public static final String KEY_PREF_FLASH_MODE="flash_mode";
    public static final String KEY_PREF_FOCUS_MODE="focus_mode";
    public static final String KEY_PREF_WHITE_BALANCE="white_balance";
    public static final String KEY_PREF_SCENE_MODE="scene_mode";
    public static final String KEY_PREF_GPS_DATA="gps_data";
    public static final String KEY_PREF_EXPOS_COMP="exposure_compensation";
    public static final String KEY_PREF_JPEG_QUALITY="jpeg_quality";
    static Camera mCamera;
    static Camera.Parameters mParameters;
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
        loadSupportedExposeCompensation(mCamera);
    }
    static SettingsFragment newInstance(Camera camera){
        SettingsFragment settingsFragment=new SettingsFragment();
        mCamera=camera;
        mParameters=camera.getParameters();
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
        ListPreference prefPreviewSize=(ListPreference)getPreferenceScreen().findPreference(KEY_PREF_PREV_SIZE);
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
        ListPreference prefPreviewSize=(ListPreference)getPreferenceScreen().findPreference(KEY_PREF_PIC_SIZE);
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
        ListPreference prefPreviewSize=(ListPreference)getPreferenceScreen().findPreference(KEY_PREF_VIDEO_SIZE);
        prefPreviewSize.setEntries(supportedPreviewSize);
        prefPreviewSize.setEntryValues(supportedPreviewSize);
    }
    private void  loadSupportedFlashMode(Camera camera){
        List<String> listSupportedPreviewSize=camera.getParameters().getSupportedFlashModes();
        final CharSequence[] supportedPreviewSize=listSupportedPreviewSize.toArray(new CharSequence[listSupportedPreviewSize.size()]);
        ListPreference prefPreviewSize=(ListPreference)getPreferenceScreen().findPreference(KEY_PREF_FLASH_MODE);
        prefPreviewSize.setEntries(supportedPreviewSize);
        prefPreviewSize.setEntryValues(supportedPreviewSize);
    }
    private void  loadSupportedFocusMode(Camera camera){
        List<String> listSupportedPreviewSize=camera.getParameters().getSupportedFocusModes();
        final CharSequence[] supportedPreviewSize=listSupportedPreviewSize.toArray(new CharSequence[listSupportedPreviewSize.size()]);
        ListPreference prefPreviewSize=(ListPreference)getPreferenceScreen().findPreference(KEY_PREF_FOCUS_MODE);
        prefPreviewSize.setEntries(supportedPreviewSize);
        prefPreviewSize.setEntryValues(supportedPreviewSize);
    }
    private void  loadSupportedWhiteBalance(Camera camera){
        List<String> listSupportedPreviewSize=camera.getParameters().getSupportedWhiteBalance();
        final CharSequence[] supportedPreviewSize=listSupportedPreviewSize.toArray(new CharSequence[listSupportedPreviewSize.size()]);
        ListPreference prefPreviewSize=(ListPreference)getPreferenceScreen().findPreference(KEY_PREF_WHITE_BALANCE);
        prefPreviewSize.setEntries(supportedPreviewSize);
        prefPreviewSize.setEntryValues(supportedPreviewSize);
    }
    private void  loadSupportedSceneMode(Camera camera){
        List<String> listSupportedPreviewSize=camera.getParameters().getSupportedSceneModes();
        final CharSequence[] supportedPreviewSize=listSupportedPreviewSize.toArray(new CharSequence[listSupportedPreviewSize.size()]);
        ListPreference prefPreviewSize=(ListPreference)getPreferenceScreen().findPreference(KEY_PREF_SCENE_MODE);
        prefPreviewSize.setEntries(supportedPreviewSize);
        prefPreviewSize.setEntryValues(supportedPreviewSize);
    }
    private void  loadSupportedExposeCompensation(Camera camera){
        int minExposComp=mParameters.getMinExposureCompensation();
        int maxExposComp=mParameters.getMaxExposureCompensation();
        List<String> exposComp=new ArrayList<>();
        for(int value=minExposComp;value<=maxExposComp;value++){
            exposComp.add(Integer.toString(value));
        }

        final CharSequence[] supportedPreviewSize=exposComp.toArray(new CharSequence[exposComp.size()]);
        ListPreference prefPreviewSize=(ListPreference)getPreferenceScreen().findPreference(KEY_PREF_EXPOS_COMP);
        prefPreviewSize.setEntries(supportedPreviewSize);
        prefPreviewSize.setEntryValues(supportedPreviewSize);
    }
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences,String key){
        switch (key){
            case KEY_PREF_PREV_SIZE:
                setPreviewSize(sharedPreferences.getString(key,""));
                break;
            case KEY_PREF_PIC_SIZE:
                setPictureSize(sharedPreferences.getString(key,""));
                break;
            case KEY_PREF_FOCUS_MODE:
                setFocusMode(sharedPreferences.getString(key,""));
                break;
            case KEY_PREF_FLASH_MODE:
                setFlashMode(sharedPreferences.getString(key,""));
                break;
            case KEY_PREF_WHITE_BALANCE:
                setWhiteBalance(sharedPreferences.getString(key,""));
                break;
            case KEY_PREF_SCENE_MODE:
                setSceneMode(sharedPreferences.getString(key,""));
                break;
            case KEY_PREF_EXPOS_COMP:
                setExposComp(sharedPreferences.getString(key,""));
                break;
            case KEY_PREF_JPEG_QUALITY:
                setJpegQuality(sharedPreferences.getString(key,""));
                break;
            case KEY_PREF_GPS_DATA:
                setGpsData(sharedPreferences.getBoolean(key,false));
                break;
        }
        mCamera.stopPreview();
        mCamera.setParameters(mParameters);
        mCamera.startPreview();
    }
    private void setPreviewSize(String key){
        String[] split=key.split("x");
        mParameters.setPreviewSize(Integer.parseInt(split[0]),Integer.parseInt(split[1]));
    }
    private void setPictureSize(String key){
        String[] split=key.split("x");
        mParameters.setPictureSize(Integer.parseInt(split[0]),Integer.parseInt(split[1]));
    }
    private void setFocusMode(String key){
        mParameters.setFocusMode(key);
    }
    private void setFlashMode(String key){
        mParameters.setFlashMode(key);
    }
    private void setWhiteBalance(String key){
        mParameters.setWhiteBalance(key);
    }
    private void setSceneMode(String key){
        mParameters.setSceneMode(key);
    }
    private void setExposComp(String key){
        mParameters.setExposureCompensation(Integer.parseInt(key));
    }
    private void setJpegQuality(String key){
        mParameters.setJpegQuality(Integer.parseInt(key));
    }
    private void setGpsData(Boolean key){
        if(key.equals(false)){
            mParameters.removeGpsData();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        getPreferenceScreen().getSharedPreferences()
                .registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        getPreferenceScreen().getSharedPreferences()
                .unregisterOnSharedPreferenceChangeListener(this);
    }
}

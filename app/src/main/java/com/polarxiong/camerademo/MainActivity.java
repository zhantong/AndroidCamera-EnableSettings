package com.polarxiong.camerademo;

import android.app.Activity;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

/**
 * Created by zhantong on 16/4/28.
 */
public class MainActivity extends Activity{
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final CameraPreview mPreview=new CameraPreview(this);
        FrameLayout preview=(FrameLayout)findViewById(R.id.camera_preview);
        preview.addView(mPreview);

        Button buttonSettings=(Button)findViewById(R.id.button_settings);
        SettingsFragment.passCamera(mPreview.getCameraInstance());
        PreferenceManager.setDefaultValues(this,R.xml.preferences,false);
        if(PreferenceManager.getDefaultSharedPreferences(this).getString(SettingsFragment.KEY_PREF_PREV_SIZE,null)==null){
            System.out.println("Main Activity");
            getFragmentManager().beginTransaction().replace(R.id.camera_preview,new SettingsFragment()).addToBackStack(null).commit();
            getFragmentManager().executePendingTransactions();
        }
        SettingsFragment.init(PreferenceManager.getDefaultSharedPreferences(this));

        buttonSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.camera_preview,new SettingsFragment()).addToBackStack(null).commit();
            }
        });
    }
}

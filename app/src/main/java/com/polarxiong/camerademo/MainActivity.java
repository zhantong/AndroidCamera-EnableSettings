package com.polarxiong.camerademo;

import android.app.Activity;
import android.os.Bundle;
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
        buttonSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SettingsFragment settingsFragment=SettingsFragment.newInstance(mPreview.getCameraInstance());
                getFragmentManager().beginTransaction().replace(R.id.camera_preview,new SettingsFragment()).addToBackStack(null).commit();
            }
        });
    }
}

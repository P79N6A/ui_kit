package com.hipac.example.uikit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.hipac.uikit.UIKitConfig;
import com.hipac.uikit.feature.features.TrackEventFeature;
import com.hipac.uikit.feature.view.TTextView;

public class MainActivity extends AppCompatActivity {

    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Switch switchView = findViewById(R.id.switch_view);
        switchView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                UIKitConfig config = UIKitConfig.getInstance();
                config.setHotMapEnable(isChecked);
                Utils.requireInvalidate(MainActivity.this);
            }
        });
        switchView.setChecked(true);
        final TTextView textView = findViewById(R.id.one);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TrackEventFeature feature = textView.findFeature(TrackEventFeature.class);
                feature.setTrackCode(String.valueOf(++count));
            }
        });
    }
}

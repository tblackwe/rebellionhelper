package com.tabletophelpers.starwarsrebellionproductionhelper.activity;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;

import com.tabletophelpers.starwarsrebellionproductionhelper.R;

public class MainActivity extends TabActivity {

    private TabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

}

package com.wuujcik.prg14.transport;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.wuujcik.prg14.R;

public class TransportOverview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transport_overview);
        Log.v("doszlo?", "transport overview class za set content");
    }
}

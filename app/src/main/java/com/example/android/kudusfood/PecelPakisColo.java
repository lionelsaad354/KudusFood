package com.example.android.kudusfood;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ViewFlipper;

import java.io.IOException;
import java.io.InputStream;

public class PecelPakisColo extends AppCompatActivity {
    TextView mText;
    int mFlipping = 0; // Initially flipping is off
    private ViewFlipper flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pecel_pakis_colo);

        mText = (TextView) findViewById(R.id.text);

        flipper = (ViewFlipper) findViewById(R.id.flipper1);

        loadDataFromAsset();

        /**mButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        flipper = (ViewFlipper) findViewById(R.id.flipper1);

        if(mFlipping==0){
        flipper.startFlipping();
        mFlipping=1;
        mButton.setText(R.string.str_btn_stop);
        }
        else{
        flipper.stopFlipping();
        mFlipping=0;
        mButton.setText(R.string.str_btn_start);
        }
        }
        });*/
    }

    public void loadDataFromAsset() {
        // load text
        try {
            // get input stream for text
            InputStream is = getAssets().open("pecel_pakis_colo.txt");
            // check size
            int size = is.available();
            // create buffer for IO
            byte[] buffer = new byte[size];
            // get data to buffer
            is.read(buffer);
            // close stream
            is.close();
            // set result to TextView
            mText.setText(new String(buffer));
        } catch (IOException ex) {
            return;
        }

    }
    public void onResume(){
        super.onResume();
        flipper.startFlipping();
        mFlipping=1;
    }
}

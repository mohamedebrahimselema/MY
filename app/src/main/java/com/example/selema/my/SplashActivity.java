package com.example.selema.my;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.viksaa.sssplash.lib.activity.AwesomeSplash;
import com.viksaa.sssplash.lib.cnst.Flags;
import com.viksaa.sssplash.lib.model.ConfigSplash;

import wail.splacher.com.splasher.lib.SplasherActivity;
import wail.splacher.com.splasher.models.SplasherConfig;
import wail.splacher.com.splasher.utils.Const;

public class SplashActivity extends SplasherActivity {
    @Override
    public void initSplasher(SplasherConfig config) {
        config.setReveal_start(Const.START_TOP_LEFT) // anitmation type ..
                //---------------
                .setAnimationDuration(1000) // Reveal animation duration ..
                //---------------
                .setLogo(R.mipmap.ic_launcher) // logo src..
                .setLogo_animation(Techniques.BounceIn) // logo animation ..
                .setAnimationLogoDuration(2000) // logo animation duration ..
                .setLogoWidth(500) // logo width ..
                //---------------
                .setTitle("Splasher Example") // title ..
                .setTitleColor(Color.parseColor("#ffffff")) // title color ..
                .setTitleAnimation(Techniques.Bounce) // title animation ( from Android View Animations ) ..
                .setTitleSize(24) // title text size ..
                //---------------
                .setSubtitle("Enjoy with this library") // subtitle
                .setSubtitleColor(Color.parseColor("#ffffff")) // subtitle color
                .setSubtitleAnimation(Techniques.FadeIn) // subtitle animation (from Android View Animations) ..
                .setSubtitleSize(16); // subtitle text size ..
                //---------------
             //   .setSubtitleTypeFace(Typeface.createFromAsset(getAssets(),"diana.otf")) // subtitle font type ..
              //  .setTitleTypeFace(Typeface.createFromAsset(getAssets(),"stc.otf")); // title font type ..

    }

    @Override
    public void onSplasherFinished() {
        Toast.makeText(this, "Go to the next activity", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
package com.bignerdranch.android.beatbox;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;

/**
 * Created by michaelgonzalez on 4/4/18.
 */


public class SoundViewModel extends BaseObservable {
    // These properties are the interface my adapter will use.
    private Sound mSound;
    private BeatBox mBeatBox;
    private float mPlayRate;

    public SoundViewModel(BeatBox beatBox) {
        mBeatBox = beatBox;
    }

    @Bindable
    public String getTitle() {
        return getSound().getName();
    }

    public Sound getSound() {
        return mSound;
    }

    public void setSound(Sound sound) {
        mSound = sound;
        notifyChange(); // let binding class know that Bindable fields on objects h/been updated.

    }
    public float getPlayRate() {
        return mSound.getPlayRate();
    }

    public void setPlayRate(float playRate) {
        mPlayRate = playRate;
    }

    public void onButtonClicked() {
        mBeatBox.play(mSound);
    }

    public void onProgressChanged() {
        Log.d("BeatBox", "Progress VM Changed");}
}

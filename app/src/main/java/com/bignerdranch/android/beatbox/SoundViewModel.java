package com.bignerdranch.android.beatbox;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.widget.SeekBar;

/**
 * Created by michaelgonzalez on 4/4/18.
 */


public class SoundViewModel extends BaseObservable {
    // These properties are the interface my adapter will use.
    private Sound mSound;
    private BeatBox mBeatBox;

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

    public void onButtonClicked() {
        mBeatBox.play(mSound);
    }


    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        float playRate = (progress * 2); // does not allow me to divide by 100 in this statement??
        mBeatBox.setPlayRate(playRate / 100);

        // Let @Bindable's know of change.
        notifyPropertyChanged(BR.playRate);
    }

    @Bindable
    public String getPlayRateText() {

        int playRate = (int) (50 * mBeatBox.getPlayRate());
        return "Playback Speed: " + playRate + "%";
    }

}

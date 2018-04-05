package com.bignerdranch.android.beatbox;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

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
}

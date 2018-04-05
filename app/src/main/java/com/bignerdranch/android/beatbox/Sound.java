package com.bignerdranch.android.beatbox;

/**
 * Created by michaelgonzalez on 4/3/18.
 */

public class Sound {
    private String mAssetPath;
    private String mName;
    private Integer mSoundId;
    private float mPlayRate;


    public void setAssetPath(String assetPath) {
        mAssetPath = assetPath;
    }

    public Sound(String assetPath) {
        mAssetPath = assetPath;
        String[] components = assetPath.split("/");
        String filename = components[components.length - 1];
        mName = filename.replace(".wav", "");
    }

    public String getAssetPath() {
        return mAssetPath;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public Integer getSoundId() {
        return mSoundId;
    }

    public void setSoundId(Integer soundId) {
        mSoundId = soundId;
    }

    public float getPlayRate() {
        return mPlayRate;
    }

    public void setPlayRate(float playRate) {
        mPlayRate = playRate;
    }
}



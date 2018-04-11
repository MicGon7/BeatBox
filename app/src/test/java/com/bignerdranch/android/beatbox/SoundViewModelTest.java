package com.bignerdranch.android.beatbox;

import android.widget.SeekBar;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyFloat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


/**
 * Created by michaelgonzalez on 4/4/18.
 */
public class SoundViewModelTest {
    private BeatBox mBeatBox;
    private Sound mSound;
    private SeekBar mSeekBar;
    private SoundViewModel mSubject; // Makes clear the subject of the test.

    // TODO Ask Matt about Spy().

    @Before
    public void setUp() throws Exception {
        // automatically create a mocked out version of BeatBox (no method definitions).
        mBeatBox = mock(BeatBox.class);

        mSound = new Sound("assetPath");
        mSubject = new SoundViewModel(mBeatBox);
        mSeekBar = mock(SeekBar.class);
        mSubject.setSound(mSound);

    }

    @Test
    public void exposesSoundNameAsTitle() {
        assertThat(mSubject.getTitle(), is(mSound.getName()));
    }


    @Test
    public void callsBeatBoxPlayOnButtonClicked() {
        mSubject.onButtonClicked();

        verify(mBeatBox).play(mSound);
    }

    @Test
    public void callsOnSeekMove() {
        mSubject.onSeekBarMove(mSeekBar);

        verify(mBeatBox).setPlayRate(anyFloat());


    }

    @Test
    public void callsGetPlayRate() {
        mSubject.getPlayRateText();

        verify(mBeatBox).getPlayRate();
    }

}
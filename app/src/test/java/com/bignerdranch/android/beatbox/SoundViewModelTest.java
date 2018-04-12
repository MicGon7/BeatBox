package com.bignerdranch.android.beatbox;

import android.widget.SeekBar;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyFloat;
import static org.mockito.Mockito.verify;


/**
 * Created by michaelgonzalez on 4/4/18.
 */
//@RunWith(MockitoJUnitRunner.class)
public class SoundViewModelTest {
    @Mock
    private BeatBox mBeatBox;

    @Mock
    private Sound mSound;

    @Mock
    private SeekBar mSeekBar;

    @Spy
    @InjectMocks
    private SoundViewModel mSubject; // Makes clear the subject of the test.


    @Before
    public void setUp() throws Exception {
        // automatically create a mocked out version of BeatBox (no method definitions).
        MockitoAnnotations.initMocks(this);

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
    public void callsOnProgressChanged() {
        mSubject.onProgressChanged(mSeekBar, 2, true);

        verify(mBeatBox).setPlayRate(anyFloat());


    }

    @Test
    public void callsGetPlayRate() {
        mSubject.getPlayRateText();

        verify(mBeatBox).getPlayRate();
    }

    @Test
    public void callsGetPlayRateText() {
        String text = mSubject.getPlayRateText();


        verify(mSubject).getPlayRateText();
        assert text.contains("Playback");



    }

}
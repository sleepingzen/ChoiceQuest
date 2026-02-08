package com.example.choicequest;

import android.media.MediaPlayer;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    private static MediaPlayer bgMusic;
    private static int[] playlist = {
            R.raw.atebit_sound,
            R.raw.atebit_sound1,
            R.raw.atebit_soound2
    };
    private static int currentTrackIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        android.util.Log.d("MUSIC_TEST", "BaseActivity onCreate called");

        if (bgMusic == null) {
            playTrack(currentTrackIndex);
        }
    }

    private void playTrack(int index) {
        if (bgMusic != null) {
            bgMusic.release();
        }

        bgMusic = MediaPlayer.create(this, playlist[index]);
        bgMusic.setVolume(0.5f, 0.5f);

        bgMusic.setOnCompletionListener(mp -> {
            currentTrackIndex = (currentTrackIndex + 1) % playlist.length;
            playTrack(currentTrackIndex);
        });

        bgMusic.start();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (bgMusic != null && !bgMusic.isPlaying()) {
            bgMusic.start();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (bgMusic != null && bgMusic.isPlaying()) {
            bgMusic.pause();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isFinishing() && bgMusic != null) {
            bgMusic.release();
            bgMusic = null;
        }
    }
}
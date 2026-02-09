package com.example.choicequest;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    private static MediaPlayer bgMusic;
    private static int[] playlist = {
            R.raw.ambient
    };
    private static int currentTrackIndex = 0;
    private static boolean isInitialized = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (!isInitialized) {
            initializeMusic();
            isInitialized = true;
        }
    }

    private void initializeMusic() {
        bgMusic = MediaPlayer.create(getApplicationContext(), playlist[currentTrackIndex]);
        bgMusic.setVolume(0.3f, 0.3f);

        bgMusic.setOnCompletionListener(mp -> {
            currentTrackIndex = (currentTrackIndex + 1) % playlist.length;
            playNextTrack();
        });

        bgMusic.start();
    }

    private void playNextTrack() {
        if (bgMusic != null) {
            bgMusic.release();
        }

        bgMusic = MediaPlayer.create(getApplicationContext(), playlist[currentTrackIndex]);
        bgMusic.setVolume(0.5f, 0.5f);

        bgMusic.setOnCompletionListener(mp -> {
            currentTrackIndex = (currentTrackIndex + 1) % playlist.length;
            playNextTrack();
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
    }
}
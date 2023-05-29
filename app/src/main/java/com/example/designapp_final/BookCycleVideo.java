package com.example.designapp_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class BookCycleVideo extends AppCompatActivity {
    Button find_bicycle;
    MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_cycle_video);

        VideoView videoView = findViewById(R.id.videoView2);
        find_bicycle = findViewById(R.id.btn_find_bicycle2);
        videoView.setVideoPath("android.resource://" + getPackageName()
                + "/" + R.raw.videonew);
        videoView.start();
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        find_bicycle.setOnClickListener(v -> {
            Intent intent = new Intent(BookCycleVideo.this,DashBoardActivity.class);
            startActivity(intent);
        });
    }
}
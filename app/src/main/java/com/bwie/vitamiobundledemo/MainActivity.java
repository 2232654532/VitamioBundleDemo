package com.bwie.vitamiobundledemo;

import android.app.Activity;
import android.os.Bundle;

import io.vov.vitamio.LibsChecker;
import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

public class MainActivity extends Activity {

    private VideoView mVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!LibsChecker.checkVitamioLibs(this))
            return;
        setContentView(R.layout.activity_main);
        mVideoView = (VideoView) findViewById(R.id.vitamio_videoView);
        //播放路径
       String path = "rtmp://rtmppull.efeizao.com/live/room_49203/chat";
        //设置视频的播放路径
        mVideoView.setVideoPath(path);
        //把播放器添加到控制器中
        mVideoView.setMediaController(new MediaController(this));
        //请求焦点
        mVideoView.requestFocus();
        //设置准备监听
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setPlaybackSpeed(1.0f);
            }
        });
    }
}

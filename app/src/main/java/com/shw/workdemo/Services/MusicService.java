package com.shw.workdemo.Services;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.IBinder;

import com.shw.workdemo.R;

public class MusicService extends Service {
    private MediaPlayer mediaPlayer;
    private String str="";
    public MusicService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if(mediaPlayer==null)
            mediaPlayer=new MediaPlayer();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String url=intent.getStringExtra("url");
        if(!str.equals(url)){
            mediaPlayer.reset();
            mediaPlayer=MediaPlayer.create(this,Uri.parse(url));
            mediaPlayer.start();
            mediaPlayer.setLooping(false);
            str=url;
        }else{
            mediaPlayer.stop();
            str="";
        }
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}

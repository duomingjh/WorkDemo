package com.shw.workdemo.Adapters;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shw.workdemo.Bean.videoData;
import com.shw.workdemo.R;
import com.shw.workdemo.Tools.GetcontextHpler;

import java.net.URL;
import java.util.List;

public class videoAdapter extends RecyclerView.Adapter<videoAdapter.ViewHolder> {
    private List<videoData> m_list;
    private View view;
    public videoAdapter(List<videoData> m_list) {
        this.m_list = m_list;
    }

    @NonNull
    @Override
    public videoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.voide_item,parent,false);
        final ViewHolder viewHolder=new ViewHolder(view);
        viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewHolder.imageView.setVisibility(View.GONE);
                viewHolder.videoView.setVisibility(View.VISIBLE);
                viewHolder.videoView.start();
            }
        });
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull videoAdapter.ViewHolder holder, int position) {
        videoData v=m_list.get(position);
        holder.videoView.setMediaController(new MediaController(holder.view.getContext()));

        holder.videoView.setVideoURI(Uri.parse(v.getUrl()));
        holder.videoView.setVisibility(View.GONE);
        holder.imageView.setVisibility(View.VISIBLE);
        holder.imageView.setImageResource(v.getImage());

    }

    @Override
    public int getItemCount() {
        return m_list.size();
    }

    public  static class ViewHolder extends RecyclerView.ViewHolder {
        VideoView videoView;
        ImageView imageView;
        View view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view=itemView;
            videoView=itemView.findViewById(R.id.video_view);
            imageView=itemView.findViewById(R.id.video_image);
        }
    }
}

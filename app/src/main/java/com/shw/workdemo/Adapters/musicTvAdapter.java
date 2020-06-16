package com.shw.workdemo.Adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shw.workdemo.Bean.musicdata;
import com.shw.workdemo.R;
import com.shw.workdemo.Services.MusicService;
import com.shw.workdemo.Tools.GetcontextHpler;

import java.util.List;

public class musicTvAdapter extends  RecyclerView.Adapter<musicTvAdapter.ViewHolder>{
    private List<musicdata> m_list;

    public musicTvAdapter(List<musicdata> m_list) {
        this.m_list = m_list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.music_item,parent,false);
        final ViewHolder holder=new ViewHolder(view);
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos=holder.getAdapterPosition();
                Intent intent=new Intent(GetcontextHpler.getContext(), MusicService.class);
                intent.putExtra("url",m_list.get(pos).getURL());
                GetcontextHpler.getContext().startService(intent);
                Toast.makeText(GetcontextHpler.getContext(),m_list.get(pos).getURL(),Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        musicdata m=m_list.get(position);
        holder.tv.setText(m.getName());
    }

    @Override
    public int getItemCount() {
        return m_list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv;
        View view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view=itemView;
            tv=itemView.findViewById(R.id.mus_name);
        }
    }
}

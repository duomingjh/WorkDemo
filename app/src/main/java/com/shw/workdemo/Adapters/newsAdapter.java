package com.shw.workdemo.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shw.workdemo.Bean.newContext;
import com.shw.workdemo.R;

import java.util.List;

public class newsAdapter extends RecyclerView.Adapter<newsAdapter.ViewHolder> {
    public List<newContext> mList;

    public newsAdapter(List<newContext> list){
        mList=list;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            newContext m=mList.get(position);
            holder.title.setText(m.getTile());
            holder.text.setText(m.getContext());
            holder.image.setBackgroundResource(m.getImage());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView title;
        TextView text;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.news_imgas);
            title=itemView.findViewById(R.id.news_title);
            text=itemView.findViewById(R.id.newa_context);
        }
    }
}

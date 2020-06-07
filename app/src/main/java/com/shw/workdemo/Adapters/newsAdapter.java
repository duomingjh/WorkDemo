package com.shw.workdemo.Adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shw.workdemo.Bean.newContext;
import com.shw.workdemo.R;
import com.shw.workdemo.activitys.detailpageActivity;

import java.util.List;

import static androidx.core.content.ContextCompat.startActivity;

public class newsAdapter extends RecyclerView.Adapter<newsAdapter.ViewHolder> {
    public List<newContext> mList;


    public newsAdapter(List<newContext> list){
        mList=list;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item,parent,false);
        final ViewHolder holder=new ViewHolder(view);
        holder.newsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos=holder.getAdapterPosition();
                newContext m=mList.get(pos);
                Intent intent=new Intent(v.getContext(), detailpageActivity.class);
                intent.putExtra("title",m.getTile());
                intent.putExtra("newsimage",m.getImage());
                intent.putExtra("detail",m.getContext());
                v.getContext().startActivity(intent);
            }
        });
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
        View newsView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            newsView=itemView;
            image=itemView.findViewById(R.id.news_imgas);
            title=itemView.findViewById(R.id.news_title);
            text=itemView.findViewById(R.id.newa_context);
        }
    }
}

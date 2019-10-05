package com.example.budejie.pro.essence.view.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.budejie.R;
import com.example.budejie.bean.PostsListBean;
import com.example.budejie.utils.DateUtils;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class EssenceVideoAdapter extends RecyclerView.Adapter<EssenceVideoAdapter.VideoAdapterViewHolder> {

    private Context context;
    private List<PostsListBean.PostList> list;

    public EssenceVideoAdapter(Context context, List<PostsListBean.PostList> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public VideoAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_essence_video_layout,parent,false);
        VideoAdapterViewHolder holder = new VideoAdapterViewHolder(v,true);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull VideoAdapterViewHolder holder, int position) {
        PostsListBean.PostList postList = this.list.get(position);

        Glide.with(context).load(postList.getProfile_image()).centerCrop().into(holder.iv_header);
        holder.tv_name.setText(postList.getName());
        holder.tv_time.setText(DateUtils.parseDate(postList.getCreate_time()));
        holder.tv_content.setText(postList.getText());
        holder.tv_like.setText(postList.getDing());
        holder.tv_dislike.setText(postList.getCai());
        holder.tv_forword.setText(postList.getRepost());
        holder.tv_comment.setText(postList.getComment());

    }

    @Override
    public int getItemCount() {
        return this.list.size();
    }

    public class VideoAdapterViewHolder extends RecyclerView.ViewHolder{

        public CircleImageView iv_header;
        public TextView tv_name;
        public TextView tv_time;
        public TextView tv_content;
        public ImageView iv_video;

        public LinearLayout ll_like;
        public TextView tv_like;

        public LinearLayout ll_dislike;
        public TextView tv_dislike;

        public LinearLayout ll_forword;
        public TextView tv_forword;

        public LinearLayout ll_comment;
        public TextView tv_comment;

        public VideoAdapterViewHolder(@NonNull View itemView, boolean isItem) {
            super(itemView);
            if (isItem) {
                iv_header =  itemView
                        .findViewById(R.id.iv_header);
                tv_name =  itemView
                        .findViewById(R.id.tv_name);
                tv_time =  itemView
                        .findViewById(R.id.tv_time);
                tv_content =  itemView
                        .findViewById(R.id.tv_content);
                iv_video = (ImageView) itemView
                        .findViewById(R.id.iv_video);

                ll_like = itemView
                        .findViewById(R.id.ll_like);
                tv_like = itemView
                        .findViewById(R.id.tv_like);

                ll_dislike = itemView
                        .findViewById(R.id.ll_dislike);
                tv_dislike = itemView
                        .findViewById(R.id.tv_dislike);

                ll_forword = itemView
                        .findViewById(R.id.ll_forword);
                tv_forword = itemView
                        .findViewById(R.id.tv_forword);

                ll_comment = itemView
                        .findViewById(R.id.ll_comment);
                tv_comment = itemView
                        .findViewById(R.id.tv_comment);
            }
        }
    }
}

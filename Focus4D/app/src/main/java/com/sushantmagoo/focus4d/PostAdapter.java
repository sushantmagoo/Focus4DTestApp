package com.sushantmagoo.focus4d;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.squareup.picasso.Picasso;
import java.util.List;

class PostsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int VIEW_TYPE_DEFAULT = 1;
    public static final int VIEW_TYPE_SUGGESTION = 2;

    List<PostItem> posts;
    Context context;
    final Picasso picasso;

    public PostsAdapter(Context context, List<PostItem> items) {
        this.context = context;
        picasso = Picasso.with(context);
        this.posts = items;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_DEFAULT) {
            View view = LayoutInflater.from(context).inflate(R.layout.post_item, parent, false);
            PostViewHolder postViewHolder = new PostViewHolder(view);
            return postViewHolder;
        } else if (viewType == VIEW_TYPE_SUGGESTION) {
            View view = LayoutInflater.from(context).inflate(R.layout.suggestion_item, parent, false);
            return new SuggestionViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof PostViewHolder) {
            ((PostViewHolder) holder).bindView(posts.get(position));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(posts.get(position).isSuggestion()) {
            return VIEW_TYPE_SUGGESTION;
        }
        else {
            return VIEW_TYPE_DEFAULT;
        }
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }


    class PostViewHolder extends RecyclerView.ViewHolder {

        private PostItem postItem;

        @BindView(R.id.username) TextView usernameTv;
        @BindView(R.id.post_text) TextView postTextTv;

        public PostViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindView(PostItem post) {
            this.postItem = post;
            if (postItem.data.length > 0) {
                final Data data = postItem.data[0];
                usernameTv.setText(data.name);
                picasso.load(data.profile_img_url);
                postTextTv.setText(data.question);
            }
        }
    }

    private class SuggestionViewHolder extends RecyclerView.ViewHolder {

        public SuggestionViewHolder(View itemView) {
            super(itemView);
        }

    }
}
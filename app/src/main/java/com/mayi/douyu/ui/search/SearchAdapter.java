package com.mayi.douyu.ui.search;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mayi.douyu.R;
import com.mayi.douyu.base.BaseRecyclerAdapter;
import com.mayi.douyu.entity.DYSearchDetails;
import com.mayi.douyu.ui.main.douyu.LiveAdapter;
import com.mayi.douyu.widget.CustomSizeImageView;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 作者 by yugai 时间 17/2/5.
 * ＊ 邮箱 784787081@qq.com
 */

public class SearchAdapter extends BaseRecyclerAdapter<DYSearchDetails.RoomEntity> {
    Context mContext;
    LiveAdapter.OnItemClickListener mOnItemClickListener;

    public SearchAdapter(Context context, LiveAdapter.OnItemClickListener onItemClickListener) {
        mContext = context;
        mOnItemClickListener = onItemClickListener;
    }

    @Override
    public void onBindItemViewHolder(RecyclerView.ViewHolder holder, final DYSearchDetails.RoomEntity data, int position) {
        final Holder roomHolder = (Holder) holder;
        Glide.with(mContext).load(data.getVertical_src()).into(roomHolder.mIvRoomSrc);
        Glide.with(mContext).load(data.getAvatar()).into(roomHolder.mAvatar);
        roomHolder.mNickname.setText(data.getNickname());
        roomHolder.mTvRoomTitle.setText(data.getRoom_name());
        roomHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnItemClickListener.onItemClick(data.getRoom_id());
            }
        });
    }

    @Override
    public RecyclerView.ViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType) {
        return new Holder(LayoutInflater.from(mContext).inflate(R.layout.item_live, parent, false));
    }

    static class Holder extends RecyclerView.ViewHolder {
        @Bind(R.id.avatar)
        CircleImageView mAvatar;
        @Bind(R.id.nickname)
        TextView mNickname;
        @Bind(R.id.tv_room_title)
        TextView mTvRoomTitle;
        @Bind(R.id.iv_room_src)
        CustomSizeImageView mIvRoomSrc;
        public Holder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
    public interface OnItemClickListener {
        void onItemClick(String roomId);
    }
}

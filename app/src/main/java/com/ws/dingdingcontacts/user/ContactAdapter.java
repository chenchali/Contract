package com.ws.dingdingcontacts.user;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.ws.dingdingcontacts.R;

import java.util.ArrayList;
import java.util.List;

import me.yokeyword.indexablerv.IndexableAdapter;


public class ContactAdapter extends IndexableAdapter<UserEntity> {
    private LayoutInflater mInflater;
    private List<UserEntity> mSelectedList;
    private List<UserEntity> mList;

    public ContactAdapter(Context context, List<UserEntity> list) {
        mSelectedList = new ArrayList<UserEntity>();
        mInflater = LayoutInflater.from(context);
        if (list == null) {
            this.mList = new ArrayList<UserEntity>();
        } else {
            this.mList = list;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateTitleViewHolder(ViewGroup parent) {
        View view = mInflater.inflate(R.layout.item_index_contact, parent, false);
        return new IndexVH(view);
    }

    @Override
    public RecyclerView.ViewHolder onCreateContentViewHolder(ViewGroup parent) {
        View view = mInflater.inflate(R.layout.item_contact, parent, false);
        return new ContentVH(view);
    }

    @Override
    public void onBindTitleViewHolder(RecyclerView.ViewHolder holder, String indexTitle) {
        IndexVH vh = (IndexVH) holder;
        vh.tv.setText(indexTitle);
    }

    @Override
    public void onBindContentViewHolder(RecyclerView.ViewHolder holder, UserEntity entity) {
        ContentVH vh = (ContentVH) holder;
        holder.itemView.setTag(vh.mCheckBox);
        vh.tvName.setText(entity.getNick());

        vh.mCheckBox.setChecked(isSelected(entity));
    }

    private boolean isSelected(UserEntity model) {
        return mSelectedList.contains(model);
        //return true;
    }

    public void toggleChecked(int position) {
        if (isSelected(mList.get(position))) {
            removeSelected(position);
        } else {
            setSelected(position);
        }

    }

    private void setSelected(int position) {
        if (!mSelectedList.contains(mList.get(position))) {
            mSelectedList.add(mList.get(position));
        }
    }

    private void removeSelected(int position) {
        if (mSelectedList.contains(mList.get(position))) {
            mSelectedList.remove(mList.get(position));
        }
    }

    private class IndexVH extends RecyclerView.ViewHolder {
        TextView tv;

        public IndexVH(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv_index);
        }
    }

    public static class ContentVH extends RecyclerView.ViewHolder {
        TextView tvName;
        CheckBox mCheckBox;

        public ContentVH(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            mCheckBox = (CheckBox) itemView.findViewById(R.id.checkbox);
        }
    }
}

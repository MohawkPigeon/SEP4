package com.example.supermegatron4000.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.logappdev2.R;
import com.example.supermegatron4000.view.activities.ActionActivity;

import java.util.List;

public class ActionsListAdapter extends RecyclerView.Adapter<ActionsListAdapter.RoomsViewHolder> {

    private LayoutInflater mInflater;
    private List<String> mWordList;

    public ActionsListAdapter(List<String> list){
        mWordList=list;
    }


    @NonNull
    @Override
    public ActionsListAdapter.RoomsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.action_list_item, parent,false);
        return new RoomsViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ActionsListAdapter.RoomsViewHolder holder, int position) {
        String mCurrent = mWordList.get(position);
        holder.text.setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }

    class RoomsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ActionsListAdapter mAdapter;
        TextView text;
        ImageButton btn1, btn2;

        public RoomsViewHolder(View itemView, ActionsListAdapter adapter){
            super(itemView);
            text = (TextView)itemView.findViewById(R.id.textViewActions);
            btn1 = (ImageButton)itemView.findViewById(R.id.btnEdit);
            btn2 = (ImageButton)itemView.findViewById(R.id.btnDel);
            this.mAdapter = adapter;

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), ActionActivity.class);
                    v.getContext().startActivity(intent);
                }
            });
        }
        @Override
        public void onClick(View v) {

        }
    }
}

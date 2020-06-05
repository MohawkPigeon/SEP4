package com.example.supermegatron4000.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.logappdev2.R;
import com.example.supermegatron4000.model.myRoom;
import com.example.supermegatron4000.view.activities.RoomActivity;

import java.util.List;

public class RoomsListAdapter extends RecyclerView.Adapter<RoomsListAdapter.MyViewHolder> {

    private LayoutInflater mInflater;
    private List<myRoom> mRoomList;
    Context mContext;


    ItemClicked activity;
    public interface ItemClicked{
        void onItemClicked(int index);
    }


    public RoomsListAdapter(Context context, List<myRoom> roomList) {
        this.mContext = context;
        this.mRoomList = roomList;

    }

    @NonNull
    @Override
    public RoomsListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rooms_list_item, parent,false);
        return new MyViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull RoomsListAdapter.MyViewHolder holder, int position) {
        myRoom mCurrent = mRoomList.get(position);
        holder.btn.setText(mCurrent.getRoomName());
    }

    @Override
    public int getItemCount() {
        if (mRoomList==null){
            return 0;
        }
        return mRoomList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        RoomsListAdapter mAdapter;
        Button btn;
        SeekBar bar;

        public MyViewHolder(View itemView, RoomsListAdapter adapter) {
            super(itemView);
            itemView.setOnClickListener(this);
            btn=(Button)itemView.findViewById(R.id.singleRoomBtn);
            bar=(SeekBar) itemView.findViewById(R.id.seekBar);
            this.mAdapter = adapter;

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int position = getAdapterPosition();
                    Intent intent = new Intent(v.getContext(), RoomActivity.class);
                    intent.putExtra("Selected_Room",mRoomList.get(position));


                    if (position != RecyclerView.NO_POSITION) {
                        Toast.makeText(v.getContext(), "You clicked " + mRoomList.get(position).getRoomName(), Toast.LENGTH_SHORT).show();
                        v.getContext().startActivity(intent);
                    }
                }
            });
        }
        @Override
        public void onClick(View view) {

        }


    }

    public interface OnRoomListener{
        void onRoomClick(int position);
    }
}

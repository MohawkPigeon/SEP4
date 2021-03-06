package com.example.supermegatron4000.view.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.logappdev2.R;
import com.example.supermegatron4000.adapters.RoomsListAdapter;
import com.example.supermegatron4000.model.myRoom;
import com.example.supermegatron4000.view.activities.RoomActivity;
import com.example.supermegatron4000.viewModel.RoomsViewModel;

import java.util.List;

public class RoomsView extends Fragment {


    private RoomsViewModel mRooms;
    private RoomsListAdapter adapter;
    private RecyclerView recyclerView;
    private ProgressBar pBar;



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.rooms_view_layout, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);

        pBar = view.findViewById(R.id.pBarRooms);

        mRooms = new ViewModelProvider(this).get(RoomsViewModel.class);
        mRooms.init();

        mRooms.getRooms().observe(getViewLifecycleOwner(), new Observer<List<myRoom>>() {
            @Override
            public void onChanged(List<myRoom> myRooms) {
                adapter.notifyDataSetChanged();
                pBar.setVisibility(View.VISIBLE);
                update();
                pBar.setVisibility(View.INVISIBLE);

            }
        });
        mRooms.getIsUpdating().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {

            }
        });

        initRecyclerView();
        return view;

    }

    public void initRecyclerView(){

        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new RoomsListAdapter(getContext(), mRooms.getRooms().getValue());
        recyclerView.setAdapter(adapter);

        RecyclerView.ItemDecoration divider = new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(divider);

    }

    public void update (){
        adapter = new RoomsListAdapter(getContext(), mRooms.getRooms().getValue());
        recyclerView.setAdapter(adapter);
    }

}

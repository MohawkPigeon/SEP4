package com.example.supermegatron4000.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.logappdev2.R;
import com.example.supermegatron4000.adapters.RoomsListAdapter;
import com.example.supermegatron4000.model.Room_simple;
import com.example.supermegatron4000.viewModel.RoomsViewModel;

import java.util.Arrays;
import java.util.List;

public class RoomsView extends Fragment {


    private RoomsViewModel mRooms;
    private RoomsListAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.rooms_view_layout, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);

        mRooms = new ViewModelProvider(this).get(RoomsViewModel.class);
        mRooms.init();

        mRooms.getRooms().observe(getViewLifecycleOwner(), new Observer<List<Room_simple>>() {
            @Override
            public void onChanged(List<Room_simple> room_simples) {
                adapter.notifyDataSetChanged();
                update();

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

        RecyclerView.ItemDecoration divider = new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(divider);

    }

}

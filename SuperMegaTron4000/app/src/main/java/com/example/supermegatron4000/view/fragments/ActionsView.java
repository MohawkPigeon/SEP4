package com.example.supermegatron4000.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.logappdev2.R;
import com.example.supermegatron4000.adapters.ActionsListAdapter;

import java.util.ArrayList;
import java.util.Arrays;

public class ActionsView extends Fragment {

    public ArrayList actions;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.actions_view_layout, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewActions);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        ActionsListAdapter adapter = new ActionsListAdapter(Arrays.asList(getResources().getStringArray(R.array.ActionsList)));
        recyclerView.setAdapter(adapter);

        RecyclerView.ItemDecoration divider = new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(divider);

        return view;
    }

    public void update (){

    }
}

package com.delivriko.askdoctorstask.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.delivriko.askdoctorstask.Adapter.InsuranceAdapter;
import com.delivriko.askdoctorstask.R;
import com.delivriko.askdoctorstask.model.Insurance;
import com.delivriko.askdoctorstask.viewmodel.InsuranceModel;

import java.util.ArrayList;

public class InsuranceFragment extends Fragment {
    private RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_insurance, container, false);
        recyclerView = root.findViewById(R.id.listView);
        initRvInsurance();
        return root;
    }

    private void initRvInsurance() {
        ArrayList<InsuranceModel> newsModel = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            newsModel.add(new InsuranceModel(new Insurance("insurance", "one")));
        }
        InsuranceAdapter customAdapter = new InsuranceAdapter(newsModel);
        GridLayoutManager layoutManager
                = new GridLayoutManager(getActivity(), 2);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(layoutManager);
    }
}
package com.delivriko.askdoctorstask.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bvapp.arcmenulibrary.ArcMenu;
import com.bvapp.arcmenulibrary.widget.FloatingActionButton;
import com.delivriko.askdoctorstask.Adapter.InsuranceAdapter;
import com.delivriko.askdoctorstask.R;
import com.delivriko.askdoctorstask.model.Insurance;
import com.delivriko.askdoctorstask.viewmodel.InsuranceModel;

import java.util.ArrayList;

public class InsuranceFragment extends Fragment {
    private ArcMenu menu;
    private RecyclerView recyclerView;

    public InsuranceFragment(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_insurance, container, false);
        recyclerView = root.findViewById(R.id.listView);
        menu = root.findViewById(R.id.arcMenu);
        initRvInsurance();
        initBottomMenu();
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

    private void initBottomMenu() {
        final int[] itemDrawables = {R.drawable.ic_menu_gallery, R.drawable.ic_menu_send, R.drawable.ic_menu_camera,
                R.drawable.ic_menu_manage};
        final String[] str = {"one", "two", "three", "four"};
        menu.showTooltip(false);
        menu.setToolTipBackColor(Color.WHITE);
        menu.setToolTipCorner(6f);
        menu.setToolTipPadding(2f);
        menu.isClose();
        menu.setToolTipTextColor(Color.BLUE);
        menu.setAnim(300, 300, ArcMenu.ANIM_MIDDLE_TO_RIGHT, ArcMenu.ANIM_MIDDLE_TO_RIGHT,
                ArcMenu.ANIM_INTERPOLATOR_ACCELERATE_DECLERATE, ArcMenu.ANIM_INTERPOLATOR_ACCELERATE_DECLERATE);

        final int itemCount = itemDrawables.length;
        for (int i = 0; i < itemCount; i++) {
            FloatingActionButton item = new FloatingActionButton(getActivity());  // Use internal FAB as child
            item.setSize(FloatingActionButton.SIZE_MINI); // set initial size for child, it will create fab first
            item.setIcon(itemDrawables[i]);
            switch (i) {
                case 0:
                case 3:
                    item.setBackgroundColor(getResources().getColor(R.color.colorPrimary)); // it will set fab child's color
                    break;
                default:
                    item.setBackgroundColor(getResources().getColor(R.color.green)); // it will set fab child's color
            }

            menu.setChildSize(item.getIntrinsicHeight()); // set absolout child size for menu

            menu.addItem(item, str[i], new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });
        }
    }

}
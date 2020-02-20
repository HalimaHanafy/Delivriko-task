package com.delivriko.askdoctorstask.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.bvapp.arcmenulibrary.ArcMenu;
import com.bvapp.arcmenulibrary.widget.FloatingActionButton;
import com.delivriko.askdoctorstask.Adapter.CardPagerAdapter;
import com.delivriko.askdoctorstask.R;
import com.delivriko.askdoctorstask.model.Doctor;
import com.delivriko.askdoctorstask.utils.ShadowTransformer;

public class AskDoctorsFragment extends Fragment {

    private ViewPager mViewPager;
    private ArcMenu menu;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_ask_doctors, container, false);
        mViewPager = root.findViewById(R.id.viewPager);
        menu = root.findViewById(R.id.arcMenu);
        initDoctorViewPager();
        initBottomMenu();
        return root;
    }

    private void initDoctorViewPager() {
        CardPagerAdapter mCardAdapter = new CardPagerAdapter();
        for (int i = 0; i < 5; i++) {
            mCardAdapter.addCardItem(new Doctor("ahmed", "21"));
        }

        ShadowTransformer mCardShadowTransformer = new ShadowTransformer(mViewPager, mCardAdapter);
        mViewPager.setAdapter(mCardAdapter);
        mViewPager.setPageTransformer(false, mCardShadowTransformer);
        mCardShadowTransformer.enableScaling(true);
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setCurrentItem(1);
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
package com.delivriko.askdoctorstask.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.delivriko.askdoctorstask.Adapter.CardPagerAdapter;
import com.delivriko.askdoctorstask.R;
import com.delivriko.askdoctorstask.model.Doctor;
import com.delivriko.askdoctorstask.utils.ShadowTransformer;

public class AskDoctorsFragment extends Fragment {

    private ViewPager mViewPager;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_ask_doctors, container, false);
        mViewPager = root.findViewById(R.id.viewPager);
        initDoctorViewPager();
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

}
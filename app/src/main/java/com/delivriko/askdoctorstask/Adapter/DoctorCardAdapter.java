package com.delivriko.askdoctorstask.Adapter;


import androidx.cardview.widget.CardView;

public interface DoctorCardAdapter {

    int MAX_ELEVATION_FACTOR = 8;

    float getBaseElevation();

    CardView getCardViewAt(int position);

    int getCount();
}

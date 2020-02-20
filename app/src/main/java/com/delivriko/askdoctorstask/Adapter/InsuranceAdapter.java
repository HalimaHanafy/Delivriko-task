package com.delivriko.askdoctorstask.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.delivriko.askdoctorstask.R;
import com.delivriko.askdoctorstask.viewmodel.InsuranceModel;

import java.util.ArrayList;


public class InsuranceAdapter extends RecyclerView.Adapter<InsuranceAdapter.RecyclerViewHolder> {


    ArrayList<InsuranceModel> newsModels;

    public InsuranceAdapter(ArrayList<InsuranceModel> models) {
        this.newsModels = models;
    }


    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_insurance, parent, false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view, viewType);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        InsuranceModel model = newsModels.get(position);
        holder.bind(model, position);
    }

    @Override
    public int getItemCount() {
        return newsModels.size();
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        //        TextView title, det;
        CardView cardView;

        public RecyclerViewHolder(View view, int viewType) {
            super(view);
//            view.setOnClickListener(this);
            cardView = view.findViewById(R.id.card);
        }

        @Override
        public void onClick(View v) {

        }

        public void bind(InsuranceModel model, int i) {
//            title.setText(model.title);
//            det.setText(model.desc);

            switch (i) {
                case 1:
                    cardView.setCardBackgroundColor(itemView.getResources().getColor(R.color.green)); // it will set fab child's color
                    cardView.setRadius(110);
//                    cardView.setPreventCornerOverlap(true);
                    break;
                default:
                    cardView.setRadius(110);
                    cardView.setCardBackgroundColor(itemView.getResources().getColor(R.color.colorPrimary)); // it will set fab child's color
            }
        }
    }

}

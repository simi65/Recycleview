package com.miss.recycleview;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterMovie extends RecyclerView.Adapter<AdapterMovie.MovieHolder> implements Filterable {

    ArrayList<ModelMovie> listData;
    ArrayList<ModelMovie> filterdata;

    public AdapterMovie(ArrayList<ModelMovie> datalist) {
        listData = datalist;
        filterdata = datalist;
    }

    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.raw_list, viewGroup, false);

        return new MovieHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder movieHolder, int i) {

        movieHolder.bindView(filterdata.get(i));

    }

    @Override
    public int getItemCount() {
        return filterdata.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                String charString = constraint.toString();
                if (charString.isEmpty()) {
                    filterdata = listData;
                } else {
                    ArrayList<ModelMovie> filterList = new ArrayList<>();
                    for (ModelMovie modelMovie : listData) {
                        if (modelMovie.getJudul().toLowerCase().contains(charString) | modelMovie.getSubjudul().toLowerCase().contains(charString)) {
                            filterList.add(modelMovie);
                        }
                        filterdata = filterList;
                    }
                }

                FilterResults filterResult = new FilterResults();
                filterResult.values = filterdata;
                return filterResult;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                filterdata = (ArrayList<ModelMovie>) results.values;
                notifyDataSetChanged();
            }
        };
    }

    public class MovieHolder extends RecyclerView.ViewHolder {

        TextView tvTitle, tvSubtitle;
        ImageView imageLogo, imageCover;

        public MovieHolder(@NonNull View itemView) {


            super(itemView);

            tvTitle = itemView.findViewById(R.id.tvJudul);
            tvSubtitle = itemView.findViewById(R.id.tvSubJudul1);

            imageLogo = itemView.findViewById(R.id.ivLogo);
            imageCover = itemView.findViewById(R.id.ivRaw);
        }

        private void bindView(ModelMovie data) {

            tvTitle.setText(data.getJudul());
            tvSubtitle.setText(data.getSubjudul());

            imageCover.setImageResource(data.getGambar());
            imageLogo.setImageResource(data.getLogo());


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemView.getContext().startActivity(new Intent(itemView.getContext(), DetailAct.class)
                            .putExtra("key", tvTitle.getText().toString()));
                }
            });

        }


    }


}

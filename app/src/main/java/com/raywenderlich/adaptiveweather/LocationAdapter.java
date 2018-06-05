package com.raywenderlich.adaptiveweather;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.ViewHolder> {

  interface OnItemClickListener {
    void onItemClick(Location location);
  };

  private List<Location> mDataset;
  private Context mContext;
  private Location selectedLocation;
  private OnItemClickListener mListener;

  LocationAdapter(Context context, List<Location> dataset, OnItemClickListener listener) {
    mContext = context;
    mDataset = dataset;
    mListener = listener;
  }

  static class ViewHolder extends RecyclerView.ViewHolder {
    TextView title;
    ViewHolder(View v) {
      super(v);
      title = (TextView) v.findViewById(android.R.id.text1);
    }
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
    View view = layoutInflater.inflate(android.R.layout.simple_selectable_list_item, parent, false);

    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, final int position) {
    holder.title.setText(mDataset.get(position).getName());
    holder.title.setTextSize(22);
    holder.itemView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        mListener.onItemClick(mDataset.get(position));
        selectedLocation = mDataset.get(position);
        notifyDataSetChanged();
      }
    });
    if (mDataset.get(position).equals(selectedLocation)) {
      int backgroundColor = mContext.getResources().getColor(R.color.color_primary_dark);
      holder.itemView.setBackgroundColor(backgroundColor);
      holder.title.setTextColor(Color.WHITE);
    } else {
      holder.itemView.setBackgroundColor(Color.WHITE);
      holder.title.setTextColor(Color.BLACK);
    }
  }

  @Override
  public int getItemCount() {
    return mDataset.size();
  }

  int getSelectedLocationIndex() {
    return mDataset.indexOf(selectedLocation);
  }

  void setSelectedLocationIndex(int index) {
    this.selectedLocation = mDataset.get(index);
  }
}

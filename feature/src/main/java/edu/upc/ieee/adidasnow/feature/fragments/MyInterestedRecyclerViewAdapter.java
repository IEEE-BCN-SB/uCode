package edu.upc.ieee.adidasnow.feature.fragments;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import edu.upc.ieee.adidasnow.feature.R;
import edu.upc.ieee.adidasnow.feature.fragments.InterestedFragment.OnListFragmentInteractionListener;
import edu.upc.ieee.adidasnow.feature.fragments.dummy.DummyContent.DummyItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyInterestedRecyclerViewAdapter extends RecyclerView.Adapter<MyInterestedRecyclerViewAdapter.ViewHolder> {

    private final List<DummyItem> mValues;
    private final OnListFragmentInteractionListener mListener;

    MyInterestedRecyclerViewAdapter(List<DummyItem> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_list_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mNameView.setText(mValues.get(position).id);
        holder.mDescriptionView.setText(mValues.get(position).content);
        holder.mPriceView.setText(String.valueOf(position) + "€");

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final View mView;
        final ImageView mImgView;
        final TextView mNameView;
        final TextView mDescriptionView;
        final TextView mPriceView;
        DummyItem mItem;

        ViewHolder(View view) {
            super(view);
            mView = view;
            mImgView = view.findViewById(R.id.product_row_image);
            mNameView = view.findViewById(R.id.product_row_name);
            mDescriptionView = view.findViewById(R.id.product_row_description);
            mPriceView = view.findViewById(R.id.product_row_price);
        }

    }
}

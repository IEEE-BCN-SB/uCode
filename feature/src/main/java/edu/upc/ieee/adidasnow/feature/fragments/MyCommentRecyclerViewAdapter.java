package edu.upc.ieee.adidasnow.feature.fragments;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import edu.upc.ieee.adidasnow.feature.R;
import edu.upc.ieee.adidasnow.feature.fragments.CommentFragment.OnListFragmentInteractionListener;
import edu.upc.ieee.adidasnow.feature.fragments.dummy.DummyContent.DummyItem;
import edu.upc.ieee.adidasnow.feature.models.Comment;
import edu.upc.ieee.adidasnow.feature.models.Product;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyCommentRecyclerViewAdapter extends RecyclerView.Adapter<MyCommentRecyclerViewAdapter.ViewHolder> {

    private final List<Comment> mValues;
    private final OnListFragmentInteractionListener mListener;

    // private List<Product> productList;

    MyCommentRecyclerViewAdapter(List<Comment> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.comment_list_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mTitleView.setText(holder.mItem.getTitle());
        holder.mDescriptionView.setText(holder.mItem.getDescription());
        holder.mNameView.setText(holder.mItem.getUser());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final View mView;
        final TextView mTitleView;
        final TextView mDescriptionView;
        final TextView mNameView;

        Comment mItem;

        ViewHolder(View view) {
            super(view);
            mView = view;
            mTitleView = view.findViewById(R.id.comment_row_title);
            mDescriptionView = view.findViewById(R.id.comment_row_product);
            mNameView = view.findViewById(R.id.comment_row_name);
        }

    }
}

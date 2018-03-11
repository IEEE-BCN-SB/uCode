package edu.upc.ieee.adidasnow.feature.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.Serializable;
import java.util.List;

import edu.upc.ieee.adidasnow.feature.R;
import edu.upc.ieee.adidasnow.feature.fragments.dummy.DummyContent;
import edu.upc.ieee.adidasnow.feature.fragments.dummy.DummyContent.DummyItem;
import edu.upc.ieee.adidasnow.feature.models.Recommendation;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class InterestedFragment extends Fragment {

    // TODO: Customize parameter argument names
    // TODO: Customize parameters
    private OnListFragmentInteractionListener mListener;
    List<Recommendation> mRecommendation;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public InterestedFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static InterestedFragment newInstance(List<Recommendation> recommendation) {
        InterestedFragment fragment = new InterestedFragment();
        Bundle args = new Bundle();
        args.putSerializable("bla",(Serializable) recommendation);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mRecommendation = (List<Recommendation>) getArguments().getSerializable("bla");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.product_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(new MyInterestedRecyclerViewAdapter(mRecommendation, mListener));
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            // Toast or pass.
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(DummyItem item);
    }
}

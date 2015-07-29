package com.niko.hannes.nikomobileapp.ui.home;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.niko.hannes.nikomobileapp.R;
import com.niko.hannes.nikomobileapp.model.Avatar;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MenuFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MenuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MenuFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private RecyclerView mlistView;

    public MenuFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.home_menu_fragment, container, false);

        bindListView(view);

        return view;
    }

    private void bindListView(View view) {

        List<MenuItemVM> menuitems = new ArrayList<MenuItemVM>();
        menuitems.add(new MenuItemVM("Hannes", "Senior software developer", Avatar.ONE));
        menuitems.add(new MenuItemVM("Kenneth", "Senior software developer", Avatar.TWO));
        menuitems.add(new MenuItemVM("Bjorn", "Senior software developer", Avatar.FOUR));
        menuitems.add(new MenuItemVM("Peter", "Senior software developer", Avatar.FIVE));
        menuitems.add(new MenuItemVM("Tony", "Software tester", Avatar.ELEVEN));
        menuitems.add(new MenuItemVM("Erik", "Software manager", Avatar.SIXTEEN));
        MenuListAdapter adapter = new MenuListAdapter(getActivity(), menuitems);


        mlistView = (RecyclerView) view.findViewById(R.id.home_menu_list);
        mlistView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mlistView.setAdapter(adapter);
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
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
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}

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
import android.widget.Toast;

import com.niko.hannes.nikomobileapp.R;
import com.niko.hannes.nikomobileapp.framework.IListItemClickListener;
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
public class MenuFragment extends Fragment implements IListItemClickListener {

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
        menuitems.add(new MenuItemVM("Bjorn", "Senior software developer", Avatar.THREE));
        menuitems.add(new MenuItemVM("Peter", "Senior software developer", Avatar.FOUR));
        menuitems.add(new MenuItemVM("Tony", "Software tester", Avatar.FIVE));
        menuitems.add(new MenuItemVM("Erik", "Software manager", Avatar.SIX));
        menuitems.add(new MenuItemVM("Koen", "SoftwareMaster Architect", Avatar.SEVEN));
        menuitems.add(new MenuItemVM("Christope", "Mobile Architect", Avatar.EIGHT));
        menuitems.add(new MenuItemVM("Joris", "Hardware Architect", Avatar.NINE));
        menuitems.add(new MenuItemVM("Luc", "Lead Designer", Avatar.TEN));
        menuitems.add(new MenuItemVM("Johan", "Customer support engineer", Avatar.ELEVEN));
        menuitems.add(new MenuItemVM("Niels", "Customer support engineer", Avatar.TWELVE));
        menuitems.add(new MenuItemVM("Blowser", "A chinese browser", Avatar.THIRTEEN));
        menuitems.add(new MenuItemVM("Toad", "Just a nice guy", Avatar.FOURTEEN));
        menuitems.add(new MenuItemVM("Wim", "Integration test expert", Avatar.FIFTEEN));
        menuitems.add(new MenuItemVM("Mario", "Super high jumper", Avatar.TWELVE));
        MenuListAdapter adapter = new MenuListAdapter(getActivity(), menuitems);
        adapter.setOnItemClickListener(this);

        mlistView = (RecyclerView) view.findViewById(R.id.home_menu_list);
        mlistView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mlistView.setAdapter(adapter);
        //mlistView.setOnClickListener();
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

    @Override
    public void onListItemClick(View v, int position) {
        Toast.makeText(getActivity(), "onListItemClick !: " + position, Toast.LENGTH_SHORT).show();
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

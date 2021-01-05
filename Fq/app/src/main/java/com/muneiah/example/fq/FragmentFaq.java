package com.muneiah.example.fq;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



public class FragmentFaq extends Fragment {
    int previousGroup = -1;
    boolean flag = false;
    private ExpandableListView expandableListView;

    private ExpandableListViewAdapter expandableListViewAdapter;

    private List<String> listDataGroup;

    private HashMap<String, List<String>> listDataChild;
    boolean mIsSaved=true;
    private Menu toolBarmenu;
    public FragmentFaq() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_faq, container, false);
     //   Toast.makeText(getContext(), "ding", Toast.LENGTH_SHORT).show();
     //   Toolbar toolbar = (Toolbar) v.findViewById(R.id.tb);
       // Toast.makeText(getContext(), "Main", Toast.LENGTH_SHORT).show();
        expandableListView = v.findViewById(R.id.expandableListView);


        // initializing the listeners
        initListeners();

        // initializing the objects
        initObjects();

        // preparing list data
        initListData();
        return v;
    }
    /*private void initViews() {

        expandableListView = v.findViewById(R.id.expandableListView);

    }*/
    private void initListeners() {

        // ExpandableListView on child click listener
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                /*Toast.makeText(
                        getContext(),
                        listDataGroup.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataGroup.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();*/
                return false;
            }
        });


        // ExpandableListView Group expanded listener
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                /*Toast.makeText(getContext(),
                        listDataGroup.get(groupPosition) + " " + getString(R.string.text_collapsed),
                        Toast.LENGTH_SHORT).show();*/
                if (groupPosition != previousGroup && flag) {
                    expandableListView.collapseGroup(previousGroup);
                }
                previousGroup = groupPosition;

                flag = true;

            }
        });

        // ExpandableListView Group collapsed listener
        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                /*Toast.makeText(getContext(),
                        listDataGroup.get(groupPosition) + " " + getString(R.string.text_collapsed),
                        Toast.LENGTH_SHORT).show();*/

            }
        });

    }

    /**
     * method to initialize the objects
     */
    private void initObjects() {

        // initializing the list of groups
        listDataGroup = new ArrayList<>();

        // initializing the list of child
        listDataChild = new HashMap<>();

        // initializing the adapter object
        expandableListViewAdapter = new ExpandableListViewAdapter(getContext(), listDataGroup, listDataChild);

        // setting list adapter
        expandableListView.setAdapter(expandableListViewAdapter);

    }

    /*
     * Preparing the list data
     *
     * Dummy Items
     */
    private void initListData() {


        // Adding group data
        listDataGroup.add(getString(R.string.text_alcohol));
        listDataGroup.add(getString(R.string.text_coffee));
        listDataGroup.add(getString(R.string.text_pasta));
        listDataGroup.add(getString(R.string.text_cold_drinks));
        listDataGroup.add(getString(R.string.land_cleaing));
        listDataGroup.add(getString(R.string.crop_insurance));

        // array of strings
        String[] array;

        // list of alcohol
        List<String> alcoholList = new ArrayList<>();
        array = getResources().getStringArray(R.array.string_array_alcohol);
        for (String item : array) {
            alcoholList.add(item);
        }

        // list of coffee
        List<String> coffeeList = new ArrayList<>();
        array = getResources().getStringArray(R.array.string_array_coffee);
        for (String item : array) {
            coffeeList.add(item);
        }

        // list of pasta
        List<String> pastaList = new ArrayList<>();
        array = getResources().getStringArray(R.array.string_array_pasta);
        for (String item : array) {
            pastaList.add(item);
        }

        // list of cold drinks
        List<String> coldDrinkList = new ArrayList<>();
        array = getResources().getStringArray(R.array.string_array_cold_drinks);
        for (String item : array) {
            coldDrinkList.add(item);
        }
        // list of cold drinks
        List<String> cleing = new ArrayList<>();
        array = getResources().getStringArray(R.array.land_clean);
        for (String item : array) {
            cleing.add(item);
        }
        // list of cold drinks
        List<String> insurence = new ArrayList<>();
        array = getResources().getStringArray(R.array.crop_insurence);
        for (String item : array) {
            insurence.add(item);
        }

        // Adding child data
        listDataChild.put(listDataGroup.get(0), alcoholList);
        listDataChild.put(listDataGroup.get(1), coffeeList);
        listDataChild.put(listDataGroup.get(2), pastaList);
        listDataChild.put(listDataGroup.get(3), coldDrinkList);
        listDataChild.put(listDataGroup.get(4), cleing);
        listDataChild.put(listDataGroup.get(5), insurence);

        // notify the adapter
        expandableListViewAdapter.notifyDataSetChanged();
    }
}
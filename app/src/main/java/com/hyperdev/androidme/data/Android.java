package com.hyperdev.androidme.data;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hyperdev.androidme.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Android extends Fragment {

    private List<Integer> mPartNum;
    private int mposition;
    private static final String PARTS_LIST = "parts_list";
    private static final String PARTS_NUMBER = "parts_number";

    public Android() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if(savedInstanceState != null){
            mPartNum = savedInstanceState.getIntegerArrayList(PARTS_LIST);
            mposition = savedInstanceState.getInt(PARTS_NUMBER);
        }
        View rootView = inflater.inflate(R.layout.fragment_android, container, false);

        final ImageView imageView = (ImageView) rootView.findViewById(R.id.imgfragment);
        if(mPartNum !=null){
            imageView.setImageResource(mPartNum.get(mposition));

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mposition < mPartNum.size()-1){
                        mposition++;
                    }else {
                        mposition = 0;
                    }
                    imageView.setImageResource(mPartNum.get(mposition));
                }
            });
        }
        return rootView;
    }
    public void setPartList(List<Integer> partList) {
        this.mPartNum = partList;
    }

    public void setListPosition(int mListPosition) {
        this.mposition = mListPosition;
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putIntegerArrayList(PARTS_LIST, (ArrayList<Integer>)mPartNum);
        outState.putInt(PARTS_NUMBER,mposition);
    }

}

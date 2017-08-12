package com.enpassio.foodtricks;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.enpassio.foodtricks.api.APIClient;
import com.enpassio.foodtricks.api.APIInterface;

/**
 * Created by ABHISHEK RAJ on 8/11/2017.
 */

public class MenuFragment extends Fragment {
    APIInterface apiInterface;

    public MenuFragment(){

    }
    @Nullable
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        apiInterface = APIClient.getClient().create(APIInterface.class);
        setHasOptionsMenu(true);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /* Inflate the layout for this fragment */
        View rootView = inflater.inflate(R.layout.fragment_menu, container, false);
        return rootView;
    }
}

package com.enpassio.foodtricks.api;

/**
 * Created by ABHISHEK RAJ on 8/11/2017.
 */

import com.enpassio.foodtricks.model.MenuList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {

    @GET("/topher/2017/May/59121517_baking/baking.json")
    Call<List<MenuList>> doGetListResources();
}
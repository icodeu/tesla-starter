/*
 * Copyright (C) 2021 Baidu, Inc. All Rights Reserved.
 */
package com.icodeyou.teslaapistarter.service;

import com.icodeyou.teslaapi.lib.AuthUtil;
import com.icodeyou.teslaapi.lib.VehicleUtil;
import com.icodeyou.teslaapi.util.EnsureUtil;

public class TeslaService {

    private String email;

    private String password;

    public String accessToken;

    public Long vehicleId;

    public TeslaService(String email, String password) {
        this.email = email;
        this.password = password;
        this.initLogin();
        this.initFirstVehicleId();
    }

    public void initLogin() {
        EnsureUtil.notEmpty(email, "email can not be empty");
        EnsureUtil.notEmpty(password, "email can not be empty");
        accessToken = AuthUtil.login(email, password);
    }

    public void initFirstVehicleId() {
        EnsureUtil.notEmpty(accessToken, "access token can not be empty");
        vehicleId = VehicleUtil.getFirstVehicleId(accessToken);
    }



}

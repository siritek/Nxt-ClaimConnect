package com.example.nxtconnect.service;

import com.example.nxtconnect.model.Common;


import java.util.List;

public interface CommonService {

    public String saveCommon(Common common);

    public List<Common> getAllcommons();
}

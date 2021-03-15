package com.easylife.service;

import com.easylife.common.ServerResponse;
import com.easylife.pojo.Recycle;

import java.util.List;

public interface IRecycleService {

    ServerResponse<List<Recycle>> SelectAll();

    ServerResponse Selectbyid(int id);
}

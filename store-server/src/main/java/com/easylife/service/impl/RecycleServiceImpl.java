package com.easylife.service.impl;

import com.easylife.common.ServerResponse;
import com.easylife.dao.RecycleMapper;
import com.easylife.pojo.Recycle;
import com.easylife.service.IRecycleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("iRecycleService")
@Slf4j
public class RecycleServiceImpl implements IRecycleService {

    @Autowired
    private RecycleMapper recycleMapper;


    @Override
    public ServerResponse<List<Recycle>> SelectAll() {
        List<Recycle> recycleList = recycleMapper.SelectAllRecycle();
        return ServerResponse.createBySuccess(recycleList);
    }

    @Override
    public ServerResponse Selectbyid(int id) {
        Recycle recycle = recycleMapper.Selectbyid(id);
        return ServerResponse.createBySuccess(recycle);
    }
}

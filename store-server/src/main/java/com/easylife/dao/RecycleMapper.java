package com.easylife.dao;

import com.easylife.pojo.Recycle;
import com.easylife.util.MyMapper;

import java.util.List;

public interface RecycleMapper extends MyMapper<Recycle> {

    List<Recycle> SelectAllRecycle();

    Recycle Selectbyid(int id);
}

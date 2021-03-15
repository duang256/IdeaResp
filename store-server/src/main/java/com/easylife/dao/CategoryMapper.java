package com.easylife.dao;

import com.easylife.pojo.Category;
import com.easylife.util.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoryMapper extends MyMapper<Category> {

    List<Category> selectCategoryChildrenByParentId(Integer parentId);

    List<Category> selectCategoryByMallId(@Param("mallId")Integer mallId);
}
package com.easylife.service;


import com.easylife.common.ServerResponse;
import com.easylife.pojo.Category;

import java.util.List;

/**
 * Created by geely
 */
public interface ICategoryService {

    ServerResponse addCategory(String categoryName, Integer parentId);
    ServerResponse updateCategoryName(Integer categoryId, String categoryName);
    ServerResponse<List<Category>> getChildrenParallelCategory(Integer categoryId);
    ServerResponse<List<Integer>> selectCategoryAndChildrenById(Integer categoryId);

    ServerResponse<List<Category>> getCategoryList();

    ServerResponse<List<Category>> selectCategoryByMallId(Integer mallId);
}

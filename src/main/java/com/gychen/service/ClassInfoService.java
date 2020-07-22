package com.gychen.service;

import com.github.pagehelper.PageInfo;
import com.gychen.po.ClassInfo;

import java.util.List;

public interface ClassInfoService {
    /**
     * 查询所有的图书类型信息
     */
    PageInfo<ClassInfo> queryClassInfoAll(String name,int page,int limit);


    /**
     * 添加图书类型
     */
    void addBookType(ClassInfo classInfo);

    /**
     * 修改 根据id查询记录信息
     */
    ClassInfo queryBookTypeById(Integer id);

    /**
     * 修改图书类型信息
     */
    void updateBookType(ClassInfo classInfo);

    /**
     * 删除 根据一个或多个id删除
     */
    void deleteBookTypeByIds(List<Integer> ids);
}

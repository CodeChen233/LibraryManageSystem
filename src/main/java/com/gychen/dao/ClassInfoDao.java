package com.gychen.dao;

import com.gychen.po.ClassInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("classDao")
public interface ClassInfoDao {
    /**
     * 查询所有图书类型信息
     */
//    @Select("select * from class_info")
//    List<ClassInfo> queryClassInfoAll();

    List<ClassInfo> queryClassInfoAll(@Param(value = "name")String name);


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

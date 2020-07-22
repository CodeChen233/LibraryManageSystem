package com.gychen.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gychen.dao.ClassInfoDao;
import com.gychen.po.ClassInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("classInfoService")
public class ClassInfoServiceImpl implements ClassInfoService {

    @Autowired
    private ClassInfoDao classDao;

    @Override
    public PageInfo<ClassInfo> queryClassInfoAll(String name,int page, int limit) {

        // 传入参数，每页条数，当前页
        PageHelper.startPage(page,limit);
        List<ClassInfo> list = classDao.queryClassInfoAll(name);
        // 通过包装获取分页需要的其他值
        PageInfo<ClassInfo> pageInfo = new PageInfo<>(list);

        return pageInfo;
    }

    @Override
    public void addBookType(ClassInfo classInfo) {
        classDao.addBookType(classInfo);
    }

    @Override
    public ClassInfo queryBookTypeById(Integer id) {
        return classDao.queryBookTypeById(id);
    }

    @Override
    public void updateBookType(ClassInfo classInfo) {
        classDao.updateBookType(classInfo);
    }

    @Override
    public void deleteBookTypeByIds(List<Integer> ids) {
//        List<Integer> list = new ArrayList<>();
//        for (String cid : ids) {
//            int id = Integer.valueOf(cid);
//            list.add(id);
//        }
        classDao.deleteBookTypeByIds(ids);
    }
}

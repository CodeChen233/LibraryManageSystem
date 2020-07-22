package com.gychen.controller;

import com.github.pagehelper.PageInfo;
import com.gychen.po.ClassInfo;
import com.gychen.service.ClassInfoService;
import com.gychen.util.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.Arrays;
import java.util.List;

@Controller
public class TypeController {

    @Autowired
    private ClassInfoService classInfoService;  // 这里的classInfoService要和ClassInfoServiceImpl中的注解名字相同

    @RequestMapping("/typeIndex")
    public String typeIndex(){

        return "type/typeIndex";
    }

    /**
     * 添加页面的转换
     */
    @GetMapping("/typeAdd")
    public String typeAdd(){
        return "type/typeAdd";
    }


    /**
     * 获取type数据信息 分页
     */
    @RequestMapping("/typeAll")
    @ResponseBody
    public RestResponse typeAll(String name, @RequestParam(defaultValue = "1") Integer page,
                                @RequestParam(defaultValue = "15") Integer limit){

        PageInfo<ClassInfo> pageInfo = classInfoService.queryClassInfoAll(name, page, limit);

        return RestResponse.ok(pageInfo.getList());
    }

    /**
     * 类型添加
     */
    @ResponseBody
    @RequestMapping("/addBookType")
    public RestResponse addBookType(ClassInfo classInfo){
        classInfoService.addBookType(classInfo);
        return RestResponse.ok();
    }

    /**
     * 根据id查询
     */
    @GetMapping("/queryBookTypeById")
    public String queryBookTypeById(Integer id, Model model){
        ClassInfo classInfo = classInfoService.queryBookTypeById(id);
        model.addAttribute("info",classInfo);
        return "type/typeUpdate";
    }

    /**
     * 修改提交功能
     */
    @ResponseBody
    @RequestMapping("/updateBookType")
    public RestResponse updateBookType(@RequestBody ClassInfo classInfo){
        classInfoService.updateBookType(classInfo);
        return RestResponse.ok();
    }


    /**
     * 删除类型
     */
    @ResponseBody
    @RequestMapping("/deleteType")
    public RestResponse deleteType(String ids){
        List list = Arrays.asList(ids.split(","));
        classInfoService.deleteBookTypeByIds(list);
        return RestResponse.ok();
    }

}

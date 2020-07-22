<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 获取项目路径和项目其它信息 -->
<%
    String path=request.getContextPath();
    String basePath=request.getScheme()+
            "://"+request.getServerName()+
            ":"+request.getServerPort()+path+
            "/";
%>

<div class="layuimini-main">

    <div class="layui-form layuimini-form">
        <div class="layui-form-item">
            <label class="layui-form-label required">类型名称</label>
            <div class="layui-input-block">
                <input type="text" name="name" lay-verify="required" lay-reqtext="类型名称不能为空" placeholder="请输入类型名称" value="" class="layui-input">
                <tip>填写自己类型名称。</tip>
            </div>
        </div>

        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">备注信息</label>
            <div class="layui-input-block">
                <textarea name="remarks" class="layui-textarea" placeholder="请输入备注信息"></textarea>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn layui-btn-normal" lay-submit lay-filter="saveBtn">确认保存</button>
            </div>
        </div>
    </div>
</div>
<script>
    layui.use(['form', 'table'], function () {
        var form = layui.form,
            layer = layui.layer,
            table = layui.table,
            $ = layui.$;

        /**
         * 初始化表单，要加上，不然刷新部分组件可能会不加载
         */
        form.render();

        // 当前弹出层，防止ID被覆盖
        var parentIndex = layer.index;

        //监听提交
        form.on('submit(saveBtn)', function (data) {

            var datas=data.field;   // 获取到form表单的数据
            // 向后台发送数据提交添加
            $.ajax({
                url:"addBookType",
                type:"POST",
                data:datas,
                success:function (result) {
                    if (result.code===0){ // 如果成功
                        layer.msg("添加成功",{
                            icon:6,
                            time:500
                        },function () {
                            parent.window.location.reload();
                            layer.close(index);
                            layer.close(parentIndex);
                        })
                    } else {
                        layer.msg("类型添加失败了")
                    }
                }
            });


            return false;
        });

    });
</script>
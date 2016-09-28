<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="utf-8"/>
</head>


<div class="form-group center">
    <label> 装置：</label>
    <select id="deviceList" name="module.device">
        <option value="">全部</option>
    </select>
    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
    <label>区域：</label>
    <select id="areaList" name="module.area">
        <option value="">全部</option>
    </select>
    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
    <label>标签号：</label>
    <input type="text" name="module.labelNumber" size="15px">
    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
    <label>密封点类型：</label>
    <select name="module.modelType">
        <option value="">全部</option>
        <option>搅拌器（轴封）</option>
        <option>连接件（螺纹连接）</option>
        <option>法兰</option>
        <option>开口阀或开口管线</option>
        <option>泵（轴封）</option>
        <option>泄压设备（安全阀）</option>
        <option>取样连接系统</option>
        <option>阀门</option>
        <option>压缩机（轴封）</option>
        <option>其他</option>
    </select>
</div>



<div class="form-group center">
    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
    <label>难于检测：</label>
    <input type="radio" id="#0" name="module.diffToCheck"
           value="是"><label
        for="#0">是</label>
    <input type="radio" id="#00" name="module.diffToCheck"
           value="否"><label
        for="#00">否</label>
    <input type="radio" id="#000" name="module.diffToCheck" value="all"
           checked="checked"><label for="#000">所有</label>

    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
    <label>险于检测：</label>
    <input type="radio" id="#01" name="module.dangerToCheck"
           value="是"><label
        for="#0">是</label>
    <input type="radio" id="#001" name="module.dangerToCheck"
           value="否"><label
        for="#00">否</label>
    <input type="radio" id="#0001" name="module.dangerToCheck" value="all"
           checked="checked"><label for="#000">所有</label>

    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
    <label>暂时移除：</label>
    <input type="radio" id="#02" name="module.tempToMove"
           value="是"><label
        for="#0">是</label>
    <input type="radio" id="#002" name="module.tempToMove"
           value="否"><label
        for="#00">否</label>
    <input type="radio" id="#0002" name="module.tempToMove" value="all"
           checked="checked"><label for="#000">所有</label>


    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
    <label>介质状态：</label>
    <select name="module.mediumStatus">
        <option value="">全部</option>
        <option>轻液</option>
        <option>气体</option>
        <option>重液</option>
    </select>

    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
    <label>图片</label>
    <select name="module.picturePath">
        <option>有图</option>
        <option>无图</option>
    </select>

</div>





// 查找装置
$("#deviceName").function(
    findDeviceName()
);

function findDeviceName(){
    var url = "${basePath}/paramsetting/modelinfosetting/device_manage_findDeviceName.action?time="+new Date().getTime();
    $.post(url,function(backData){
        alert(backData);
        var obj = JSON.parse(backData);
        var array = obj.codeList;
        var size = array.length;
        //迭代数组
        for(var i=0;i<size;i++){
            //获取数组中的每个元素
            var deviceName = array[i].deviceName;
            //去掉重复元素
            if ($("#deviceName option:contains('" + deviceName + "')").length > 0)
                $("#deviceName option:contains('" + deviceName + "')").remove();
            //判断不为空 创建option元素
            if (deviceName != null && deviceName != ""){
                var $option = $("<option>"+deviceName+"</option>");
                //将option元素添加到装置下拉框中
                $("#deviceName").append( $option );
            }
        }
    });
}
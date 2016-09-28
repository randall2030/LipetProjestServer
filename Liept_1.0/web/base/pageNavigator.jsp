<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="c_pate" style="margin-top: 5px;">
    <s:if test="pageResult.totalCount > 0">
        <div class="center"> <!--分页, center使其居中-->
            <ul class="pagination">

                <li class="red">
                    总共 <s:property value="pageResult.totalCount"/> 条记录，当前第 <s:property value="pageResult.pageNo"/> 页，
                    共 <s:property value="pageResult.totalPageCount"/> 页
                </li>

                <s:if test="pageResult.pageNo > 1">
                    <li class="red">
                        <a href="javascript:doGoPage(<s:property value='pageResult.pageNo-1'/>)">
                            <i class="icon-double-angle-left"></i>
                        </a>
                    </li>
                </s:if>

                <s:else>
                    <li class="disabled red">
                        <a href="javascript:doGoPage(<s:property value='pageResult.pageNo-1'/>)">
                            <i class="icon-double-angle-left"></i>
                        </a>
                    </li>
                </s:else>

                <s:if test="pageResult.pageNo < pageResult.totalPageCount">
                    <li class="red">
                        <a href="javascript:doGoPage(<s:property value='pageResult.pageNo+1'/>)">
                            <i class="icon-double-angle-right"></i>
                        </a>
                    </li>
                </s:if>
                <s:else>
                    <li class="disabled red">
                        <a href="javascript:doGoPage(<s:property value='pageResult.pageNo'/>)">
                            <i class="icon-double-angle-right"></i>
                        </a>
                    </li>
                </s:else>

                <li class="red">
                    <input type="text" id="pageNo" name="pageNo" style="width: 30px;"
                           onkeypress="if(event.keyCode == 13){doGoPage(this.value);}" min="1"
                           max="<s:property value='pageResult.totalCount'/>" value="<s:property value='pageResult.pageNo'/>"/>
                </li>

            </ul>
        </div>
    </s:if>
    <s:else><span class="red">暂无数据！</span></s:else>
</div>
<script type="text/javascript">
    //翻页
    function doGoPage(pageNo) {
        document.getElementById("pageNo").value = pageNo;
        document.getElementById("form_pageNavigator").submit();
    }
</script>



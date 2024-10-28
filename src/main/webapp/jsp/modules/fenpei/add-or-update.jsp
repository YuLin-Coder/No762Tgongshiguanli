<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-cn">

<head>
    <%@ include file="../../static/head.jsp" %>
    <link href="http://www.bootcss.com/p/bootstrap-datetimepicker/bootstrap-datetimepicker/css/datetimepicker.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap-select.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" charset="utf-8">
        window.UEDITOR_HOME_URL = "${pageContext.request.contextPath}/resources/ueditor/"; //UEDITOR_HOME_URL、config、all这三个顺序不能改变
    </script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/ueditor/ueditor.all.min.js"></script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/ueditor/lang/zh-cn/zh-cn.js"></script>
</head>
<style>
    .error {
        color: red;
    }
</style>
<body>
<!-- Pre Loader -->
<div class="loading">
    <div class="spinner">
        <div class="double-bounce1"></div>
        <div class="double-bounce2"></div>
    </div>
</div>
<!--/Pre Loader -->
<div class="wrapper">
    <!-- Page Content -->
    <div id="content">
        <!-- Top Navigation -->
        <%@ include file="../../static/topNav.jsp" %>
        <!-- Menu -->
        <div class="container menu-nav">
            <nav class="navbar navbar-expand-lg lochana-bg text-white">
                <button class="navbar-toggler" type="button" data-toggle="collapse"
                        data-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="ti-menu text-white"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul id="navUl" class="navbar-nav mr-auto">

                    </ul>
                </div>
            </nav>
        </div>
        <!-- /Menu -->
        <!-- Breadcrumb -->
        <!-- Page Title -->
        <div class="container mt-0">
            <div class="row breadcrumb-bar">
                <div class="col-md-6">
                    <h3 class="block-title">编辑项目分配</h3>
                </div>
                <div class="col-md-6">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="${pageContext.request.contextPath}/index.jsp">
                                <span class="ti-home"></span>
                            </a>
                        </li>
                        <li class="breadcrumb-item">项目分配管理</li>
                        <li class="breadcrumb-item active">编辑项目分配</li>
                    </ol>
                </div>
            </div>
        </div>
        <!-- /Page Title -->

        <!-- /Breadcrumb -->
        <!-- Main Content -->
        <div class="container">

            <div class="row">
                <!-- Widget Item -->
                <div class="col-md-12">
                    <div class="widget-area-2 lochana-box-shadow">
                        <h3 class="widget-title">项目分配信息</h3>
                        <form id="addOrUpdateForm">
                            <div class="form-row">
                            <!-- 级联表的字段 -->
                                    <div class="form-group col-md-6">
                                        <label>任务</label>
                                        <div>
                                            <select id="renwuSelect" name="renwuSelect"
                                                    class="selectpicker form-control"  data-live-search="true"
                                                    title="请选择" data-header="请选择" data-size="5">
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>任务名称</label>
                                        <input id="rwname" name="rwname" class="form-control"
                                               placeholder="任务名称" readonly>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>任务类型</label>
                                        <input id="rwleixValue" name="rwleixValue" class="form-control"
                                               placeholder="任务类型" readonly>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>项目信息模块</label>
                                        <div>
                                            <select id="xiangmuSelect" name="xiangmuSelect"
                                                    class="selectpicker form-control"  data-live-search="true"
                                                    title="请选择" data-header="请选择" data-size="5">
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>项目名称</label>
                                        <input id="xmname" name="xmname" class="form-control"
                                               placeholder="项目名称" readonly>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>进度报工</label>
                                        <input id="schedule" name="schedule" class="form-control"
                                               placeholder="进度报工" readonly>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>项目费用</label>
                                        <input id="expense" name="expense" class="form-control"
                                               placeholder="项目费用" readonly>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>是否验收</label>
                                        <input id="shifouValue" name="shifouValue" class="form-control"
                                               placeholder="是否验收" readonly>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>用户表</label>
                                        <div>
                                            <select id="yonghuSelect" name="yonghuSelect"
                                                    class="selectpicker form-control"  data-live-search="true"
                                                    title="请选择" data-header="请选择" data-size="5">
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>名称</label>
                                        <input id="name" name="name" class="form-control"
                                               placeholder="名称" readonly>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>账号</label>
                                        <input id="username" name="username" class="form-control"
                                               placeholder="账号" readonly>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>头像</label>
                                        <img id="imgPhotoImg" src="" width="100" height="100">
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>性别</label>
                                        <input id="sexValue" name="sexValue" class="form-control"
                                               placeholder="性别" readonly>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>手机号</label>
                                        <input id="phone" name="phone" class="form-control"
                                               placeholder="手机号" readonly>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>身份证</label>
                                        <input id="idNumber" name="idNumber" class="form-control"
                                               placeholder="身份证" readonly>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>身份</label>
                                        <input id="role" name="role" class="form-control"
                                               placeholder="身份" readonly>
                                    </div>
                            <!-- 当前表的字段 -->
                                    <input id="updateId" name="id" type="hidden">
                                <input id="xiangmuId" name="xiangmuId" type="hidden">
                                <input id="yonghuId" name="yonghuId" type="hidden">
                                <input id="renwuId" name="renwuId" type="hidden">
                                <div class="form-group col-md-12 mb-3">
                                    <button id="submitBtn" type="button" class="btn btn-primary btn-lg">提交</button>
                                    <button id="exitBtn" type="button" class="btn btn-primary btn-lg">返回</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <!-- /Widget Item -->
            </div>
        </div>
        <!-- /Main Content -->
    </div>
    <!-- /Page Content -->
</div>
<!-- Back to Top -->
<a id="back-to-top" href="#" class="back-to-top">
    <span class="ti-angle-up"></span>
</a>
<!-- /Back to Top -->
<%@ include file="../../static/foot.jsp" %>
<script src="${pageContext.request.contextPath}/resources/js/vue.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.ui.widget.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.fileupload.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.form.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/validate/jquery.validate.min.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/validate/messages_zh.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/validate/card.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/datetimepicker/bootstrap-datetimepicker.min.js"></script>
</script><script type="text/javascript" charset="utf-8"
                 src="${pageContext.request.contextPath}/resources/js/bootstrap-select.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/laydate.js"></script>
<script>
    <%@ include file="../../utils/menu.jsp"%>
    <%@ include file="../../static/setMenu.js"%>
    <%@ include file="../../utils/baseUrl.jsp"%>

    var tableName = "fenpei";
    var pageType = "add-or-update";
    var updateId = "";
    var crossTableId = -1;
    var crossTableName = '';
    var ruleForm = {};
    var crossRuleForm = {};


    // 下拉框数组
        <!-- 当前表的下拉框数组 -->
        <!-- 级联表的下拉框数组 -->
    var renwuOptions = [];
    var xiangmuOptions = [];
    var yonghuOptions = [];

    var ruleForm = {};


    // 文件上传
    function upload() {

        <!-- 当前表的文件上传 -->

    }

    // 表单提交
    function submit() {
        if (validform() == true && compare() == true) {
            let data = {};
            getContent();
           if($("#xiangmuId") !=null){
               var xiangmuId = $("#xiangmuId").val();
               if(xiangmuId == null || xiangmuId =='' || xiangmuId == 'null'){
                   alert("项目名称不能为空");
                   return;
               }
           }
           if($("#yonghuId") !=null){
               var yonghuId = $("#yonghuId").val();
               if(yonghuId == null || yonghuId =='' || yonghuId == 'null'){
                   alert("负责人不能为空");
                   return;
               }
           }
           if($("#renwuId") !=null){
               var renwuId = $("#renwuId").val();
               if(renwuId == null || renwuId =='' || renwuId == 'null'){
                   alert("分配任务不能为空");
                   return;
               }
           }
            let value = $('#addOrUpdateForm').serializeArray();
            $.each(value, function (index, item) {
                data[item.name] = item.value;
            });
            let json = JSON.stringify(data);
            var urlParam;
            var successMes = '';
            if (updateId != null && updateId != "null" && updateId != '') {
                urlParam = 'update';
                successMes = '修改成功';
            } else {
                urlParam = 'save';
                successMes = '添加成功';
            }
            httpJson("fenpei/" + urlParam, "POST", data, (res) => {
                if(res.code == 0){
                    window.sessionStorage.removeItem('addfenpei');
                    window.sessionStorage.removeItem('updateId');
                    let flag = true;
                    if (flag) {
                        alert(successMes);
                    }
                    if (window.sessionStorage.getItem('onlyme') != null && window.sessionStorage.getItem('onlyme') == "true") {
                        window.sessionStorage.removeItem('onlyme');
                        window.sessionStorage.setItem("reload","reload");
                        window.parent.location.href = "${pageContext.request.contextPath}/index.jsp";
                    } else {
                        window.location.href = "list.jsp";
                    }
                }
            });
        } else {
            alert("表单未填完整或有错误");
        }
    }

    // 查询列表
        <!-- 查询当前表的所有列表 -->
        <!-- 查询级联表的所有列表 -->
        function renwuSelect() {
            //填充下拉框选项
            http("renwu/page?page=1&limit=100&sort=&order=", "GET", {}, (res) => {
                if(res.code == 0){
                    renwuOptions = res.data.list;
                }
            });
        }

        function renwuSelectOne(id) {
            http("renwu/info/"+id, "GET", {}, (res) => {
                if(res.code == 0){
                ruleForm = res.data;
                renwuShowImg();
                renwuDataBind();
            }
        });
        }
        function xiangmuSelect() {
            //填充下拉框选项
            http("xiangmu/page?page=1&limit=100&sort=&order=", "GET", {}, (res) => {
                if(res.code == 0){
                    xiangmuOptions = res.data.list;
                }
            });
        }

        function xiangmuSelectOne(id) {
            http("xiangmu/info/"+id, "GET", {}, (res) => {
                if(res.code == 0){
                ruleForm = res.data;
                xiangmuShowImg();
                xiangmuDataBind();
            }
        });
        }
        function yonghuSelect() {
            //填充下拉框选项
            http("yonghu/page?page=1&limit=100&sort=&order=", "GET", {}, (res) => {
                if(res.code == 0){
                    yonghuOptions = res.data.list;
                }
            });
        }

        function yonghuSelectOne(id) {
            http("yonghu/info/"+id, "GET", {}, (res) => {
                if(res.code == 0){
                ruleForm = res.data;
                yonghuShowImg();
                yonghuDataBind();
            }
        });
        }



    // 初始化下拉框
    <!-- 初始化当前表的下拉框 -->

    <!-- 初始化级联表的下拉框(要根据内容修改) -->
    <!-- 初始化级联表的下拉框(要根据内容修改) -->
    <!-- 初始化级联表的下拉框(要根据内容修改) -->
    <!-- 初始化级联表的下拉框(要根据内容修改) -->
    <!-- 初始化级联表的下拉框(要根据内容修改) -->
    <!-- 初始化级联表的下拉框(要根据内容修改) -->
        function initializationrenwuSelect() {
            var renwuSelect = document.getElementById('renwuSelect');
            if(renwuSelect != null && renwuOptions != null  && renwuOptions.length > 0 ) {
                for (var i = 0; i < renwuOptions.length; i++) {
                        renwuSelect.add(new Option(renwuOptions[i].rwname, renwuOptions[i].id));
                }

                $("#renwuSelect").change(function(e) {
                        renwuSelectOne(e.target.value);
                });
            }

        }

        function initializationxiangmuSelect() {
            var xiangmuSelect = document.getElementById('xiangmuSelect');
            if(xiangmuSelect != null && xiangmuOptions != null  && xiangmuOptions.length > 0 ) {
                for (var i = 0; i < xiangmuOptions.length; i++) {
                        xiangmuSelect.add(new Option(xiangmuOptions[i].xmname, xiangmuOptions[i].id));
                }

                $("#xiangmuSelect").change(function(e) {
                        xiangmuSelectOne(e.target.value);
                });
            }

        }

        function initializationyonghuSelect() {
            var yonghuSelect = document.getElementById('yonghuSelect');
            if(yonghuSelect != null && yonghuOptions != null  && yonghuOptions.length > 0 ) {
                for (var i = 0; i < yonghuOptions.length; i++) {
                        yonghuSelect.add(new Option(yonghuOptions[i].name, yonghuOptions[i].id));
                }

                $("#yonghuSelect").change(function(e) {
                        yonghuSelectOne(e.target.value);
                });
            }

        }



    // 下拉框选项回显
    function setSelectOption() {

        <!-- 当前表的下拉框回显 -->
        <!--  级联表的下拉框回显  -->
            var renwuSelect = document.getElementById("renwuSelect");
            if(renwuSelect != null && renwuOptions != null  && renwuOptions.length > 0 ) {
                for (var i = 0; i < renwuOptions.length; i++) {
                    if (renwuOptions[i].id == ruleForm.renwuId) {//下拉框value对比,如果一致就赋值汉字
                        renwuSelect.options[i+1].selected = true;
                        $("#renwuSelect" ).selectpicker('refresh');
                    }
                }
            }
            var xiangmuSelect = document.getElementById("xiangmuSelect");
            if(xiangmuSelect != null && xiangmuOptions != null  && xiangmuOptions.length > 0 ) {
                for (var i = 0; i < xiangmuOptions.length; i++) {
                    if (xiangmuOptions[i].id == ruleForm.xiangmuId) {//下拉框value对比,如果一致就赋值汉字
                        xiangmuSelect.options[i+1].selected = true;
                        $("#xiangmuSelect" ).selectpicker('refresh');
                    }
                }
            }
            var yonghuSelect = document.getElementById("yonghuSelect");
            if(yonghuSelect != null && yonghuOptions != null  && yonghuOptions.length > 0 ) {
                for (var i = 0; i < yonghuOptions.length; i++) {
                    if (yonghuOptions[i].id == ruleForm.yonghuId) {//下拉框value对比,如果一致就赋值汉字
                        yonghuSelect.options[i+1].selected = true;
                        $("#yonghuSelect" ).selectpicker('refresh');
                    }
                }
            }
    }


    // 填充富文本框
    function setContent() {

        <!-- 当前表的填充富文本框 -->
    }
    // 获取富文本框内容
    function getContent() {

        <!-- 获取当前表的富文本框内容 -->
    }
    //数字检查
        <!-- 当前表的数字检查 -->

    function exit() {
        window.sessionStorage.removeItem("updateId");
        window.sessionStorage.removeItem('addfenpei');
        window.location.href = "list.jsp";
    }
    // 表单校验
    function validform() {
        return $("#addOrUpdateForm").validate({
            rules: {
                xiangmuId: "required",
                yonghuId: "required",
                renwuId: "required",
            },
            messages: {
                xiangmuId: "项目名称不能为空",
                yonghuId: "负责人不能为空",
                renwuId: "分配任务不能为空",
            }
        }).form();
    }

    // 获取当前详情
    function getDetails() {
        var addfenpei = window.sessionStorage.getItem("addfenpei");
        if (addfenpei != null && addfenpei != "" && addfenpei != "null") {
            window.sessionStorage.removeItem('addfenpei');
            //注册表单验证
            $(validform());
            $('#submitBtn').text('新增');

        } else {
            $('#submitBtn').text('修改');
            var userId = window.sessionStorage.getItem('userId');
            updateId = userId;//先赋值登录用户id
            var uId  = window.sessionStorage.getItem('updateId');//获取修改传过来的id
            if (uId != null && uId != "" && uId != "null") {
                //如果修改id不为空就赋值修改id
                updateId = uId;
            }
            window.sessionStorage.removeItem('updateId');
            http("fenpei/info/" + updateId, "GET", {}, (res) => {
                if(res.code == 0)
                {
                    ruleForm = res.data
                    // 是/否下拉框回显
                    setSelectOption();
                    // 设置图片src
                    showImg();
                    // 数据填充
                    dataBind();
                    // 富文本框回显
                    setContent();
                    //注册表单验证
                    $(validform());
                }

            });
        }
    }

    // 清除可能会重复渲染的selection
    function clear(className) {
        var elements = document.getElementsByClassName(className);
        for (var i = elements.length - 1; i >= 0; i--) {
            elements[i].parentNode.removeChild(elements[i]);
        }
    }

    function dateTimePick() {
    }


    function dataBind() {


    <!--  级联表的数据回显  -->
        renwuDataBind();
        xiangmuDataBind();
        yonghuDataBind();


    <!--  当前表的数据回显  -->
        $("#updateId").val(ruleForm.id);
        $("#xiangmuId").val(ruleForm.xiangmuId);
        $("#yonghuId").val(ruleForm.yonghuId);
        $("#renwuId").val(ruleForm.renwuId);

    }
    <!--  级联表的数据回显  -->
    function renwuDataBind(){

                    <!-- 把id赋值给当前表的id-->
        $("#renwuId").val(ruleForm.id);
        $("#rwname").val(ruleForm.rwname);
        $("#rwleixValue").val(ruleForm.rwleixValue);
        $("#neirongContent").val(ruleForm.neirongContent);
    }

    function xiangmuDataBind(){

                    <!-- 把id赋值给当前表的id-->
        $("#xiangmuId").val(ruleForm.id);

        $("#xmname").val(ruleForm.xmname);
        $("#schedule").val(ruleForm.schedule);
        $("#expense").val(ruleForm.expense);
        $("#shifouValue").val(ruleForm.shifouValue);
        $("#qidongshuFile").val(ruleForm.qidongshuFile);
    }

    function yonghuDataBind(){

                    <!-- 把id赋值给当前表的id-->
        $("#yonghuId").val(ruleForm.id);

        $("#name").val(ruleForm.name);
        $("#username").val(ruleForm.username);
        $("#password").val(ruleForm.password);
        $("#sexValue").val(ruleForm.sexValue);
        $("#phone").val(ruleForm.phone);
        $("#idNumber").val(ruleForm.idNumber);
        $("#role").val(ruleForm.role);
    }


    //图片显示
    function showImg() {
        <!--  当前表的图片  -->

        <!--  级联表的图片  -->
        renwuShowImg();
        xiangmuShowImg();
        yonghuShowImg();
    }


    <!--  级联表的图片  -->

    function renwuShowImg() {
    }


    function xiangmuShowImg() {
    }


    function yonghuShowImg() {
        $("#imgPhotoImg").attr("src",ruleForm.imgPhoto);
    }



    $(document).ready(function () {
        //设置右上角用户名
        $('.dropdown-menu h5').html(window.sessionStorage.getItem('username'))
        //设置项目名
        $('.sidebar-header h3 a').html(projectName)
        //设置导航栏菜单
        setMenu();
        $('#exitBtn').on('click', function (e) {
            e.preventDefault();
            exit();
        });
        //初始化时间插件
        dateTimePick();
        //查询所有下拉框
            <!--  当前表的下拉框  -->
            <!-- 查询级联表的下拉框(用id做option,用名字及其他参数做名字级联修改) -->
            renwuSelect();
            xiangmuSelect();
            yonghuSelect();



        // 初始化下拉框
            <!--  初始化当前表的下拉框  -->
            <!--  初始化级联表的下拉框  -->
            initializationrenwuSelect();
            initializationxiangmuSelect();
            initializationyonghuSelect();

        $(".selectpicker" ).selectpicker('refresh');
        getDetails();
        //初始化上传按钮
        upload();
    <%@ include file="../../static/myInfo.js"%>
                $('#submitBtn').on('click', function (e) {
                    e.preventDefault();
                    //console.log("点击了...提交按钮");
                    submit();
                });
        readonly();
    });

    function readonly() {
        if (window.sessionStorage.getItem('role') != '管理员') {
            $('#jifen').attr('readonly', 'readonly');
            //$('#money').attr('readonly', 'readonly');
        }
    }

    //比较大小
    function compare() {
        var largerVal = null;
        var smallerVal = null;
        if (largerVal != null && smallerVal != null) {
            if (largerVal <= smallerVal) {
                alert(smallerName + '不能大于等于' + largerName);
                return false;
            }
        }
        return true;
    }


    // 用户登出
    <%@ include file="../../static/logout.jsp"%>
</script>
</body>

</html>
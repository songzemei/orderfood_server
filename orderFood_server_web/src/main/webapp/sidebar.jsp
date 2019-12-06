<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="${pageContext.request.contextPath}/img/user2-160x160.jpg" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p><security:authentication property="principal.username"/></p>
                <a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
            </div>
        </div>
        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu">
            <li class="header">菜单</li>
            <li id="admin-index"><a href="${pageContext.request.contextPath}/main.jsp"><i
                    class="fa fa-dashboard"></i><span>首页</span></a>
            </li>
            <%-- 系统管理 --%>
            <security:authorize access="hasAnyRole({'ROLE_BOSS'})">
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-cogs"></i><span>系统管理</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">
                    <%--<security:authorize access="hasAnyRole({'ROLE_BOSS'})">--%>
                    <li id="user-setting">
                        <a href="${pageContext.request.contextPath}/admin/all">
                            <i class="fa fa-circle-o"></i>管理员管理
                        </a>
                    </li>
                    <%--</security:authorize>--%>

                    <%--<security:authorize access="hasAnyRole({'ROLE_BOSS'})">--%>
                    <li id="role-setting">
                        <a href="${pageContext.request.contextPath}/role/all">
                            <i class="fa fa-circle-o"></i>角色管理
                        </a>
                    </li>
                    <%--</security:authorize>--%>

                    <%--<security:authorize access="hasAnyRole({'ROLE_BOSS'})">--%>
                    <li id="permission-setting">
                        <a href="${pageContext.request.contextPath}/permission/findAll">
                            <i class="fa fa-circle-o"></i>角色权限管理
                        </a>
                    </li>
                    <%--</security:authorize>--%>

                    <%--<security:authorize access="hasAnyRole({'ROLE_BOSS'})">--%>
                    <li id="log-setting">
                        <a href="${pageContext.request.contextPath}/log/all">
                            <i class="fa fa-circle-o"></i>普通日志管理
                        </a>
                    </li>
                    <%--</security:authorize>--%>

                    <%--<security:authorize access="hasAnyRole({'ROLE_BOSS'})">--%>
                    <li id="errorLog-setting">
                        <a href="${pageContext.request.contextPath}/errorLog/all">
                            <i class="fa fa-circle-o"></i>错误日志管理
                        </a>
                    </li>
                    <%--</security:authorize>--%>
                </ul>
            </li>
            </security:authorize>


            <li class="treeview">
                <a href="#">
                    <i class="fa fa-cube"></i><span>基础数据</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">
                    <li id="product-manage">
                        <a href="${pageContext.request.contextPath}/product/all">
                            <i class="fa fa-circle-o"></i>产品管理
                        </a>
                    </li>
                    <li id="member-cancel">
                        <a href="${pageContext.request.contextPath}/member/all">
                            <i class="fa fa-circle-o"></i>会员管理
                        </a>
                    </li>
                    <li id="worker-cancel">
                        <a href="${pageContext.request.contextPath}/worker/all">
                            <i class="fa fa-circle-o"></i>查看配送员
                        </a>
                    </li>
                    <li id="orders-cancel-unfinish">
                        <a href="${pageContext.request.contextPath}/orders/allUnFinish">
                            <i class="fa fa-circle-o"></i>查看未配送订单
                        </a>
                    </li>
                    <li id="order-cancel-finish">
                        <a href="${pageContext.request.contextPath}/orders/allFinish">
                            <i class="fa fa-circle-o"></i>查看已完成订单
                        </a>
                    </li>
                </ul>
            </li>
        </ul>
    </section>
    <!-- /.sidebar -->
</aside>
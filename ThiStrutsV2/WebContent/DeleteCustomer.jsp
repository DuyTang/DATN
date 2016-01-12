<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<jsp:include page="header.jsp" />
<div class="container">
    <h3>Delete customer: </h3>
	<html:form action="/delCus" method="post">
        <div class="row form-group">
            <label class="col-lg-2">Customer code</label>
            <div class="col-lg-3">
                <html:text property="maKH" styleClass="form-control" readonly="true"></html:text>
            </div>
        </div>
        <div class="row form-group">
            <label class="col-lg-2">Full name</label>
            <div class="col-lg-3">
                <html:text property="tenKH" styleClass="form-control" readonly="true"></html:text>
            </div>
        </div>
        <div class="row form-group">
            <label class="col-lg-2">Address</label>
            <div class="col-lg-3">
                <html:text property="diaChi" styleClass="form-control" readonly="true"></html:text>
            </div>
        </div>
        <div class="row form-group">
            <label class="col-lg-2">Email</label>
            <div class="col-lg-3">
                <html:text property="email" styleClass="form-control" readonly="true"></html:text>
            </div>
        </div>
        <div class="row form-group">
            <label class="col-lg-2">Phone number</label>
            <div class="col-lg-3">
                <html:text property="soDienThoai" styleClass="form-control" readonly="true"></html:text>
            </div>
        </div>
        
        <div class="row form-group">
            <label class="col-lg-2">Status</label>
            <div class="col-lg-3">
                <html:radio property="tinhTrang" value="1" style="margin-right: 10px;" disabled="true">True</html:radio>
            	<html:radio property="tinhTrang" value="0" style="margin: 0px 10px 0px 30px;" disabled="true">False</html:radio>
            </div>
        </div>
        
        <div class="row form-group">
            <div class="col-lg-3 col-lg-offset-2">
                <html:submit styleClass="btn btn-primary" property="submit" value="submit">Confirm</html:submit>
                <button class="btn btn-primary" onclick="history.go(-1);">Come back</button>
            </div>
        </div>
    </html:form>
</div>

<jsp:include page="footer.jsp" />
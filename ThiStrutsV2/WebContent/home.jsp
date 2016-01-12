
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<jsp:include page="headerHomePage.jsp" />
<style type="text/css">
.box-content {
	width: 220px;
	height: 210px;
	border: 1px solid;
	position: relative;
	overflow: hidden;
	background-image: url(images/photos/four_column3.jpg);
}

.box-content:hover .box-hover {
	left: 0;
	/*display: block;*/
}

.box-hover {
	left: -102%;
	padding-top: 100px;
	position: absolute;
	width: 100%;
	height: 100%;
	background: rgba(250, 250, 250, .8);
	top: 0;
	-webkit-transition: all 0.25s ease-in-out;
	-moz-transition: all 0.25s ease-in-out;
	-o-transition: all 0.25s ease-in-out;
	transition: all 0.25s ease-in-out;
	/*display: none;*/
}

.List_image {
	line-height: 1;
	border-radius: 5px 5px 0 0;
	-moz-border-radius: 5px 5px 0 0;
	-webkit-border-radius: 5px 5px 0 0;
	width: auto;
	margin-left: -10px;
	position: relative;
}

.List_image>ul>li {
	display: inline-block;
	box-shadow: 0 1px 3px rgba(0, 0, 0, 0.3);
	color: blue;
	width: 210px;
	float: left;
	margin: 0;
	height: 290px;
	margin-left: 20px;
	position: relative;
}

.List_image>ul>li>a {
	text-align: center;
	padding-left: 25px;
	padding-bottom: 10px;
}

.List_image>ul>li>a:HOVER {
	color: red;
	font-weight: bold;
}

.List_image>ul>li>span {
	text-align: center;
	color: red;
	font-weight: bold;
	padding-left: 10px;
	padding-top: 5px;
	margin-top: 5px;
}

.List_image>ul>li>b {
	padding-left: 20px;
}

.nav ul {
	list-style: none;
	margin: 0;
	padding: 0;
}

.nav ul li {
	display: inline-block;
}
</style>
<!--end box_head -->
<%-- Noi Dung Day---------------------------------------------- --%>
<%-- Noi Dung Day---------------------------------------------- --%>
<%-- Noi Dung Day---------------------------------------------- --%>
<%-- Noi Dung Day---------------------------------------------- --%>

<div class="container">
		<div class="featured">
			<div class="box_head">
				<h3>SẢN PHẨM</h3>
		<div class="pagers center"></div>
</div>
<div id="asd">
	<div class="cycle-slideshow" data-cycle-fx="scrollHorz"
		data-cycle-timeout=0 data-cycle-slides="> ul"
		data-cycle-prev="div.pagers a.featuredPrev"
		data-cycle-next="div.pagers a.featuredNxt">

		<div class="List_image">
			<ul>
				<logic:iterate name="trangChuForm" property="arrSanPham" id="sp">
					<li>
						<div class="box-content">
							<bean:define id="maSP" name="sp" property="maSP"></bean:define>
						<div class="img">
							
							<div class="box-hover">
								<html:link styleClass="btn btn-success"
									action="/do-hang?maSP=${maSP}"> Mua </html:link>
								<html:link styleClass="btn btn-success"
									action="/chi-tietSP?maLoaiSP=${maSP}"> Chi tiết</html:link>
							</div>
							
							<a href="#">
									<img src="img/imgLapTop/<bean:write name="sp" property="anhSP" />" alt="product">
							</a>
						</div>
						</div>
						<h6>
							<html:link action="/chi-tietSP?maLoaiSP=${maSP}">
								<bean:write name="sp" property="tenSP" />
							</html:link>
						</h6>
						<h4>
							Giá:
							<bean:write name="sp" property="giaBanSP" />
						</h4>
					</li>
				</logic:iterate>
			</ul>
		</div>

	</div>

	<bean:define id="x" name="trangChuForm" property="soTrang"></bean:define>
	<div>
		<button id="50" value="<bean:write name="x" />" name="buttonAB"
			onclick="ajaxHome('<bean:write name="x" />')"
			class="btn btn-info btn-lg btn-block">
			XEM THÊM, CÒN LẠI 
			<bean:write name="x" />
			 SẢN PHẨM
		</button>
	</div>
</div>

<div id="chayDen"></div>

</div>

</div>
<div style="width: 1200px;margin-left: 70px" ><jsp:include page="footerHomePage.jsp" /></div>
<!--end featured-->



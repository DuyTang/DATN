<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div id="chayDen"></div>
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
							Giá:
							<bean:write name="sp" property="giaBanSP" />
						</h4>
					</li>
				</logic:iterate>
			</ul>
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


<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<!-- jQuery.dropKick plug-in -->

<script src="js/dropKick/jquery.dropkick-1.0.0.js"></script>
<!-- jQuery.nicescroll plug-in -->
<script src="js/jquery.nicescroll.js"></script>
<!-- jQuery.tweet plug-in -->
<script src="js/jquery.tweet.js"></script>
<!-- jQuery.cycle2 plug-in -->
<script src="js/jquery.cycle2.min.js"></script>
<script src="js/jquery.cycle2.tile.min.js"></script>
<!-- jQuery.jcarousellite plug-in -->
<script src="js/jcarousellite_1.0.1.min.js"></script>
<!-- jQuery.fancybox plug-in -->

<script src="js/fancybox/jquery.fancybox-1.3.4.pack.js"></script>
<!-- jQuery.etalage plug-in -->
<script src="js/jquery.etalage.min.js"></script>
<!-- jQuery.cookie plug-in -->
<script src="js/jquery.cookie.js"></script>
<!--my custom code-->
<script src="js/main.js"></script>


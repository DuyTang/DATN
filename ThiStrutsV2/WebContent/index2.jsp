<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<html lang="en">
<!--<![endif]-->
<head>

<!-- Basic Page Needs
  ================================================== -->
<meta charset="utf-8">
<title>Shoploop: eCommerce Website</title>
<meta name="description" content="">
<meta name="author" content="Ahmed Saeed">

<!-- Mobile Specific Metas
  ================================================== -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">

<!-- CSS
  ================================================== -->
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/home2.css">
<link rel="stylesheet" href="css/responsive.css">

<!--[if lt IE 9]>
		<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<script src="http://ie7-js.googlecode.com/svn/version/2.1(beta4)/IE9.js"></script>
		<link rel="stylesheet" type="text/css" href="css/ie8-and-down.css" />
	<![endif]-->

<!-- Favicons
	================================================== -->
<link rel="shortcut icon" href="images/favicon.ico">
<link rel="apple-touch-icon" href="images/apple-touch-icon.png">
<link rel="apple-touch-icon" sizes="72x72"
	href="images/apple-touch-icon-72x72.png">
<link rel="apple-touch-icon" sizes="114x114"
	href="images/apple-touch-icon-114x114.png">

</head>
<body>

	<!--start header-->
	<header>

		<div id="middleHeader">
			<div class="container">
				<div class="sixteen columns">
					<div id="logo">
						<h1>
							<a href="index.html">logo</a>
						</h1>
					</div>
					<!--end logo-->

					<form action="#" method="post" accept-charset="utf-8">
						<label> <input type="text" name="search"
							placeholder="Search in Product" value="">
						</label>
					</form>
					<!--end form-->

				</div>
				<!--end sixteen-->
			</div>
			<!--end container-->
		</div>
		<!--end middleHeader-->

		<div class="container">
			<div class="sixteen columns">
				<div id="mainNav" class="clearfix">
					<nav>
						<ul>
							<li><a class="hasdropdown" href="#">Pages</a>
								<ul class="submenu">
									<li><a href="index.html">Home</a></li>
									<li><a href="index2.html">Home 2</a></li>
									<li><a href="about.html">About</a></li>
									<li><a href="blog.html">Blog</a></li>
									<li><a href="blog_post.html">Blog Post</a></li>
									<li><a href="contact.html">Contact</a></li>
								</ul></li>
							<li><a class="desktop hasdropdown" href="#">Desktop</a>
								<ul class="submenu">
									<li><a href="#">PC</a></li>
									<li><a href="#">Mac</a></li>
									<li><a href="#">Luinx</a></li>
								</ul></li>
							<li><a class="labtops" href="#">Laptops</a></li>
							<li><a class="componients hasdropdown" href="#">Componients</a>
								<ul class="submenu">
									<li><a href="#">Mic &amp; Trackballs</a></li>
									<li><a href="#">Mointors</a></li>
									<li><a href="#">Printers</a></li>
									<li><a href="#">Scanners</a></li>
									<li><a href="#">Web Cameras</a></li>
								</ul></li>
							<li><a class="tablets" href="#">Tablets</a></li>
							<li><a class="software" href="#">Software</a></li>
							<li><a class="watches hasdropdown" href="#">Watches</a>
								<ul class="submenu">
									<li><a href="#">Test one</a></li>
									<li><a href="#">Test Two</a></li>
									<li><a href="#">Test Three</a></li>
									<li><a href="#">Test Four</a></li>
									<li><a href="#">Test Five</a></li>
								</ul></li>
						</ul>

					</nav>
					<!--end nav-->

					<div id="cart">
						<a class="cart_dropdown" href="javascript:void(0);"><img
							src="images/icons/cart_icon.png" alt=""> 3 items<span>:
								$320.00<span></a>
						<div class="cart_content">
							<b class="cart_content_arrow"></b>
							<ul>
								<li class="clearfix">
									<div class="cart_product_name">
										<img src="images/photos/dropdown_cart_image.jpg"
											alt="product image"> <span> <strong><a
												href="#">product Name Here and long</a></strong><br> Color:
											black<br> Size: 36
										</span>
									</div>
									<div class="cart_product_price">
										<span> <strong>2x - $130.00</strong><br> <a
											class="remove_item" href="#">Remove</a>
										</span>
									</div>
									<div class="clear"></div>
								</li>
								<li class="clearfix">
									<div class="cart_product_name">
										<img src="images/photos/dropdown_cart_image.jpg"
											alt="product image"> <span> <strong><a
												href="#">product Name Here and long</a></strong><br> Color:
											black<br> Size: 36
										</span>
									</div>
									<div class="cart_product_price">
										<span> <strong>2x - $130.00</strong><br> <a
											class="remove_item" href="#">Remove</a>
										</span>
									</div>
								</li>
							</ul>
							<!--end ul-->

							<div class="dropdown_cart_info clearfix">
								<div class="cart_buttons">
									<a class="gray_btn" href="#">View Cart</a><br> <a
										class="red_btn" href="#">Checkout</a>
								</div>
								<!--end cart buttons-->

								<div class="cart_total_price">
									<span> Sub Total : $820.00<br> VAT 16% : $390.00<br>
										<strong>TOTAL : $1,598.30</strong>
									</span>
								</div>
								<!--end cart buttons-->
							</div>
							<!--end dropdown_cart_info-->

						</div>
						<!--end cart_content-->
					</div>
					<!--end cart-->

				</div>
				<!--end main-->
			</div>
			<!--end sixteen-->
		</div>
		<!--end container-->

	</header>
	<!--end header-->



	<div class="container">
		<div class="sixteen columns">

			<div id="slide_outer">
				<div class="mainslide">

					<div class="pagers center">
						<a class="prev slide_prev" href="#prev">Prev</a> <a
							class="nxt slide_nxt" href="#nxt">Next</a>
					</div>

					<ul class="cycle-slideshow clearfix" data-cycle-fx="scrollHorz"
						data-cycle-timeout="2000" data-cycle-slides="> li"
						data-cycle-pause-on-hover="true"
						data-cycle-prev="div.pagers a.slide_prev"
						data-cycle-next="div.pagers a.slide_nxt">
						<li class="clearfix">
							<div class="slide_img">
								<img src="images/icons/iphone_4_icon.png" alt="">
							</div>
							<div class="flex-caption">
								<h5>
									Now it's available<br> <span>IPhone 4 is Released</span>
								</h5>
								<p>Quisque pharetra neque at odio viverra pellentesque
									ultrices mi sodales. Nam accumsan lacus sed ipsum tempus
									mollis. Nulla vitae lorem libero, at porta enim. Aenean quis
									justo metus.</p>
								<p>Nam accumsan lacus sed ipsum tempus mollis. Nulla vitae
									lorem libero, at porta enim. Aenean quis justo metus.</p>
								<a href="#"><span>View Item</span><span class="shadow">$190.00</span></a>
							</div>
						</li>

						<li class="clearfix">
							<div class="slide_img">
								<img src="images/icons/iphone_4_icon2.png" alt="">
							</div>
							<div class="flex-caption">
								<h5>
									Now it's available<br> <span>IPhone 4 is Released</span>
								</h5>
								<p>Quisque pharetra neque at odio viverra pellentesque
									ultrices mi sodales. Nam accumsan lacus sed ipsum tempus
									mollis. Nulla vitae lorem libero, at porta enim. Aenean quis
									justo metus.</p>
								<p>Nam accumsan lacus sed ipsum tempus mollis. Nulla vitae
									lorem libero, at porta enim. Aenean quis justo metus.</p>
								<a href="#"><span>View Item</span><span class="shadow">$190.00</span></a>
							</div>
						</li>

						<li class="clearfix">
							<div class="slide_img">
								<img src="images/icons/camcorder.png" alt="">
							</div>
							<div class="flex-caption">
								<h5>
									New Entry this day<br> <span>DV Camcorder</span>
								</h5>
								<p>Quisque pharetra neque at odio viverra pellentesque
									ultrices mi sodales. Nam accumsan lacus sed ipsum tempus
									mollis. Nulla vitae lorem libero, at porta enim. Aenean quis
									justo metus.</p>
								<a href="#"><span>View Item</span><span class="shadow">$210.90</span></a>
							</div>
						</li>
					</ul>
				</div>
				<div class="shadow_left"></div>
				<div class="shadow_right"></div>
			</div>


			<div id="mainNav" class="clearfix">
				<nav>
					<ul>
						<li style="width: 100px; text-align: center;"><a href="#">
								Home </a></li>
						<li><a style="width: 70px; text-align: center;" href="#">Contact</a></li>
						<li><a style="width: 70px; text-align: center;" href="#">Software</a></li>
						<li><a style="width: 70px; text-align: center;" href="#">Guarantee</a></li>


						<html:form action="home-page">
							<html:select styleId="cbHangSanPham" property="maHang"
								styleClass="form-control" style="width:200px">
								<option value="">--Choose manufacturer--</option>
								<html:optionsCollection name="trangChuForm"
									property="arrHangSanPham" label="tenHang" value="maHang" />
							</html:select>

							<select id="cbCPU" class="form-control"
								style="width: 200; float: right;">
								<option value="">--Choose CPU--</option>
								<option value="3">Core i3</option>
								<option value="5">Core i5</option>
								<option value="7">Core i7</option>
								<option value="khac">Other</option>
							</select>
							<input id="txtTimKiem"
								style="float: right; margin-right: 350px; width: 200px"
								type="text" class="form-control" placeholder="Tìm kiem"
								onkeyup="timKiem()">

						</html:form>

					</ul>

				</nav>
			</div>

		</div>
	</div>
	<!-- container -->



	<!-- strat the main content area -->

	<div class="container">


		<div class="featured">
			<div class="box_head">
				<h3>Featured Items</h3>
				<div class="pagers center"></div>
			</div>
			<!--end box_head -->


			<div id="noiDung">
				<div class="cycle-slideshow" data-cycle-fx="scrollHorz"
					data-cycle-timeout=0 data-cycle-slides="> ul"
					data-cycle-prev="div.pagers a.featuredPrev"
					data-cycle-next="div.pagers a.featuredNxt">
					<ul class="product_show">
						<logic:iterate name="trangChuForm" property="arrSanPham" id="sp">
							<li class="column">
								<div class="img">
									<div class="hover_over">
										<a class="link" href="#">link</a> <a class="cart" href="#">cart</a>
									</div>
									<a href="#"> <img src="images/photos/four_column3.jpg"
										alt="product">
									</a>
								</div>
								<h6>
									<a href="#"><bean:write name="sp" property="tenSP" /></a>
								</h6>
								<h4>
									Prices:
									<bean:write name="sp" property="giaBanSP" />
								</h4>
							</li>
						</logic:iterate>
					</ul>
				</div>
				<bean:define id="x" name="trangChuForm" property="soTrang"></bean:define>
				<div>
					<button onclick="ajaxHome('<bean:write name="x" />')"
						class="btn btn-info btn-lg btn-block">
						View more
						<bean:write name="x" />
						product
					</button>
				</div>
			</div>
			<script>
				function ajaxHome(soTrang) {
					var txtCPU = document.getElementById("cbCPU").value;
					var txtTimKiem = document.getElementById("txtTimKiem").value;
					var txtHangSanPham = document
							.getElementById("cbHangSanPham").value;

					var xmlhttp;
					if (window.XMLHttpRequest) {
						xmlhttp = new XMLHttpRequest();
					} else {
						xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
					}
					xmlhttp.onreadystatechange = function() {
						if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
							document.getElementById("noiDung").innerHTML = xmlhttp.responseText;
						}
					}
					xmlhttp.open("GET",
							"http://localhost:81/ThiStrutsV2/home-page.do?soTrang="
									+ soTrang + "&txtTimKiem=" + txtTimKiem
									+ "&maHang=" + txtHangSanPham + "&tenCPU="
									+ txtCPU + "", true);
					xmlhttp.send();
				}
			</script>
			<!--end featured-->

			<div class="sixteen columns">
				<div class="brands">

					<div class="box_head">
						<h3>brands</h3>
						<div class="pagers center">
							<a class="prev brand_prev" href="#prev">Prev</a> <a
								class="nxt brand_nxt" href="#nxt">Next</a>
						</div>
					</div>
					<!--end box_head -->

					<div class="brandOuter">
						<ul>
							<li><a href="#"> <img
									src="images/brands/logo_adidas-130x130.jpg" alt="brand">
							</a></li>
							<li><a href="#"> <img
									src="images/brands/logo_asics-130x130.jpg" alt="brand">
							</a></li>
							<li><a href="#"> <img
									src="images/brands/logo_conv-130x130.jpg" alt="brand">
							</a></li>
							<li><a href="#"> <img
									src="images/brands/logo_nike-130x130.jpg" alt="brand">
							</a></li>
							<li><a href="#"> <img
									src="images/brands/logo_puma-130x130.jpg" alt="brand">
							</a></li>
							<li><a href="#"> <img
									src="images/brands/logo_rbk-130x130.jpg" alt="brand">
							</a></li>
							<li><a href="#"> <img
									src="images/brands/logo_nike-130x130.jpg" alt="brand">
							</a></li>
							<li><a href="#"> <img
									src="images/brands/logo_asics-130x130.jpg" alt="brand">
							</a></li>
						</ul>
					</div>
				</div>
				<!--end brands-->
			</div>
			<!--end sixteen-->

		</div>
		<!--end container-->
		<!-- end the main content area -->






		<!-- start the footer area-->
		<footer>
			<div class="container">
				<div class="three columns">
					<div id="info">
						<h3>Informations</h3>
						<ul>
							<li><a href="#">About Us</a></li>
							<li><a href="#">Delivery Informations</a></li>
							<li><a href="#">privecy Policey</a></li>
							<li><a href="#">Terms &amp; Condations</a></li>
						</ul>
					</div>
				</div>
				<!--end three-->

				<div class="three columns">
					<div id="customer_serices">
						<h3>Customer Servies</h3>
						<ul>
							<li><a href="#">Contact Us</a></li>
							<li><a href="#">Returns</a></li>
							<li><a href="#">Site map</a></li>
							<li><a href="#">addation Link</a></li>
						</ul>
					</div>
				</div>
				<!--end three-->

				<div class="three columns">
					<div id="extra">
						<h3>Extra Stuff</h3>
						<ul>
							<li><a href="#">Brands</a></li>
							<li><a href="#">Gift Vouchers</a></li>
							<li><a href="#">Affiliates</a></li>
							<li><a href="#">Specials</a></li>
						</ul>
					</div>
				</div>
				<!--end three-->

				<div class="three columns">
					<div id="my_account">
						<h3>My Account</h3>
						<ul>
							<li><a href="#">Login Area</a></li>
							<li><a href="#">Order History</a></li>
							<li><a href="#">Wish List</a></li>
							<li><a href="#">newsLatter</a></li>
						</ul>
					</div>
				</div>
				<!--end three-->

				<div class="four columns">
					<div id="delivery" class="clearfix">
						<h3>Delivery Info</h3>
						<ul>
							<li class="f_call">Call Us On: 555-555-555</li>
							<li class="f_call">Call Us On: 666-666-666</li>
							<li class="f_mail">example@example.com</li>
							<li class="f_mail">shoploop@shoploop.com</li>
						</ul>
					</div>
				</div>
				<!--end four-->

			</div>
			<!--end container-->


			<div class="tweets">
				<div class="container">
					<div class="sixteen columns">

						<div class="tweet">
							<!-- tweets will generate automaticlly here-->
						</div>
						<!--end tweet-->

						<!-- <div class="pagers">
						<button class="prev tweet_prev">Prev</button>
						<button class="nxt  tweet_nxt">Next</button>
					</div> -->
					</div>
				</div>
			</div>
			<!--end tweets-->


			<div class="container">
				<div class="sixteen">
					<p class="copyright">
						Copyright 2012 for <a href="#">ShoppingLoop.com</a><br>
						Powered By: <a href="#">opencart.</a>
					</p>
					<ul class="socials">
						<li><a class="twitter" href="#">twitter</a></li>
						<li><a class="facebook" href="#">face</a></li>
						<li><a class="googlep" href="#">google+</a></li>
						<li><a class="vimeo" href="#">vimeo</a></li>
						<li><a class="skype" href="#">skype</a></li>
						<li><a class="linked" href="#">linked</a></li>
					</ul>
				</div>
				<!--end sixteen-->
			</div>
			<!--end container-->

		</footer>
		<!--end the footer area -->





		<!-- Sidebar Widget
	================================================== -->
		<div id="sideWidget">
			<div class="bgPatterns">
				<h4>Solid Colors</h4>
				<a href="#" style="background: #fff">white</a> <a href="#"
					style="background: #fafafa">light_gray</a> <a href="#"
					style="background: #f7f7f7">gray</a> <br> <br>

				<h4>Body Patterns</h4>
				<a href="#"
					style="background: url(images/bg/white_carbon.png) repeat">white_carbon</a>

				<a href="#" style="background: url(images/bg/circles.png) repeat">circles</a>

				<a href="#" style="background: url(images/bg/cubes.png) repeat">cubes</a>

				<a href="#"
					style="background: url(images/bg/exclusive_paper.png) repeat">exclusive_paper</a>

				<a href="#"
					style="background: url(images/bg/gplaypattern.png) repeat">gplaypattern</a>

				<a href="#"
					style="background: url(images/bg/large_leather.png) repeat">large_leather</a>

				<a href="#" style="background: url(images/bg/lghtmesh.png) repeat">lghtmesh</a>

				<a href="#" style="background: url(images/bg/light_wool.png) repeat">light_wool</a>

				<a href="#" style="background: url(images/bg/lil_fiber.png) repeat">lil_fiber</a>

				<a href="#" style="background: url(images/bg/snow.png) repeat">snow</a>

				<a href="#"
					style="background: url(images/bg/soft_wallpaper.png) repeat">soft_wallpaper</a>

				<a href="#" style="background: url(images/bg/weave.png) repeat">weave</a>

				<a href="#"
					style="background: url(images/bg/white_brick_wall.png) repeat">white_brick_wall</a>

				<a href="#"
					style="background: url(images/bg/white_paperboard.png) repeat">white_paperboard</a>

				<a href="#"
					style="background: url(images/bg/white_tiles.png) repeat">white_tiles</a>

				<a href="#" style="background: url(images/bg/wall4.png) repeat">wall4</a>

				<a href="#" style="background: url(images/bg/furley_bg.png) repeat">furley_bg</a>

				<a href="#"
					style="background: url(images/bg/extra_clean_paper.png) repeat">extra_clean_paper</a>

			</div>
			<a class="WidgetLink" href="#open">+</a>
		</div>
		<!-- End Sidebar Widget-->




		<!-- JS
	================================================== -->
		<script
			src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
		<!-- jQuery.dropKick plug-in -->
		<link rel="stylesheet" href="js/dropKick/dropkick.css">
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
		<link rel="stylesheet" href="js/fancybox/jquery.fancybox-1.3.4.css">
		<script src="js/fancybox/jquery.fancybox-1.3.4.pack.js"></script>
		<!-- jQuery.etalage plug-in -->
		<script src="js/jquery.etalage.min.js"></script>
		<!-- jQuery.cookie plug-in -->
		<script src="js/jquery.cookie.js"></script>
		<!--my custom code-->
		<script src="js/main.js"></script>


		<!-- End Document
================================================== -->
</body>
</html>
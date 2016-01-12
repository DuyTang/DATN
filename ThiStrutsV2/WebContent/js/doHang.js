var arr = [];
// create products object

function products(ten, gia, id) {
	this.id = id;
	this.ten = ten;
	this.gia = gia;
}
function addSanPham(ten, gia, id) {
	arr.push(new products(ten, gia, id));
	window.location.href = "doHang.jsp";
}
function hienThiDonHang() {
	// browse and display all elements
	alert("ok");
	var data = "";
	for (var i = 0; i < arr.length; i++) {
		data = data
				.concat("<tr><td >"
						+ arr[i].ten
						+ "</td><td>"
						+ arr[i].gia
						+ "</td><td ><label><input class='gray_btn' type='button' id='min_qty' class='qty' value='-'></label><label><input type='text' maxlength='12' value='1' size='2'></label><label><input class='gray_btn' type='button' id='max_qty' class='qty' value='+'></label></td><td >tong gia</td><td><a class='delete_item' href='#'>delete</a></td></tr>");
	}
	document.getElementById("content").innerHTML = data;
}


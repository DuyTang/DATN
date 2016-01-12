function sumTotal(){
	var giaChip = $('.Chip').val();
	var giaChip1 = giaChip.split("-");
	var giaChip2 = giaChip1[0];
	
	var giaMainboard = $('.Mainboard').val();
	var giaMain1 = giaMainboard.split("-");
	var giaMain2 = giaMain1[0];
	
	var giaChuot = $('.Chuot').val();
	var giaChuot1 = giaChuot.split("-");
	var giaChuot2 = giaChuot1[0];
	
	var giaHDD = $('.HDD').val();
	var giaHDD1 = giaHDD.split("-");
	var giaHDD2 = giaHDD1[0];
	
	var giaBanPhim = $('.BanPhim').val();
	var giaBanPhim1 = giaBanPhim.split("-");
	var giaBanPhim2 = giaBanPhim1[0];
	
	var giaTanNhiet = $('.TanNhiet').val();
	var giaTanNhiet1 = giaTanNhiet.split("-");
	var giaTanNhiet2 = giaTanNhiet1[0];
	
	var giaPhuKien = $('.PhuKien').val();
	var giaPhuKien1 = giaPhuKien.split("-");
	var giaPhuKien2 = giaPhuKien1[0];
	
	var giaCase = $('.Case').val();
	var giaCase1 = giaCase.split("-");
	var giaCase2 = giaCase1[0];
	
	var giaNguon = $('.Nguon').val();
	var giaNguon1 = giaNguon.split("-");
	var giaNguon2 = giaNguon1[0];
	
	var giaDVD = $('.DVD').val();
	var giaDVD1 = giaDVD.split("-");
	var giaDVD2 = giaDVD1[0];

	var giaManHinh = $('.ManHinh').val();
	var giaManHinh1 = giaManHinh.split("-");
	var giaManHinh2 = giaManHinh1[0];
	
	var soLuongRam = $('.SoLuong').val();
	
	var giaRam = $('.Ram').val();
	var giaRamChuyen = giaRam.split("-");
	var giaRamChuyen2 = giaRamChuyen[0];
	var giaRamTong = Number(giaRamChuyen2) * Number(soLuongRam);
	
	var loaiRam = giaRamChuyen[2];
	var loaiRamMain = giaMain1[2];
	
//	var total =  Number(giaChip) + Number(giaHDD)+ Number(giaMain2) +  Number(giaChuot)   +  Number(giaRamTong)  + Number(giaBanPhim)+ Number(giaManHinh)+Number(giaCase)+ Number(giaNguon)+ Number(giaDVD) + Number(giaTanNhiet) + Number(giaPhuKien) ;
//	$('#total').text(total);
	if(giaRamChuyen2 != "" && giaRamChuyen2 != null && soLuongRam ==1){
		var total =  Number(giaChip2) + Number(giaHDD2)+ Number(giaMain2) +  Number(giaChuot2)   +  Number(giaRamChuyen2)  + Number(giaBanPhim2)+ Number(giaManHinh2)+Number(giaCase2)+ Number(giaNguon2)+ Number(giaDVD2) + Number(giaTanNhiet2) + Number(giaPhuKien2) ;
		
		//$('#total').html("<b>" + val(total) + " VND" ;
		total = total.toString().replace(/(\d)(?=(\d\d\d)+(?!\d))/g, "$1,");
		$('#total').val(total);
	}else{
		var total =  Number(giaChip2) + Number(giaHDD2)+ Number(giaMain2) +  Number(giaChuot2)   +  Number(giaRamTong)  + Number(giaBanPhim2)+ Number(giaManHinh2)+Number(giaCase2)+ Number(giaNguon2)+ Number(giaDVD2) + Number(giaTanNhiet2) + Number(giaPhuKien2) ;
		
		//$('#total').html("<b>" + total + " VND") ;
		//$('#total').html("<b>" + val(total) + " VND" ;
		total = total.toString().replace(/(\d)(?=(\d\d\d)+(?!\d))/g, "$1,");
		$('#total').val(total);
	}
	
	if(loaiRam != null && loaiRam != loaiRamMain && loaiRam != "" && loaiRamMain != null && loaiRamMain != ""){
		alert('Bạn chọn Ram và Mainboard khác loại nhau');
	}
}	
$('.Chip').change(function(){
	sumTotal();
});
$('.HDD').change(function(){
	sumTotal();
});
$('.Mainboard').change(function(){
	sumTotal();
});
$('.Chuot').change(function(){
	sumTotal();
});
$('.Ram').change(function(){
	sumTotal();
});
$('.BanPhim').change(function(){
	sumTotal();
});
$('.ManHinh').change(function(){
	sumTotal();
});
$('.Case').change(function(){
	sumTotal();
});
$('.Nguon').change(function(){
	sumTotal();
});
$('.DVD').change(function(){
	sumTotal();
});
$('.TanNhiet').change(function(){
	sumTotal();
});
$('.PhuKien').change(function(){
	sumTotal();
});
$('.SoLuong').change(function(){
	sumTotal();
});
$(function(){
	$("#maKH").attr("placeholder","--Nhập mã khách hàng");
});
$(function(){
	$("#tenKH").attr("placeholder","--Nhập tên khách hàng");
});
$(function(){
	$("#diaChi").attr("placeholder","--Nhập địa chỉ khách hàng");
});
$(function(){
	$("#email").attr("placeholder","--Nhập email khách hàng");
});
$(function(){
	$("#sodienthoai").attr("placeholder","--Nhập số điện thoại khách hàng");
});






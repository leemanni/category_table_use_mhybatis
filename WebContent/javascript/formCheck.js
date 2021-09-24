$( ()=>{
	$('.form_main:eq(0)').submit(function(e) {
		var category = $.trim($('.category_main:eq(0)').val()).length
		if(category==0){
			alert('만들 카테고리 를 입력하세요')
			$('.form_main:eq(0)')[0].reset();
			$('.category_main:eq(0)').focus();
			e.preventDefault();
		}
		alert('카테고리 등록 완료!')
	})
	
	
	
	 
})
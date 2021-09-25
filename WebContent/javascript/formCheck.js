$( ()=>{
	$('.form_main:eq(0)').submit(function(e) {
		var category = $.trim($('.category_main:eq(0)').val()).length
		if(category==0){
			alert('만들 카테고리 를 입력하세요')
			$('.form_main:eq(0)')[0].reset();
			$('.category_main:eq(0)').focus();
			e.preventDefault();
		}else{
			alert('카테고리 등록 완료!')
		}
	})
	
	$('.sub_form').each(function(i, element) {
		$(element).addClass('form-index_'+i);
	})
	
	$('.sub_category').each(function(i, element) {
		$(element).addClass('category-index_'+i);
	})
	
	$('.sub_form').each(function(i, element) {
		$('.form-index_'+i).submit(function(e) {
			var sub_category = $.trim($('.category-index_'+i).val()).length;
//			alert(sub_category)
			if(sub_category == 0){
				alert('만들 카테고리 를 입력하세요')
				e.preventDefault();
				$('.form-index_'+i)[0].reset()
				$('.category-index_'+i).focus()
			}
		})
	})
	
})
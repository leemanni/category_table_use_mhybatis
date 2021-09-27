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

function mySubmitDelete(obj) {
	obj.action = 'delete.jsp' ;
	// 이런식으로 action 이라는 예약어를 사용하면 해당 페이지로 데이터를 전송해준다
	obj.submit();
	// action 페이지를 호출하고 폼의 데이터를 전송한다.
}

function undoRemove(obj) {
	obj.action = 'deleteRestore.jsp' ;
	obj.submit();
}

// 신고 하는 페이지로 연결하는 함수
function report(obj) {
	obj.action = 'deleteReport.jsp' ;
	obj.submit();
}

function update(obj) {
	if(!obj.category.value || obj.category.value.trim().length ==0){
		alert('만들 카테고리 를 입력하세요')
		obj.category.value = '';
		obj.category.focus();
	}else{
		obj.action = 'update.jsp' ;
		obj.submit();
	}
}













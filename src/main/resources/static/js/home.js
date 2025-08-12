const titleEl = document.querySelector('[id=title]');

/* 검색 버튼 */
const btnM = document.querySelectorAll('[id=btn-m]')[0];

/* 글쓰기 버튼 */
const btnA = document.querySelectorAll('[id=btn-m]')[1];

/* 작성 취소 버튼 */
const btnB = document.querySelectorAll('[id=btn-m]')[2];

const inputAreaEl = document.querySelector('[id=inputArea]');

const selectEl = document.querySelector('[id=menuList]');

let optionEl = '';

selectEl.addEventListener('change', function(e) {
	const selectIndex = selectEl.selectedIndex;
	const selectOption = selectEl.options[selectIndex];
	
	optionEl = selectOption.innerHTML;
});

/* 글쓰기 버튼 클릭 이벤트 */
btnA.addEventListener('click', function() {
	titleEl.type = 'text';
	inputAreaEl.style.display = 'block';
});

/* 작성 취소 버튼 클릭 이벤트 */
btnB.addEventListener('click', function() {
	
	if(titleEl.type == 'text') {
		if(confirm('작성하신 내용이 전부 삭제됩니다.\r\n 그래도 작성을 취소하시겠습니까?')) {
			titleEl.type = 'hidden';
			titleEl.value = '';
			
			inputAreaEl.style.display = 'none';
			inputAreaEl.value = '';
		} else {
			
			return false;
		}
	}
});

/* 작성 완료 버튼 클릭 이벤트 */

/* 게시글 추가 액션 폼 */
const formEl = document.querySelector('[id=content-submit]');

/* 작성 완료 버튼 */
const btnC = document.querySelector('[type=button]');

btnC.addEventListener('click', function(e) {
	if(titleEl.value.trim() !== '') {
		if(inputAreaEl.value.trim() !== '') {
			if(optionEl !== '') {
				if(confirm(optionEl + ' 메뉴를 선택하셨습니다. 확인을 누르시면 게시글 작성이 완료됩니다.')) {
					formEl.submit();				
				} else {
					e.preventDefault();
					
					return false;
				}				
			} else {
				alert('작성할 게시글의 메뉴를 선택하세요.');
			}
				
		} else {
			alert('내용을 입력하세요.');
		}
	} else {
		alert('제목을 입력하세요.');
	}
});

btnM.addEventListener('click', function(e) {
	const searchEl = document.querySelector('[name=search]');
	
	if(searchEl.value.trim() == '') {
		alert('검색할 제목을 입력하세요.');
		
		e.preventDefault();
		return false;
	}
	
	btnM.href='/board/search?search=' + searchEl.value;
});



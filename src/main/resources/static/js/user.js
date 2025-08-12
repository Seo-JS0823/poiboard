/* 폼 엘리먼트 가져오기 */
const formEl = document.querySelector('form');

/* 회원가입 페이지에서 쓸 이메일 확인 체크 */
let emailcheck = false;

/* 회원가입 버튼을 누르면 실행되는 submit 이벤트 정의 */
formEl.addEventListener('submit', function(e) {
	
	/* 각 입력 데이터들의 엘리먼트를 변수에 할당한다. */
	const useridEl = document.querySelector('[name=userid]');
	const pwdEl = document.querySelector('[name=passwd]');
	const usernameEl = document.querySelector('[name=username]');
	
	/* 비밀번호 확인을 위한 변수로 id가 pwdcheck인 비밀번호 확인란 엘리먼트를 가져온다. */
	const pwdcheckEl = document.querySelector('[id=pwdcheck]');
	
	const emailEl = document.querySelector('[name=email]');
	
	/* 정규식 준비 */
	const useridReg = /^[a-zA-Z][0-9a-zA-Z]{6,12}$/;
	const pwdElReg = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[@#$%^&*])[A-Za-z\d@#$%^&*]{8,12}$/;
	const emailReg = /^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$/;
	
	
	/*
	로그인 페이지에서 쓸 함수다.
	로그인 페이지는 userid 와 passwd 만 있기 때문에 이를 제외한 나머지 3개가
	Null이면 로그인 페이지라고 판단한다.
	*/
	if(usernameEl == null && pwdcheckEl == null && emailEl == null) {
		/* 검사할 입력 데이터 준비 */
		const userid = useridEl.value.trim();
		const passwd = pwdEl.value.trim();
		
		/* 아이디 입력란에 데이터가 없으면 실행된다. */
		if(userid == '') {
			alert('아이디를 입력해주세요.')
			
			e.preventDefault();
			useridEl.focus();
			
			return false;
		}
		
		/*
		아이디 입력값에 대해 정규식 조건에 해당하지 않으면 실행된다.
		해당되면 true를 반환해서 if 안으로 들어가지 않는다.
		
		로그인 페이지이므로 이미 한 번 회원가입 했기 때문에 정규식 검사는 필요가 없을 것 같다.
		하지만 오타로 인해 서버로 한 번 다녀오는 것이 부담된다면 써도 될 듯 하다.
		
		if(!useridReg.test(userid)) {
			alert('올바른 아이디를 입력해주세요. 6~12자의 영문 소문자와 숫자만 허용합니다.');
			
			e.preventDefault();
			useridEl.focus();
			
			return false;
		}
		*/
		
		/* 비밀번호 입력란에 데이터가 없으면 실행된다. */
		if(passwd == '') {
			alert('비밀번호를 입력해주세요.')
			
			e.preventDefault();
			pwdEl.focus();
			
			return false;
		}
		
		return true;
	/* 회원가입 페이지에서 쓸 함수 */
	} else {
		/* 검사할 입력 데이터 준비 */
		const userid = useridEl.value.trim();
		const passwd = pwdEl.value.trim();
		const passwdCheck = pwdcheckEl.value.trim();
		const username = usernameEl.value.trim();
		const email = emailEl.value.trim();
		
		/* 입력 데이터가 없으면 실행된다. */
		if(username == '') {
			alert('성함을 입력해주세요.');
			
			e.preventDefault();
			usernameEl.focus();
			
			return false;
		}
		
		/* 아이디 입력란에 데이터가 없으면 실행된다. */
		if(userid == '') {
			alert('아이디를 입력해주세요.')
			
			e.preventDefault();
			useridEl.focus();
			
			return false;
		}
		
		/*
		아이디 입력값에 대해 정규식 조건에 해당하지 않으면 실행된다.
		해당되면 true를 반환해서 if 안으로 들어가지 않는다.
		*/
		if(!useridReg.test(userid)) {
			alert('아이디는 6~12자의 영문과 숫자만 가능합니다.')
			
			e.preventDefault();
			useridEl.focus();
			
			return false;
		}
		
		/* 비밀번호 입력란에 데이터가 없으면 실행된다. */
		if(pwdEl.value.trim() == '') {
			alert('비밀번호를 입력해주세요.')
			
			e.preventDefault();
			pwdEl.focus();
			
			return false;
		}
		
		/*
		비밀번호 입력값에 대해 정규식 조건에 해당하지 않으면 실행된다.
		해당되면 true를 반환해서 if 안으로 들어가지 않는다.
		*/
		if(!pwdElReg.test(passwd)) {
			alert('비밀번호는 8~12자의 영문 대·소문자와 특수문자를 1개씩 포함해야 합니다.');
			
			e.preventDefault();
			pwdEl.focus();
			
			return false;
		}
		
		/*
		비밀번호 입력 데이터와 비밀번호 확인란 입력 데이터가 일치하지 않으면
		해당 if문이 실행된다.
		*/
		if(passwd !== passwdCheck) {
			alert('비밀번호 확인란과 일치하지 않습니다.');
			
			e.preventDefault();
			pwdcheckEl.focus();
			
			return false;
		}
		
		/*
		이메일 입력 데이터가 있는지 검사한다.
		
		해당 if문은 이메일 입력란에 데이터가 없을 경우 실행된다.
		그리고 이메일이 없다고 체크한 후 회원가입에 실패해서뒤로가기 버튼으로
		되돌아왔을 때 true라서 이메일 입력값에 대해서 체크하지 않는다.
		*/
		if(email == '' && emailcheck == false) {
			
			/* 이메일은 필수가 아니기 때문에 한 번 물어본다. */
			if(emailcheck == false && confirm('이메일이 없으십니까?')) {
				if(confirm('확인 버튼을 누르면 회원가입을 진행합니다.')) {
					emailcheck = true;
									
					return true;
				} else {
					alert('이메일을 입력해주세요.');
					
					e.preventDefault();
					emailEl.focus();
					
					return false;	
				}
			} else {
				alert('이메일을 입력해주세요.');
					
				e.preventDefault();
				emailEl.focus();
					
				return false;
			}	
		}
		
		/*
		이메일 입력 데이터가 정규식 조건에 해당하지 않으면 실행된다.
		해당 if문은 이메일 입력란에 데이터가 존재할 때만 실행된다.
		
		이메일이 없다고 체크한 후 회원가입에 어떤 이유로 실패해서
		뒤로가기 버튼으로 되돌아 왔을 때 emailcheck 변수가 그대로 true이기 때문에
		해당 if문은 emailcheck 변수를 사용하지 않는다.
		
		되돌아와서 한 번이라도 이메일을 입력한 후 회원가입 버튼을 누르면 emailcheck에 false를 할당한다.
		*/
		if(!emailReg.test(email) && email != '') {
			emailcheck = false;
			
			alert('이메일 형식으로 입력하세요.');
			
			e.preventDefault();
			emailEl.focus();
			
			return false;
		}
		
	}
});

const menuSeeEl = document.getElementById('[id=menuSee]');

if(menuSeeEl.value.trim() !== '') {
	alert('로그인을 해야 메뉴 목록을 확인할 수 있습니다.');
}

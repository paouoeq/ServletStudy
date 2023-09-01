<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- jquery CDM -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<!-- jquery -->
<script>
	$(document).ready(function(){
		$("#passwd2").on("keyup", function(){
			var passwd = $("#passwd").val(); // input tage이기 때문에 val로 값 가져옴
			var passwd2 = $("#passwd2").val();
			var mesg = "비번 일치";
			if(passwd != passwd2) {
				mesg="비번 불일치";
			}
			
			$("#idcheck").text(mesg); // spane태그에 값을 넣어줌
		});
		
		// id 중복체크
		$("#idDupulicatedcheck").on("click", function(){
			// button은 기본적으로 form태그 안에서 submit처럼 동작함 => submit 비활성화 필요
			event.preventDefault() // submit 비활성화
			//ajax 연동
			$.ajax({
                // 요청코드
                type:"get", // MemberIdCheckServlet으로 doget방식으로 url넘겨줌
                url:"MemberIdCheckServlet", // 버튼 눌렀을 때 이동할 곳 정하기
                data:{
                    userid:$("#userid").val() // MemberIdCheckServlet으로 넘겨줄 값 : userid값
                },

                // 응답코드
                dataType:'text', // 응답받을 데이터 타입
                success:function(data, satatus, xhr) { // 성공했을 때 data변수에 MemberIdCheckServlet에서 넘어온 값(mesg) 저장
                    console.log(data);
                    $("#result").text(data); // id값이 result인 span태그에 값 넣어줌 -> 사용자에게 출력됨
                },
                error:function(xhr, status, error) {
                    console.log("에러발생");
                }
            });
		});
		
		
		// 모든 회원정보가 입력된 후 submit 되도록 만들기
		$("form").on("submit", function() {
			var userid = $("#userid").val();
			var passwd = $("#passwd").val();
			var passwd2 = $("#passwd2").val();
			var username = $("#username").val();
			var sample4_postcode = $("#sample4_postcode").val();
			var sample4_roadAddress = $("#sample4_roadAddress").val();
			var sample4_jibunAddress = $("#sample4_jibunAddress").val();
			var phone2 = $("#phone2").val();
			var phone3 = $("#phone3").val();
			var email1 = $("#email1").val();
			var email2 = $("#email2").val();
			
			if(userid.length == 0) {
				event.preventDefault()
		        alert("ID는 필수 기입 사항");
		        $("#userid").focus();
			}
			else if(passwd.length == 0) {
				event.preventDefault()
		        alert("비밀번호는 필수 기입 사항");
		        $("#passwd").focus();
			}
			else if(passwd2.length == 0) {
				event.preventDefault()
		        alert("비밀번호 검사를 해주세요");
		        $("#passwd2").focus();
			}
			else if(username.length == 0) {
				event.preventDefault()
		        alert("이름은 필수 기입 사항");
		        $("#username").focus();
			}
			else if(sample4_postcode.length == 0) {
				event.preventDefault()
		        alert("주소는 필수 기입 사항");
			}
			else if(sample4_roadAddress.length == 0) {
				event.preventDefault()
		        alert("주소는 필수 기입 사항")
			}
			else if(sample4_jibunAddress.length == 0) {
				event.preventDefault()
		        alert("주소는 필수 기입 사항");
			}
			else if(phone2.length == 0) {
				event.preventDefault()
		        alert("핸드폰 번호는 필수 기입 사항");
		        $("#phone2").focus();
			}
			else if(phone3.length == 0) {
				event.preventDefault()
		        alert("핸드폰 번호는 필수 기입 사항");
		        $("#phone3").focus();
			}
			else if(email1.length == 0) {
				event.preventDefault()
		        alert("이메일은 필수 기입 사항");
		        $("#email1").focus();
			}
			else if(email2.length == 0) {
				event.preventDefault()
		        alert("이메일은 필수 기입 사항");
		        $("#email2").focus();
			}
				
		});
		
	});


</script>
<form action="MemberAddServlet" method="post">
*아이디:<input type="text" name="userid" id="userid">
<button id="idDupulicatedcheck">중복확인</button><span id="result"></span><br>
*비밀번호:<input type="text" name="passwd" id="passwd"><br>
*비밀번호확인:<input type="text" name="passwd2" id="passwd2"><span id="idcheck"></span><br>
*이름:<input type="text" name="username" id="username"><br>

<!-- kakao address API --> <!-- 제공된 API에는 name속성이 없으니 추가해줌 -->
<input type="text" name="post" id="sample4_postcode" placeholder="우편번호">
<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
<input type="text" name="addr1" id="sample4_roadAddress" placeholder="도로명주소">
<input type="text" name="addr2" id="sample4_jibunAddress" placeholder="지번주소">
<span id="guide" style="color:#999"></span>
<br>
<!-- kakao address API -->

전화번호:
<select name="phone1">
	<option value="010">010</option>
	<option value="011">011</option>
</select>-
<input type="text" name="phone2" id="phone2">-
<input type="text" name="phone3" id="phone3"><br>
이메일:
<input type="text" name="email1" id="email1">@<input type="text" name="email2" id="email2" placeholder="직접입력">
<select>
	<option value="daum.net">daum.net</option>
	<option value="google.com">google.com</option>
	<option value="naver.com">naver.com</option>
</select><br>
<input type="submit" value="회원가입">
<input type="reset" value="취소">

<!-- kakao address API script -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 도로명 조합형 주소 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }
                // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
                if(fullRoadAddr !== ''){
                    fullRoadAddr += extraRoadAddr;
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample4_postcode').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('sample4_roadAddress').value = fullRoadAddr;
                document.getElementById('sample4_jibunAddress').value = data.jibunAddress;

                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    //예상되는 도로명 주소에 조합형 주소를 추가한다.
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    document.getElementById('guide').innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    document.getElementById('guide').innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';

                } else {
                    document.getElementById('guide').innerHTML = '';
                }
            }
        }).open();
    }
</script>
<!-- kakao address API script -->

</form>
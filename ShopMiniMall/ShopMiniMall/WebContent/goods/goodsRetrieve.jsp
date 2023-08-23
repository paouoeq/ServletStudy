<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- jquery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script>
	$(document).ready(function(){
		// 주문수량 up
		$("#up").on("click", function(){
			var gAmount = Number.parseInt($("#gAmount").val());
			$("#gAmount").val(++gAmount);
		});
		
		// 주문수량 down ==> 최저값 1
		$("#down").on("click", function(){
			var gAmount = Number.parseInt($("#gAmount").val());
			if(gAmount==1) {
				$("#gAmount").val(1);
			}else {
				$("#gAmount").val(--gAmount);
			}
		});
		
		// 장바구니 버튼 이벤트 처리
		$(cartBtn).on("click", function(){
			var f = $("#myForm")[0]; // form객체를 변수로 받음 => 배열로 받음
			f.action="CartAddServlet" // 장바구니 버튼 클릭시 form태그의 액션값이 변경됨 => 첫번째 form태그임을 알려주기 위해 인덱스 적용
			
			// 다른 속성을 바꿀 때도 action과 마찬가지로 f.속성명=값 형식으로 설정해주면 된다.
		});
		
		// 구매 버튼 이벤트 처리
		$(buyBtn).on("click", function(){
			var f = $("#myForm")[0]; // form객체를 변수로 받음 => 배열로 받음
			f.action="main" // 장바구니 버튼 클릭시 form태그의 액션값이 변경됨 => 첫번째 form태그임을 알려주기 위해 인덱스 적용
			
		});
	});
	
	
</script>
<!-- 구매/장바구니 버튼에 따라 action값이 다르도록(동적으로) 설정해줘야 한다. -->
<form name="goodRetrieveForm" id="myForm" method="GET" action="#">
		<!-- 선택 옵션 외의 넘겨줘야 할 정보들은 hidden으로 명시 -->
	    <input type="hidden" name="gImage" value="${ goodsRetrieve.gImage }"> 
	    <input type="hidden" name="gCode" value="${ goodsRetrieve.gCode }">
	    <input type="hidden" name="gName" value="${ goodsRetrieve.gName }">
	    <input type="hidden" name="gPrice" value="${ goodsRetrieve.gPrice }">

	<table width="100%" cellspacing="0" cellpadding="0">
		<tr>
			<td height="30">
		</tr>
		<tr>
			<td>
				<table align="center" width="710" cellspacing="0" cellpadding="0"
					border="0" style='margin-left: 30px'>
					<tr>
						<td class="td_default"><font size="5"><b>- 상품 정보 -</b></font>
							&nbsp;</td>
					</tr>
					<tr>
						<td height="5"></td>
					</tr>
					<tr>
						<td height="1" colspan="8" bgcolor="CECECE"></td>
					</tr>
					<tr>
						<td height="10"></td>
					</tr>

					<tr>
						<td rowspan="7"><img src="images/items/${ goodsRetrieve.gImage }.gif"
							border="0" align="center" width="300" /></td>
						<td class="td_title">제품코드</td>
						<td class="td_default" colspan="2" style='padding-left: 30px'>${ goodsRetrieve.gCode }
						</td>
					</tr>
					<tr>
						<td class="td_title">상품명</td>
						<td class="td_default" colspan="2" style='padding-left: 30px'>${ goodsRetrieve.gName }</td>
					</tr>
					<tr>
						<td class="td_title">가격</td>

						<td class="td_red" colspan="2" style='padding-left: 30px'>
						￦${ goodsRetrieve.gPrice }
						</td>
					</tr>
					<tr>
						<td class="td_title">배송비</td>
						<td colspan="2"><font color="#2e56a9" size="2"
							style='padding-left: 30px'><b> 무료배송</b> </font> <font size="2">(도서
								산간지역 별도 배송비 추가)</font></td>
					</tr>
					<tr>
						<td class="td_title" rowspan="2">상품옵션</td>
						<td colspan="2" style='padding-left: 30px'><select
							class="select_change" size="1" name="gSize" id="gSize">
								<option selected value="사이즈선택">사이즈선택</option>
								<option value="L">L</option>
								<option value="M">M</option>
								<option value="S">S</option>
						</select></td>
					</tr>
					<tr>
						<td colspan="2" style='padding-left: 30px'><select
							class="select_change" size="1" name="gColor"
							id="gColor">
								<option selected value="색상선택">색상선택</option>
								<option value="navy">navy</option>
								<option value="black">black</option>
								<option value="ivory">ivory</option>
								<option value="white">white</option>
								<option value="gray">gray</option>
						</select></td>
					</tr>

					<tr>
						<td class="td_title">주문수량</td>
						<td style="padding-left: 30px">
						<input type="text"
							   name="gAmount" value="1" id="gAmount"
							   style="text-align: right; height: 18px"> 
						<img src="images/up.PNG" id="up"> <img src="images/down.PNG"
							 id="down"></td>
					</tr>
				</table>

			</td>
		</tr>
	</table>

	<br> <button id="buyBtn">구매</button>
	&nbsp;&nbsp;
	<button id="cartBtn">장바구니</button>
</form>
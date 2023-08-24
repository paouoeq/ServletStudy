<%@page import="com.dto.CartDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>

<!-- Ajax 통해 수정버튼 활성화 -->
<script>
	$(document).ready(function(){
		$(".updateBtn").on("click", function(){
			var num = $(this).attr("data-num"); // attr : 속성값을 가져옴
			var gAmount = $("#gAmount"+num).val();
			
			//ajax 연동 - 수정버튼
			$.ajax({
                // 요청코드
                type:"get", // CartUpdateServlet으로 doget방식으로 url넘겨줌
                url:"CartUpdateServlet", // 버튼 눌렀을 때 이동할 곳 정하기
                data:{ // CartUpdateServlet 으로 넘겨줄 값
                	num:num,
                    gAmount:gAmount
                },

                // 응답코드
                dataType:'text', // 응답받을 데이터 타입
                success:function(data, satatus, xhr) { 
                	// 성공했을 때 합계를 수정해줘야함(수량이 변경되었기 때문)
                	var price = $("#gPrice"+num).text(); // price값 가져오는 방법1
//                	var price2 = $("#sum"+num).attr("data-price"); // // price값 가져오는 방법2
                	
                    $("#sum"+num).text(Number.parsInt(price)*Number.parsInt(gAmount));
                },
                error:function(xhr, status, error) {
                    console.log("에러발생");
                }
            }); 
		});// end updateBtn
		
		// 단일 삭제 버튼 이벤트
		$(".deleteBtn").on("click", function(){
			var num = $(this).attr("data-num"); // attr : 속성값을 가져옴
			//alert(num); // num값 확인
			location.href="CartDeleteServlet?num="+num; // 쿼리스트링으로 num값 넘겨줌
			
		});
		
	}); 
	
</script>






<!-- JSTL 적용 -->
<table width="90%" cellspacing="0" cellpadding="0" border="0">

	<tr>
		<td height="30">
	</tr>

	<tr>
		<td colspan="5" class="td_default">&nbsp;&nbsp;&nbsp; <font
			size="5"><b>- 장바구니-</b></font> &nbsp;
		</td>
	</tr>

	<tr>
		<td height="15">
	</tr>

	<tr>
		<td colspan="10">
			<hr size="1" color="CCCCCC">
		</td>
	</tr>

	<tr>
		<td height="7">
	</tr>

	<tr>
		<td class="td_default" align="center">
		<input type="checkbox" name="allCheck" id="allCheck"> <strong>전체선택</strong></td>
		<td class="td_default" align="center"><strong>주문번호</strong></td>
		<td class="td_default" align="center" colspan="2"><strong>상품정보</strong></td>
		<td class="td_default" align="center"><strong>판매가</strong></td>
		<td class="td_default" align="center" colspan="2"><strong>수량</strong></td>
		<td class="td_default" align="center"><strong>합계</strong></td>
		<td></td>
	</tr>

	<tr>
		<td height="7">
	</tr>
	
	
	
	<tr>
		<td colspan="10">
			<hr size="1" color="CCCCCC">
		</td>
	</tr>



	<form name="myForm">
<!-- 반복문 시작 -->
		<c:forEach var="dto" items="${ cartList }" varStatus="status">

		 <input type="text" name="num81" value="81" id="num81">
		 <input type="text" name="gImage81" value="bottom1" id="gImage81">
		 <input type="text" name="gName81" value="제나 레이스 스커트" id="gName81">
		  <input type="text" name="gSize81" value="L" id="gSize81">
		   <input type="text" name="gColor81" value="navy" id="gColor81"> 
		   <input type="text" name="gPrice81" value="9800" id="gPrice81">

		<tr>
			<td class="td_default" width="80">
			<!-- checkbox는 체크된 값만 서블릿으로 넘어간다. 따라서 value에 삭제할 num값을 설정한다. -->
			<input type="checkbox"
				name="check" id="check81" class="check" value="81"></td>
			<td class="td_default" width="80">${dto.num}</td>
			<td class="td_default" width="80"><img
				src="images/items/${dto.gImage}.gif" border="0" align="center"
				width="80" /></td>
			<td class="td_default" width="300" style='padding-left: 30px'>${dto.gName}
				<br> <font size="2" color="#665b5f">[옵션 : 사이즈(${dto.gSize})
					, 색상(${dto.gColor})]
			</font></td>
			<td class="td_default" align="center" width="110" >
			<!-- price값 얻는 방법1 : span태그 추가해 price값 얻기 -->
			<span id="gPrice${dto.num}">￦${dto.gPrice}</span> <!-- price값을 가져오기 위해 span태그 추가 -->
			
			</td>
			<td class="td_default" align="center" width="90">
			<input class="input_default" type="text" name="gAmount"
				id="gAmount${dto.num}" style="text-align: right" maxlength="3"
				size="2" value="${dto.gAmount}"></input></td> <!-- gAmount id를 구별하기 위해 num 추가 -->
				
				
			<!-- 반복문 => 수정 버튼의 아이디가 모두 같음 => 따라서 아이디 대신 클래스 사용 -->
			<!-- 클래스를 구별하기 위해 커스텀 속성 추가 => num값으로 구별 -->
			<td><input type="button" value="수정" class="updateBtn" data-num="${dto.num}"/></td> 
			
			<td class="td_default" align="center" width="80" style='padding-left: 5px'>
				<span id="sum${dto.num}" data-price="${dto.gPrice}"> <!-- sum 아이디 구별을 위해 num값 이용 -->
				￦${dto.gPrice * dto.gAmount} <!-- price값 얻는 방법2 : 커스텀속성을 통해 price값 얻기 -->
				</span>
			</td>
			<td>
				<input type="button" value="주문">
			</td>
			<td class="td_default" align="center" width="30"
				style='padding-left: 10px'>
				<!-- 수정과 마찬가지로 id로는 중복이 생겨 class로 처리, 커스텀속성으로 num값 얻기 -->
				<input type="button" value="삭제" class="deleteBtn" data-num="${dto.num}"></td>
			<td height="10"></td>
		</tr>

		</c:forEach>
<!-- 반복문 끝 -->

	</form>
	<tr>
		<td colspan="10">
			<hr size="1" color="CCCCCC">
		</td>
	</tr>
	<tr>
		<td height="30">
	</tr>

	<tr>
		<td align="center" colspan="5"><a class="a_black"
			href=""> 전체 주문하기 </a>&nbsp;&nbsp;&nbsp;&nbsp; 
			<a class="a_black" href=""> 전체 삭제하기 </a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a class="a_black" href=""> 계속 쇼핑하기 </a>&nbsp;&nbsp;&nbsp;&nbsp;
		</td>
	</tr>
	<tr>
		<td height="20">
	</tr>

</table>
function addToCart(action){
	document.addForm.action=action;
	document.addForm.submit();
	alert("도서가 장바구니에 추가w");
}

function removeFromCart(action){
	console.log("removeFromCart 진입")
	document.removeForm.action=action;
	document.removeForm.submit();
	window.location.reload();
}

function clearCart(){
	console.log("clearCart 진입")
	document.clearForm.submit();
	window.location.reload();
}

function deleteConfirm(id){
	console.log("deleteConfirm 진입")
	if(confirm("삭제합니다!!") == true) location.href="./delete?id=" + id;
	else return;
}
let deletebtn = document.querySelector(`#delbtn${member.getUserId()}`);
console.log(deletebtn);

deletebtn.addEventListener("click", delfunc);

function delfunc(e)
{
	console.log("함수입장");
	let result = window.confirm("정말 삭제하시겠습니까?");
	if(result)
		{
			alert("삭제합니다.")
			window.location.href = "deleteMember?userId=${member.getUserId()}";
			
		}
	else
		{
			alert("취소하였습니다.")
		}
}

	// 	검색기능
	let search = document.querySelector("#searchBox");
//	console.log(search);
	let pages = document.querySelector("#pages");

	search.addEventListener("input", searchFunction);
	
	function searchFunction(e)
	{
		e.preventDefault();
		let searchFor = search.value;
		let searchFortoJsonify = {"searchFor" : searchFor};
// 		console.log("searchFortoJsonify : "+searchFortoJsonify);
		$.ajax({
	        url: "/ourProject/board/list/searching",
	        type: "POST",
	        contentType: "application/json",
	        data: JSON.stringify(searchFortoJsonify),
	        dataType: "json",
	        success:function(hello) 
	        {
	        	console.log(hello);
	        	let resultHtml = '';
				let totalPagesFromSearch = '';
	        	if(hello == null || hello.length===0)
	        		{
	        			resultHtml = '<tr><td colspan = "5"> 검색 결과가 없습니다.</td></tr>';
	        		}
	        	else
	        		{
	        			hello.forEach(function(board){
							
							if(board.number === undefined)
							{
								console.log(board.totalPage);
								(function()
								{
									for(let i=1; i<=board.totalPage; i++)
										{
											console.log(i);
											totalPagesFromSearch += `
											<a href="/ourProject/board/list/searched?currentPage=${i}&search=${searchFor}">${i} </a>`
										};
									
								})();
								return;
							}
							resultHtml +=`
    						<tr>
			                    <td><a href="content?number=${board.number}">${board.number}</a></td>
			                    <td><a href="content?number=${board.number}">${board.category}</a></td>
			                    <td><a href="content?number=${board.number}">${board.title}</a></td>
			                    <td><a href="content?number=${board.number}">${board.date}</a></td>
			                    <td><a href="content?number=${board.number}"></a></td>
							</tr>
							`;
   						});
						
	        		}
//	        	console.log(resultHtml);
				console.log(totalPagesFromSearch);
	        	$('#resultBody').empty().append(resultHtml);
				$('#pages').empty().append(totalPagesFromSearch);
	        },
	        error: function(error) {
	            console.error("에러발생:", error);
	        }
	    });
	}

function addComment(params){
	let pno =params.data.pno;
	let writer =params.data.writer;
	let content =$("#input-cmt").val();
	if(content==""&&content==null){
		alert("내용을 입력해주세요");
		return false;
	}else{
		let cmtData ={pno:pno, writer:writer, content:content};
		$.ajax({
			type:"post",
			url:"/comment/new",
			data:JSON.stringify(cmtData),
			contentType: "application/json; charset=utf-8"
		}).done(function(response){
			alert(response);
			listComment(pno,1);
		}).fail(function(){
			alert("fail");
		}).always(function(){
			$("#input-cmt").val("");
		});

	}
}

function listComment(pno, page){
	let pageNo = page >1 ? page:1;
	$.getJSON("/comment/p/"+pno+"/"+pageNo+".json", function(result){
		printList(result, pageNo)
	}).fail(function(){
		alert("load comment fail");
	});
}

function printList(result,pageNo){
	if(result.list == null || result.list.length ==0){
		return;
	}
	var cmtListULTag = $("#list-cmt-ul");
	var cmtStr="";
	 for(var i =0; i< result.list.length; i++){

		 cmtStr += "<li class='list-group-item d-flex justify-content-between'>";
		 cmtStr += "<span class='badge badge-secondary'>"+result.list[i].writer+"</span>";
		 cmtStr += "<span class='cmtText'>"+result.list[i].content+"</span>";
		 cmtStr += "<span class='badge badge-light'>"+formatTime(result.list[i].modd8)+"</span>";
		 cmtStr += "<button type='button' class='btn btn-outline-warning btn-sm' id='modCmtBtn'>수정</button>";
		 cmtStr += "<button type='button' class='btn btn-outline-warning btn-sm' id='delCmtBtn'>삭제</button>";
		 cmtStr += "</li>";
	 }
	 cmtListULTag.html(cmtStr).trigger("create");
	
}
function formatTime(modd8){
	var distTime=modd8- new Date().getTime();
//	return new Date(modd8).toLocaleDateString(undefined,{ weekday: 'long', year: 'numeric', month: 'long', day: 'numeric' })
	return -Math.floor(distTime/1000)+'초 전';
}

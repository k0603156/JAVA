var commentWrapper,commentBtn, modVal;
var commentCno;
function addComment(params){
	var pno =params.data.pno;
	var writer =params.data.writer;
	var content =$("#input-cmt").val();
	if(content==""&&content==null){
		alert("내용을 입력해주세요");
		return false;
	}else{
		var cmtData ={pno:pno, writer:writer, content:content};
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
	var pageNo = page >1 ? page:1;
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

		 cmtStr += "<li class='list-group-item d-flex justify-content-between' data-cno='"+result.list[i].cno+"'>";
		 cmtStr += "<span class='badge badge-secondary'>"+result.list[i].writer+"</span>";
		 cmtStr += "<span class='cmtText'>"+result.list[i].content+"</span>";
		 cmtStr += "<span class='badge badge-light'>"+formatTime(result.list[i].modd8)+"</span>";
		 cmtStr += "<button type='button' class='btn btn-outline-warning btn-sm' id='modCmtBtn'>수정</button>";
		 cmtStr += "<button type='button' class='btn btn-outline-warning btn-sm' id='delCmtBtn'>삭제</button>";
		 cmtStr += "</li>";
	 }
	 cmtListULTag.html(cmtStr).trigger("create");
	 printListPaging(result.commentcnt,pageNo);
}
function printListPaging(cmtTotal, page){
	var cmtPagination =$('#pagination-cmt');
	var pagingStr ="";
	var pageNum =page;
	var endPage =Math.ceil(pageNum/10)*10;
	var startPage =endPage -9;
	var prev = startPage != 1;
	var next =false;
	
	if(endPage*10 >cmtTotal){
		endPage =Math.ceil(cmtTotal/10);
	}else{
		next=true;
	}
	
	if(prev){
		pagingStr+='<li class="page-item"><a class="page-link" href="'
			+(startPage-1)
			+'">Prev</a></li>';
	}for(var i =startPage; i<=endPage; i++){
		var clsActive = pageNum ==i?'active':'';
		pagingStr+='<li class="page-item '
			+clsActive
			+'"><a class="page-link">'
			+i
			+'</a></li>';
	}
	if(next){
		pagingStr+='<li class="page-item"><a class="page-link" href="'
			+(endPage+1)
			+'">Next</a></li>';
	}
	cmtPagination.html(pagingStr).trigger("create");
}
function formatTime(modd8){
	var distTime=modd8- new Date().getTime();
	return new Date(modd8).toLocaleDateString(undefined,{ weekday: 'long', year: 'numeric', month: 'long', day: 'numeric' })
//	return -Math.floor(distTime/1000)+'초 전';
}

function modifyComment(modVal,cno){
	var cno = cno;
	var cmtText = modVal;
	$.ajax({
		url:"/comment/"+cno,
		type:"put",
		data:JSON.stringify({
			cno:cno,
			content:cmtText
		}),
		contentType: "application/json; charset=utf-8"
	}).done(function(response){
		alert(response);
		changeComment();
	}).fail(function(){
		alert("수정 실패");
	});	
}
function changeComment(){
	commentWrapper.find("#modInput").remove();
	commentWrapper.find(".cmtText").text(modVal);
	commentWrapper.find(".badge-light").after(commentBtn);
}
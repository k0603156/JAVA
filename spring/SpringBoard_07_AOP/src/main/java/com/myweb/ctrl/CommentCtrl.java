package com.myweb.ctrl;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myweb.domain.CommentDTO;
import com.myweb.domain.CommentVO;
import com.myweb.domain.Criteria;
import com.myweb.service.CommentService;

@RestController
@RequestMapping("/comment/*")
public class CommentCtrl {
	private static final Logger log = LoggerFactory.getLogger(CommentCtrl.class);
	@Inject
	private CommentService csv;

	@RequestMapping(method= {RequestMethod.PATCH,RequestMethod.PUT}, value="/{cno}", consumes="application/json",
			produces = "application/text; charset=utf-8")
	public ResponseEntity<String> modify(@PathVariable("cno")int cno,
			@RequestBody CommentVO cvo){
		cvo.setCno(cno);
				return csv.modify(cvo)==1
						? new ResponseEntity<String>("수정되었습니다.",HttpStatus.OK)
						: new ResponseEntity<String>(HttpStatus.CONFLICT);
	}
	@GetMapping(value = "/p/{pno}/{page}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<CommentDTO> list(@PathVariable("pno")int pno,@PathVariable("page")int page){
		Criteria cri = new Criteria(page, 10);
		
		return new ResponseEntity<CommentDTO>(csv.list(cri, pno),HttpStatus.OK);	
	}

	@PostMapping(value = "/new", consumes = "application/json", produces = "application/text; charset=utf-8")
	public ResponseEntity<String> write(@RequestBody CommentVO cvo) {
		int isSuccess = csv.write(cvo);

		return isSuccess == 1 ? new ResponseEntity<>("등록되었습니다.", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.CONFLICT);

	}
}

package com.myweb.ctrl;
import java.io.IOException;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myweb.domain.Criteria;
import com.myweb.domain.PagingVO;
import com.myweb.domain.QnaVO;
import com.myweb.service.QnaService;
@Controller
@RequestMapping("/qna/*")
public class QnaCtrl {
	private static final Logger log = LoggerFactory.getLogger(QnaCtrl.class);
	@Inject
	private QnaService qsv;

	@GetMapping("/list")
	public void list(Model model, Criteria cri) {
		model.addAttribute("list", qsv.list(cri));
		int totalCnt = qsv.totalCount(cri);
		model.addAttribute("qgvo", new PagingVO(totalCnt,cri));
	}
	@GetMapping({"/detail", "/modify"})
	public void detail(@RequestParam("qno") int qno, Model model,@ModelAttribute("cri")Criteria cri) {
		model.addAttribute("qvo", qsv.detail(qno));
	}
	
	@GetMapping("/write")
	public void write() {
	}
	@PostMapping("/write")
	public String write(QnaVO qvo, RedirectAttributes reAttr) throws IllegalStateException, IOException {
		
		log.info("qno:::"+qvo.getTitle());
		qsv.write(qvo);
		reAttr.addFlashAttribute("result", "write_ok");
		return "redirect:/qna/list";
	}
}

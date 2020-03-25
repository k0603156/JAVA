package com.myweb.ctrl;
import java.io.IOException;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myweb.domain.ProductVO;
import com.myweb.service.ProductService;
import com.myweb.util.FileProcess;
@Controller
@RequestMapping("/product/*")
public class ProductCtrl {
	private static final Logger log = LoggerFactory.getLogger(ProductCtrl.class);
	@Inject
	private ProductService psv;
	@Inject
	private FileProcess fp;
	
	@PostMapping("/remove")
	public String remove(@RequestParam("pno")int pno,RedirectAttributes reAttr) {
		log.info(">>remove");
		psv.delete(pno);
		reAttr.addFlashAttribute("result","remove_success");
		return "redirect:/product/list";
	}
	
	@GetMapping({"/detail", "/modify"})
	public void detail(@RequestParam("pno")int pno,Model model) {
		log.info(">>detail, modify");
		model.addAttribute("pvo",psv.selectOne(pno));
	}
	
	@PostMapping("/modify")
	public String modify(ProductVO pvo,RedirectAttributes reAttr) {
		log.info(">>modify");
		psv.update(pvo);
		reAttr.addFlashAttribute("result","modify_success");
		return "redirect:/product/detail?pno="+pvo.getPno();
	}
	
	@GetMapping("/write")
	public void write() {
		log.info(">>write");
	}
	
	@PostMapping("/write")
	public String write(MultipartHttpServletRequest mreq, RedirectAttributes reAttr) {
		log.info(">>write");
		psv.insert(fp.fileSave(mreq));
		reAttr.addFlashAttribute("result", "write_success");
		return "redirect:/product/list";
	}	
	
/*	@RequestMapping(value="/list", method=RequestMethod.GET)*/
	@GetMapping("/list")
	public void list(Model model) {
		log.info(">>list");
		model.addAttribute("list", psv.selectList());
	}
	
}

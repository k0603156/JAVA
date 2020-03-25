package com.myweb.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.myweb.domain.ProductVO;

@Component
public class FileProcess {
	private static final Logger log = LoggerFactory.getLogger(FileProcess.class);
	@Resource(name = "upImages")
	String upImages;

	public ProductVO fileSave(MultipartHttpServletRequest mreq) {
		log.info("File");
		String title = mreq.getParameter("title");
		String content = mreq.getParameter("content");
		String writer = mreq.getParameter("writer");
		MultipartFile imgfile = mreq.getFile("imgfile");
		String saveFileName="";
		if (imgfile == null) {
			saveFileName = "none";
		} else {
			String orgFileName = imgfile.getOriginalFilename();
			saveFileName = UUID.randomUUID().toString()+"_"+orgFileName;
			File file = new File(upImages+saveFileName);
			try {
				imgfile.transferTo(file);
			} catch (IllegalStateException | IOException e) {
				System.out.println(e);
				e.printStackTrace();
			}
		}
		ProductVO pvo = new ProductVO(title, writer, content, saveFileName);
		return pvo;
	}
}

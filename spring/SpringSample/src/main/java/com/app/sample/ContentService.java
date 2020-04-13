package com.app.sample;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ContentService {
	private static final Logger log = LoggerFactory.getLogger(ContentService.class);
	@Inject
	private ContentDao cdao;
	public List<ContentVO> list(){
		return cdao.selectList();
	}
}

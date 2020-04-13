package com.app.sample;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class ContentDao {
	private static final Logger log = LoggerFactory.getLogger(ContentDao.class);
	private static String ns = "ContentMapper.";
	@Inject
	private SqlSession sql;
	
	public  List<ContentVO> selectList(){

		return sql.selectList(ns+"list");
	}
}

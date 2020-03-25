package com.myweb.service;

import java.util.List;

import com.myweb.domain.ProductVO;

public interface ProductService {
	public void insert(ProductVO pvo);
	public List<ProductVO> selectList();
	public ProductVO selectOne(Integer pno);
	public void update(ProductVO pno);
	public void delete(Integer pno);
}

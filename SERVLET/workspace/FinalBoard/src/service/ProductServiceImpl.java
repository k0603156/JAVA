package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import persistence.ProductDAO;
import persistence.ProductDAOImpl;
import persistence.ProductDTO;

public class ProductServiceImpl implements ProductService {

	private static Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);
	ProductDAO pdao;
	
	public ProductServiceImpl() {
		pdao= new ProductDAOImpl();
	}
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, String action) {
		if(action.equals("")){}
		else if(action.equals("")) {}
	}
	
	@Override
	public void create(ProductDTO pdto) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<ProductDTO> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductDTO getDetail() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modify(ProductDTO pdtp) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(int pno) {
		// TODO Auto-generated method stub

	}

	@Override
	public void readCount(int pno) {
		// TODO Auto-generated method stub

	}

}

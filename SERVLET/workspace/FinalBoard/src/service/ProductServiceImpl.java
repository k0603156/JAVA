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
	ProductDTO pdto;
	List<ProductDTO> pList;
	public ProductServiceImpl() {
		pdao= new ProductDAOImpl();
	}
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, String action) {
		if(action.equals("pWrite")){
			String category = request.getParameter("category");
			String pname = request.getParameter("pname");
			String pwriter = request.getParameter("pwriter");
			String pcontent = request.getParameter("pcontent");
			ProductDTO pdto = new ProductDTO(category, pname, pcontent, pwriter, null);
			create(pdto);
		}
		else if(action.equals("pList")) {
			pList = getList();
			request.setAttribute("objList", pList);
		}
		else if(action.equals("pDetail") || action.equals("pModify")) {
			Integer pno = (Integer) request.getAttribute("pno");
			if(pno==null)pno = Integer.parseInt(request.getParameter("pno"));
			
			pdto= getDetail(pno);
			request.setAttribute("pdto", pdto);
		}
		else if(action.equals("pModifySave")) {
			int pno = Integer.parseInt(request.getParameter("pno"));
			String category = request.getParameter("category");
			String pname = request.getParameter("pname");
			String pwriter = request.getParameter("pwriter");
			String pcontent = request.getParameter("pcontent");
			ProductDTO pdto = new ProductDTO(pno, category, pname, pcontent, pwriter, null);
			
			modify(pdto);
			request.setAttribute("pno", pno);
		}
	}
	
	@Override
	public void create(ProductDTO pdto) {
		pdao.insert(pdto);
	}

	@Override
	public List<ProductDTO> getList() {
		return pdao.getList();
	}

	@Override
	public ProductDTO getDetail(int pno) {
		return pdao.getDetail(pno);
	}

	@Override
	public void modify(ProductDTO pdto) {
		pdao.update(pdto);

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

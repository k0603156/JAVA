package service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

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
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			if(isMultipart) {
				ServletContext context = request.getServletContext();
				log.info(""+context);
				String saveDir = context.getRealPath("upload");
				log.info(saveDir);
				int maxSize = 2*1024*1024;
				String encoding="UTF-8";
				
				MultipartRequest multi;
				try {
					multi = new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());
					String category = multi.getParameter("category");
					String pname = multi.getParameter("pname");
					String pwriter = multi.getParameter("pwriter");
					String pcontent = multi.getParameter("pcontent");
					String imgfile = multi.getFilesystemName("imgfile");
					
					ProductDTO pdto = new ProductDTO(category, pname, pcontent, pwriter, imgfile);		
					create(pdto);
				
				} catch (IOException e) {
					log.info(">> Multipart fail");
					e.printStackTrace();
				}

			}
	
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

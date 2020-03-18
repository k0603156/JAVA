package ctrl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import service.ProductService;
import service.ProductServiceImpl;

@WebServlet("/product")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(ProductController.class);
	ProductService service;
	
    public ProductController() {
    	service = new ProductServiceImpl();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equals("pList")) {
			service.execute(request, response, action);
			RequestDispatcher dispatcher =request.getRequestDispatcher("index.jsp?pg=pList");
			dispatcher.forward(request,response);
			
		}else if(action.equals("pWrite")) {
			service.execute(request, response, action);
			RequestDispatcher dispatcher =request.getRequestDispatcher("product?action=pList");
			dispatcher.forward(request,response);
			
		}else if(action.equals("pDetail")) {
			service.execute(request, response, action);
			RequestDispatcher dispatcher =request.getRequestDispatcher("index.jsp?pg=pDetail");
			dispatcher.forward(request,response);
			
		}else if(action.equals("pModify")) {
			service.execute(request, response, action);
			RequestDispatcher dispatcher =request.getRequestDispatcher("index.jsp?pg=pModify");
			dispatcher.forward(request,response);
		}
		else if(action.equals("pModifySave")) {
			service.execute(request, response, action);
			RequestDispatcher dispatcher =request.getRequestDispatcher("product?action=pDetail");
			dispatcher.forward(request,response);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

}

package persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import orm.DBBuilder;

public class ProductDAOImpl implements ProductDAO {

	private static Logger log = LoggerFactory.getLogger(ProductDAOImpl.class);
	private SqlSession sql;
	private static String namespace="mapper.productMapper";
	
	public ProductDAOImpl() {
		new DBBuilder();
		sql=DBBuilder.getFactory().openSession();
	}
	
	@Override
	public void insert(ProductDTO pdto) {

	}

	@Override
	public List<ProductDTO> getList() {
		return null;
	}

	@Override
	public ProductDTO getDetail(int pno) {
		return null;
	}

	@Override
	public void update(ProductDTO pdto) {

	}

	@Override
	public void delete(int pno) {

	}

	@Override
	public void readCount(int pno) {

	}
}

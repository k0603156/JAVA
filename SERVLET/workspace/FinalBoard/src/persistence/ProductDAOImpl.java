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
		sql.insert(namespace+".padd", pdto);
		sql.commit();
	}

	@Override
	public List<ProductDTO> getList() {
		return sql.selectList(namespace+".plist");
	}

	@Override
	public ProductDTO getDetail(int pno) {
		return sql.selectOne(namespace+".pdetail", pno);
	}

	@Override
	public void update(ProductDTO pdto) {
		sql.update(namespace+".pupdate", pdto);
	}

	@Override
	public void delete(int pno) {

	}

	@Override
	public void readCount(int pno) {

	}
}

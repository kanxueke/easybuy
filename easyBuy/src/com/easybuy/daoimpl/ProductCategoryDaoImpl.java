package com.easybuy.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.easybuy.dao.BaseDao;
import com.easybuy.dao.ProductCategoryDao;

public class ProductCategoryDaoImpl extends BaseDao<String> implements
		ProductCategoryDao {

	@Override
	public List<String> findProductCategoryLevel1() {
		// TODO Auto-generated method stub
		String sql="select name from easybuy_product_category where type=1";
		List<String> names = super.executeQuery(sql, null);
		return null;
	}

	@Override
	public String getEntity(ResultSet rs) {
		// TODO Auto-generated method stub
		String name=null;
		if(rs!=null){
			try {
				if(rs.next()){
					 name = rs.getString("name");
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return name;
	}

}

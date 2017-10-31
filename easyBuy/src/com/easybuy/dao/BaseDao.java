package com.easybuy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.easybuy.utils.ConfigManager;

/**
 * 数据库连接与关闭工具
 * 
 * @author Administrator
 * 
 */
public abstract class BaseDao<T> {

	private static Logger logger = Logger.getLogger(BaseDao.class);

	/**
	 * 查中�?��用到的获得实体对象的方法，由具体的DaoImpl实现
	 * @param rs
	 * @return
	 */
	public abstract T getEntity(ResultSet rs);
	
	/**
	 * 获取数据库连接对�?
	 * @return 连接对象
	 */
	public Connection getConnection() {
		try {
			//加载驱动
			Class.forName(ConfigManager.getInstance().getString("jdbc.driver"));
			//获得连接
			return DriverManager.getConnection(ConfigManager.getInstance().getString("jdbc.url"),
					ConfigManager.getInstance().getString("jdbc.username"), 
					ConfigManager.getInstance().getString("jdbc.password"));
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			logger.error(e);
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e);
		}
		return null;
		/*Connection conn=null;
		try {
			Context context=new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/news");
			conn=ds.getConnection();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;*/
	}

	/**
	 * 关闭数据库所有连�?
	 */
	public void closeAllResource(Connection conn, Statement stmt, PreparedStatement ps,
			ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
				logger.error(e);
			}
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
				logger.error(e);
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
				logger.error(e);
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				logger.error(e);
			}
		}
	}

	/**
	 * 操作数据库的增删改方�?
	 * @param sql
	 * @param param
	 * @return 影响的行�?
	 */
	public int executeUpdate(String sql, Object[] params) {
		Connection conn = getConnection();
		PreparedStatement ps = null;
		try {
			//创建语句集对�?
			ps = conn.prepareStatement(sql);
			if (params != null && params.length > 0) {
				for (int i = 0; i < params.length; i++) {
					ps.setObject(i+1, params[i]);
				}
			}
			logger.debug(sql);
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e);
		} finally {
			this.closeAllResource(conn, null, ps, null);
		}
		return -1;
	}

	/**
	 * 查数据并显示的方�?
	 * @param sql
	 * @param params
	 * @return 对象集合
	 */
	public List<T> executeQuery(String sql, Object[] params){
		Connection conn = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<T> list = new ArrayList<T>();
		try {
			ps = conn.prepareStatement(sql);
			if (params!=null && params.length>0) {
				for (int i = 0; i < params.length; i++) {
					ps.setObject(i+1, params[i]);
				}
			}
			rs = ps.executeQuery();
			while(rs.next()){
				T t = getEntity(rs);
				list.add(t);
			}
			logger.debug(sql);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e);
		}finally{
			this.closeAllResource(conn, null, ps, rs);
		}
		return null;
	}
	
	
	public Integer executeQueryCount(String sql){
		Connection conn = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			rs = conn.prepareStatement(sql).executeQuery();
			logger.debug(sql);
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e);
		}finally{
			this.closeAllResource(conn, null, ps, rs);
		}
		return null;
	}
	
}

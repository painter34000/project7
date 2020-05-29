package co.yedam.project2.menu;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.project2.common.DAO;

public class MenuDAO extends DAO{
	
	private PreparedStatement psmt;
	private ResultSet rs;
	
	private final String menuList ="select * from menu order by mname desc";  //메뉴 보여주는 쿼리
	private final String insertMenu = "insert into menu(mname, mprice) values( ?, ?)";
	private final String menuSelect = "SELECT * FROM menu WHERE mName=?";
	private final String menuUpdate = "Update into memo(MNAME,MPRICE) Values(?,?);";
	private final String menuDelete = "DELETE FROM MEMO WHERE MNAME =?";
	
	public MenuDAO() {
		super();
	}
	
	public void menuUpdate() throws SQLException {
		MenuVO vo = new MenuVO();
		try {
			psmt = conn.prepareStatement(menuUpdate);
			
			psmt.setString(1, vo.getmName());
			psmt.setInt(2, vo.getmPrice());
			
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			conn.close();
		}
	}
	
	public void menuInsert(MenuVO vo) throws SQLException {//메뉴 넣기
		try {
			psmt = conn.prepareStatement(insertMenu);
			
			psmt.setString(1, vo.getmName());
			psmt.setInt(2, vo.getmPrice());
			
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			conn.close();
		}
	}//end of menuInsert
	
	public List<MenuVO> getList() {//메뉴 전체조회
		List<MenuVO> list = new ArrayList<MenuVO>();
		try {			
			psmt = conn.prepareStatement(menuList);
			rs = psmt.executeQuery();
			while(rs.next()) {
				MenuVO vo = new MenuVO();
				vo.setmName(rs.getString("mname"));
				vo.setmPrice(rs.getInt("mprice"));
				
				list.add(vo);
			}			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}//end of getList
	
	
	public MenuVO getMenu(String mName) throws SQLException {//메뉴 단건조회
		MenuVO vo = new MenuVO();
		try {
			psmt = conn.prepareStatement(menuSelect);
			psmt.setString(1, mName);
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setmName(rs.getString("mName"));
				vo.setmPrice(rs.getInt("mPrice"));				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			conn.close();
		}
		return vo;
		
	}

}

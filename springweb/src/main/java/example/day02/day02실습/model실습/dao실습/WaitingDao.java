package example.day02.day02실습.model실습.dao실습;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import example.day02.day02실습.model실습.dto실습.BaseDao;
import example.day02.day02실습.model실습.dto실습.WaitingDto;

public class WaitingDao extends BaseDao {
    
    private WaitingDao() {}
    private static final WaitingDao instance = new WaitingDao();
    public static WaitingDao getInstance() {return instance;}
    
    // [1] 대기 등록
    public boolean save(WaitingDto waitingDto) {
        try {String sql ="insert into waiting(phone, people_count) values(?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, waitingDto.getPhone());
            ps.setInt(2, waitingDto.getCount());

            int result = ps.executeUpdate();
            if(result == 1) {return true;}
        } catch(Exception e) {System.out.println("대기 등록 실패 : " + e);}
        return false;
    }

     // [2] 대기 전체조회
    public ArrayList<WaitingDto> findAll() {

        ArrayList<WaitingDto> list = new ArrayList<>();

        try {String sql = "select * from waiting";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                WaitingDto waitingDto = new WaitingDto();
                waitingDto.setW_No(rs.getInt("w_no"));
                waitingDto.setPhone(rs.getString("phone"));
                waitingDto.setCount(rs.getInt("people_count"));
                list.add(waitingDto);
            }
        } catch(Exception e) {
            System.out.println("대기 전체조회 오류 : " + e);
        }

        return list;
    }

        
    // [3] 개별수정 DAO
    public boolean update(WaitingDto waitingDto) {
        try {String sql = "update waiting set people_count = ? where phone = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, waitingDto.getCount());
            ps.setString(2, waitingDto.getPhone());
            int result = ps.executeUpdate();
            if(result == 1) return true;
        } catch(SQLException e) {System.out.println(e);}
        return false;
        }

    // [4] 개별삭제 DAO
    public boolean delete(String W_Pn) {
        try {String sql = "delete from waiting where phone = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, W_Pn);
            int result = ps.executeUpdate();
            if(result == 1) return true;
        } catch(SQLException e) {
            System.out.println(e);
            }
        return false;
        }

}

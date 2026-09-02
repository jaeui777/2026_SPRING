package example.day02.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import example.day02.model.dto.BoardDto;

public class BaseDao {
    // 여러개 DAO 클래스들에게 JDBC 연동 인스턴스 상속
    // 1. 연동 정보
    private String url = "jdbc:mysql://127.0.0.1:3306/mydb0826";
    private String user = "root";
    private String password = "1234";
    // 2. 연동 인터페이스 , protected: 상속관계이면 다른패키지도 접근허용
    protected Connection conn; 
    // 3. 연동 메소드
    private void connect( ){
        try{    // 3-1 : mysql Driver 클래스 로드 한다.
                Class.forName("com.mysql.cj.jdbc.Driver");
                // 3-2 : 데이터베이스 서버와 연동 후 성공하면 conn(인터페이스) 대입
                conn = DriverManager.getConnection(url, user, password );
        }catch( Exception e ){ System.out.println("DB연동실패" + e);}
    }
    // 4. 기본생성자에 연동메소드 실행 , BaseDao 클래스로부터 상속받은 DAO들은 자동 connect 
    protected BaseDao(){ connect(); }

        // [3] 개별수정 DAO
    public boolean update( BoardDto boardDto ){
        try{
            String sql = "update board set content = ? where no = ? ";// 1.1 SQL 작성
            PreparedStatement ps = conn.prepareStatement(sql); // 1.2 SQL 기재 *예외*
            ps.setString( 1 , boardDto.getContent() );// 1.3 SQL내 ? 매개변수대입
            ps.setInt( 2 , boardDto.getNo() );
            int result = ps.executeUpdate(); // 1.4 SQL 실행
            if( result == 1 ) return true; // 1.5 실행 결과 반환
        }catch( SQLException e ){ System.out.println( e ); }
        return false; // 1.5 실행 결과 반환
    }

    
 	
    // [4] 개별삭제 DAO 
    public boolean delete( int no ){
        try{ String sql = "delete from board where no = ?";
            PreparedStatement ps = conn.prepareStatement( sql );
            ps.setInt( 1 , no ); // SQL 문법내 첫번째 ? 에 매개변수 값 대입 
            int result = ps.executeUpdate();
            if( result == 1 ) return true;
        }catch( SQLException e ){ System.out.println( e ); }
        return false;
    }
} // class end 


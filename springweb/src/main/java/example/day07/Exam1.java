package example.day07;

public class Exam1 {
    public static void main(String[] args) {
        
        // 서로 다른 클래스의 메소드 호출 하는 방법
        // 메소드란? 상호작용( 2개 이상의 개체 주고(인수M)받는(리턴) )
        // 1. 인스턴스 생성하여 메소드 호출
        TestService testService = new TestService();
        int result1 = testService.plus( 3, 5);
        System.out.println(result1);
        // 2. 싱글톤

        // 3.

        // 4.











            
    } // main end
} // class end

class TestService {
    int plus( int x , int y ) {
        return  x + y;
    }
}

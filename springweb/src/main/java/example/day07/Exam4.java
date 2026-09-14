package example.day07;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Exam4 {
    public static void main(String[] args) {
        // 메소드 레퍼런스 : 람다식이 단순히 기존 메소드만 호출하는 경우 간결하게 표현하는 방법
        // 1. Integer.parseInt( "문자" ); //문자 --> 정수 변환 함수
        Function<String , Integer > function1 = ( x ) -> { return Integer.parseInt(x);};
        Function< String , Integer > function2 = Integer::parseInt;
        System.out.println(function2.apply("10")); // "10" -> 10
        // 2.
        List< String > names = List.of("유재석","강호동","신동엽","서장훈");
            // 1)
            for ( int index = 0; index <= names.size() - 1 ; index++) {System.out.println(names.get(index));}
            // 2)
            for ( String name : names) { System.out.println( name );}
            // 3) 
            names.stream().forEach((name) -> {System.out.println(name);});
            // 4) 메소드참조는 메소드명 명시하고 () 소괄호 작성하지 않는다.
            names.stream().forEach(System.out::println);
        // 3. 이르들의 글자수 출력하세요
            for( int index = 0; index <= names.size()-1 ; index++){

            }
        // 4. names 리스트내 문자열/이름들을 각각 대입하여 Student 객체 만드세요.
          // 전통방식
          List<Student> lst1 = new ArrayList<>();
          for( int index = 0 ; index<= names.size() - 1 ; index++) {
            Student student = new Student(names.get(index));
          }
          // 스트림 API
          List<Student> list2 = names.stream().map(name -> { return new Student(name); }).toList();
          //메소드참조(레퍼런스)
          List<Student> list3 = names.stream().map(Student::new).toList();
    } // main end
} // class end

class Student{
    private String name;
    public Student (String name) {this.name = name;}
}

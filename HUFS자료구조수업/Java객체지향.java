public class Java객체지향 {
    
}
//객체지향설계 방법
// 객체지향 개념을 기초로 잘 정의된 객체들을 먼저 식별한 후 이들이 상호 작용하게
//구현함으로써 원하는 결과를 생성하게 하는것
//객체지향 개념의 본질
//캡슐화
//  객체
//  public private protected
//상속
//  메소드 오버라이딩
//  코드의 재사용
//다형성
abstract public class Shape{
    private int x,y;
    private int width,height;
    public abstract void draw() {} //필수 구현
}
class Rectangle extends Shape {
    private int width;
    public void draw() {
        
    }
}



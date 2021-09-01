
//클래스와 객체
//Class - 객체에 대한 명세(변수와 메소드 포함)
//   캡슐화
//   정보은닉
//Object - 클래스의 인스턴스
class Point {
    public double x; //인스턴스 변수
    public void clear(){
        x=0;
    }
}
//자바에서 객체는 heap에 생성 메모리(heap)
Point point1 = new Point(); //여기서 실제로 2가지 경우가 일어남
Point point2 - new Point();
//1. 메모리에 객체 생성
//2. 생성된 객체의 변수를 초기화 하기 위해 생성자 호출
// 객체의 크기는 변수의 크기
//point1에는 이 객체의 주소를 가지고 있는 것
//method-전역변수 - static 
//stack-지역변수 - 메소드의 인자 , return address
//heap - 객체
Point point3 = point1;
point3 = point2;
if(point3 == point2){

}//true
//매개변수 전달
//파일이름이랑 main 클래스 이름이 달라서 static 붙여준거
public static class CallTest{
    public static void main(String[] args){
        CallTest test = new CallTest();
        test.callByValueTest();
    }
    void callByValueTest(){
        int i=99;
        
    }
    String name = "seoul";
    int len = name.length(); //5
    String sub = name.substring(2,4); //2~3 ou
     
}




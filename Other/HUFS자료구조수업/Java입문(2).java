//클래스 - 인터페이스+구현
//인터페이스 - 구현없이 선언만 해놓은 메소드들의 집합
public interface Comparable {
    int compareTo(Comparable x); //클래스가 구현해야 될 추상 메소드
}
public class Height implements Comparable{
    private int value;
    public Height(int x) {
        value = x;
    }
    public String toString() {
        return Integer.toString(value);
    }
    public int compareTo(Comparable x) {
        return value< ((Height)x).value ?-1 :
            value ==((Height)x).value?0:1;
    }
}
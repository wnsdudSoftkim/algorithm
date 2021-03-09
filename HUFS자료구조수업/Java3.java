//소프트웨어의 중요조건
//효율성
//정확성
// 요구분석 -> 시스템 명세 -> 설계 -> 구현 -> 테스트 -> 유지보수
//추상데이터 타입
// abstract
//알고리즘과 성능분석
// 알고리즘 = 특정 문제를 해결하기 위해 논리전ㄱ으로 기술한 일련의 명령문
// 프로그램 = 알고리즘을 컴퓨터가 이해하고 실행할 수 있는 특정 ㅇ프로그래밍 언어로 표현 한 것
//알고리즘의 요건
//  완전성과 명확성
//  입력과 출력
//  유한성
//알고리즘의 표현
// ADL(Algorithm Description Language)
// 알고리즘 기술을 위해 정의한 언어
//순환함수(재귀함수)recursion
//  분활 정복의 특성을 가진 문제에 적합
//  예)이원탐색
public static int binsearch(int[] a, int key, int left, int right){
    if(left<=right) {
        int mid = (left+right)/2;
        if(key==a[mid]) return mid;
        else if(key<a[mid]) return binsearch(a,key,left,mid-1);
        else return binsearch(a,key,mid+1,right)
    }
    return -1;
}
//프로그램 성능분석
// 공간복잡도 - 총 저장 공간
// 시간복잡도 - 시간
import java.util.*;
//첫번째 시도 (50/100)
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        String popAnswer = phone_book[0];
        for(int i=1; i<phone_book.length; i++) {
            String check = phone_book[i].substring(0,popAnswer.length());
            if(check.equals(popAnswer)) answer = false;
        }
        return answer;
    }
}
//다른사람 풀이
class Solution2 {
    public boolean solution(String[] phoneBook) {
       for(int i=0; i<phoneBook.length-1; i++) {
            for(int j=i+1; j<phoneBook.length; j++) {
                if(phoneBook[i].startsWith(phoneBook[j])) {return false;}
                if(phoneBook[j].startsWith(phoneBook[i])) {return false;}
            }
        }
        return true;
    }
}
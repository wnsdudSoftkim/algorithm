public class 보글문제 {
    static int dx[] = {-1,-1,-1,1,1,1,0,0};
    static int dy[] = {-1,0,1,-1,0,1,-1,1};
    static boolean boggle(int x, int y, String word) {
        //기저사례
        if(!inRange(x,y)) return false;
        if(board[x][y]!=word.charAt(0))
            return false;
        if (word.length()==1) return true;
        for(int direction = 0; direction<8; ++direction){
            int nextX = x+dx[direction] , nextY = y+dx[direction];
        }
    }
}

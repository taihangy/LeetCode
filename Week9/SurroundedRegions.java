public class Solution {
    private static int[] directionX={+1,-1,0,0};
    private static int[] directionY={0,0,+1,-1};
    
    public void solve(char[][] board) {
        if(board==null||board.length==0||board[0].length==0)
            return;
        int row=board.length;
        int col=board[0].length;
        for(int i=0;i<row;i++){
            bfs(board,i,0);
            bfs(board,i,col-1);
        }
        for(int j=0;j<col;j++){
            bfs(board,0,j);
            bfs(board,row-1,j);
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                switch(board[i][j]){
                    case 'O':
                        board[i][j]='X';
                        break;
                    case 'F':
                        board[i][j]='O';
                        break;
                }
            }
        }
    }
    
    private void bfs(char[][] board, int i,int j){
        if(board[i][j]=='X') return;
        
        LinkedList<Node> queue=new LinkedList<Node>();
        queue.offer(new Node(i,j));
        
        while(!queue.isEmpty()){
            Node cur=queue.poll();
            board[cur.i][cur.j]='F';
            for(Node node:expand(cur,board)){
                queue.offer(node);
            }
        }
    }
    
    static class Node{
            int i;
            int j;
            public Node(int i,int j){
                this.i=i;
                this.j=j;
            }
        }
    
    private List<Node> expand(Node cur,char[][] board){
        List<Node> expansion=new ArrayList<Node>();
        for(int i=0;i<directionX.length;i++){
            int x=cur.i+directionX[i];
            int y=cur.j+directionY[i];
            if(x>=0&&x<board.length&&y>=0&&y<board[0].length&&board[x][y]=='O'){
                board[x][y]='T';
                expansion.add(new Node(x,y));
            }
        }
        return expansion;
    }


    private int row;
    private int col;
    private char[][] board;
    private LinkedList<Integer> queue;
    
    public void solve(char[][] board){
        if(board==null||board.length==0||board[0].length==0)
            return;
        this.board=board;
        this.row=board.length;
        this.col=board[0].length;
        this.queue=new LinkedList<Integer>();
        
        for(int i=0;i<row;i++){
            enqueue(i,0);
            enqueue(i,col-1);
        }
        for(int j=1;j<col-1;j++){
            enqueue(0,j);
            enqueue(row-1,j);
        }
        
        while(!queue.isEmpty()){
            int cur=queue.poll();
            int x=cur/col;
            int y=cur%col;
            board[x][y]='D';
            enqueue(x+1,y);
            enqueue(x-1,y);
            enqueue(x,y+1);
            enqueue(x,y-1);
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]=='D') board[i][j]='O';
                else if(board[i][j]=='O') board[i][j]='X';
            }
        }
    }
    
    private void enqueue(int x,int y){
        if(x>=0&&x<row&&y>=0&&y<col&&board[x][y]=='O'){
            queue.offer(x*col+y);
        }
    }
}
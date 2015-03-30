public class WordSearch{
	public boolean exist(char[][] board,String word){
		if(board==null||board.length==0||board[0].length==0) return false;
		if(word==null||word.length()==0) return true;
		boolean[][] marked=new boolean[board.length][board[0].length];
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				if(search(board,word,marked,i,j,0)) 
					return true;
			}
		}
		return false;
	}
	public boolean search(char[][] board,String word,boolean[][] marked,int i,int j,int index){
		if(index==word.length()) return true;
		if(i<0||j<0||i>=board.length||
			j>=board[0].length||marked[i][j]||board[i][j]!=word.charAt(index))
			return false;
		marked[i][j]=true;
		boolean res=search(board,word,marked,i-1,j,index+1)||
					search(board,word,marked,i+1,j,index+1)||
					search(board,word,marked,i,j-1,index+1)||
					search(board,word,marked,i,j+1,index+1);
		marked[i][j]=false;
		return res;
	}
}
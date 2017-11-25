package edu.happpylearn.dp.findworkpath;
import java.util.Scanner;

/**
 * Find Working Path problem
 * @author hu.xu
 *
 */
public class WorkPathMain {
	
	int ROW;
	int COL;
	
	int map[][];
	int joy[][];
	int from[][];
	
	int LEFT= 1;
	int UP = 2;
	
	public WorkPathMain() {
	}
	
	
	public void inputDataInt(){
		Scanner sc = new Scanner(System.in);
		ROW = sc.nextInt();
		COL = sc.nextInt();
		
		map = new int[ROW][COL];
		joy = new int[ROW][COL];
		from = new int[ROW][COL];
		
		for(int row=0; row<ROW; row++){
			for(int col=0; col<COL; col++){
				map[row][col] = sc.nextInt();
			}
			
		}
		
		sc.close();
	}
	
	public void solve(){
		calcMaxJoy(ROW, COL);
		System.out.println(joy[ROW-1][COL-1]);
		printMaxJoyPath(ROW-1, COL-1);
	}
	
	/**
	 * Calc Joy along the path
	 * @param mRow
	 * @param mCol
	 */
	public void calcMaxJoy(int mRow, int mCol){
		
		for(int row=0; row<mRow; row++){
			for(int col=0; col<mCol; col++){
				if(row == 0 && col == 0){
					joy[row][col] = map[row][col];
				}else if(row==0 && col > 0){
					joy[row][col] = joy[row][col-1] + map[row][col];
					from[row][col]= LEFT;
				}else if(row>0 && col==0){
					joy[row][col] = joy[row-1][col] + map[row][col];
					from[row][col] = UP;
				}else{
					joy[row][col] = max(joy[row-1][col], joy[row][col-1])+map[row][col];
					if(joy[row-1][col] > joy[row][col-1]){
						from[row][col] = UP;
					}else{
						from[row][col] = LEFT;
					}
				}
			}
		}
		
	}
	/**
	 * Print the path which has maximum joy
	 * @param row
	 * @param col
	 */
	public void printMaxJoyPath(int row, int col){
		if(row==0 && col==0){
			return ;
		}
		
		if(from[row][col] == LEFT){
			printMaxJoyPath(row, col-1);
		}else{
			printMaxJoyPath(row-1, col);
		}
		System.out.print("("+row+", "+col+") ");
	}
	
	/**
	 * Return bigger number
	 * @param i
	 * @param j
	 * @return
	 */
	private int max(int i, int j) {
		if(i >= j){
			return i;
		}
		return j;
	}


	public static void main(String[] args) {
		WorkPathMain m = new WorkPathMain();		
		m.inputDataInt();	// get the data input
		m.solve();			// get solution
		
	}

}

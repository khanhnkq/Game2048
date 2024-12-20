package Game2048;

import java.util.Random;

public class quanlyData {
	public quanlyData() {
		taoSo();
	}
	
	Random random=new Random();
	
	public void taoSo() {
		
		int oTrong=0;
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				 if(Data.getData().arr[i][j]==0) {
					 oTrong++;
				 }
			}
		}
		
		if(oTrong>=2) {
			if(random.nextInt(10)>6) {
				oTrong=1;
			}
			else {
				oTrong=2;
			}
		}
		
		while(oTrong!=0) {
			int x=random.nextInt(4);
			int y=random.nextInt(4);
			
			while(Data.getData().arr[x][y]!=0) {
				x=random.nextInt(4);
				y=random.nextInt(4);
			}
			
			if(random.nextInt(10)>6) {
				Data.getData().arr[x][y]=4;
			}
			else {
				Data.getData().arr[x][y]=2;
			}
			oTrong--;
		}
	}
	
    public void moveLeft() {
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				if(Data.getData().arr[i][j]!=0) {
					donO(i, j, 0, -1);
				}
			}
		}
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				if(Data.getData().arr[i][j]!=0) {
					gopO(i, j, 0, 1);
				}
			}
		}
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				if(Data.getData().arr[i][j]!=0) {
					donO(i, j, 0, -1);
				}
			}
		}
		taoSo();
    }
    
    public void moveRight() {
    	for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				if(Data.getData().arr[i][j]!=0) {
					donO(i, j, 0, +1);
				}
			}
		}
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				if(Data.getData().arr[i][j]!=0) {
					gopO(i, j, 0, 1);
				}
			}
		}
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				if(Data.getData().arr[i][j]!=0) {
					donO(i, j, 0, +1);
				}
			}
		}
		taoSo();
    }
    
    public void moveUp() {
    	for(int i=3;i>=0;i--) {
			for(int j=0;j<4;j++) {
				if(Data.getData().arr[i][j]!=0) {
					donO(i, j, -1, 0);
				}
			}
		}
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				if(Data.getData().arr[i][j]!=0) {
					gopO(i, j, -1, 0);
				}
			}
		}
		for(int i=3;i>=0;i--) {
			for(int j=0;j<4;j++) {
				if(Data.getData().arr[i][j]!=0) {
					donO(i, j, -1, 0);
				}
			}
		}
		taoSo();
    }
    
    public void moveDown() {
    	for(int i=3;i>=0;i--) {
			for(int j=0;j<4;j++) {
				if(Data.getData().arr[i][j]!=0) {
					donO(i, j, +1, 0);
				}
			}
		}
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				if(Data.getData().arr[i][j]!=0) {
					gopO(i, j, -1, 0);
				}
			}
		}
		for(int i=3;i>=0;i--) {
			for(int j=0;j<4;j++) {
				if(Data.getData().arr[i][j]!=0) {
					donO(i, j, +1, 0);
				}
			}
		}
		taoSo();
    }
    
    private void donO(int i, int j, int it, int jt) {
    	if(i==0&&it==-1) {
    		return;
    	}
    	if(i==3&&it==1) {
    		return;
    	}
    	if(j==0&&jt==-1) {
    		return;
    	}
    	if(j==3&&jt==1) {
    		return;
    	}
    	
    	int x=i+it;
    	int y=j+jt;
    	
    	if(Data.getData().arr[x][y]!=0) {
    		return;
    	}
    	
    	int k = Data.getData().arr[i][j];
    	Data.getData().arr[x][y]=k;
    	Data.getData().arr[i][j]=0;
    	donO(x,y ,it,jt);
    }
    
    private void gopO(int i, int j, int it, int jt) {
    	if(i==0&&it==-1) {
    		return;
    	}
    	if(i==3&&it==1) {
    		return;
    	}
    	if(j==0&&jt==-1) {
    		return;
    	}
    	if(j==3&&jt==1) {
    		return;
    	}
    	
    	int x=i+it;
    	int y=j+jt;
    	
    	if(Data.getData().arr[x][y]!=Data.getData().arr[i][j]) {
    		return;
    	}
    	
    	int k = Data.getData().arr[i][j]*2;
    	Data.getData().arr[x][y]=0;
    	Data.getData().arr[i][j]=k;
    	donO(x,y ,it,jt);
    }
}

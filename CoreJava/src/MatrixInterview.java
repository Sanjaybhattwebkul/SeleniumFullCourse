
public class MatrixInterview {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* 2 4 5
		   3 2 10
		   1 2 0   */
		int abc[][]={‌{2,4,5},{3,2,10},{1,2,0}};
		int min=abc[0][0];
		int mincoloumn = 0;


		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(abc[i][j]<min)//2
				{
					min=abc[i][j];
					mincoloumn=j;
				}
			}
		}
		System.out.println(min); // minumum numberof 3*3 Matrix
		//=1
		int max=abc[0][mincoloumn];
		int k = 0;
		while(k<3)
		{
			if(abc[k][mincoloumn]>max)
			{
				max=abc[k][mincoloumn];
			}
			k++;
		}

		System.out.println(max);  // Maximun numberof of that column in which the minimum number of matrix
	}

}


import java.io.*;
import java.util.*;
public class Solution {
   
    static void printGrid(int grid[][],int n,int m)
    {
        for(int i=0;i<n;i++)
         {for(int j=0;j<m;j++)
            System.out.print(grid[i][j]);
         
          System.out.println();
         }
        System.out.println();
    }
   
   
    // Function to print next generation
static void nextTick(int grid[][], int M, int N)
{
int[][] future = new int[M][N];
       
// Loop through every cell
for (int l = 0; l < M ; l++)
{
for (int m = 0; m < N ; m++)
{
// finding no Of Neighbours that are alive
int aliveNeighbours = 0;
for (int i = -1; i <= 1; i++)
for (int j = -1; j <= 1; j++)
  if(l+i >=0 && l+i <M && m+j >=0 && m+j<N)
aliveNeighbours += grid[l + i][m + j];

// The cell needs to be subtracted from
// its neighbours as it was counted before
aliveNeighbours -= grid[l][m];

// Implementing the Rules of Life

// Cell is lonely and dies
if ((grid[l][m] == 1) && (aliveNeighbours < 2))
future[l][m] = 0;

// Cell dies due to over population
else if ((grid[l][m] == 1) && (aliveNeighbours > 3))
future[l][m] = 0;

// A new cell is born
else if ((grid[l][m] == 0) && (aliveNeighbours == 3))
future[l][m] = 1;

// Remains the same
else
future[l][m] = grid[l][m];
}
}


   //Next Generation
// printGrid(future,N,M);
    for (int i = 0; i < M; i++)
          {
            for (int j = 0; j < N; j++)
            {
                if(future[i][j]==1)
                System.out.print(i + " " + j + "\n");
            }
      }
}
   
public static void main (String[] args) {
int M = 10, N = 10;

int grid[][] = new int[10][10];
Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of Cordinates");
        int n = sc.nextInt();
       
        for(int i=0;i<n;i++)
            {
                int x = sc.nextInt(),y=sc.nextInt();
                grid[x][y]=1;
            }
// printGrid(grid,N,M);
nextTick(grid, M, N);
}
}
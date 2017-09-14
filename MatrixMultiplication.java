import java.util.Scanner;
import java.util.Random;

class MatrixMultiplication
{
   public static void main(String args[])
   {
      int m, n, p, q, sum = 0, c, d, k ;
      Random r = new Random();

      Scanner in = new Scanner(System.in);
      System.out.println("*** Minimum dimension of Matrix must be 25 ***");
      System.out.println("Enter the number of rows and columns of first matrix");
      m = in.nextInt();
      n = in.nextInt();
      int Low = 0;
      int High = 30;

      int first[][] = new int[m][n];

      for ( c = 0 ; c < m ; c++ )
         for ( d = 0 ; d < n ; d++ )
            first[c][d] = r.nextInt(High-Low) + Low;

      System.out.println("Enter the number of rows and columns of second matrix");
      p = in.nextInt();
      q = in.nextInt();

      if ( n != p )
         System.out.println("Matrices with entered orders can't be multiplied with each other.");
      else
      {
         int second[][] = new int[p][q];
         int multiply[][] = new int[m][q];

         for ( c = 0 ; c < p ; c++ )
            for ( d = 0 ; d < q ; d++ )
               second[c][d] = r.nextInt(High-Low) + Low;

         long startTime = System.currentTimeMillis();

         for ( c = 0 ; c < m ; c++ )
         {
            for ( d = 0 ; d < q ; d++ )
            {
               for ( k = 0 ; k < p ; k++ )
               {
                  sum = sum + first[c][k]*second[k][d];
               }

               multiply[c][d] = sum;
               sum = 0;
            }
         }
         long elapsedTime = System.currentTimeMillis() - startTime;
         System.out.println("Product of matrices: ");

         for ( c = 0 ; c < m ; c++ )
         {
            for ( d = 0 ; d < q ; d++ )
               System.out.print(multiply[c][d]+"\t");

            System.out.print("\n");
         }

         System.out.println("Time in ms elapsed for matrix mulitplication: " + elapsedTime);


         if ( m != p && n !=q)
            System.out.println("Matrices with entered orders can't be added with each other.");
         else
         {
            int tot [][]= new int[m][n];
            long start = System.nanoTime();
            for ( c = 0 ; c < m ; c++ )
               for ( d = 0 ; d < n ; d++ )
                  tot[c][d] = first[c][d] + second[c][d];

            long elapsed = System.nanoTime() - start;

            System.out.println("Sum of entered matrices:-");

            for ( c = 0 ; c < m ; c++ )
            {
               for ( d = 0 ; d < n ; d++ )
               System.out.print(tot[c][d]+"\t");
               System.out.println();
            }  
            System.out.println("Time in ns elapsed for matrix addition: " + elapsed);

         }
      }
   }
}

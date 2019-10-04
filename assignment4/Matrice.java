package assignment4;

public class Matrice {

    public static void main(String[] args){
        int[][] A = new int[][]{{1,0,0},{-1,0,3}};
        int[][] B = new int[][]{{7,0,0},{0,0,0},{0,0,1}};

        Matrice test = new Matrice();
        int[][] c = test.matriceMultiple(A,B);
        for(int i = 0; i< c.length; i++){
            for(int j = 0; j< c[i].length; j++){
                System.out.print(c[i][j]);
            }
        }

    }

    public int[][] matriceMultiple(int a[][], int b[][]){

        int x = a.length;
        int y = b[0].length;
        int[][] c = new int[x][y];
        for(int i = 0; i< a.length; i++){
            for(int j = 0; j< b[0].length; j++){
                for(int k = 0; k< b.length; k++){
                    c[i][j] += a[i][k] *b[k][j];
                }

            }
        }
        return c;

    }

}

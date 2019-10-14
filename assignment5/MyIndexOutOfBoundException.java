package assignment5;

public class MyIndexOutOfBoundException {
    private int index = 0;
    private int lowerBound = 0;
    private int upperBound = 9;

    public void MyIndexOutOfBoundException(int index){
        this.index = index;
        if(this.index > this.upperBound || this.index < this.lowerBound)
            throw new IndexOutOfBoundException();
        else{
            System.out.println("the index is : " + this.index);
        }

    }

    public static void main(String args[]){
        MyIndexOutOfBoundException test = new MyIndexOutOfBoundException();
        int index = 0;


        try{
            for(int i = 0; i< 10; i++){
                index++;
                test.MyIndexOutOfBoundException(index);
            }

        }catch(IndexOutOfBoundException ie){
            System.out.println("Error Message: Index: " + index +", but Lower bound: 0, Upper bound: 9 ");
        }


    }

}

class IndexOutOfBoundException extends IllegalArgumentException{

}

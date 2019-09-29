package assignment3;


public class Zigzag {
    public String convert(String s, int numRows){
        if(numRows <=1 || s ==null)
            return s;

        StringBuilder sb = new StringBuilder();
        int len = s.length();

        for(int i = 0; i< numRows; i++){      //read the rows
            int index = i;
            sb.append(s.charAt(index));
            for(int k = 1; index < len; k++){
                if(i ==0 || i == numRows -1){    //the first or last row
                    index += 2 * numRows - 2;
                }
                else{
                    if((k & 0x1) == 1){
                        index += 2 * (numRows - 1 - i);
                    }
                    else
                        index += 2 * i;
                }
                if(index < len)
                    sb.append(s.charAt(index));
            }

        }
        String result = sb.toString();
        return result;
    }

    public static void main(String[] args){
        Zigzag test = new Zigzag();
        System.out.println( test.convert("PAYPALISHIRING",4));

    }
}

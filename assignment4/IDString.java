package assignment4;

public class IDString {

    public int[] IDstring(String s){
        int n = s.length();
        int i = 0;
        int d = n;

        if(s.length()<1 || s.length()>10000){
            return null;
        }

        int[] id = new int[s.length()+1];
        for(int j = 0; j< s.length();j++){
            if(s.charAt(j) == 'I'){
                id[j] = i++;
            }
            else if(s.charAt(j) == 'D'){
                id[j] = d--;
            }
        }
        id[n] = i;
        return id;

    }

    public static void main(String[] args){
        IDString test = new IDString();
        int[] id = test.IDstring("IDID");
        for(int k = 0; k< id.length-1; k++){
            System.out.print(id[k] + ",");
        }
        System.out.println(id[id.length-1]);
    }
}

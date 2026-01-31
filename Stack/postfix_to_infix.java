// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class Main {
    public static boolean isoperator(char ch){
        return ch=='+'||ch=='-'||ch=='/'||ch=='*'||ch=='^';
    }
    public static String posttoinfix(String s){
        Stack<String>st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                st.push(ch+"");
            }
            else if(isoperator(ch)){
               String op2=st.pop();
               String op1=st.pop();
               String result="("+op1+ch+op2+")";
                st.push(result);
            }
        }
        return st.peek();
    }
    public static void main(String[] args) {
        String s="abc*+";
        
        System.out.println(posttoinfix(s));
    }
}

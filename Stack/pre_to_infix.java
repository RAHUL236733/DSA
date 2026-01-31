import java.util.*;
class Main {
    public static boolean operator(char c){
        return (c=='+' || c=='-' || c=='*' || c=='/' || c=='^');
    }
    public static String prefixToInfix(String exp){
        Stack<String>st=new Stack<>();
        for(int i=exp.length()-1;i>=0;i--){
            char ch=exp.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                st.push(ch+"");
            }
            else if(operator(ch)){
                String op1=st.pop();
                String op2=st.pop();
                st.push("("+op1+ch+op2+")");
            }
        }
        return st.peek();
    }
    public static void main(String[] args) {
        String exp="*+ab-cd";
        System.out.println(prefixToInfix(exp));
    }
}
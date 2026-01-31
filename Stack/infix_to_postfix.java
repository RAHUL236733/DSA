import java.util.*;
class Main {
    static int precedence(char ch){
        if(ch=='+'|| ch=='-'){
            return 1;
        }
        if(ch=='*' || ch=='/'){
            return 2;
        }
        if(ch=='^'){
            return 3;
        }
        return -1;
    }
    public static String convert(String exp){
        Stack<Character>st=new Stack<>();
        String result="";
        for(int i=0;i<exp.length();i++){
            char ch=exp.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                result=result+ch;
            }
            else if(ch=='('){
                st.push(ch);
            }
            else if(ch==')'){
                while(!st.isEmpty() && st.peek() != '('){
                    result=result+st.pop();
                }
                st.pop();
            }
            else{
                while(!st.isEmpty() && precedence(ch)<=precedence(st.peek())){
                    result=result+st.pop();
                }
                st.push(ch);
            }
        }
            while(!st.isEmpty()){
                result=result+st.pop();
            }
            return result;
        }
    public static void main(String[] args) {
        String expression="k+L-M*N+(O^P)*W/U/V*T+Q";
        System.out.print(convert(expression));
    }
}
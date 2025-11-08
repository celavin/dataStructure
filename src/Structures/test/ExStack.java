package Structures.test;

public class ExStack {
    public static void main(String[] args) {


    }
    static boolean isValid(String s){
        MyArrayStack stack = new MyArrayStack();
        for (char c : s.toCharArray()) {
            if(c =='('||c=='{'||c=='['){
                stack.push(1);
            } else if (c ==')'||c=='}'||c==']') {
                if(stack.top == -1){
                    return false;
                }
                stack.pop();
            }
        }
        if(stack.top!=-1){
            return false;
        }
        return true;
    }
}

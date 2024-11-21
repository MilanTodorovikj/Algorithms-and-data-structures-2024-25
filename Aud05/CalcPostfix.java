package Aud05;
public class CalcPostfix {
    public static Double evaluiraj_postfix(String izraz) {
        LinkedStack<Double> stack = new LinkedStack<>();
        Double r = null;
        for (int i = 0; i < izraz.length(); i++) {
            char c = izraz.charAt(i);
            if (c == ' ') continue;
            else if (Character.isDigit(c)) {
//                stack.push(c);
//                stack.push(Character.digit(c, 10));
                stack.push((double) c - '0');
            } else {
//                6 2 - => 6-2
//                5 2 / => 2
                System.out.println("Pred promenata (top first):" + stack + " operator:" + c);
                if (stack.size() >= 2) {
                    Double posleden_broj = stack.pop();
                    Double pretposleden_broj = stack.pop();
                    switch (c) {
                        case '+':
                            stack.push(pretposleden_broj + posleden_broj);
                            break;
                        case '*':
                            stack.push(pretposleden_broj * posleden_broj);
                            break;
                        case 'x':
                            stack.push(pretposleden_broj * posleden_broj);
                            break;
                        case '-':
                            stack.push(pretposleden_broj - posleden_broj);
                            break;
                        case '/':
                            stack.push(pretposleden_broj / posleden_broj);
                            break;
                    }
                    System.out.println("Po promenata (top first):" + stack);
                } else {
                    System.out.println("Nevaliden vlez - nedostasuva operand na pozicija:" + i);
                    return r;
                }
            }
        }
        if (stack.size() != 1) {
            System.out.println("Nevaliden vlez - nedostasuva operator");
        } else {
            r = stack.pop();
        }
        return r;
    }

    public static void main(String[] args) {
        String primer = "5  9 + 2 * 6 5 * +";
        System.out.println("rezultatot e " + evaluiraj_postfix(primer));
    }

}

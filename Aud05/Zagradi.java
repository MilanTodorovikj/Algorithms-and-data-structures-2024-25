package Aud05;
public class Zagradi {
    public static boolean daliKorektni(String phrase) {
        // Test whether phrase is well-bracketed.
        ArrayStack<Character> bracketStack = new ArrayStack<Character>(100);
        for (int i = 0; i < phrase.length(); i++) {
            char cur = phrase.charAt(i);
            if (cur == '(' || cur == '[' || cur == '{')
                bracketStack.push(cur);
            else if (cur == ')' || cur == ']' || cur == '}') {
                if (bracketStack.isEmpty()) return false;
                char left = bracketStack.pop();
                if (!daliSoodvetni(left, cur)) return false;
            }
        }
        return (bracketStack.isEmpty());
    }

    public static boolean daliZagraditeSePravilni(String izraz) {
        LinkedStack<Character> stack = new LinkedStack<>();
        for (int i = 0; i < izraz.length(); i++) {
            char c = izraz.charAt(i);
            if (c == ' ') continue;
            if ((c == '(') || (c == '{') || (c == '[')) {
                stack.push(c);
            } else if ((c == ')') || (c == '}') || (c == ']')) {
                if (stack.isEmpty()) return false;
                char t = stack.pop();
                if (!((t == '{' && c == '}') || (t == '[' && c == ']') || (t == '(' && c == ')'))) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static boolean daliSoodvetni(char left, char right) {
        // Test whether left and right are matching brackets
        // (assuming that left is a left bracket and right is a right bracket).
        switch (left) {
            case '(':
                return (right == ')');
            case '[':
                return (right == ']');
            case '{':
                return (right == '}');
        }
        return false;
    }



    public static void main(String[] args) {
        String phrase = "s x (s - a) x (s - b) x (s - c)";
//        String phrase = "s x (s - a) x s - b) x (s - c)";
        System.out.println(phrase + " ima "
                + (daliZagraditeSePravilni(phrase) ? "korektni" : "nekorektni")
                + " zagradi.");
    }

}

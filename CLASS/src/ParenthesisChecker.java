public class ParenthesisChecker {
    char[] openParenthesis = { '<', '(', '{', '[' };
    char[] closeParenthesis = { '>', ')', '}', ']' };
    CharArrayStack stack;

    public ParenthesisChecker() {
        stack = new CharArrayStack(100);
    }

    public ParenthesisChecker(char[] open, char[] close) {
        this.openParenthesis = open;
        this.closeParenthesis = close;
        stack = new CharArrayStack(100);
    }

    public boolean isParenthesis(char c) {
        boolean isParen = false;

        for (int i = 0; i < openParenthesis.length; i++) {
            if (c == openParenthesis[i]) {
                return isParen = true;
            }
        }
        for (int i = 0; i < closeParenthesis.length; i++) {
            if (c == closeParenthesis[i]) {
                return isParen = true;
            }
        }

        return isParen;
    }

    public boolean isOpen(char c) {
        boolean open = false;

        for (int i = 0; i < openParenthesis.length; i++) {
            if (c == openParenthesis[i]) {
                return open = true;
            }
        }

        return open;
    }

    public boolean isClose(char c) {
        boolean close = false;

        for (int i = 0; i < closeParenthesis.length; i++) {
            if (c == closeParenthesis[i]) {
                return close = true;
            }
        }

        return close;
    }

    public boolean isMatch(char c1, char c2) {
        int openIdx = 0, closeIdx = 0;

        if (!isOpen(c1))
            return false;
        if (!isClose(c2))
            return false;

        for (int i = 0; i < openParenthesis.length; i++) {
            if (c1 == openParenthesis[i]) {
                openIdx = i;
                break;
            }
        }

        for (int i = 0; i < closeParenthesis.length; i++) {
            if (c2 == closeParenthesis[i]) {
                closeIdx = i;
                break;
            }
        }

        return (openIdx == closeIdx) ? true : false;
    }

    public boolean validate(String expression) {
        stack.clear();

        for (int i = 0; i < expression.length(); i++) {
            char test = expression.charAt(i);

            if (!isParenthesis(test))
                continue;
            if (isOpen(test)) {
                stack.push(test);
            } else {
                char last = stack.pop();
                if (!isMatch(last, test))
                    return false;
            }
        }

        return stack.isEmpty();
    }

    public void print(String expression, boolean match) {
        if (match) {
            System.out.println(expression + ": OK");
        } else {
            System.out.println(expression + ": ERROR");
        }
    }

    public static void main(String[] args) {
        ParenthesisChecker pc = new ParenthesisChecker();
        String[] testcases = { "(1+2)", "2+(2+[3+<4*5>]-9)/2", "(3+(3+(4+5]))", "(4*[1+(3-5]))", "5+(5+6*7+(9+[2/5])" };

        for (int i = 0; i < testcases.length; i++) {
            pc.print(testcases[i], pc.validate(testcases[i]));
        }
    }
}

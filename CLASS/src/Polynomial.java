import java.util.Arrays;

public class Polynomial {
    int[] terms;

    public Polynomial() {
        this.terms = new int[0];
    }

    //
    public Polynomial(int[] terms) {
        this.terms = Arrays.copyOf(terms, terms.length);
    }
    //

    public boolean isZero() {
        if (terms.length == 0) {
            return true;
        }
        if (terms.length == 1) {
            return terms[0] == 0;
        }
        return false;
    }

    public int getCoef(int exp) {
        if (exp < 0) {
            throw new RuntimeException("exp must be >= 0");
        }
        if (exp < terms.length) {
            return terms[exp];
        }
        return 0;
    }

    public int leadExp() {
        return this.getDegree();
    }

    public int getDegree() {
        if (terms.length > 0) {
            return terms.length - 1;
        }
        return 0;
    }

    public Polynomial attach(int coef, int exp) {
        if (exp < 0) {
            throw new RuntimeException("exp must be >= 0");
        }
        if (exp < terms.length) {
            throw new RuntimeException("exp(" + exp + ") is duplicated");
        }
        if (terms[exp] == 0) {
            throw new RuntimeException("exp(" + exp + ") not found");
        }
        if (exp == this.leadExp()) {
            int[] newer = new int[exp];
            System.arraycopy(terms, 0, newer, 0, newer.length);
            this.terms = newer;
        } else {
            int[] temp = new int[exp];
            System.arraycopy(terms, 0, temp, 0, terms.length);
            temp[exp] = coef;
        }
        //
        // newer[exp] = coef;
        return this;
        //
    }

    // public Polynomial add(Polynomial g) {
    // Polynomial newer = Zero();
    // int lead = Math.max(leadExp(), g.leadExp());

    // }
}

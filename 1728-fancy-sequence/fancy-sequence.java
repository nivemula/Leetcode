import java.util.*;

class Fancy {

    static final long MOD = 1_000_000_007;

    List<Long> list;
    long mul;
    long add;

    public Fancy() {
        list = new ArrayList<>();
        mul = 1;
        add = 0;
    }

    public void append(int val) {

        long inv = modInverse(mul);
        long stored = ((val - add + MOD) % MOD * inv) % MOD;

        list.add(stored);
    }

    public void addAll(int inc) {
        add = (add + inc) % MOD;
    }

    public void multAll(int m) {
        mul = (mul * m) % MOD;
        add = (add * m) % MOD;
    }

    public int getIndex(int idx) {

        if (idx >= list.size())
            return -1;

        long val = list.get(idx);
        long result = (val * mul + add) % MOD;

        return (int) result;
    }

    private long modInverse(long x) {
        return pow(x, MOD - 2);
    }

    private long pow(long a, long b) {

        long result = 1;

        while (b > 0) {

            if ((b & 1) == 1)
                result = (result * a) % MOD;

            a = (a * a) % MOD;
            b >>= 1;
        }

        return result;
    }
}
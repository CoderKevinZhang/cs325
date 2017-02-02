
public class Pair<L,R>
{
    private L l;
    private R r;

    public Pair(L l, R r)
    {
        this.l = l;
        this.r = r;
    }

    public L getL() { return l; }

    public R getR() { return r; }

    public void setL(L l) { this.l = l; }

    public void setR(R r) { this.r = r; }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        } else if(obj instanceof Pair<?,?>) {
            Pair<?, ?> pair = (Pair<?, ?>) obj;
            if((pair.getL().equals(this.getL()) && pair.getR().equals(this.getR()))
                || (pair.getL().equals(this.getR()) && pair.getR().equals(this.getL())))
                return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        // cache
        int leftHash = this.getL().hashCode();
        int rightHash = this.getR().hashCode();

        int k1 = Math.max(leftHash, rightHash);
        int k2 = Math.min(leftHash, rightHash);

        // Canton pairing function
        return (int) (0.5 * (k1 + k2) * (k1 + k2 + 1) + k2);
    }

    @Override
    public String toString()
    {
        return this.l + " " + this.r;
    }
}

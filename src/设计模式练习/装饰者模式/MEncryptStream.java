package 设计模式练习.装饰者模式;

/**
 * @author xt
 * @version 1.0
 * @date 2020/10/5 23:08
 */
public class MEncryptStream extends MStream {
    MStream mStream;

    public MEncryptStream(MStream mStream) {
        this.mStream = mStream;
    }

    @Override
    public void Read() {
        mStream.Read();
        System.out.println("Encrypt read");
    }

    @Override
    public void Write() {
        mStream.Write();
        System.out.println("Encrypt Write");
    }

    @Override
    public void skip(int where) {
        mStream.skip(where);
        System.out.println("Encrypt skip");
    }
}

package 设计模式练习.装饰者模式;

/**
 * @author xt
 * @version 1.0
 * @date 2020/10/5 23:01
 */
public class MFileStream extends MStream {
    MStream mStream;

    public MFileStream(MStream mStream) {
        this.mStream = mStream;
    }

    @Override
    public void Read() {
        mStream.Read();
        System.out.println("net read");
    }

    @Override
    public void Write() {
        mStream.Write();
        System.out.println("net write");
    }

    @Override
    public void skip(int where) {
        mStream.skip(where);
        System.out.println("net skip" + where);
    }
}

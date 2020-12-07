package 设计模式练习.装饰者模式;

/**
 * @author xt
 * @version 1.0
 * @date 2020/10/5 23:02
 */
public class MNetStream extends MStream {
    MStream mStream;

    public MNetStream(MStream mStream) {
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

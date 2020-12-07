package 设计模式练习.装饰者模式;

/**
 * @author xt
 * @version 1.0
 * @date 2020/10/5 23:04
 */
public class MBufferStream extends MStream {
    MStream mStream;

    public MBufferStream(MStream mStream) {
        this.mStream = mStream;
    }

    @Override
    public void Read() {
        mStream.Read();
        System.out.println("buffer");
    }

    @Override
    public void Write() {
        mStream.Write();
        System.out.println("buffer");
    }

    @Override
    public void skip(int where) {
        mStream.skip(where);
        System.out.println("buffer");
    }
}

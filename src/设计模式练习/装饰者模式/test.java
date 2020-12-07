package 设计模式练习.装饰者模式;

/**
 * @author xt
 * @version 1.0
 * @date 2020/10/5 23:14
 */
public class test {
    public static void main(String[] args) {
        MFileStream fileStream = new MFileStream(new MStream() {
            @Override
            public void Read() {
                System.out.println("base read");
            }

            @Override
            public void Write() {
                System.out.println("base Write");
            }

            @Override
            public void skip(int where) {
                System.out.println("base skip");
            }
        });
        MBufferStream bufferStream = new MBufferStream(fileStream);
        MEncryptStream mEncryptStream = new MEncryptStream(bufferStream);
        mEncryptStream.Read();
        mEncryptStream.Write();
        mEncryptStream.skip(11);
    }
}

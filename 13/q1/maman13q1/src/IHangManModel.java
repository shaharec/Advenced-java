import java.io.FileNotFoundException;

public interface IHangManModel {
    void handelLetter(char c);

    int getLifes();

    void reset() throws FileNotFoundException;

    String getGuss();
}

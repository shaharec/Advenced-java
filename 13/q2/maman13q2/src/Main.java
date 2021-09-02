import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        ITriviaModel model = new TriviaModel();
        ITriviaView view = new TriviaView(model);
        ITriviaController controller = new TriviaController(model,view);
    }
}

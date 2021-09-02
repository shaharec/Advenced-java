import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {


        IHangManModel model = new HangManModel();
        IHangManView view = new HangManView(model);
        IHangManController controller = new HangManController(model,view);
    }
}

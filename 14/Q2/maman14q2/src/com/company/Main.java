package com.company;

public class Main {

    public static void main(String[] args) {

        IModel model = new Model();
        IView view = new View(model);
        Controller controller = new Controller(model,view);

    }
}

package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    private Controller controller;

    @Override
    public void start(Stage primaryStage) throws Exception {
        //GridPane root = FXMLLoader.load(getClass().getResource("game.fxml"));
        FXMLLoader loader=new FXMLLoader(getClass().getResource("game.fxml"));
        GridPane rootGridPane = loader.load();
        controller = loader.getController();
        controller.createPlayground();

        primaryStage.setTitle("Connect Four");
        primaryStage.setScene(new Scene(rootGridPane));
        primaryStage.setResizable(false);

        primaryStage.show();

        MenuBar menuBar = createMenu();
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());

        Pane menuPane = (Pane) rootGridPane.getChildren().get(0);
        menuPane.getChildren().add(menuBar);


    }

    public MenuBar createMenu() {
        //File Menu
        Menu fileMenu = new Menu("File");
        MenuItem newGame = new MenuItem("New Game");

        newGame.setOnAction(actionEvent -> controller.resetGame());  //Creating the Action Listener on NewGame.

        MenuItem resetGame = new MenuItem("Reset Game");

        resetGame.setOnAction(actionEvent -> controller.resetGame());  //Creating the Action Listener on ResetGame.

        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
        MenuItem exit = new MenuItem("Exit");

        exit.setOnAction(actionEvent -> exitGame());  //Creating the Action Listener on ExitGame.

        //Adding menu item to file menu
        fileMenu.getItems().addAll(newGame, resetGame, separatorMenuItem, exit);

        //Help Menu
        Menu helpMenu = new Menu("Help");
        MenuItem aboutGame = new MenuItem("About Connect4");

        aboutGame.setOnAction(actionEvent -> aboutConnect4Game());    //Creating the Action Listener on AboutGame.

        MenuItem aboutMe = new MenuItem("About Me");

        aboutMe.setOnAction(actionEvent -> aboutDeveloper());

        //Adding menu item to help menu.
        helpMenu.getItems().addAll(aboutGame, separatorMenuItem, aboutMe);

        //Menu Bar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, helpMenu);

        return menuBar;
    }

    private void aboutDeveloper() {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Me");
        alert.setHeaderText("Abhinandan Karmakar");
        alert.setContentText("I Love to play with code");
        alert.show();
    }

    private void aboutConnect4Game() {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Connect4 Game");
        alert.setHeaderText("How to Play");
        alert.setContentText("Connect Four is a two-player connection game in which the\n" +
                             "players first choose a color and then take turns dropping\n" +
                             "colored discs from the top into a seven-column, six-row \n" +
                             "vertically suspended grid. The pieces fall straight down,\n " +
                             "occupying the next available space within the column. The\n" +
                             "objective of the game is to be the first to form a horizontal,\n" +
                             "vertical, or diagonal line of four of one's own discs. Connect\n" +
                             "Four is a solved game. The first player can always win by playing\n" +
                             "the right moves.");
        alert.show();
    }

    private void exitGame() {
        Platform.exit();
        System.exit(0);
    }




    public static void main(String[] args) {

        launch(args);
    }
}

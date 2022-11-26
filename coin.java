import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.nio.file.Files;
import java.util.Random;

public class coin extends Application {
    static String timesAll;
    static String timesA;
    static String timesB;
    static int time;
    static int[] data;
    public static void main(String[] args) {
        //coinThrower(10000);
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Button start = new Button("开始");
        Button output = new Button("导出");
        TextField textField = new TextField();
        textField.setTooltip(new Tooltip("要抛的次数"));
        textField.setPrefWidth(100);
        HBox hBox = new HBox();
        hBox.getChildren().addAll(start,output,textField);
        Scene scene = new Scene(hBox);
        stage.setScene(scene);
        stage.setTitle("抛硬币");
        stage.setWidth(200);
        stage.setHeight(100);
        stage.show();

        start.setOnAction(actionEvent -> {
            int i =Integer.parseInt(textField.getText());
            coinThrower(i);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText(timesAll+timesA+timesB);
            alert.showAndWait();
        });
        output.setOnAction(actionEvent -> {
            FileChooser fileChooser = new FileChooser();
            File s = fileChooser.showSaveDialog(stage);

                try {
                    fileWriter(s.getPath());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

        });
    }

    public static void coinThrower(int times)  {
        time=times;
        int upsideTimes =0;
        int downsideTimes = 0;
        data = new int[times];
        Random random = new Random();
        for (int i=0;i<times;i++){
            int p = random.nextInt();
            System.out.print(p+"    ");
            data[i] = p;
            if (p%2==0){
                upsideTimes = upsideTimes+1;
            } else {
                downsideTimes= downsideTimes+1;
            }
        }
        timesAll = "总次数="+times+"\n";
        System.out.println(timesAll);
        double possibilityA = (double)upsideTimes/times;
        System.out.println("正面次数="+upsideTimes+"  频率="+possibilityA);
        timesA = "正面次数="+upsideTimes+"  频率="+possibilityA+"\n";
        double possibilityB = (double)downsideTimes/times;
        System.out.println("反面次数="+downsideTimes+"  频率="+possibilityB);
        timesB = "反面次数="+downsideTimes+"  频率="+possibilityB+"\n";

    }
    public static void fileWriter(String filePath) throws Exception {
        System.out.println(filePath);
        File file = new File(filePath);
        OutputStream outputStream = Files.newOutputStream(file.toPath());
        outputStream.write(timesAll.getBytes());
        outputStream.write(timesA.getBytes());
        outputStream.write(timesB.getBytes());
        outputStream.close();


        FileWriter fileWriter = new FileWriter(file,true);
        for (int i=0;i<time;i++) {
            fileWriter.write(data[i]+"\n");
        }
        fileWriter.close();
    }
}
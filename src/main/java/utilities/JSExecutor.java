package utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JSExecutor {

  public static void executeScript(WebDriver driver, String script, Object... args) {
    try {
      JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
      Object result = jsExecutor.executeScript(script, args);

      Logger.infoMessage("JavaScrip results: " + result);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void runCommand(String command) {
    String projectDirectory = Paths.get("").toAbsolutePath().toString();
    ArrayList<String> commandArray = new ArrayList<>();
    commandArray.add(command);

    if (LocalEnviroment.isWindows()) {
      commandArray.add(0, "cmd");
      commandArray.add(1, "/c");
    } else {
      commandArray.add(0, "/bin/bash");
      commandArray.add(1, "-c");
    }
    try {
      ProcessBuilder processBuilder = new ProcessBuilder(commandArray);
      processBuilder.directory(new File(projectDirectory));
      processBuilder.start();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

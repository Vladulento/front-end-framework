package steps;

import static helpers.Runners.runAccessibilityCopy;
import static helpers.Runners.runAllureReport;

import java.lang.reflect.ParameterizedType;

import utilities.*;

//@ExtendWith(TestErrorHandler.class)
public abstract class GenericTest<T> {

    protected T controller;

    public static void cleanReportsAndLogs() {
        JSExecutor.runCommand(
                LocalEnviroment.isWindows()
                        ? Constants.EXTENT_CLEAN_COMMAND_WIN
                        : Constants.EXTENT_CLEAN_COMMAND_MAC);
    }

    public static void runReports() {
        runAllureReport();
        runAccessibilityCopy();
    }

    public void setController() {
        controller = createControllerInstance();
    }

    @SuppressWarnings("unchecked")
    private T createControllerInstance() {
        try {
            return ((Class<T>)
                    ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0])
                    .getDeclaredConstructor()
                    .newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Failed to create controller instance", e);
        }
    }

    public void shutController() {
        Accessibility.checkAccessibility();
        NetworkLogs.getNetworkLogs();
        DriverConfiguration.quitDriver();
    }
}

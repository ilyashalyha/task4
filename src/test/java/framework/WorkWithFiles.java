package framework;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.io.File;
import java.nio.file.Paths;
import java.time.Duration;

public class WorkWithFiles extends Browser {

    Actions actions = new Actions(getDriver());

    public File findDownloadedFile(String fileName) {
        File steamFileDir = new File(Paths.get("").toAbsolutePath().toString());
        boolean flag = false;
        File downloadedFile = null;
        do {
            for (int i = 0; i < Integer.parseInt(getTimeoutForDownloadFile()); i++) {
                File[] steamFileDirList = steamFileDir.listFiles();
                if (steamFileDirList != null) {
                    for (File file : steamFileDirList) {
                        if (file.getName().equals(fileName)) {
                            flag = true;
                            downloadedFile = file;
                            break;
                        }
                    }
                }
                if (!flag) {
                    waitForFile();
                } else break;
            }
        } while (downloadedFile == null);
        return downloadedFile;
    }

    private void waitForFile() {
        actions.pause(Duration.ofMillis(1000));
    }

    public void checkFileNameAndKill(String fileName) {
        Assert.assertEquals(findDownloadedFile(fileName).getName(), fileName);
        if (findDownloadedFile(fileName).delete()) {
            System.out.println("Downloaded file deleted");
        } else System.out.println("Downloaded file is not deleted");
    }
}
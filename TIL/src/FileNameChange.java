import java.util.Scanner;
import java.io.File;

public class FileNameChange {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String path = in.nextLine();
        in.close();

        File dir = new File(path);
        String[] fileNames = dir.list();

        for (String fileName : fileNames) {
            File oldFile = new File(path + "\\" + fileName);

            fileName = fileName.substring(0, fileName.length() - 3);
            String[] fileNameExceptExt = fileName.split("_");
            String newFileName;
            if (fileNameExceptExt.length == 2) {
                newFileName = fileNameExceptExt[1] + "_" + fileNameExceptExt[0] + ".py";
            } else if (fileNameExceptExt.length == 3) {
                newFileName = fileNameExceptExt[1] + "_" + fileNameExceptExt[2] + "_" + fileNameExceptExt[0] + ".py";
            } else
                newFileName = fileName + ".py";

            File newFile = new File(path + "\\" + newFileName);

            if (newFile.exists())
                continue;

            boolean success = oldFile.renameTo(newFile);
            if (success)
                System.out.println(newFileName);
            else
                System.out.println("File didn\'t change");
        }
    }
}

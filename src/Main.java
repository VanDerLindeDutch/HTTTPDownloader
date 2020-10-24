import BitumURL.FileIsNotDirException;
import BitumURL.ReadLinkList;

public class Main {
    public static void main(String[] args) {

        try {
            new ReadLinkList("links.txt").readAndDownload(3, "C:\\Users\\Lamer\\Desktop\\HTTPDownloader\\DownloadedFiles");
        } catch (FileIsNotDirException e) {
            e.printStackTrace();
        }


    }
}

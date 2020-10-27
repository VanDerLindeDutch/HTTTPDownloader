import BitumURL.FileIsNotDirException;
import BitumURL.ReadLinkList;

public class Main {
    public static void main(String[] args) {
//"links.txt" "C:\\Users\\Lamer\\Desktop\\HTTPDownloader\\DownloadedFiles"
        try {
            new ReadLinkList(args[2]).readAndDownload(Integer.parseInt(args[0]),args[1]);
        } catch (FileIsNotDirException e) {
            e.printStackTrace();
        }


    }
}

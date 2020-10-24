import BitumURL.*;
import org.w3c.dom.css.Counter;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args){

        try {
            new ReadLinkList("links.txt").readAndDownload(3, "C:\\Users\\Lamer\\Desktop\\HTTPDownloader\\DownloadedFiles");
        } catch (FileIsNotDirException e) {
            e.printStackTrace();
        }



    }
}

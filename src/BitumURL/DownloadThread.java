package BitumURL;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static BitumURL.CopyFile.copyFile;


public class DownloadThread implements Runnable {
    final List<Map.Entry<String, List<String>>> list;
    String dir;
    final int begin, NoT;

    public DownloadThread(List<Map.Entry<String, List<String>>> list, String dir, int begin, int not) {
        this.list = list;
        this.dir = dir;
        this.begin = begin;
        NoT = not;
    }

    @Override
    public void run() {
        int i = begin;
        while (i < list.size()) {
            Map.Entry<String, List<String>> entry = list.get(i);
            List<String> value = entry.getValue();
            try {
                new Download(GetUrl.get(entry.getKey())).checkDownloadTime(dir, value.get(0));
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (entry.getValue().size() > 1) {
                for (String j : value.subList(1, value.size())) {
                    try {
                        copyFile(dir + "\\" + value.get(0), dir + "\\" + j);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            i += NoT;
        }
    }

}


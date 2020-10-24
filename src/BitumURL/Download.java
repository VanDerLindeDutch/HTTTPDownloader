package BitumURL;

import java.io.*;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;


class Download {
    private final URL url;

    public Download(URL url) {
        this.url = url;
    }

    public void checkDownloadTime(String dir, String path) throws IOException {
        long time = System.currentTimeMillis();
        download(dir + "\\" + path);
        double secTime = ((System.currentTimeMillis() - time) / 1000.0);
        File file = new File(dir, path);
        double lengthMB = ((file.length() * 8.0)) / 1024 / 1024;
        double speed = lengthMB / secTime;
        System.out.println("Thread name-" + Thread.currentThread().getName());
        System.out.printf("File %s was downloaded in %d miliseconds. Download speed-%.2f Mb/S\n", file.getName(), System.currentTimeMillis() - time, speed);
    }

    private void download(String path) throws IOException {
        ReadableByteChannel readableByteChannel = Channels.newChannel(url.openStream());
        FileChannel fileChannel = new FileOutputStream(path).getChannel();
        fileChannel.transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
        readableByteChannel.close();
        fileChannel.close();
    }

}

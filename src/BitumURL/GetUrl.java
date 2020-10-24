package BitumURL;

import java.net.MalformedURLException;
import java.net.URL;

class GetUrl {
    public static URL get(String http) throws MalformedURLException {
        return(new URL(http));
    }
}


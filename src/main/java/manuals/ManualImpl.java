package manuals;

import java.util.ArrayList;
import java.util.List;

public class ManualImpl implements Manual {
    @Override
    public List<String> getManual() {
        List<String> pages = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            pages.add("Manual page " + i);
        }
        return pages;
    }
}

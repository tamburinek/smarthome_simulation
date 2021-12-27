package manuals;

import java.util.List;

public class ManualProxyImpl implements Manual {

    private Manual manual;

    @Override
    public List<String> getManual() {
        if (manual == null) {
            System.out.println("Fetching manual");
            manual = new ManualImpl();
        }
        return manual.getManual();
    }
}

package hu.nive.ujratervezes.zarovizsga.cleaning;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CleaningService {
    private List<Cleanable> cleanables = new ArrayList<>();

    public void add(Cleanable cleanable) {
        cleanables.add(cleanable);
    }

    public int cleanAll() {
        int sum = 0;
        for (Cleanable c : cleanables) {
            sum += c.clean();

        }
        cleanables.clear();
        return sum;
    }

    public int cleanOnlyOffices() {
        int sum = 0;
        for (Cleanable c : cleanables) {
            if (c instanceof Office) {
                sum += c.clean();
            }
        }
        for (Iterator<Cleanable> c = cleanables.iterator(); c.hasNext();) {
            Cleanable value = c.next();
            if (value instanceof Office) {
                c.remove();
            }
        }
        return sum;
    }

    public List<Cleanable> findByAddressPart(String address) {
        List<Cleanable> result = new ArrayList<>();
        for (Cleanable c : cleanables) {
            if (c.getAddress().contains(address)) {
                result.add(c);
            }
        }
        return result;
    }

    public String getAddresses() {
        StringBuilder sb = new StringBuilder();
        for (Cleanable c : cleanables) {
            sb.append(c.getAddress()).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    public List<Cleanable> getCleanables() {
        return cleanables;
    }
}

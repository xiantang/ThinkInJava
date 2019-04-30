package designpattern.composite;

import javax.management.OperationsException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xiantang
 * @Date: 2019/4/30 14:27
 */
public class Headquarter extends Composite {

    private ArrayList<Composite> arrayList = new ArrayList<Composite>();

    @Override
    void add(Composite company) throws OperationsException {
        arrayList.add(company);
    }

    @Override
    void delete(Composite company) throws OperationsException {
        arrayList.remove(company);
    }

    @Override
    List<Composite> getAll() throws OperationsException {
        return arrayList;
    }
}

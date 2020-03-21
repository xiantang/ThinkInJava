package info.xiantang.designpattern.composite;

import javax.management.OperationsException;
import java.util.List;

/**
 * @Author: xiantang
 * @Date: 2019/4/30 14:20
 */
public class Office extends Composite {
    @Override
    void add(Composite company) throws OperationsException {
        throw new OperationsException();
    }

    @Override
    List<Composite> getAll() throws OperationsException {
        throw new OperationsException();
    }

    @Override
    void delete(Composite company) throws OperationsException {
        throw new OperationsException();
    }
}

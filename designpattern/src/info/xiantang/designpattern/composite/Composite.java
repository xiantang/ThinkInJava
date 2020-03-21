package info.xiantang.designpattern.composite;

import javax.management.OperationsException;
import java.util.List;

/**
 * @Author: xiantang
 * @Date: 2019/4/30 14:17
 */
public abstract class Composite {

    abstract void add(Composite company) throws OperationsException;

    abstract void delete(Composite company) throws OperationsException;

    abstract List<Composite> getAll() throws OperationsException;

}

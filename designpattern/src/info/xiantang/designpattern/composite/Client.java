package info.xiantang.designpattern.composite;

import javax.management.OperationsException;

/**
 * @Author: xiantang
 * @Date: 2019/4/30 14:25
 */
public class Client {
    public static void main(String[] args) throws OperationsException {
        Composite head = new Headquarter();
        Composite educationalAdministrationOffice = new Office();
        Composite executiveOffice = new Office();
        head.add(educationalAdministrationOffice);
        head.add(executiveOffice);
        Composite banchCampu = new BranchCampu();
        banchCampu.add(new Office());
        banchCampu.add(new Office());
        head.add(banchCampu);

        dfs(head);
    }

    public static void dfs(Composite composite) throws OperationsException {
        if (composite instanceof Office) {
            System.out.println("通知完成");
        } else {
            for (Composite composite1 :
                    composite.getAll()) {
                dfs(composite1);
            }
        }
    }
}

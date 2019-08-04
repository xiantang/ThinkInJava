package designpattern.factory.factory1;

/**
 * @Author: xiantang
 * @Date: 2019/4/28 19:29
 */
public class OracleFactory implements Factory {
    @Override
    public Connection createConnection() {
        return new OracleConnection();
    }

    @Override
    public Statement createStatement() {
        return new OracleStatement();
    }

}

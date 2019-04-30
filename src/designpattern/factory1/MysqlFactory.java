package designpattern.factory1;

/**
 * @Author: xiantang
 * @Date: 2019/4/28 19:29
 */
public class MysqlFactory implements Factory {
    @Override
    public Connection createConnection() {
        return new MysqlConnection();
    }

    @Override
    public Statement createStatement() {
        return new MysqlStatement();
    }

}

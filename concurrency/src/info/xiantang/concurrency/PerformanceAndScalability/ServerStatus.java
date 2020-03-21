package info.xiantang.concurrency.PerformanceAndScalability;


import java.util.Set;

/**
 * @Author: xiantang
 * @Date: 2019/4/22 15:01
 */
public class ServerStatus {
    public final Set<String> users;
    public final Set<String> queries;

    public ServerStatus(Set<String> users, Set<String> queries) {
        this.users = users;
        this.queries = queries;
    }

    public void addUser(String u) {
        synchronized (users) {
            users.add(u);
        }
    }

    public void addQuery(String q) {
        synchronized (queries) {
            queries.add(q);

        }

    }



}

package info.xiantang.redisdemo.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    private UserService service;

    @RequestMapping("/add")
    Long add() {
        return service.addUser();
    }

    /**
     * 分页查询
     *
     * @param start
     * @param end
     * @return
     */
    @RequestMapping(value = "index/{start}/{end}")
    String page(@PathVariable("start") Integer start, @PathVariable("end") Integer end) {
        return service.index(start, end);
    }


    @RequestMapping("/addWithRank/{name}/{rank}")
    Boolean addWithRank(@PathVariable("name") String name, @PathVariable("rank") Integer rank) {
        return service.addUserWithRank(name,rank);
    }



}

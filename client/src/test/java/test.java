import com.orange.client.IOrangeClient;
import com.orange.client.domain.User;
import com.orange.client.exception.ClientException;
import com.orange.client.impl.OrangeClientImpl;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA 14.
 * User: karl.zhao
 * Time: 2016/2/16 0016.
 */
public class test {
    public static void main(String[] args) throws ClientException,IOException {

        IOrangeClient iOrangeClient = new OrangeClientImpl("http://127.0.0.1:9999");

        User user = new User("111111","admin");


        System.out.println("use num接口:"+iOrangeClient.test("123456789"));

        System.out.println("use hello1接口:"+iOrangeClient.hello1("abcd"));
        System.out.println("use hello2 get接口:"+iOrangeClient.hello2("orange"));

        // insert
        System.out.println("add:"+iOrangeClient.insertDataByUsername("orange"));

        // del
        System.out.println("del:"+iOrangeClient.deleteDataByUsername("orange"));

        // updata
        System.out.println("updata:"+iOrangeClient.updataDataByUsername("admin", "hi aaa"));

        // select
        System.out.println("select map1:"+iOrangeClient.getUserInfoByUserMap(user).toString());
        System.out.println("select map2:"+iOrangeClient.getUserInfoByUsername(user.getUsername()).toString());
        // System.out.println("select class:"+iOrangeClient.getUserInfoByUser(user).toString());

    }
}

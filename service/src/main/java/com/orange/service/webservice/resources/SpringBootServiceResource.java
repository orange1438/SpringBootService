package com.orange.service.webservice.resources;

import com.orange.service.domain.User;
import com.orange.service.redis.IRedisService;
import com.orange.service.service.IOrangeservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA 14.
 * User: karl.zhao
 * Time: 2016/2/14 0014.
 * 如何使用Jersey实现RestFul，参考：http://my.oschina.net/mlongbo/blog/152548#OSC_h4_13
 */
@Component
@Path("/")
public class SpringBootServiceResource {

    @Autowired
    private IRedisService redisService;

    @Autowired
    private IOrangeservice orangeservice;

    //这里的函数名字无所谓，因为调用函数，是通过Path调用的
    @POST
    @Path("/num")
    @Produces(MediaType.APPLICATION_JSON)
    public Map TEST_1(String userid){
        Map<String,String> map = new HashMap<>();
        map.put("id",userid);
        map.put("name","orange");

        // 测试redis
        redisService.textfun();

        return map;
    }

    @POST
    @Path("/hello1")
    @Produces(MediaType.APPLICATION_JSON)
    public String TEST_2(String openid){
        return orangeservice.hello("Post:"+openid);
    }

    @GET
    @Path("/hello2/{OrangeId}")
    @Consumes(MediaType.APPLICATION_JSON)//标注可接受请求的MIME媒体类型
    @Produces(MediaType.APPLICATION_JSON)//标注返回的MIME媒体类型
    public String getTerminalByTerminalId(@PathParam("OrangeId")String terminalId){
        return orangeservice.hello("Get:"+terminalId);
    }

    @POST
    @Path("/insert")
    @Consumes(MediaType.APPLICATION_JSON)
    public int insertDD(String username){
        return orangeservice.insertDataByUsername(username);
    }

    @POST
    @Path("/select")
    @Produces(MediaType.APPLICATION_JSON)
    public Map selectDD(String id){
        return orangeservice.getUserInfoByUsername(id);
    }

    /*
      类的传递,传送方式参考client里
    * */
    @POST
    @Path("/selectmap")
    @Produces(MediaType.APPLICATION_JSON)
    public Map selectMap(User user){
        return orangeservice.getUserInfoByUserMap(user);
    }

    /*
      类的传递,目前在mybabit执行查询时候有问题。
    * */
    @POST
    @Path("/selectclass")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public User selectClass(User user){
        User xxx = orangeservice.getUserInfoByUser(user);
        System.out.println("xxx:"+xxx.toString());
        return xxx;
    }

    @POST
    @Path("/del")
    @Produces(MediaType.APPLICATION_JSON)
    public int delDD(String username){
        return orangeservice.deleteDataByUsername(username);
    }

    @POST
    @Path("/updata")
    @Consumes("application/json")    // 可接受请求的MIME媒体类型
    /* 注：如果想一次性传多个参数的post请求，目前我就晓得hash、map传递
    * 传递：{"username":"admin","updataforuserid":"aaaaaaaaaaa"}*/
    public int updataDD(HashMap<String,String> dd){
        return orangeservice.updataDataByUsername(dd.get("username"),dd.get("updataforuserid"));
    }

    /* 笔者使用的Jersey构建的RestFul */
    /*下面是资源请求的web方法，请根据实际情况更改*/
    /*
    @POST
    @Path("/terminal")
    @Produces(MediaType.APPLICATION_JSON)//标注返回的MIME媒体类型
    public boolean addTerminal(TerminalInfo terminalInfo){
       return terminalService.addTerminal(terminalInfo);
    }

    @GET
    @Path("/terminal/{terminalId}")
    @Consumes(MediaType.APPLICATION_JSON)//标注可接受请求的MIME媒体类型
    @Produces(MediaType.APPLICATION_JSON)//标注返回的MIME媒体类型
    public TerminalInfo getTerminalByTerminalId(@PathParam("terminalId")String terminalId){
        return terminalService.getTerminal(terminalId);
    }

    @PUT
    @Path("/terminal")
    @Produces(MediaType.APPLICATION_JSON)//标注返回的MIME媒体类型
    public boolean updateTerminal(TerminalInfo terminalInfo){
        return terminalService.modifyTerminal(terminalInfo);
    }

    @DELETE
    @Path("/terminal/{terminalId}")
    @Consumes(MediaType.APPLICATION_JSON)//标注可接受请求的MIME媒体类型
    @Produces(MediaType.APPLICATION_JSON)//标注返回的MIME媒体类型
    public boolean deleteTerminalByTerminalId(@PathParam("terminalId")String terminalId){
        return terminalService.deleteTerminal(terminalId);
    }

    @GET
    @Path("/terminal")
    @Consumes(MediaType.APPLICATION_JSON)//标注可接受请求的MIME媒体类型
    @Produces(MediaType.APPLICATION_JSON)//标注返回的MIME媒体类型
    public TerminalInfoCollection searchTerminal(@QueryParam("offset")int offset,@QueryParam("max")int max){
        if(max==0){
            max=10;
        }
        return terminalService.searchTerminal(max,offset);
    }

    @GET
    @Path("/restau-terminal/{restaurantId}")
    @Consumes(MediaType.APPLICATION_JSON)//标注可接受请求的MIME媒体类型
    @Produces(MediaType.APPLICATION_JSON)//标注返回的MIME媒体类型
    public TerminalInfo getTerminalByRestaurantId(@PathParam("restaurantId")String restaurantId){
        return terminalService.getTerminalByRestaurant(restaurantId);
    }
    */
}

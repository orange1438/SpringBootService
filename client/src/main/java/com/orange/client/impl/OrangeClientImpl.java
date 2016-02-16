package com.orange.client.impl;

import com.orange.client.IOrangeClient;
import com.orange.client.domain.User;
import com.orange.client.exception.ClientException;
import com.orange.client.exception.ExceptionEntity;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA 14.
 * User: karl.zhao
 * Time: 2016/2/16 0016.
 */
public class OrangeClientImpl implements IOrangeClient {

    private String Service_Url="http://127.0.0.1:9999";
    private final Client client = ClientFactory.create();

    public String getService_Url() {
        return Service_Url;
    }
    public void setService_Url(String service_Url) {
        Service_Url = service_Url;
    }

    public OrangeClientImpl(){}
    public OrangeClientImpl(String Service_Url){
        this.Service_Url=Service_Url;
    }

    @Override
    public Map test(String id) throws ClientException, IOException {
        Response response = null;
        Map receiveOk = null;

        try {
            response = client.target(getService_Url()).path("/num").request().post(Entity.entity(id, MediaType.APPLICATION_JSON));
        } catch (Exception e) {
            ExceptionEntity exceptionEntity = new ExceptionEntity(9001, "服务器连接失败");
            throw new ClientException(exceptionEntity);
        }
        if (response.getStatusInfo().getFamily().equals(Response.Status.Family.SUCCESSFUL)) {
            try {
                receiveOk = response.readEntity(Map.class);
            } catch (ProcessingException e) {
                ExceptionEntity exceptionEntity = new ExceptionEntity(9002, "服务器返回错误的数据类型");
                throw new ClientException(exceptionEntity);
            }
        } else {
            ExceptionEntity exceptionEntity = response.readEntity(ExceptionEntity.class);
            throw new ClientException(exceptionEntity);
        }
        return receiveOk;
    }

    @Override
    public String hello1(String id) throws ClientException, IOException {
        Response response = null;
        String receiveOk = null;

        try {
            response = client.target(getService_Url()).path("/hello1").request().post(Entity.entity(id, MediaType.APPLICATION_JSON));
        } catch (Exception e) {
            ExceptionEntity exceptionEntity = new ExceptionEntity(9001, "服务器连接失败");
            throw new ClientException(exceptionEntity);
        }
        if (response.getStatusInfo().getFamily().equals(Response.Status.Family.SUCCESSFUL)) {
            try {
                receiveOk = response.readEntity(String.class);
            } catch (ProcessingException e) {
                ExceptionEntity exceptionEntity = new ExceptionEntity(9002, "服务器返回错误的数据类型");
                throw new ClientException(exceptionEntity);
            }
        } else {
            ExceptionEntity exceptionEntity = response.readEntity(ExceptionEntity.class);
            throw new ClientException(exceptionEntity);
        }
        return receiveOk;
    }

    /* 注：这是GET方法 */
    @Override
    public String hello2(String id) throws ClientException, IOException {
        Response response = null;
        String receiveOk = null;

        response = client.target(getService_Url()).path("/hello2/{OrangeId}").resolveTemplate("OrangeId", id).request().get();
        if (response.getStatusInfo().getFamily().equals(Response.Status.Family.SUCCESSFUL)) {
            try {
                receiveOk = response.readEntity(String.class);
            } catch (ProcessingException e) {
                ExceptionEntity exceptionEntity=new ExceptionEntity(9002,"服务器返回错误的数据类型");
                throw new ClientException(exceptionEntity);
            }
        } else {
            ExceptionEntity exceptionEntity = response.readEntity(ExceptionEntity.class);
            throw new ClientException(exceptionEntity);
        }
        return receiveOk;
    }

    @Override
    public Map getUserInfoByUsername(String username) throws ClientException, IOException {
        Response response = null;
        Map receiveOk = null;

        try {
            response = client.target(getService_Url()).path("/select").request().post(Entity.entity(username, MediaType.APPLICATION_JSON));
        } catch (Exception e) {
            ExceptionEntity exceptionEntity = new ExceptionEntity(9001, "服务器连接失败");
            throw new ClientException(exceptionEntity);
        }
        if (response.getStatusInfo().getFamily().equals(Response.Status.Family.SUCCESSFUL)) {
            try {
                receiveOk = response.readEntity(Map.class);
            } catch (ProcessingException e) {
                ExceptionEntity exceptionEntity = new ExceptionEntity(9002, "服务器返回错误的数据类型");
                throw new ClientException(exceptionEntity);
            }
        } else {
            ExceptionEntity exceptionEntity = response.readEntity(ExceptionEntity.class);
            throw new ClientException(exceptionEntity);
        }
        return receiveOk;
    }

    @Override
    public User getUserInfoByUser(User user) throws ClientException, IOException {
        Response response = null;
        User receiveOk = null;

        try {
            response = client.target(getService_Url()).path("/selectclass").request().post(Entity.entity(user, MediaType.APPLICATION_JSON));
        } catch (Exception e) {
            ExceptionEntity exceptionEntity = new ExceptionEntity(9001, "服务器连接失败");
            throw new ClientException(exceptionEntity);
        }
        if (response.getStatusInfo().getFamily().equals(Response.Status.Family.SUCCESSFUL)) {
            try {
                receiveOk = response.readEntity(User.class);
            } catch (ProcessingException e) {
                ExceptionEntity exceptionEntity = new ExceptionEntity(9002, "服务器返回错误的数据类型");
                throw new ClientException(exceptionEntity);
            }
        } else {
            ExceptionEntity exceptionEntity = response.readEntity(ExceptionEntity.class);
            throw new ClientException(exceptionEntity);
        }
        return receiveOk;
    }

    @Override
    public Map getUserInfoByUserMap(User user) throws ClientException, IOException {
        Response response = null;
        Map receiveOk = null;

        try {
            response = client.target(getService_Url()).path("/selectmap").request().post(Entity.entity(user, MediaType.APPLICATION_JSON));
        } catch (Exception e) {
            ExceptionEntity exceptionEntity = new ExceptionEntity(9001, "服务器连接失败");
            throw new ClientException(exceptionEntity);
        }
        if (response.getStatusInfo().getFamily().equals(Response.Status.Family.SUCCESSFUL)) {
            try {
                receiveOk = response.readEntity(Map.class);
            } catch (ProcessingException e) {
                ExceptionEntity exceptionEntity = new ExceptionEntity(9002, "服务器返回错误的数据类型");
                throw new ClientException(exceptionEntity);
            }
        } else {
            ExceptionEntity exceptionEntity = response.readEntity(ExceptionEntity.class);
            throw new ClientException(exceptionEntity);
        }
        return receiveOk;
    }

    @Override
    public int insertDataByUsername(String username) throws ClientException, IOException {
        Response response = null;
        int receiveOk = 0;
        try {
            response = client.target(getService_Url()).path("/insert").request().post(Entity.entity(username, MediaType.APPLICATION_JSON));
        } catch (Exception e) {
            ExceptionEntity exceptionEntity = new ExceptionEntity(9001, "服务器连接失败");
            throw new ClientException(exceptionEntity);
        }
        if (response.getStatusInfo().getFamily().equals(Response.Status.Family.SUCCESSFUL)) {
            try {
                receiveOk = response.readEntity(Integer.class);
            } catch (ProcessingException e) {
                ExceptionEntity exceptionEntity = new ExceptionEntity(9002, "服务器返回错误的数据类型");
                throw new ClientException(exceptionEntity);
            }
        } else {
            ExceptionEntity exceptionEntity = response.readEntity(ExceptionEntity.class);
            throw new ClientException(exceptionEntity);
        }
        return receiveOk;
    }

    @Override
    public int deleteDataByUsername(String username) throws ClientException, IOException {
        Response response = null;
        int receiveOk = 0;
        try {
            response = client.target(getService_Url()).path("/del").request().post(Entity.entity(username, MediaType.APPLICATION_JSON));
        } catch (Exception e) {
            ExceptionEntity exceptionEntity = new ExceptionEntity(9001, "服务器连接失败");
            throw new ClientException(exceptionEntity);
        }
        if (response.getStatusInfo().getFamily().equals(Response.Status.Family.SUCCESSFUL)) {
            try {
                receiveOk = response.readEntity(Integer.class);
            } catch (ProcessingException e) {
                ExceptionEntity exceptionEntity = new ExceptionEntity(9002, "服务器返回错误的数据类型");
                throw new ClientException(exceptionEntity);
            }
        } else {
            ExceptionEntity exceptionEntity = response.readEntity(ExceptionEntity.class);
            throw new ClientException(exceptionEntity);
        }
        return receiveOk;
    }

    /*
        传递json  {"username":"admin","updataforuserid":"aaaaaaaaaaa"}
     */
    @Override
    public int updataDataByUsername(String username, String updataforuserid) throws ClientException, IOException {
        Map<String,String> map = new HashMap<>();
        map.put("username",username);
        map.put("updataforuserid",updataforuserid);

        Response response = null;
        int receiveOk = 0;
        try {
            response = client.target(getService_Url()).path("/updata").request().post(Entity.entity(map, MediaType.APPLICATION_JSON));
        } catch (Exception e) {
            ExceptionEntity exceptionEntity = new ExceptionEntity(9001, "服务器连接失败");
            throw new ClientException(exceptionEntity);
        }
        if (response.getStatusInfo().getFamily().equals(Response.Status.Family.SUCCESSFUL)) {
            try {
                receiveOk = response.readEntity(Integer.class);
            } catch (ProcessingException e) {
                ExceptionEntity exceptionEntity = new ExceptionEntity(9002, "服务器返回错误的数据类型");
                throw new ClientException(exceptionEntity);
            }
        } else {
            ExceptionEntity exceptionEntity = response.readEntity(ExceptionEntity.class);
            throw new ClientException(exceptionEntity);
        }
        return receiveOk;
    }





    /*在这里像下面的代码一样，写你的服务提供的相关方法*/
    /*
    @Override
    public boolean addTerminal(TerminalInfo terminalInfo) throws ClientException,IOException {
        Response response = null;
        boolean isOk =false;
        response = client.target(getService_Url()).path("/terminal").request().post(Entity.entity(terminalInfo, MediaType.APPLICATION_JSON_TYPE));
        if (response.getStatusInfo().getFamily().equals(Response.Status.Family.SUCCESSFUL)) {
            try {
                isOk = response.readEntity(Boolean.class);
            } catch (ProcessingException e) {
                ExceptionEntity exceptionEntity=new ExceptionEntity(9002,"服务器返回错误的数据类型");
                throw new ClientException(exceptionEntity);
            }
        } else {
            ExceptionEntity exceptionEntity = response.readEntity(ExceptionEntity.class);
            throw new ClientException(exceptionEntity);
        }
        return isOk;
    }

    @Override
    public boolean modifyTerminal(TerminalInfo terminalInfo) throws ClientException,IOException {
        Response response = null;
        boolean isOk =false;
        response = client.target(getService_Url()).path("/terminal").request().put(Entity.entity(terminalInfo, MediaType.APPLICATION_JSON_TYPE));
        if (response.getStatusInfo().getFamily().equals(Response.Status.Family.SUCCESSFUL)) {
            try {
                isOk = response.readEntity(Boolean.class);
            } catch (ProcessingException e) {
                ExceptionEntity exceptionEntity=new ExceptionEntity(9002,"服务器返回错误的数据类型");
                throw new ClientException(exceptionEntity);
            }
        } else {
            ExceptionEntity exceptionEntity = response.readEntity(ExceptionEntity.class);
            throw new ClientException(exceptionEntity);
        }
        return isOk;
    }

    @Override
    public boolean deleteTerminal(String terminalId) throws ClientException,IOException {
        Response response = null;
        boolean isOk =false;
        response = client.target(getService_Url()).path("/terminal/{terminalId}").resolveTemplate("terminalId", terminalId).request().delete();
        if (response.getStatusInfo().getFamily().equals(Response.Status.Family.SUCCESSFUL)) {
            try {
                isOk = response.readEntity(Boolean.class);
            } catch (ProcessingException e) {
                ExceptionEntity exceptionEntity=new ExceptionEntity(9002,"服务器返回错误的数据类型");
                throw new ClientException(exceptionEntity);
            }
        } else {
            ExceptionEntity exceptionEntity = response.readEntity(ExceptionEntity.class);
            throw new ClientException(exceptionEntity);
        }
        return isOk;
    }

    @Override
    public TerminalInfoCollection searchTerminal(int max, int offset) throws ClientException,IOException {
        Response response = null;
        TerminalInfoCollection terminalInfoCollection =null;
        response = client.target(getService_Url()).path("/terminal").queryParam("max",max).queryParam("offset",offset).request().get();
        if (response.getStatusInfo().getFamily().equals(Response.Status.Family.SUCCESSFUL)) {
            try {
                terminalInfoCollection = response.readEntity(TerminalInfoCollection.class);
            } catch (ProcessingException e) {
                ExceptionEntity exceptionEntity=new ExceptionEntity(9002,"服务器返回错误的数据类型");
                throw new ClientException(exceptionEntity);
            }
        } else {
            ExceptionEntity exceptionEntity = response.readEntity(ExceptionEntity.class);
            throw new ClientException(exceptionEntity);
        }
        return terminalInfoCollection;
    }

    @Override
    public TerminalInfo getTerminal(String terminalId) throws ClientException,IOException {
        Response response = null;
        TerminalInfo terminalInfo =null;
        response = client.target(getService_Url()).path("/terminal/{terminalId}").resolveTemplate("terminalId", terminalId).request().get();
        if (response.getStatusInfo().getFamily().equals(Response.Status.Family.SUCCESSFUL)) {
            try {
                terminalInfo = response.readEntity(TerminalInfo.class);
            } catch (ProcessingException e) {
                ExceptionEntity exceptionEntity=new ExceptionEntity(9002,"服务器返回错误的数据类型");
                throw new ClientException(exceptionEntity);
            }
        } else {
            ExceptionEntity exceptionEntity = response.readEntity(ExceptionEntity.class);
            throw new ClientException(exceptionEntity);
        }
        return terminalInfo;
    }
    */
}

package com.tsaksia.dealer.server;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

/**
 * Created by samyboukhris on 28/05/2018.
 */
@RestController
@RequestMapping("/api")
public class DealerService {

    private EurekaClient eurekaClient;
    private String twitterServiceId = "twitter-service";


    @Autowired
    public DealerService(EurekaClient eurekaClient) {
        this.eurekaClient = eurekaClient;
    }


    @RequestMapping(method = RequestMethod.GET, path = "/lookfor")
    public Object lookFor(@PathParam("q") String query) {
        Application twitter = this.eurekaClient.getApplication(twitterServiceId);
        InstanceInfo instanceInfo = twitter.getInstances().get(0);
        String twitterEndPoint = instanceInfo.getIPAddr() + instanceInfo.getPort();
        return "houhou";
    }


}

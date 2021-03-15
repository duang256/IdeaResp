package server;

import server.Mapping;
import server.Servlet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebContext {
    private List<Servlet> servlets;
    private List<Mapping> mappings;
    private Map<String ,String > servletMap=new HashMap<>();
    private Map<String ,String >mappingMap=new HashMap<>();

    public WebContext(List<Servlet> servlets, List<Mapping> mappings) {
        this.servlets = servlets;
        this.mappings = mappings;
        for (Servlet servlet:servlets
             ) {
            servletMap.put(servlet.getName(),servlet.getClz());
        }
        for (Mapping mapping:mappings
             ) {
            for (String pattern:mapping.getPatterns()
                 ) {
                mappingMap.put(pattern,mapping.getName());
            }
        }


    }
    //这样通过传入url就返回了class
    public String getClz(String url){
        String name=mappingMap.get(url);
        return servletMap.get(name);
    }

    public WebContext() {
    }
}

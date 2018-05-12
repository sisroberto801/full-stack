package com.project.diplomaed.common;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BuildResponse {

    private static Logger logger = LoggerFactory.getLogger(BuildResponse.class);
    private Map<String,Object> objectMap;
    ObjectMapper mapper;

    private Integer total;
    private Integer code;
    private Integer page;
    private Integer perPage;
    private String status;
    private String success;
    private String message;
    private Object result;

    private String TOTAL_TEXT = "total";
    private String PAGE_TEXT = "page";
    private String PER_PAGE_TEXT = "perPage";
    private String STATUS_TEXT = "status";
    private String SUCCESS_TEXT = "success";
    private String DATA_TEXT = "data";

    private String EMPTY = "";
    private Integer CERO = 0;
    private Integer TEN = 10;

    public BuildResponse(){
        this.objectMap  = new HashMap<String,Object>();
        this.mapper = new ObjectMapper();

        this.total = new Integer(CERO);
        this.page = new Integer(CERO);
        this.perPage = new Integer(TEN);
        this.status = new String();
        this.success = new String();
    }

//    public String getResult() {
//        try {
//            result = mapper.writeValueAsString(this.objectMap);
//        }catch (Exception e){
//            logger.error(e.getMessage());
//        }
//        return result;
//    }

    public void clean(){
        this.objectMap.clear();
        this.mapper = new ObjectMapper();

        this.total = CERO;
        this.page = CERO;
        this.perPage = TEN;
        this.status = EMPTY;
        this.success = EMPTY;
        this.code = CERO;
        this.message = EMPTY;
    }


    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
        this.objectMap.put(TOTAL_TEXT,total);
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
        this.objectMap.put(PAGE_TEXT, page);
    }

    public Integer getPerPage() {
        return perPage;
    }

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
        this.objectMap.put(PER_PAGE_TEXT, perPage);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
        this.objectMap.put(STATUS_TEXT, status);
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
        this.objectMap.put(SUCCESS_TEXT, success);
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
        this.objectMap.put(DATA_TEXT, result);
    }
}

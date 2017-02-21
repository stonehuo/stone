package com.kpap.client.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import org.apache.cxf.binding.corba.wsdl.ObjectFactory;

import com.kpap.client.model.ResultData;
import com.kpap.client.model.ResultInfo;


/**
 * 
 * 专利评估服务接口<BR>
 *
 * @auther shenhaiwen
 * @date 2016-12-15 下午11:00:25
 */

/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "IEvalService", targetNamespace = "http://client.eval.ipph.cn/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface IEvalService {


    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns cn.ipph.eval.client.ResultData
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "loadDataFromSearch", targetNamespace = "http://client.eval.ipph.cn/", className = "cn.ipph.eval.client.LoadDataFromSearch")
    @ResponseWrapper(localName = "loadDataFromSearchResponse", targetNamespace = "http://client.eval.ipph.cn/", className = "cn.ipph.eval.client.LoadDataFromSearchResponse")
    public ResultData loadDataFromSearch(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        String arg3);

    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns cn.ipph.eval.client.ResultInfo
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "loadIndexList", targetNamespace = "http://client.eval.ipph.cn/", className = "cn.ipph.eval.client.LoadIndexList")
    @ResponseWrapper(localName = "loadIndexListResponse", targetNamespace = "http://client.eval.ipph.cn/", className = "cn.ipph.eval.client.LoadIndexListResponse")
    public ResultInfo loadIndexList(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2);

    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns cn.ipph.eval.client.ResultInfo
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "loadAvgIndex", targetNamespace = "http://client.eval.ipph.cn/", className = "cn.ipph.eval.client.LoadAvgIndex")
    @ResponseWrapper(localName = "loadAvgIndexResponse", targetNamespace = "http://client.eval.ipph.cn/", className = "cn.ipph.eval.client.LoadAvgIndexResponse")
    public ResultInfo loadAvgIndex(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2);

}
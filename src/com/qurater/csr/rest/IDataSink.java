package com.qurater.csr.rest;

public interface IDataSink {
    /**
     * Success
     * @param data
     */
    public void receive(String response);
    
    /**
     * Error
     * @param data
     */
    public void error(Throwable e, String response);
}
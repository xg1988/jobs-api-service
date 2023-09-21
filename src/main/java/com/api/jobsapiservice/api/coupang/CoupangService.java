package com.api.jobsapiservice.api.coupang;

import org.apache.http.ParseException;

import java.io.IOException;

public interface CoupangService {
    public String _callAPICoupang(String requestUrl) throws IOException ;
    public CoupangDto bestcategories(String categoryId, int size) throws ParseException, IOException ;
    public CoupangDto goldbox()throws ParseException, IOException ;
    public CoupangSearchDto search(String keyword, int size) throws ParseException, IOException ;

}

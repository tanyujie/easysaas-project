package org.easymis.easyicc.common.result;

import org.easymis.easyicc.common.jackson.SeventeenTableJsonSerializer;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 *  @author twb
 *
 */
@JsonSerialize( nullsUsing= SeventeenTableJsonSerializer.class)
public class SearchResult extends RestResult {

    public static SearchResult buildSuccess() {
        SearchResult searchResult = new SearchResult();
        searchResult.success();
        return searchResult;
    }

    public static SearchResult buildSuccess(Object t) {
        SearchResult searchResult = buildSuccess();
        searchResult.setData(t);
        return searchResult;
    }

    public static SearchResult buildError() {
        SearchResult searchResult = new SearchResult();
        searchResult.error();
        return searchResult;
    }

    public static SearchResult buildError(String msg) {
        SearchResult searchResult = new SearchResult();
        searchResult.error(msg);
        return searchResult;
    }

    public static SearchResult buildFail() {
        SearchResult searchResult = new SearchResult();
        searchResult.fail();
        return searchResult;
    }

    public static SearchResult buildFail(String msg) {
        SearchResult searchResult = buildFail();
        searchResult.fail(msg);
        return searchResult;
    }

    public static SearchResult buildOAuthFail() {
        SearchResult searchResult = new SearchResult();
        searchResult.authFail();
        return searchResult;
    }

}

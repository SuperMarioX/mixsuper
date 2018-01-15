package com.supermario.mixsuper.wrapper;

import lombok.*;

import java.io.Serializable;
import java.util.Map;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LogTrace implements Serializable {

    private static final long serialVersionUID = -2811654044475729476L;

    private String requestUrl;

    private String requestUri;
    private String queryString;
    private String remoteAddress;
    private String remoteHost;
    private String remotePort;
    private String localAddress;
    private String localName;
    private String method;
    private Map headers;
    private Map parameters;
    private String classMethod;
    private String args;
}


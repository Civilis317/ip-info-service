package net.playground.ipinfoservice.model;

import lombok.Data;

@Data
public class CheckIpWhitelistedRequest {
    private String ipAddress;
    private String application;
}

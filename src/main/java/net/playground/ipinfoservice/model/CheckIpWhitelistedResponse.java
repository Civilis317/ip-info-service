package net.playground.ipinfoservice.model;

import lombok.Data;

@Data
public class CheckIpWhitelistedResponse {
    private String ipAddress;
    private String application;
    private boolean whitelisted;
}

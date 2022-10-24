package net.playground.ipinfoservice.persistence;

import inet.ipaddr.AddressStringException;
import inet.ipaddr.IPAddress;
import inet.ipaddr.IPAddressString;
import lombok.extern.slf4j.Slf4j;
import net.playground.ipinfoservice.model.CheckIpWhitelistedRequest;
import net.playground.ipinfoservice.model.CheckIpWhitelistedResponse;
import net.playground.ipinfoservice.persistence.repository.IpInfoRepository;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class StorageService {
    private final IpInfoRepository ipInfoRepository;

    public StorageService(IpInfoRepository ipInfoRepository) {
        this.ipInfoRepository = ipInfoRepository;
    }

    public CheckIpWhitelistedResponse checkIpAddress(CheckIpWhitelistedRequest request) {
        CheckIpWhitelistedResponse response = new CheckIpWhitelistedResponse();
        response.setApplication(request.getApplication());
        response.setIpAddress(request.getIpAddress());
        response.setWhitelisted(false);
        ipInfoRepository.findByApplicationCode(request.getApplication()).forEach(r -> {
            if (performCheck(r.getIpRange(), request.getIpAddress())) {
                response.setWhitelisted(true);
            }
            log.debug("checking if {} contains {}: {}", r.getIpRange(), request.getIpAddress(), performCheck(r.getIpRange(), request.getIpAddress()));
        });
        return response;
    }

    private boolean performCheck(String ipRange, String ipAddress) {
        try {
            IPAddress range = new IPAddressString(ipRange).toAddress();
            IPAddress address  = new IPAddressString(ipAddress).toAddress();
            return range.contains(address);
        } catch (AddressStringException e) {
            log.error(e.getMessage(), e);
            return false;
        }
    }

}

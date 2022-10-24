package net.playground.ipinfoservice.persistence.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "ipinfo")
public class IpInfoEntity {

    @Id
    @Column(name="id", nullable = false)
    private Integer id;

    @Column(name="application_code", nullable = false)
    private String applicationCode;

    @Column(name="ip_range", nullable = false)
    private String ipRange;

    @Column(name="active", nullable = false)
    private Boolean active;
}

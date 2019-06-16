package com.louis.oauth.config;

import com.louis.core.entity.BaseEntity;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.*;

/**
 * @author John·Louis
 * @date create in 2019/6/16
 */

@Table(name = "oauth_client_details")
@Entity
public class SecurityClientDetails extends BaseEntity<Long> implements ClientDetails{

    private static final long serialVersionUID = 6872024378796071307L;

    @Setter
    private String clientId;

    @Setter
    @Transient
    private Set<String> resourceId;

    @Setter
    private boolean secretRequired = Boolean.TRUE;

    @Setter
    private String clientSecret;

    @Setter
    private boolean scoped = Boolean.TRUE;

    @Setter
    @Transient
    private Set<String> scope;

    @Transient
    @Setter
    private Set<String> authorizedGrantType;

    @Transient
    @Setter
    private Set<String> registeredRedirectUri;

    @Transient
    @Setter
    private Collection<GrantedAuthority> authorities;

    @Setter
    private Integer accessTokenValiditySeconds;

    @Setter
    private Integer refreshTokenValiditySeconds;

    @Setter
    private boolean autoApprove;

    @Transient
    @Setter
    private Map<String, Object> additionalInformation;







    @Override
    public String getClientId() {
        return this.clientId;
    }

    @Override
    public Set<String> getResourceIds() {
        return Optional.ofNullable(resourceId).orElse(new HashSet<>());
    }

    @Override
    public boolean isSecretRequired() {
        return this.secretRequired;
    }

    @Override
    public String getClientSecret() {
        return clientSecret;
    }

    @Override
    public boolean isScoped() {
        return scoped;
    }

    @Override
    public Set<String> getScope() {
        return Optional.ofNullable(scope).orElse(new HashSet<>());
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        return Optional.ofNullable(authorizedGrantType).orElse(new HashSet<>());
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        return Optional.ofNullable(registeredRedirectUri).orElse(new HashSet<>());
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return Optional.ofNullable(authorities).orElse(new HashSet<>());
    }

    @Override
    public Integer getAccessTokenValiditySeconds() {
        return this.accessTokenValiditySeconds;
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {
        return this.refreshTokenValiditySeconds;
    }

    @Override
    public boolean isAutoApprove(String scope) {
        return this.autoApprove;
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        return Optional.ofNullable(this.additionalInformation).orElse(new HashMap<>());
    }

}

package com.louis.server.entity.oauth;

import com.louis.core.entity.AbstractAuditable;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * @author John·Louis
 * <p>
 * Date: 2019/6/20
 * Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "client_detail")
public class ClientDetail extends AbstractAuditable<Long> {

    private static final long serialVersionUID = 4110170602933263982L;

    @NonNull
    @NotNull
    @Column(name = "client_id", unique = true, nullable = false, length = 200)
    private String clientId;

    @NonNull
    @NotNull
    @Column(name = "client_secret", nullable = false)
    private String clientSecret;

    @Column(name = "access_token_validity_seconds")
    private Integer accessTokenValiditySeconds;

    @Column(name = "refresh_token_validity_seconds")
    private Integer refreshTokenValiditySeconds;

//    @Singular
    @OneToMany(mappedBy = "clientDetails", fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL)
    private Set<ClientDetailsGrantType> authorizedGrantTypeXrefs;

//    @Singular
    @OneToMany(mappedBy = "clientDetails", fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL)
    private Set<ClientDetailsToScopes> scopeXrefs;

//    @Singular
    @OneToMany(mappedBy = "clientDetails", fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL)
    private Set<ClientDetailsToResourceId> resourceIdXrefs;

//    @Singular("redirectUri")
    @OneToMany(mappedBy = "clientDetails", fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL)
    private Set<RedirectUriEntity> redirectUris;

}

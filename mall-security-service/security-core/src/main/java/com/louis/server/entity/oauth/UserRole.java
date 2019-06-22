package com.louis.server.entity.oauth;

import com.louis.core.entity.AbstractAuditable;
import lombok.*;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(of = {"role"}, callSuper = true)
@ToString(of = "role", callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "user_role")
public class UserRole extends AbstractAuditable<Long> {

    private static final long serialVersionUID = 8960438784916678172L;
    @NonNull
    @NotNull
    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.DETACH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @NonNull
    @NotNull
    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.DETACH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", nullable = false)
    @Where(clause = "disabled = False")
    private RoleEntity role;

}

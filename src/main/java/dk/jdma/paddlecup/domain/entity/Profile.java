package dk.jdma.paddlecup.domain.entity;

import dk.jdma.paddlecup.domain.enums.ProfileRole;
import dk.jdma.paddlecup.domain.enums.ProfileStatus;
import dk.jdma.paddlecup.security.GrantedAuthorityImpl;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.annotations.Type;
import org.hibernate.envers.Audited;
import org.joda.time.DateTime;
import org.springframework.data.domain.Auditable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;


@Entity
@Audited   // Use @Audited to Enable Hibernate Envers
public class Profile implements Auditable<String,Long>, Serializable, UserDetails {

    private static final long serialVersionUID = 3398394021253290285L;

    public Profile() {
    }

    // Audit fields
    private String createdBy;
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime createdDate;
    private String lastModifiedBy;
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime lastModifiedDate;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ProfileRole profileRole;

    private String userHash;

    private String email;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ProfileStatus status;

    private String lastName;

    private String firstName;

    @Basic
    private String phoneMobile;

    @NotNull
    @Column(unique = true)
    private String userName;

    @NotNull
    private String password;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id", nullable = true)
    private Address address;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(style = "M-")
    private Date dob;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

	@Version
    @Column(name = "version")
    private Integer version;

	public Long getId() {
        return this.id;
    }

	public void setId(Long id) {
        this.id = id;
    }

	public Integer getVersion() {
        return this.version;
    }

	public void setVersion(Integer version) {
        this.version = version;
    }

	public String getUserHash() {
        return this.userHash;
    }

	public void setUserHash(String userHash) {
        this.userHash = userHash;
    }

	public String getEmail() {
        return this.email;
    }

	public void setEmail(String email) {
        this.email = email;
    }

	public ProfileStatus getStatus() {
        return this.status;
    }

	public void setStatus(ProfileStatus status) {
        this.status = status;
    }

	public String getLastName() {
        return this.lastName;
    }

	public void setLastName(String lastName) {
        this.lastName = lastName;
    }

	public String getFirstName() {
        return this.firstName;
    }

	public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

	public String getUserName() {
        return this.userName;
    }

	public void setUserName(String userName) {
        this.userName = userName;
    }

	public Date getDob() {
        return this.dob;
    }

	public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getPhoneMobile() {
        return phoneMobile;
    }

    public void setPhoneMobile(String phoneMobile) {
        this.phoneMobile = phoneMobile;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public DateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(DateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public DateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(DateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ProfileRole getProfileRole() {
        return profileRole;
    }

    public void setProfileRole(ProfileRole profileRole) {
        this.profileRole = profileRole;
    }

    @Transient
    public boolean isNew() {
        if (id == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        authorities.add(new GrantedAuthorityImpl(this.profileRole.name()));
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.getStatus().equals(ProfileStatus.ACTIVE);
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.getStatus().equals(ProfileStatus.ACTIVE);
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.getStatus().equals(ProfileStatus.ACTIVE);
    }

    @Override
    public boolean isEnabled() {
        return this.getStatus().equals(ProfileStatus.ACTIVE);
    }

    @Override
    public String toString() {
        return "Profile{" +
                "createdBy='" + createdBy + '\'' +
                ", createdDate=" + createdDate +
                ", lastModifiedBy='" + lastModifiedBy + '\'' +
                ", lastModifiedDate=" + lastModifiedDate +
                ", profileRole=" + profileRole +
                ", userHash='" + userHash + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", phoneMobile='" + phoneMobile + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", address=" + address +
                ", dob=" + dob +
                ", id=" + id +
                ", version=" + version +
                '}';
    }
}

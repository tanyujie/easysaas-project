package org.easymis.easycrm.core.security.userdetail;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class ExpireDateGrantedAuthority implements GrantedAuthority {

    private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

    public static final String defaultRole = "ROLE_USER";

    public static final String anonymous = "ROLE_ANONYMOUS";

   // public static final String preciseQuery = "ROLE_PRECISE_QUERY";
    // role_Sn
    private final String role;

    //timestamp
    private final long fromTime;
    //timestamp
    private final long toTime;

    public ExpireDateGrantedAuthority(String role, LocalDateTime fromTime, LocalDateTime toTime) {
        Assert.hasText(role, "A granted authority textual representation is required");
        this.role = role;
        this.fromTime = fromTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
        this.toTime = toTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }

    @Override
    public String getAuthority() {
        return role;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof ExpireDateGrantedAuthority) {
            return role.equals(((ExpireDateGrantedAuthority) obj).role);
        }

        return false;
    }

    public long getExpireTime() {
        return this.toTime;
    }

    public String getExpireTimeFormat() {
        LocalDateTime toDatetime = LocalDateTime.ofEpochSecond(this.toTime / 1000, 0, ZoneOffset.ofHours(8));
        return toDatetime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }


    public boolean isExpire() {
        long now = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        return now > this.toTime;

    }

    public boolean isExpire(long currentTimestamp) {
        return currentTimestamp > this.toTime;
    }

    @Override
    public int hashCode() {
        return this.role.hashCode();
    }

    @Override
    public String toString() {
        return this.role;
    }


    public static ExpireDateGrantedAuthority defaultGrantedAuthority() {
        return new ExpireDateGrantedAuthority(defaultRole, LocalDateTime.now()
                , LocalDateTime.parse("2030-01-01 23:59:59", DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss")));
    }


    public static ExpireDateGrantedAuthority defaultGrantedAuthority(LocalDateTime fromDateTime) {
        return new ExpireDateGrantedAuthority(defaultRole, fromDateTime
                , LocalDateTime.parse("2030-01-01 23:59:59", DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss")));
    }


    public Boolean isVip() {  // 当前非vip只有一个 "ROLE_USER"
        return !Objects.equals(defaultRole, this.role) && !Objects.equals(anonymous,this.role);
    }




}

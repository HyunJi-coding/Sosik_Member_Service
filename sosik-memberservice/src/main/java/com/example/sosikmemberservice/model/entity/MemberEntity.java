package com.example.sosikmemberservice.model.entity;


import com.example.sosikmemberservice.model.MemberRole;
import com.example.sosikmemberservice.model.vo.Email;
import com.example.sosikmemberservice.model.vo.Name;
import com.example.sosikmemberservice.model.vo.ProfileImageUrl;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "member")
public class MemberEntity  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Embedded
    private Email email;
    @Column(length = 255, nullable = false)
    private String password;
    @Embedded
    private Name name;
    @Column(nullable = true)
    private String gender;
    @Column(precision = 4, scale = 1)
    private BigDecimal height;

    @Column(name="role")
    @Enumerated(EnumType.STRING)
    private MemberRole role = MemberRole.USER;

    @Column(precision = 1)
    private Integer activityLevel;
    @Column(length = 20, nullable = false)
    private String nickname;

    @Embedded
    private ProfileImageUrl profileImage;

    @Column(nullable = false)
    private String birthday;

    @Column(precision = 5)
    private Integer tdeeCalculation;



    public MemberEntity(final Email email,
                        final Name name,
                        final String password,
                        final String gender,
                        final BigDecimal height,
                        final Integer activityLevel,
                        final String nickname,
                        final ProfileImageUrl profileImage,
                        final String birthday,
                        final Integer tdeeCalculation
    ){
        this.email = email;
        this.name = name;
        this.password=password;
        this.gender = gender;
        this.height = height;
        this.activityLevel = activityLevel;
        this.nickname = nickname;
        this.profileImage = profileImage;
        this.birthday = birthday;
        this.tdeeCalculation =tdeeCalculation;

    }

    @Builder
    public MemberEntity(
            final String email,
            final String name,
            final String password,
            final String gender,
            final BigDecimal height,
            final Integer activityLevel,
            final String nickname,
            final String profileImage,
            final String birthday,
            final Integer tdeeCalculation
    ){
        this(new Email(email),new Name(name),password,gender,height,activityLevel,nickname,new ProfileImageUrl(profileImage),birthday,tdeeCalculation);
    }

}

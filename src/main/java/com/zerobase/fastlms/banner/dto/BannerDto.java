package com.zerobase.fastlms.banner.dto;

import com.zerobase.fastlms.banner.entity.Banner;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BannerDto {
    Long id;
    String title;
    String link;
    String targetType;
    int sortIndex;
    boolean visible;
    LocalDateTime regDt;
    LocalDateTime udtDt;
    String filename;
    String urlFilename;

    long totalCount;
    long seq;

    public static BannerDto of(Banner banner) {
        return BannerDto.builder()
                .id(banner.getId())
                .title(banner.getTitle())
                .link(banner.getLink())
                .targetType(banner.getTargetType())
                .sortIndex(banner.getSortIndex())
                .visible(banner.isVisible())
                .regDt(banner.getRegDt())
                .udtDt(banner.getUdtDt())
                .filename(banner.getFilename())
                .urlFilename(banner.getUrlFilename())
                .build();
    }

    public static List<BannerDto> of(List<Banner> banners) {
        if (banners == null) {
            return null;
        }

        List<BannerDto> bannerList = new ArrayList<>();
        for(Banner x : banners) {
            bannerList.add(BannerDto.of(x));
        }
        return bannerList;
    }

    public String getRegDtText() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
        return regDt != null ? regDt.format(formatter) : "";
    }
}

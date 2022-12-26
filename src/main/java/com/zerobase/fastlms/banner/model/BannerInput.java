package com.zerobase.fastlms.banner.model;

import lombok.Data;

@Data
public class BannerInput {
    long id;
    String title;
    String link;
    String targetType;
    int sortIndex;
    boolean visible;
    String filename;
    String urlFilename;

    String idList;  // for 삭제
}

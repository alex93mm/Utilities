package com.amdevelop.awsimageupload.buckets;

public enum BucketName {

    PROFILE_IMAGE("aws-image-upload");

    private final String bucketName;

    BucketName(String bucketName){
        this.bucketName = bucketName;
    }

    public String getBucketName() {
        return bucketName;
    }
}

package br.com.julioneto.sessender.services;

import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;

public class AwsCredentials {
    public static AwsCredentialsProvider AwsCredentials(){
        return () -> new software.amazon.awssdk.auth.credentials.AwsCredentials() {
            @Override
            public String accessKeyId() {
                return System.getenv("AWS_ACCESS_KEY");
            }

            @Override
            public String secretAccessKey() {
                return System.getenv("AWS_SECRET_KEY");
            }
        };
    }
}

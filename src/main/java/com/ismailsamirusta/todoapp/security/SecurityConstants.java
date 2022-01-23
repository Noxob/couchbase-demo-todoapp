package com.ismailsamirusta.todoapp.security;

public class SecurityConstants {
    public static final String SECRET = "PUT_YOUR_SECRET_HERE";
    public static final long EXPIRATION_TIME = 300_000;
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/user/register";
}
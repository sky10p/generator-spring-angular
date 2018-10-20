package com.everis.<%= appName %>.security;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Base64.Encoder;

import org.springframework.security.crypto.keygen.BytesKeyGenerator;
import org.springframework.security.crypto.keygen.KeyGenerators;
import org.springframework.util.Assert;

import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

public final class SecurityEncoder
{

    private static final int PRV_SALT_LENGTH = 768;

    private SecurityEncoder()
    {
        super();
    }

    public static String hashPassword(String password, String salt)
    {
        String passwordHashString;
        HashFunction sha256;
        String saltedPassword;
        HashCode passwordHash;

        Assert.notNull(password, "Password must NOT be null");
        Assert.notNull(salt, "Salt must NOT be null");
        Assert.state(password.isEmpty() == false, "Password must NOT be empty");
        Assert.notNull(salt.isEmpty() == false, "Salt must NOT be empty");

        sha256 = Hashing.sha256();
        saltedPassword = password.concat(salt);

        passwordHash = sha256.hashString(saltedPassword, StandardCharsets.UTF_8);
        passwordHashString = passwordHash.toString();

        return passwordHashString;

    }

    public static boolean checkSaltedPassword(String password, String salt, String expectedHash)
    {
        String passwordHash;

        passwordHash = hashPassword(password, salt);

        return expectedHash.equals(passwordHash);
    }

    public static String generateSalt()
    {
        String salt;

        BytesKeyGenerator keyGenerator;
        Encoder base64Encoder;
        byte[] saltBytes;

        base64Encoder = Base64.getEncoder();
        keyGenerator = KeyGenerators.secureRandom(PRV_SALT_LENGTH);
        saltBytes = keyGenerator.generateKey();
        salt = base64Encoder.encodeToString(saltBytes);
        return salt;
    }
}

package com.example.marvel.util

import java.math.BigInteger
import java.security.MessageDigest

object ApiConstants {
    const val MAX_RESULT = "10"
    const val BASE_URL = "https://gateway.marvel.com"
    const val PUBLIC_KEY = "a4e039be7beb4fcc6bce7fb6af7f0a59"
    const val PRIVATE_KEY = "a014b2a133469de6d2cf17063a1cdf967fea053f"
    const val TIMESTAMP = "1"

    fun createHash(): String {
        val strToMD = "$TIMESTAMP$PRIVATE_KEY$PUBLIC_KEY"
        val md5 = MessageDigest.getInstance("MD5")

        return BigInteger(1, md5.digest(strToMD.toByteArray()))
            .toString(16)
            .padStart(32, '0')
    }
}
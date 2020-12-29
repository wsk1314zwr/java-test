package com.wsk.study.security.rsa;

public class MainTest {

    public static void main(String[] args) throws Exception {
        String filepath="/Users/skwang/Downloads";

        //生成公钥和私钥文件
//        RSAEncrypt.genKeyPair(filepath);

        System.out.println("--------------公钥加密私钥解密过程-------------------");
        String plainText="123456";
        //公钥加密过程
        byte[] cipherData=RSAEncrypt.encrypt(RSAEncrypt.loadPublicKeyByStr(RSAEncrypt.loadPublicKeyByFile(filepath)),plainText.getBytes());
        String cipher=Base64.encode(cipherData);
        System.out.println("公钥加解密-加密前的明文：");
        System.out.println(plainText);
        System.out.println("公钥加解密-加密后的密文：");
        System.out.println(cipher);
        //私钥解密过程
        byte[] res=RSAEncrypt.decrypt(RSAEncrypt.loadPrivateKeyByStr(RSAEncrypt.loadPrivateKeyByFile(filepath)), Base64.decode(cipher));
        String restr=new String(res);
        System.out.println("公钥加解密-解密后的明文：");
        System.out.println(restr);
        System.out.println();



        System.out.println("--------------私钥加密公钥解密过程-------------------");
        plainText="ihep_私钥加密公钥解密";
        //私钥加密过程
        cipherData=RSAEncrypt.encrypt(RSAEncrypt.loadPrivateKeyByStr(RSAEncrypt.loadPrivateKeyByFile(filepath)),plainText.getBytes());
        cipher=Base64.encode(cipherData);
        //公钥解密过程
        res=RSAEncrypt.decrypt(RSAEncrypt.loadPublicKeyByStr(RSAEncrypt.loadPublicKeyByFile(filepath)), Base64.decode(cipher));
        restr=new String(res);
        System.out.println("私钥加解密-加密前的明文：");
        System.out.println(plainText);
        System.out.println("私钥加解密-加密后的密文：");
        System.out.println(cipher);
        System.out.println("私钥加解密-解密后的明文：");
        System.out.println(restr);
        System.out.println();


//        System.out.println("---------------私钥签名过程------------------");
//        String content="ihep_这是用于签名的原始数据";
//        String signstr=RSASignature.sign(content,RSAEncrypt.loadPrivateKeyByFile(filepath));
//        System.out.println("签名原串：");
//        System.out.println(content);
//        System.out.println("签名串：");
//        System.out.println(signstr);
//
//        System.out.println();
//
//        System.out.println("---------------公钥校验签名------------------");
//        System.out.println("签名原串："+content);
//        System.out.println(plainText);
//        System.out.println("签名串："+signstr);
//        System.out.println(plainText);
//
//        System.out.println("验签结果："+RSASignature.doCheck(content, signstr, RSAEncrypt.loadPublicKeyByFile(filepath)));
//        System.out.println();

    }
}
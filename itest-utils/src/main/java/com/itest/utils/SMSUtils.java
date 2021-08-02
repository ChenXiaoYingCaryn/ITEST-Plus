package com.itest.utils;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

/**
 * @author ChanV
 * @create 2021-03-02-11:32
 */
public class SMSUtils {

    public static boolean sendSMS(String phoneNumber, String code){
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4G3AGK2pVk6aeqF6Y1xu", "YMs53dRYiMArBTqtls0tBPlXL4PR2S");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phoneNumber);
        request.putQueryParameter("SignName", "1");
        request.putQueryParameter("TemplateCode", "1");


        request.putQueryParameter("TemplateParam", code);


        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
            return response.getHttpResponse().isSuccess();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}

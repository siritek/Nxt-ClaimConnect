package com.example.withoutdb.controller;


import com.example.withoutdb.model.CCClaimPayload;
import com.example.withoutdb.model.Fnol;
import com.example.withoutdb.service.CreateClaimFileGWCC;
import com.example.withoutdb.service.DBConn;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.UUID;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

@RestController
@CrossOrigin
public class SendClaimtoGWCCcontroller {

    @PostMapping("/generateClaimFile")
    public String generateClaimFile(@RequestBody CCClaimPayload claimPayload, HttpServletResponse response) throws IOException {
        System.out.println("inside generateClaimFile");
        if (claimPayload == null) {
            System.out.println("claimPayload is null");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return "null values are not allowed";
        } else {
            String policyNumber = claimPayload.getPolicyNumber();
            String claimNumber = claimPayload.getClaimNumber();
            String jsonPayload = getPaylodforCCintegration(policyNumber, claimNumber);
            System.out.println("claim number is " + claimNumber);

            // Construct S3 bucket name and object key
            String bucketName = "nxtcc";
            String basePath = "upload/"; // Specify the path within the bucket

            // Combine basePath and fileName to get the S3 object key
            String fileName = CreateClaimFileGWCC.createUniqueClaimFile(basePath);
            String objectKey = basePath + fileName;

            // Create an instance of the AmazonS3 client
            AmazonS3 s3Client = AmazonS3ClientBuilder.defaultClient();

            // Write the JSON payload to S3
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentType("application/json");
            metadata.setContentLength(jsonPayload.length());
            s3Client.putObject(new PutObjectRequest(bucketName, objectKey, new ByteArrayInputStream(jsonPayload.getBytes()), metadata));

            return "CC payload generated to the file: " + fileName + " with this payload " + jsonPayload;
        }
    }
//    @PostMapping("/generateClaimFile")
//    public String generateClaimFile(@RequestBody CCClaimPayload claimPayload, HttpServletResponse response) throws IOException {
//        System.out.println("inside generateClaimFile");
//        if (claimPayload == null) {
//            System.out.println("claimPayload is null");
//            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//            return "null vaules are not allowed";
//        } else {
//            String policyNumber = claimPayload.getPolicyNumber();
//            String claimNumber = claimPayload.getClaimNumber();
//            String jsonPayload = getPaylodforCCintegration(policyNumber, claimNumber);
//            System.out.println("claim number is " + claimNumber);
//            String basePath = "s3://nxtcc/upload/";
//            //String basePath = "C:\\TestClaim\\";
//            String fileName = CreateClaimFileGWCC.createUniqueClaimFile(basePath);
//            CreateClaimFileGWCC.writeJsonToFile(jsonPayload, basePath, fileName);
//
//            return "CC payload generated to the file: " + fileName + " with this payload " + jsonPayload;
//        }
//    }

    private DBConn dbConn;

    private String getPaylodforCCintegration(String policyNumber, String claimNumber) {
        CCClaimPayload payload;
        Fnol fnoldata;

        try {
            Connection con = DBConn.getMyConnection();

            payload = new CCClaimPayload();

            String sqlQuery = "SELECT * FROM nxt_master WHERE PolicyNumber = ? AND ClaimNumber = ?";
            PreparedStatement ps = con.prepareStatement(sqlQuery);
            ps.setString(1, policyNumber);
            ps.setString(2, claimNumber);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                payload.setBaseClaimNumber(rs.getString("ClaimNumber"));
                payload.setPolicyNumber(rs.getString("PolicyNumber"));
                payload.setLossDate(rs.getString("dateOfLoss"));
                payload.setLossLocation(rs.getString("LossLocation"));
                payload.setReportedBy(rs.getString("ReportedBy"));
                payload.setReportedDate(rs.getString("DateReported"));
                payload.setLossDate(rs.getString("DateOfLoss"));
                payload.setName(rs.getString("Name"));
                payload.setAddress(rs.getString("Address"));
                payload.setBasePolicyNumber("5566112234");
                payload.setLossDescription(rs.getString("LossDescription"));
                payload.setPolicyType("MutualRequest_Ext");
                payload.setTypeOfLoss("GL");
                payload.setWeatherInvolved(rs.getString("WeatherInvolved"));
                String randomStringaa = UUID.randomUUID().toString().substring(0, 4);
                payload.setWeatherDescription(randomStringaa);
                payload.setCountry("US");
                payload.setCity(rs.getString("City"));
                payload.setState("AZ");
                payload.setZipcode("60067");
                payload.setLossDate(rs.getString("DateOfLoss"));
                payload.setRelationshipToInsured("insured");
                payload.setLossParty("third_party");
                payload.setHowReported("Internet");
                payload.setCreationDate(rs.getString("CreationDate"));
                payload.setClaimant(rs.getString("Claimant"));
                payload.setClaimantType("insured");
                System.out.println("this if payload inserted " + payload.toString());
            }

        } catch (Exception e) {
            System.out.println("error:-" + e.getMessage());
            e.printStackTrace();
            return "error in getPaylodforCCintegration, please consult with the developer " + e.getMessage();
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String payloadJson = gson.toJson(payload);

        JsonObject claimdataJson = new JsonObject();
        claimdataJson.add("ClaimData", gson.fromJson(payloadJson, JsonObject.class));
        System.out.println(claimdataJson.toString());

        return claimdataJson.toString();


    }
}

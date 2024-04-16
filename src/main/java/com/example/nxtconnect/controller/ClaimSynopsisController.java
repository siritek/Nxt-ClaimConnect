package com.example.nxtconnect.controller;

import com.example.nxtconnect.model.ClaimGeneration;
import com.example.nxtconnect.service.DBConn;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//@CrossOrigin
@RestController
@RequestMapping("/claim")
public class ClaimSynopsisController {

    private final DBConn dbConn;

    public ClaimSynopsisController(DBConn dbConn) {
        this.dbConn = dbConn;
    }

    @GetMapping("/loss/{claimNumber}")
    public List<ClaimGeneration> getClaimLoss(@PathVariable String claimNumber) {

        List<ClaimGeneration> claimLossList = new ArrayList<>();
        System.out.println("Claim Number: " + claimNumber);

        try (Connection conn = dbConn.getMyConnection();
             PreparedStatement statement = conn.prepareStatement(
                     "SELECT ClaimNumber, PolicyNumber, NAME, DateofLoss, Adjuster, DateReported, LossLocation, LossDescription, TimeofLoss, ReportedBy, PolicyType, EffectiveDate, ExpirationDate, LossCause, TypeofLoss, Address,City, State, Countries, Zipcode, Lossparty, PrimaryCoverage, ExposuresStatus FROM nxt_master WHERE ClaimNumber = ?"
             )) {
            statement.setString(1, claimNumber);

            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    ClaimGeneration claimGeneration = new ClaimGeneration();

                    claimGeneration.setClaimNumber(rs.getString("ClaimNumber"));
                    claimGeneration.setPolicyNumber(rs.getString("PolicyNumber"));
                    claimGeneration.setName(rs.getString("NAME"));

                    LocalDateTime dateOfLoss = null;
                    Timestamp dateOfLossTimestamp = rs.getTimestamp("DateofLoss");
                    if (dateOfLossTimestamp != null) {
                        dateOfLoss = dateOfLossTimestamp.toLocalDateTime();
                        claimGeneration.setDateOfLoss(dateOfLoss.toString());
                    }

                    claimGeneration.setAdjuster(rs.getString("Adjuster"));

                    LocalDateTime dateReported = null;
                    Timestamp dateReportedTimestamp = rs.getTimestamp("DateReported");
                    if (dateReportedTimestamp != null) {
                        dateReported = dateReportedTimestamp.toLocalDateTime();
                        claimGeneration.setDateOfReport(dateReported.toString());
                    }

                    claimGeneration.setAddress1(rs.getString("LossLocation"));
                    claimGeneration.setLossDescription(rs.getString("LossDescription"));
                    claimGeneration.setTimeOfLoss(rs.getString("TimeofLoss"));
                    claimGeneration.setReportedBy(rs.getString("ReportedBy"));
                    claimGeneration.setPolicyType(rs.getString("PolicyType"));

                    LocalDateTime effectiveDate = null;
                    Timestamp effectiveDateTimestamp = rs.getTimestamp("EffectiveDate");
                    if (effectiveDateTimestamp != null) {
                        effectiveDate = effectiveDateTimestamp.toLocalDateTime();
                        claimGeneration.setEffectiveDate(effectiveDate.toString());
                    }

                    LocalDateTime expirationDate = null;
                    Timestamp expirationDateTimestamp = rs.getTimestamp("ExpirationDate");
                    if (expirationDateTimestamp != null) {
                        expirationDate = expirationDateTimestamp.toLocalDateTime();
                        claimGeneration.setExpirationDate(expirationDate.toString());
                    }

                    claimGeneration.setLossCause(rs.getString("LossCause"));
                    claimGeneration.setTypeOfLoss(rs.getString("TypeofLoss"));
                    claimGeneration.setAddress(rs.getString("Address"));
                    claimGeneration.setCity(rs.getString("City"));
                    claimGeneration.setState(rs.getString("State"));
                    claimGeneration.setCountries(rs.getString("Countries"));
                    claimGeneration.setZipcode(rs.getString("Zipcode"));
                    claimGeneration.setLossParty(rs.getString("LossParty"));
                    claimGeneration.setPrimaryCoverage(rs.getString("PrimaryCoverage"));
                    claimGeneration.setExposuresStatus(rs.getString("ExposuresStatus"));

                    claimLossList.add(claimGeneration);
                }
            }
        } catch (SQLException e) {
            System.out.println("Exception in getClaimLoss method: " + e);
        }

        System.out.println("Claim Loss List: " + claimLossList);
        return claimLossList;
    }

//    @GetMapping("/loss/{claimNumber}")
//    public List<ClaimGeneration> getClaimLoss(@PathVariable String claimNumber) {
//
//        List<ClaimGeneration> claimLossList = new ArrayList<>();
//        System.out.println("Claim Number: " + claimNumber);
//        //  System.out.println("Policy Number: " + policyNumber);
//
//        try (Connection conn = dbConn.getMyConnection();
//             PreparedStatement statement = conn.prepareStatement(
//                     "SELECT ClaimNumber, PolicyNumber, NAME, DateofLoss, Adjuster, DateReported, LossLocation, LossDescription, TimeofLoss, ReportedBy, PolicyType, EffectiveDate, ExpirationDate, LossCause, TypeofLoss, Address,City, State, Countries, Zipcode, Lossparty, PrimaryCoverage, ExposuresStatus FROM nxt_master WHERE ClaimNumber = ?"
//             )) {
//            statement.setString(1, claimNumber);
//            //    statement.setString(2, policyNumber);
//
//            try (ResultSet rs = statement.executeQuery()) {
//                while (rs.next()) {
//                    ClaimGeneration claimGeneration = new ClaimGeneration();
//
//                    claimGeneration.setClaimNumber(rs.getString("ClaimNumber"));
//                    claimGeneration.setPolicyNumber(rs.getString("PolicyNumber"));
//                    claimGeneration.setName(rs.getString("NAME"));
//
//                    LocalDateTime dateOfLoss = rs.getTimestamp("DateofLoss").toLocalDateTime();
//                    claimGeneration.setDateOfLoss(dateOfLoss.toString());
//                    claimGeneration.setAdjuster(rs.getString("Adjuster"));
//                    LocalDateTime dateReported = rs.getTimestamp("DateReported").toLocalDateTime();
//                    claimGeneration.setDateOfReport(dateReported.toString());
//                    claimGeneration.setAddress1(rs.getString("LossLocation"));
//                    claimGeneration.setLossDescription(rs.getString("LossDescription"));
//                    claimGeneration.setTimeOfLoss(rs.getString("TimeofLoss"));
//                    claimGeneration.setReportedBy(rs.getString("ReportedBy"));
//                    claimGeneration.setPolicyType(rs.getString("PolicyType"));
//                    LocalDateTime effectiveDate = rs.getTimestamp("EffectiveDate").toLocalDateTime();
//                    claimGeneration.setEffectiveDate(effectiveDate.toString());
//                    LocalDateTime expirationDate = rs.getTimestamp("ExpirationDate").toLocalDateTime();
//                    claimGeneration.setExpirationDate(expirationDate.toString());
////                    LocalDateTime cancellationDate = rs.getTimestamp("CancellationDate").toLocalDateTime();
////                    claimGeneration.setCancellationDate(cancellationDate.toString());
//                    claimGeneration.setLossCause(rs.getString("LossCause"));
//                    claimGeneration.setTypeOfLoss(rs.getString("TypeofLoss"));
//                    claimGeneration.setAddress(rs.getString("Address"));
//                    claimGeneration.setCity(rs.getString("City"));
//                    claimGeneration.setState(rs.getString("State"));
//                    claimGeneration.setCountries(rs.getString("Countries"));
//                    claimGeneration.setZipcode(rs.getString("Zipcode"));
//                    claimGeneration.setLossParty(rs.getString("LossParty"));
//                    claimGeneration.setPrimaryCoverage(rs.getString("PrimaryCoverage"));
//                    claimGeneration.setExposuresStatus(rs.getString("ExposuresStatus"));
//
//
//
//                    claimLossList.add(claimGeneration);
//                }
//            }
//        } catch (SQLException e) {
//            System.out.println("Exception in getClaimLoss method: " + e);
//        }
//
//        System.out.println("Claim Loss List: " + claimLossList);
//        return claimLossList;
//    }
}

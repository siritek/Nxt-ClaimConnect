package com.example.withoutdb.controller;

import com.example.withoutdb.model.ClaimGeneration;
import com.example.withoutdb.service.DBConn;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
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
        //  System.out.println("Policy Number: " + policyNumber);

        try (Connection conn = dbConn.getMyConnection();
             PreparedStatement statement = conn.prepareStatement(
                     "SELECT ClaimNumber, PolicyNumber, NAME, DateofLoss, Adjuster, DateReported, LossLocation, LossDescription, TimeofLoss, ReportedBy, PolicyType, EffectiveDate, ExpirationDate, CancellationDate, LossCause, TypeofLoss, Address,City, State, Countries, Zipcode, Lossparty, PrimaryCoverage, ExposuresStatus FROM NXT_Master WHERE ClaimNumber = ?"
             )) {
            statement.setString(1, claimNumber);
            //    statement.setString(2, policyNumber);

            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    ClaimGeneration claimGeneration = new ClaimGeneration();

                    claimGeneration.setClaimNumber(rs.getString("ClaimNumber"));
                    claimGeneration.setPolicyNumber(rs.getString("PolicyNumber"));
                    claimGeneration.setName(rs.getString("NAME"));

                    LocalDateTime dateOfLoss = rs.getTimestamp("DateofLoss").toLocalDateTime();
                    claimGeneration.setDateOfLoss(dateOfLoss.toString());
                    claimGeneration.setAdjuster(rs.getString("Adjuster"));
                    LocalDateTime dateReported = rs.getTimestamp("DateReported").toLocalDateTime();
                    claimGeneration.setDateOfReport(dateReported.toString());
                    claimGeneration.setAddress1(rs.getString("LossLocation"));
                    claimGeneration.setLossDescription(rs.getString("LossDescription"));
                    claimGeneration.setTimeOfLoss(rs.getString("TimeofLoss"));
                    claimGeneration.setReportedBy(rs.getString("ReportedBy"));
                    claimGeneration.setPolicyType(rs.getString("PolicyType"));
                    LocalDateTime effectiveDate = rs.getTimestamp("EffectiveDate").toLocalDateTime();
                    claimGeneration.setEffectiveDate(effectiveDate.toString());
                    LocalDateTime expirationDate = rs.getTimestamp("ExpirationDate").toLocalDateTime();
                    claimGeneration.setExpirationDate(expirationDate.toString());
                    LocalDateTime cancellationDate = rs.getTimestamp("CancellationDate").toLocalDateTime();
                    claimGeneration.setCancellationDate(cancellationDate.toString());
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
}







//package com.example.withoutdb.controller;
//
//import com.example.withoutdb.model.ClaimGeneration;
//import com.example.withoutdb.service.DBConn;
//import org.springframework.web.bind.annotation.*;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//@CrossOrigin
//@RestController
//@RequestMapping("/claim")
//public class ClaimSynopsisController {
//
//    private final DBConn dbConn;
//
//    public ClaimSynopsisController(DBConn dbConn) {
//        this.dbConn = dbConn;
//    }
//
//    @GetMapping("/loss/{claimNumber}")
//    public List<ClaimGeneration> getClaimLoss(@PathVariable String claimNumber) {
//
//        List<ClaimGeneration> claimLossList = new ArrayList<>();
//        System.out.println("Claim Number: " + claimNumber);
//      //  System.out.println("Policy Number: " + policyNumber);
//
//        try (Connection conn = dbConn.getMyConnection();
//             PreparedStatement statement = conn.prepareStatement(
//                     "SELECT ClaimNumber, PolicyNumber, NAME, DateofLoss, Adjuster, DateReported, LossLocation, LossDescription FROM NXT_Master WHERE ClaimNumber = ?"
//             )) {
//            statement.setString(1, claimNumber);
//        //    statement.setString(2, policyNumber);
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
//}





//package com.example.withoutdb.controller;
//
//import com.example.withoutdb.model.ClaimGeneration;
//import com.example.withoutdb.service.DBConn;
//import org.springframework.web.bind.annotation.*;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//@CrossOrigin(origins = "http://localhost:3000")
//@RestController
//@RequestMapping("/claim")
//public class ClaimSynopsisController {
//
//    private final DBConn dbConn;
//
//    public ClaimSynopsisController(DBConn dbConn) {
//        this.dbConn = dbConn;
//    }
//
//    @GetMapping("/loss/{claimNumber}")
//    public List<ClaimGeneration> getClaimLoss(@PathVariable("claimNumber") String claimNumber) {
//        List<ClaimGeneration> claimLossList = new ArrayList<>();
//        System.out.println("Claim Number: " + claimNumber);
//
//        try {
//            Connection conn = dbConn.getMyConnection();
//            PreparedStatement statement = conn.prepareStatement("SELECT ClaimNumber, PolicyNumber, NAME, DateofLoss, Adjuster, DateReported, LossLocation, LossDescription FROM NXT_Master WHERE ClaimNumber = ?");
//            statement.setString(1, claimNumber);
//
//            ResultSet rs = statement.executeQuery();
//            while (rs.next()) {
//                ClaimGeneration claimGeneration = new ClaimGeneration();
//
//                claimGeneration.setClaimNumber(rs.getString("ClaimNumber"));
//                claimGeneration.setPolicyNumber(rs.getString("PolicyNumber"));
//                claimGeneration.setName(rs.getString("NAME"));
//
//                LocalDateTime dateOfLoss = rs.getTimestamp("DateofLoss").toLocalDateTime();
//                claimGeneration.setDateOfLoss(dateOfLoss.toString());
//                claimGeneration.setAdjuster(rs.getString("Adjuster"));
//                LocalDateTime dateReported = rs.getTimestamp("DateReported").toLocalDateTime();
//                claimGeneration.setDateOfReport(dateReported.toString());
//                claimGeneration.setAddress1(rs.getString("LossLocation"));
//                claimGeneration.setLossDescription(rs.getString("LossDescription"));
//
//                claimLossList.add(claimGeneration);
//            }
//
//            conn.close();
//        } catch (SQLException e) {
//            System.out.println("Exception in getClaimLoss method: " + e);
//        }
//
//        System.out.println("Claim Loss List: " + claimLossList);
//        return claimLossList;
//    }
//}



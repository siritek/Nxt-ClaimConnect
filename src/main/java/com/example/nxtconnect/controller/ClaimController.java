package com.example.nxtconnect.controller;

import com.example.nxtconnect.model.Fnol;
import com.example.nxtconnect.service.DBConn;
import org.springframework.web.bind.annotation.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

@RestController
//@CrossOrigin(origins = {"http://localhost:3000", "https://gfnurnjftf.us-east-1.awsapprunner.com"})
@RequestMapping("/claimcenter")
public class ClaimController {

    private final DBConn dbConn;

    public ClaimController(DBConn dbConn) {
        this.dbConn = dbConn;
    }
    public static class FnolWrapper {
        private List<Fnol> claimloss;
        public FnolWrapper(List<Fnol> claimloss) {
            this.claimloss = claimloss;
        }
        public List<Fnol> getClaimloss() {
            return claimloss;
        }

        public void setClaimloss(List<Fnol> claimloss) {
            this.claimloss = claimloss;
        }
    }
    @GetMapping("/loss/{policy}")
    public Fnol createLoss(@PathVariable("policy") String policy) {
        Fnol claimLoss = new Fnol();
        System.out.println(policy);

        try {
            Connection conn = dbConn.getMyConnection();
            PreparedStatement statement = conn.prepareStatement("SELECT dateOfLoss,dateOfReport,reportedBy, description, loss_cause, incident_only, coverage_in_question, how_reported, policyNumber,lossLocation,lossTime, first_suit_notice, weather_related, lossTime FROM claim WHERE policyNumber = ?");
            statement.setString(1, policy);

            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                LocalDateTime dateOfLoss = rs.getTimestamp("dateOfLoss").toLocalDateTime();
                claimLoss.setDateOfLoss(dateOfLoss.toString());
                LocalDateTime dateOfReport = rs.getTimestamp("dateOfReport").toLocalDateTime();
                claimLoss.setDateOfReport(dateOfReport.toString());
                claimLoss.setReportedBy(rs.getString("reportedBy"));
                claimLoss.setDescription(rs.getString("description"));
                claimLoss.setLoss_cause(rs.getString("loss_cause"));
                claimLoss.setIncident_only(rs.getBoolean("incident_only"));
                claimLoss.setCoverage_in_question(rs.getBoolean("coverage_in_question"));
                claimLoss.setHow_reported(rs.getString("how_reported"));
                claimLoss.setFirst_suit_notice(rs.getBoolean("first_suit_notice"));
                claimLoss.setWeather_related(rs.getBoolean("weather_related"));
                claimLoss.setPolicyNumber(rs.getString("policyNumber"));
                claimLoss.setLossLocation(rs.getString("lossLocation"));
                claimLoss.setLossTime(rs.getString("lossTime"));
               // claimLoss.setLossTime(rs.getTime("lossTime")); // Assuming you have a setTime method for lossTime
                System.out.println("Reported By: " + claimLoss.getReportedBy());
                System.out.println("Description: " + claimLoss.getDescription());
                System.out.println("Loss Cause: " + claimLoss.getLoss_cause());
                System.out.println("Incident Only: " + claimLoss.getIncident_only());
                System.out.println("Coverage in Question: " + claimLoss.getCoverage_in_question());
                System.out.println("How Reported: " + claimLoss.getHow_reported());
                System.out.println("First Suit Notice: " + claimLoss.getFirst_suit_notice());
                System.out.println("Weather Related: " + claimLoss.getWeather_related());
            }

            conn.close();
        }
//        {
//            Connection conn = dbConn.getMyConnection();
//            PreparedStatement statement = conn.prepareStatement("SELECT reportedby,description,loss_cause,incident_only,coverage_in_question,how_reported,first_suit_notice,weather_related FROM claim WHERE policyNumber = ?");
//            statement.setString(1, policy);
//
//            ResultSet rs = statement.executeQuery();
//            if (rs.next()) {
//                //policynumber,description, loss_cause,incident_only, coverage_in_question, how_reported, first_suit_notice, weather_related, catastrophe
//                claimLoss.setReportedBy(rs.getString("reportedby"));
//                claimLoss.setDescription(rs.getString("description"));
//                claimLoss.setLoss_cause(rs.getString("loss_cause"));
//                claimLoss.setIncident_only(rs.getBoolean("incident_only"));
//                claimLoss.setCoverage_in_question(rs.getBoolean("coverage_in_question"));
//                claimLoss.setHow_reported(rs.getString("how_reported"));
//                claimLoss.setFirst_suit_notice(rs.getBoolean("first_suit_notice"));
//                claimLoss.setWeather_related(rs.getBoolean("weather_related"));
//                // claimLoss.setCatastrophe(rs.getString("catastrophe"));//catastrophe
//                // add date dated to send to CC
//            }
//
//            conn.close();
//        }
//{
//            Connection conn = dbConn.getMyConnection();
//            PreparedStatement statement = conn.prepareStatement("SELECT reportedby,description,loss_cause,incident_only,coverage_in_question,how_reported,first_suit_notice,weather_related,catastrophe FROM claim WHERE policynumber = ?");
//            statement.setString(1, policy);
//
//            ResultSet rs = statement.executeQuery();
//            if (rs.next()) {
//                //policynumber,description, loss_cause,incident_only, coverage_in_question, how_reported, first_suit_notice, weather_related, catastrophe
//                claimLoss.setReportedBy(rs.getString("reportedby"));
//                claimLoss.setDescription(rs.getString("description"));
//                claimLoss.setLoss_cause(rs.getString("loss_cause"));
//                claimLoss.setIncident_only(rs.getBoolean("incident_only"));
//                claimLoss.setCoverage_in_question(rs.getBoolean("coverage_in_question"));
//                claimLoss.setHow_reported(rs.getString("how_reported"));
//                claimLoss.setFirst_suit_notice(rs.getBoolean("first_suit_notice"));
//                claimLoss.setWeather_related(rs.getBoolean("weather_related"));
//                // claimLoss.setCatastrophe(rs.getString("catastrophe"));//catastrophe
//                // add date dated to send to CC
//            }
//
//            conn.close();
//        }

        catch (SQLException e) {
            System.out.println("Exception in createLoss method: " + e);
        }
        return claimLoss;
    }

}

    /*@GetMapping("/loss/{policy}")
    public ResponseEntity<FnolWrapper> createLoss(@PathVariable("policy") String policy) {
        List<Fnol> claimloss = new ArrayList<>();

        try {
            Connection conn = dbConn.getMyConnection();
            PreparedStatement statement = conn.prepareStatement("SELECT reportedby FROM fnol WHERE policynumber = ?");
            statement.setString(1, policy);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Fnol x = new Fnol();
                x.setReportedby(rs.getString("reportedby"));
                claimloss.add(x);
            }

            conn.close();
        } catch (SQLException e) {
            System.out.println("Exception in createLoss method: " + e);
        }

        FnolWrapper response = new FnolWrapper(claimloss);
        return ResponseEntity.ok(response);
    }
}*/
/*


    @GetMapping("/loss/{policy}")
    public List<Fnol> createLoss(@PathVariable("policy") String policy) {
        List<Fnol> claimloss = new ArrayList<>();

        try {
            Connection conn = dbConn.getMyConnection();
            PreparedStatement statement = conn.prepareStatement("SELECT reportedby FROM fnol WHERE policynumber = ?");
            statement.setString(1, policy);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Fnol x = new Fnol();
                x.setReportedby(rs.getString("reportedby"));
                claimloss.add(x);
            }

            conn.close();
        } catch (SQLException e) {
            System.out.println("Exception in createLoss method: " + e);
        }

        return claimloss;
    }
}  */
/*

    @GetMapping("/loss/{policy}")
    public List<Fnol> createLoss( @PathVariable("policy") String policy) {

        List<Fnol> claimloss = new ArrayList<Fnol>();
        try {
            Connection conn = dbConn.getMyConnection();
            PreparedStatement statement = conn.prepareStatement("SELECT reportedby FROM fnol WHERE policynumber = ?");
            statement.setString(1, policy);
            System.out.println(""+Integer.parseInt(String.valueOf(policy))+" test ");
            conn.close();


        } catch (SQLException e) {
            System.out.println("Exception in getFnol method: " + e);
        }

        // Create a new list with only claimnumber and timeofloss properties
        List<Fnol> result = new ArrayList<>();
        for (Fnol fnol : claimloss) {
            Fnol newFnol = new Fnol();
            newFnol.setReportedby(fnol.getReportedby());
            //  newFnol.setClaimnumber(fnol.getClaimnumber());
            //  newFnol.setTimeofloss(fnol.getTimeofloss());
            result.add(newFnol);
        }

        return result;
    }


}
*/

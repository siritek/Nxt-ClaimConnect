package com.example.withoutdb.controller;

import com.example.withoutdb.model.ConfirmationHistory;
import com.example.withoutdb.service.DBConn;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/confirmationHistory")
public class ConfirmationHistoryController {

    @GetMapping("/getAll")
        public List<ConfirmationHistory> ConfirmationHistory() {
            List<ConfirmationHistory> allresponses = new ArrayList<ConfirmationHistory>();
            try {
                Connection con = DBConn.getMyConnection();
                PreparedStatement ps = con.prepareStatement("select * from gwccresponsetable");
                ResultSet rs = ps.executeQuery();
                ConfirmationHistory x = null;
                while(rs.next())
                {
                    x = new ConfirmationHistory();
                    x.setBasePolicyNumber(rs.getString("BasePolicyNumber"));
                    x.setBaseClaimNumber(rs.getString("BaseClaimNumber"));
                    x.setGwclaimNumber(rs.getString("GWCCClaimnumber"));
                    x.setCreateDateTime(rs.getString("createdDate"));
                    //x.setOther(rs.getString("other"));
                    x.setStatus(rs.getString("response"));
                    allresponses.add(x);
                }
                con.close();
            }
            catch(SQLException e) {
                System.out.println("Exception in get ConfirmationHistory  method "+ e);
            }
            return allresponses;
        }
    }


